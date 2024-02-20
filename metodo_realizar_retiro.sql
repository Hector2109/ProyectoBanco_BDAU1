DELIMITER $$

CREATE PROCEDURE realizar_retiro(
    IN p_folio INT,
    IN p_contrasenia VARCHAR(50),
    IN p_fecha_parametro DATETIME
)
BEGIN
    DECLARE v_estado_retiro INT;
    DECLARE v_fecha_creacion DATETIME;
    DECLARE v_num_cuenta INT;
    DECLARE v_saldo_actual DECIMAL(10, 2);
    DECLARE v_minutos_pasados INT;
    DECLARE v_monto_retiro DECIMAL(10, 2);

    -- Iniciar transacción
    START TRANSACTION;

    -- Obtener estado, fecha de creación, número de cuenta y monto del retiro
    SELECT estado, fecha, num_cuenta, saldo_transaccion INTO v_estado_retiro, v_fecha_creacion, v_num_cuenta, v_monto_retiro
    FROM retiros
    INNER JOIN transacciones ON retiros.id_transaccion = transacciones.id_transaccion
    WHERE folio = p_folio AND contrasenia = MD5(p_contrasenia); -- Encriptar la contraseña dada

    -- Verificar si el retiro existe y coincide con la contraseña
    IF v_estado_retiro IS NULL THEN
        -- No se encontró el retiro con el folio y/o contraseña proporcionados
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El folio y/o contraseña proporcionados son incorrectos';
    ELSE
        -- Verificar si han pasado más de 10 minutos desde la creación del retiro
        SET v_minutos_pasados = TIMESTAMPDIFF(MINUTE, v_fecha_creacion, p_fecha_parametro);

        IF v_minutos_pasados > 10 THEN
            -- Han pasado más de 10 minutos, no se puede realizar el retiro
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Han pasado más de 10 minutos desde la creación del retiro';
        ELSE
            -- Verificar si el retiro ya fue realizado (estado = 1)
            IF v_estado_retiro = 1 THEN
                -- El retiro ya fue realizado previamente, no se puede realizar nuevamente
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El retiro ya fue realizado previamente';
            ELSE
                -- Obtener el saldo actual de la cuenta
                SELECT saldo INTO v_saldo_actual
                FROM cuentas
                WHERE num_cuenta = v_num_cuenta;

                -- Verificar si hay saldo suficiente en la cuenta para realizar el retiro
                IF v_saldo_actual < ABS(v_monto_retiro) THEN
                    -- No hay saldo suficiente en la cuenta para realizar el retiro
                    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente en la cuenta';
                ELSE
                    -- Actualizar el saldo de la cuenta restando el monto del retiro
                    UPDATE cuentas
                    SET saldo = saldo + v_monto_retiro
                    WHERE num_cuenta = v_num_cuenta;

                    -- Actualizar el estado del retiro a 1 (realizado)
                    UPDATE retiros
                    SET estado = 1
                    WHERE folio = p_folio;

                    -- Confirmar la transacción
                    COMMIT;
                END IF;
            END IF;
        END IF;
    END IF;
END$$

DELIMITER ;