CREATE DATABASE betobank_bda;
use betobank_bda;

CREATE TABLE clientes (
  id_cliente int NOT NULL AUTO_INCREMENT,
  correo VARCHAR (200) NOT NULL UNIQUE,
  nombre varchar(50) NOT NULL,
  apellido_paterno varchar(25) NOT NULL,
  apellido_materno varchar(25) DEFAULT NULL,
  fecha_nacimiento date NOT NULL,
  calle varchar(45) NOT NULL,
  colonia varchar(45) NOT NULL,
  cp varchar(5) NOT NULL,
  num_casa varchar(5) NOT NULL,
  contrasenia varchar(50) NOT NULL,
  PRIMARY KEY (id_cliente)
);

CREATE TABLE cuentas (
  num_cuenta int NOT NULL AUTO_INCREMENT,
  saldo decimal(10,0) NOT NULL,
  fecha_apertura datetime NOT NULL,
  estado bit(1) NOT NULL,
  id_cliente int NOT NULL,
  PRIMARY KEY (num_cuenta),
  KEY id_cliente_idx (id_cliente),
  CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
);

CREATE TABLE transacciones (
  id_transaccion int NOT NULL AUTO_INCREMENT,
  saldo_transaccion decimal(10,0) NOT NULL,
  fecha datetime NOT NULL,
  PRIMARY KEY (id_transaccion)
);

CREATE TABLE transferencia (
  id_transferencia int NOT NULL AUTO_INCREMENT,
  id_transaccion int NOT NULL,
  num_cuenta_transferir int NOT NULL,
  PRIMARY KEY (id_transferencia),
  KEY id_transaccion_idx (id_transaccion),
  KEY num_cuenta_transferir_idx (num_cuenta_transferir),
  CONSTRAINT id_transaccion FOREIGN KEY (id_transaccion) REFERENCES transacciones (id_transaccion),
  CONSTRAINT num_cuenta_transferir FOREIGN KEY (num_cuenta_transferir) REFERENCES cuentas (num_cuenta)
);

CREATE TABLE retiros (
	folio INT PRIMARY KEY AUTO_INCREMENT,
    contrasenia VARCHAR (50) not null,
    estado bit(1) NOT NULL,
    id_transaccion INT NOT NULL,
	FOREIGN KEY (id_transaccion) REFERENCES transacciones (id_transaccion)
);

ALTER TABLE transacciones
ADD COLUMN num_cuenta INT NOT NULL,
ADD CONSTRAINT fk_num_cuenta
FOREIGN KEY (num_cuenta) REFERENCES cuentas(num_cuenta);