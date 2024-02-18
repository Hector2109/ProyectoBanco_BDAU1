DELIMITER //

CREATE PROCEDURE realizar_transferencia(
    IN saldo_transferencia DECIMAL(10,2),
    IN id_cuenta_origen INT,
    IN id_cuenta_destino INT
)
BEGIN
    DECLARE id_transaccion_nueva INT;
    DECLARE saldo_origen DECIMAL(10,2);
    DECLARE saldo_destino DECIMAL(10,2);
    DECLARE cuenta_origen_activa BIT;
    DECLARE cuenta_destino_activa BIT;

    -- Verificar si la cuenta de origen tiene saldo suficiente
    SELECT IF(saldo >= saldo_transferencia, 1, 0) INTO cuenta_origen_activa FROM cuentas WHERE num_cuenta = id_cuenta_origen;

    -- Verificar si la cuenta de destino está activa
    SELECT estado INTO cuenta_destino_activa FROM cuentas WHERE num_cuenta = id_cuenta_destino;

    -- Si la cuenta de origen no tiene saldo suficiente o la cuenta de destino no está activa, salir del procedimiento
    IF cuenta_origen_activa = 0 OR cuenta_destino_activa = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede realizar la transferencia debido a restricciones en las cuentas.';
        ROLLBACK;
    ELSE
        -- Iniciar una transacción
        START TRANSACTION;

        -- Insertar una nueva transacción
        INSERT INTO transacciones (saldo_transaccion, fecha, num_cuenta)
        VALUES (saldo_transferencia, NOW(), id_cuenta_origen);
        
        -- Obtener el ID de la última transacción insertada
        SET id_transaccion_nueva = LAST_INSERT_ID();

        -- Insertar los detalles de la transferencia
        INSERT INTO transferencia (id_transaccion, num_cuenta_transferir)
        VALUES (id_transaccion_nueva, id_cuenta_destino);

        -- Obtener los saldos de las cuentas involucradas
        SELECT saldo INTO saldo_origen FROM cuentas WHERE num_cuenta = id_cuenta_origen;
        SELECT saldo INTO saldo_destino FROM cuentas WHERE num_cuenta = id_cuenta_destino;

        -- Actualizar los saldos de las cuentas
        UPDATE cuentas SET saldo = saldo_origen - saldo_transferencia WHERE num_cuenta = id_cuenta_origen;
        UPDATE cuentas SET saldo = saldo_destino + saldo_transferencia WHERE num_cuenta = id_cuenta_destino;

        -- Confirmar la transacción
        COMMIT;
    END IF;
END //

DELIMITER ;

-- Prueba
-- CALL realizar_transferencia(499.99, 3, 1);