-- Crear base de datos
DROP DATABASE IF EXISTS roommanagement;
CREATE DATABASE IF NOT EXISTS roommanagement;
USE roommanagement;

-- Crear tabla de salas
CREATE TABLE IF NOT EXISTS sala (
  idSala INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) DEFAULT NULL,
  descripcion VARCHAR(255) DEFAULT NULL,
  precio DECIMAL(10,2)
);

-- Insertar datos de ejemplo en la tabla sala
INSERT INTO sala (nombre, descripcion, precio) VALUES ('Sala 1', 'Sala general 1', 49.99);
INSERT INTO sala (nombre, descripcion, precio) VALUES ('Sala 2', 'Sala general 2', 49.99);
INSERT INTO sala (nombre, descripcion, precio) VALUES ('Sala 3', 'Sala vip 1', 99.99);
INSERT INTO sala (nombre, descripcion, precio) VALUES ('Sala 4', 'Sala vip 2', 99.99);
INSERT INTO sala (nombre, descripcion, precio) VALUES ('Sala 5', 'Sala general 3', 49.99);

-- Crear tabla de usuarios con el campo de contraseña
CREATE TABLE IF NOT EXISTS usuario (
  idUsuario INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  dni VARCHAR(8) NOT NULL UNIQUE,
  telefono VARCHAR(12),
  email VARCHAR(255) NOT NULL,
  rol ENUM('administrador', 'cliente') DEFAULT 'cliente',
  contrasena VARCHAR(255) NOT NULL -- Campo para almacenar contraseñas de forma segura
);

-- Crear tabla de reservas con relación a las salas y usuarios
CREATE TABLE IF NOT EXISTS reserva (
  idReserva INT AUTO_INCREMENT PRIMARY KEY,
  idUsuario INT,
  idSala INT,
  fechaReserva DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (idSala) REFERENCES sala(idSala),
  FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);


INSERT INTO usuario (nombre, dni, telefono, email, rol, contrasena) 
VALUES ('Admin', '87654321', '123456789', 'admin@gmail.com', 'administrador', '123456');

INSERT INTO usuario (nombre, dni, telefono, email, contrasena) 
VALUES ('jesus', '12345678', '987654321', 'jesus@gmail.com', '123456');

-- Consultar salas
SELECT * FROM sala;

SELECT * FROM usuario;

SELECT * FROM reserva;
