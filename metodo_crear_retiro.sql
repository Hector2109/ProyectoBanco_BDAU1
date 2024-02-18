DELIMITER //

CREATE PROCEDURE crear_retiro(
    IN id_cuenta INT,
    IN monto DECIMAL(10,2),
    OUT id_retiro INT
)
BEGIN
    DECLARE cuenta_estado INT;
    DECLARE retiro_contrasenia VARCHAR(50);

    -- Obtener el estado de la cuenta
    SELECT estado INTO cuenta_estado FROM cuentas WHERE num_cuenta = id_cuenta;

    -- Verificar si la cuenta está activa (estado = 1)
    IF cuenta_estado = 1 THEN
        -- Iniciar una transacción
        START TRANSACTION;

        -- Insertar una nueva transacción para el retiro
        INSERT INTO transacciones (saldo_transaccion, fecha, num_cuenta)
        VALUES (-monto, NOW(), id_cuenta);

        -- Obtener el ID de la última transacción insertada
        SET id_retiro = LAST_INSERT_ID();

        -- Insertar los detalles del retiro
        INSERT INTO retiros (contrasenia, estado, id_transaccion)
        VALUES (MD5(RAND()), 0, id_retiro);

        -- Confirmar la transacción
        COMMIT;
    ELSE
        -- Si la cuenta está inactiva, mostrar un mensaje de error
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede realizar el retiro. La cuenta está inactiva.';
    END IF;
END //

DELIMITER ;

