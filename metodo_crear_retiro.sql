DELIMITER //

CREATE PROCEDURE crear_retiro(
    IN id_cuenta INT,
    IN monto DECIMAL(10,2),
    OUT id_retiro INT,
    OUT retiro_contrasenia_plana VARCHAR(50) -- Salida para la contraseña sin encriptar
)
BEGIN
    DECLARE cuenta_estado INT;

    -- Obtener el estado de la cuenta
    SELECT estado INTO cuenta_estado FROM cuentas WHERE num_cuenta = id_cuenta;

    -- Verificar si la cuenta está activa 
    IF cuenta_estado = 1 THEN
        -- Iniciar una transacción
        START TRANSACTION;

        -- Insertar una nueva transacción para el retiro
        INSERT INTO transacciones (saldo_transaccion, fecha, num_cuenta)
        VALUES (-monto, NOW(), id_cuenta);

        -- Obtener el ID de la última transacción insertada
        SET id_retiro = LAST_INSERT_ID();

        -- Generar contraseña aleatoria de 4 letras y 4 números
        SET retiro_contrasenia_plana = CONCAT(
            SUBSTRING('ABCDEFGHIJKLMNÑOPQRSTUVWXYZ', FLOOR(1 + RAND() * 26), 1),
            SUBSTRING('ABCDEFGHIJKLMNÑOPQRSTUVWXYZ', FLOOR(1 + RAND() * 26), 1),
            SUBSTRING('ABCDEFGHIJKLMNÑOPQRSTUVWXYZ', FLOOR(1 + RAND() * 26), 1),
            SUBSTRING('ABCDEFGHIJKLMNÑOPQRSTUVWXYZ', FLOOR(1 + RAND() * 26), 1),
            ROUND(RAND() * 9999)
        );

        -- Insertar los detalles del retiro con la contraseña encriptada
        INSERT INTO retiros (contrasenia, estado, id_transaccion)
        VALUES (MD5(retiro_contrasenia_plana), 0, id_retiro);

        -- Confirmar la transacción
        COMMIT;
    ELSE
        -- Si la cuenta está inactiva, mostrar un mensaje de error
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede realizar el retiro. La cuenta está inactiva.';
    END IF;
END //

DELIMITER ;
