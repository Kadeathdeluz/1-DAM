CREATE DATABASE IF NOT EXISTS db_elec_corrupoly 
CHARACTER SET utf8mb4 COLLATE utf8mb4_es_0900_as_cs;

use db_elec_corrupoly;

CREATE TABLE IF NOT EXISTS centro (
id_centro VARCHAR(5) PRIMARY KEY,
nombre_centro VARCHAR(60),
direccion VARCHAR(100),
CONSTRAINT cen_nomdir_uk UNIQUE(nombre_centro,direccion)
);

CREATE TABLE IF NOT EXISTS horario (
dia DATE,
hora_inicio TIME,
hora_fin TIME,
PRIMARY KEY(dia,hora_inicio,hora_fin),
CONSTRAINT hor_dia_ck CHECK(dia >='2025-03-03' AND dia <='2025-03-18'),
CONSTRAINT hor_inifin_ck CHECK(TIMEDIFF(hora_fin,hora_inicio) <= TIME(20000) 
    AND TIMEDIFF(hora_fin,hora_inicio) > TIME(0))
);

CREATE TABLE IF NOT EXISTS votante (
dni VARCHAR(10) PRIMARY KEY,
nom_comp VARCHAR(200),
dir_tipo VARCHAR(4),
dir_nombre VARCHAR(60),
dir_piso TINYINT,
dir_numero SMALLINT,
dir_localidad VARCHAR(50) NOT NULL,
telefono VARCHAR(12)
);

CREATE TABLE IF NOT EXISTS senador (
dni VARCHAR(10) PRIMARY KEY,
circ_presenta VARCHAR(25) NOT NULL,
partido VARCHAR(4),
num_votos INTEGER,
pago_compra_voto DECIMAL(5,2),
CONSTRAINT sen_vot_fk FOREIGN KEY(dni) REFERENCES votante(dni),
CONSTRAINT sen_par_ck CHECK(partido IN ('ASIR', 'DAM', 'DAW', 'PHT', 'PRO'))    
);

CREATE TABLE IF NOT EXISTS interventor (
dni VARCHAR(10) PRIMARY KEY,
sueldo DECIMAL(8,2) NOT NULL,
centro_asignado VARCHAR(5) NOT NULL,
supervisor VARCHAR(10),
CONSTRAINT int_vot_fk FOREIGN KEY(dni) REFERENCES votante(dni),
CONSTRAINT int_cen_fk FOREIGN KEY(centro_asignado) REFERENCES centro(id_centro) 
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT int_int_fk FOREIGN KEY(supervisor) REFERENCES interventor(dni)
);

CREATE TABLE IF NOT EXISTS id_digital (
id VARCHAR(10) PRIMARY KEY,
password CHAR(16),
circunscripcion VARCHAR(25),
comprado BOOLEAN,
senador_corrupto VARCHAR(10),
CONSTRAINT id_sen_fk FOREIGN KEY(senador_corrupto) REFERENCES senador(dni)
);

CREATE TABLE IF NOT EXISTS pide_c (
dni_votante VARCHAR(10),
dia DATE,
hora_inicio TIME,
hora_fin TIME,
id_centro VARCHAR(5),
PRIMARY KEY(dni_votante,dia,hora_inicio,hora_fin,id_centro),
CONSTRAINT pid_vot_fk FOREIGN KEY(dni_votante) REFERENCES votante(dni),
CONSTRAINT pid_hor_fk FOREIGN KEY(dia,hora_inicio,hora_fin) 
REFERENCES horario(dia,hora_inicio,hora_fin),
CONSTRAINT pid_cen_fk FOREIGN KEY(id_centro) REFERENCES centro(id_centro)
);

CREATE TABLE IF NOT EXISTS vota_sen (
id_voto VARCHAR(10),
dni_senador VARCHAR(10),
PRIMARY KEY(id_voto,dni_senador),
CONSTRAINT vos_dig_fk FOREIGN KEY(id_voto) REFERENCES id_digital(id),
CONSTRAINT vos_sen_fk FOREIGN KEY(dni_senador) REFERENCES senador(dni)
);

INSERT INTO centro VALUES
('C006', 'Centro de Estudios Superiores Robantes', 'Calle de Alca, 49'),
('C007', 'Centro de Bienestar Animal Los Esquilados', 'Carretera del Extremado, 16'),
('C008', 'Centro de Innovación Tecnológica y Empresarial', 'Calle de Santa Engracia, 28'),
('C009', 'Centro de Cultura y Ocio Gran Vida', 'Calle Gran Vida, 45'),
('C010', 'Centro de Deporte Dopa2', 'Avenida de Eurroba, 10');

INSERT INTO horario VALUES
('2025-03-03', '09:00:00', '11:00:00'),
('2025-03-03', '12:00:00', '14:00:00'),
('2025-03-03', '15:00:00', '17:00:00'),
('2025-03-04', '10:00:00', '12:00:00'),
('2025-03-04', '13:00:00', '15:00:00'),
('2025-03-04', '16:00:00', '18:00:00'),
('2025-03-05', '09:30:00', '11:30:00'),
('2025-03-05', '12:30:00', '14:30:00'),
('2025-03-05', '15:30:00', '17:30:00'),
('2025-03-06', '10:30:00', '12:30:00'),
('2025-03-06', '13:30:00', '15:30:00'),
('2025-03-06', '16:30:00', '18:30:00'),
('2025-03-07', '09:15:00', '11:15:00'),
('2025-03-07', '12:15:00', '14:15:00'),
('2025-03-07', '15:15:00', '17:15:00'),
('2025-03-08', '10:15:00', '12:15:00'),
('2025-03-08', '13:15:00', '15:15:00'),
('2025-03-08', '16:15:00', '18:15:00'),
('2025-03-09', '09:45:00', '11:45:00'),
('2025-03-09', '12:45:00', '14:45:00');

INSERT INTO votante VALUES
('12345678A', 'David Miente Losada', 'C/', 'San Juan', 2, 12, 'Bribonería', '555123456'),
('23456789B', 'Yolanda Metu Sueldo', 'Av.', 'Carretas', 4, 34, 'Tongo', '555234567'),
('34567890C', 'Carlos Martínez Gómez', 'Pz.', 'Mayor', 1, 56, 'Ciudad del Robo', '555345678'),
('45678901D', 'Diana Rodríguez Fernández', 'C/', 'Valencia', 3, 78, 'Freedonia', '555456789'),
('56789012E', 'Elena Sánchez Cohecho', 'C/', 'Delicias', 5, 90, 'Abucity', '555567890'),
('67890123F', 'Fernando Comisión Permanente', 'C/', 'Sevilla', 2, 12, 'Tramposta', '555678901'),
('78901234G', 'Gloria Malversa Mucho', 'C/', 'Embajadores', 4, 34, 'Pelotazo', '555789012'),
('89012345H', 'Óscar Gocom Prado', 'C/', 'Fuencarral', 1, 56, 'Enchufity', '555890123'),
('90123456I', 'Bruno Roba Robles', 'C/', 'Goya', 3, 78, 'Desfalcon', '555901234'),
('01234567J', 'Javier Mangui López', 'C/', 'Ventisquero de la Condesa', 5, 90, 'Trapelcheo', '555012345'),
('11223344K', 'Karla López Pérez', 'C/', 'Hortaleza', 2, 12, 'Bribonería', '555112233'),
('22334455L', 'Luis Martínez Rodríguez', 'C/', 'Jorge Juan', 4, 34, 'Tongo', '555223344'),
('33445566M', 'María Rodríguez Gómez', 'C/', 'León', 1, 56, 'Ciudad del Robo', '555334455'),
('44556677N', 'Nicolás Sánchez Fernández', 'C/', 'Jorge Juan', 3, 78, 'Freedonia', '555445566'),
('55667788O', 'Olga González Díaz', 'C/', 'Lope de Vega', 5, 90, 'Abucity', '555556677'),
('66778899P', 'Pedro Pérez García', 'C/', 'Santiago', 2, 12, 'Tramposta', '555667788'),
('77889900Q', 'Queralt Díaz Martínez', 'C/', 'Menéndez Pelayo', 4, 34, 'Pelotazo', '555778899'),
('88990011R', 'Raúl Fernández López', 'C/', 'Lope de Vega', 1, 56, 'Enchufity', '555889900'),
('99001122S', 'Sara García Ruiz', 'C/', 'Toledo', 3, 78, 'Desfalcon', '555990011'),
('00112233T', 'Tomás López González', 'C/', 'Ríos Rosas', 5, 90, 'Trapelcheo', '555001122'),
('11223344U', 'Ursula Martínez Pérez', 'C/', 'Quevedo', 2, 12, 'Bribonería', '555112233'),
('22334455V', 'Víctor Rodríguez Sánchez', 'C/', 'Serrano', 4, 34, 'Tongo', '555223344'),
('33445566W', 'Wendy Sánchez Fernández', 'C/', 'Reina Victoria', 1, 56, 'Ciudad del Robo', '555334455'),
('44556677X', 'Xavier González Gómez', 'C/', 'Girona', 3, 78, 'Freedonia', '555445566'),
('55667788Y', 'Isabel Pérez Díaz', 'C/', 'Narváez', 5, 90, 'Abucity', '555556677'),
('66778899Z', 'Zacarías Díaz García', 'C/', 'Quevedo', 2, 12, 'Tramposta', '555667788'),
('12345678Z', 'Zoe García Pérez', 'C/', 'Menéndez Pelayo', 4, 34, 'Pelotazo', '555123456'),
('23456789Y', 'Yago López Sánchez', 'Av.', 'Málaga', 1, 56, 'Enchufity', '555234567'),
('34567890X', 'Xenia Martínez Gómez', 'Pz.', 'Salamanca', 3, 78, 'Desfalcon', '555345678'),
('45678901W', 'Walter Rodríguez Fernández', 'C/', 'Zaragoza', 5, 90, 'Trapelcheo', '555456789'),
('56789012V', 'Verónica Sánchez Díaz', 'C/', 'América', 2, 12, 'Bribonería', '555567890'),
('67890123U', 'Ulises González García', 'C/', 'Narváez', 4, 34, 'Tongo', '555678901'),
('78901234T', 'Teresa Pérez Martín', 'C/', 'Velázquez', 1, 56, 'Ciudad del Robo', '555789012'),
('89012345S', 'Sergio Díaz López', 'C/', 'Colón', 3, 78, 'Freedonia', '555890123'),
('90123456R', 'Rosa Fernández Ruiz', 'C/', 'Ríos Rosas', 5, 90, 'Abucity', '555901234'),
('01234567Q', 'Quim García Sánchez', 'C/', 'Velázquez', 2, 12, 'Tramposta', '555012345'),
('11223344P', 'Patricia López Pérez', 'C/', 'San Luis', 4, 34, 'Pelotazo', '555112233'),
('22334455O', 'Óscar Martínez Rodríguez', 'C/', 'Serrano', 1, 56, 'Enchufity', '555223344');

INSERT INTO senador VALUES
('12345678A', 'Impunícia', 'ASIR', 33000, 500.00),
('23456789B', 'Ladronia', 'ASIR', 25000, 500.00),
('34567890C', 'Impunícia', 'DAM', 40000, NULL),
('45678901D', 'Ladronia', 'DAM', 38000, NULL),
('56789012E', 'Impunícia', 'DAW', 25000, 350.50),
('67890123F', 'Ladronia', 'DAW', 35000, 750.00),
('78901234G', 'Ladronia', 'PHT', 350000, 999.99),
('89012345H', 'Impunícia', 'PHT', 50000, 700.00),
('90123456I', 'Ladronia', 'PRO', 42000, 100.00),
('01234567J', 'Impunícia', 'PRO', 15000, 800.00);

INSERT INTO interventor VALUES
('12345678A', 1500.00, 'C006', NULL),
('78901234G', 2000.00, 'C007', NULL),
('11223344U', 1900.00, 'C009', NULL),
('99001122S', 1700.00, 'C009', '11223344U'),
('33445566M', 1800.00, 'C008', '99001122S'),
('67890123F', 2100.00, 'C006', NULL),
('55667788O', 1600.00, 'C009', '99001122S');

INSERT INTO id_digital VALUES
('I1J2K3L4M5', '4gH7!pQ9@wE3#rT6', 'Impunícia', TRUE, '12345678A'),
('R2S5T8Q3P6', '3fJ6^tG8*nM7(cB4', 'Impunícia', TRUE, '56789012E'),
('N5O4P3Q2R1', '9lN1)zX3+eD6-aF0', 'Ladronia', TRUE, '78901234G'),
('C9D7E5F3G1', '7xH9#yF4$sC8%tP3', 'Ladronia', TRUE, '23456789B'),
('M9N7L5K3J1', '1yN0)qP6+cL9-eH5', 'Ladronia', FALSE, NULL),
('V8Z6Y4X2W7', '3yN9)qG5+cM4-eH8', 'Ladronia', TRUE, '67890123F'),
('N8M6L4K2J7', '2zB1)hL8+cE4-eP6', 'Ladronia', TRUE, '67890123F'),
('H5I4J3K2L1', '9dG5.kE6,lH4;nC1', 'Ladronia', TRUE, '78901234G'),
('F6E8D2C4A9', '5aP7_mJ4@zC6/iE2', 'Ladronia', FALSE, NULL),
('Z5X7W9Y3V1', '6cL8&zE3^hB7*nJ2', 'Ladronia', TRUE, '23456789B'),
('3A7F9B4C5D', '1dG2.kC6,lH7;nF0', 'Impunícia', TRUE, '90123456I'),
('U7T9S5R3Q1', '6aH3_mE9@yT4/iG8', 'Ladronia', TRUE, '01234567J'),
('Y2X4Z6W8V1', '2fT5`eC7|dL2=sN0', 'Impunícia', TRUE, '89012345H'),
('P1Q3R5S7T9', '0fT6`eC2|dM5·sP9', 'Impunícia', TRUE, '90123456I'),
('Z5A4B3C2D1', '4aH8_mF7@yT3/iN6', 'Ladronia', TRUE, '78901234G'),
('C1D2E3F4G5', '8xJ3#nS1$sF6%gT2', 'Impunícia', FALSE, NULL),
('J5K4L3M2N1', '6rF9~wM7/oD3@hN4', 'Ladronia', FALSE, NULL),
('D1C3E5F7G9', '7cE2&yH0^eJ5*nM9', 'Impunícia', TRUE, '56789012E'),
('D5E4F3G2H1', NULL, 'Ladronia', TRUE, '01234567J'),
('O3N5M7L9K1', '8eC0.kH6,lP3;nF2', 'Ladronia', FALSE, NULL),
('Z1X4C7V2B9', '6wS2.kJ7,lM4;nH0', 'Ladronia', TRUE, '78901234G'),
('K0L9M8N7O6', '0eN6.kH3,lP5;nG9', 'Impunícia', TRUE, '12345678A'),
('S6T8Q2R4P9', '4wS5:uG2!dN8@rF7', 'Ladronia', TRUE, '78901234G'),
('G2F4E6D8C3', '9xH4#yE1$sL7%tC3', 'Ladronia', TRUE, '78901234G'),
('Y1Z2A3B4C5', '8cM3&zP0^hJ6*nF2', 'Impunícia', TRUE, '89012345H'),
('G1H2I3J4K5', '7rL6~vF4/oE3@kP1', 'Impunícia', FALSE, NULL),
('X5Y4Z3A2B1', '1gC8`xT6|nF51sL3', 'Ladronia', TRUE, '67890123F'),
('X6Y2Z8W1T9', '3wP4:uN2!zG9@rL8', 'Impunícia', FALSE, NULL),
('L5M4N3O2P1', '5rM7~vJ4/oG8@kF3', 'Ladronia', FALSE, NULL),
('A9B8C7D6E5', '5wP8:uN4!zG3@rM7', 'Impunícia', TRUE, '89012345H'),
('S4T6Q8R2P7', '9dL5`xP4|gN3asH8', 'Impunícia', TRUE, '89012345H'),
('T5U4V3W2X1', '0yJ2)qG7+cF1-eS6', 'Ladronia', TRUE, '78901234G'),
('P5Q4R3S2T1', '5cM3&zH8^eP2*nL7', 'Ladronia', FALSE, NULL),
('O1P2Q3R4S5', NULL, 'Impunícia', TRUE, '90123456I'),
('P8Q3R6S1T7', '2wS7:uG5!nD0@rM6', 'Impunícia', FALSE, NULL),
('H3J5L7N9M1', '6xP4#nS9$sH3%gC2', 'Impunícia', FALSE, NULL),
('S1T2U3V4W5', '7eG3.kF2,lB1;nT8', 'Impunícia', FALSE, NULL),
('U1V2W3X4Y5', '1wB6:uT0!dF5@rN3', 'Impunícia', FALSE, NULL),
('E1F2G3H4I5', '3aT6_mJ7@zL4/iG9', 'Impunícia', TRUE, '12345678A'),
('W1X3Y5Z7V9', '4rN1~wF6/oE0@hT9', 'Ladronia', FALSE, NULL),
('K2L4M6N8P3', '2aF5_mH4@zC3/iP6', 'Ladronia', FALSE, NULL),
('Q7R9S3T5U1', '8fC1`yJ3|nD2isM4', 'Ladronia', FALSE, NULL),
('K1L2M3N4O5', '3rD6~vL4/oG2@kN9', 'Impunícia', FALSE, NULL),
('B4C6D8E2F9', '9zS0)hM5+cJ3-eG8', 'Impunícia', TRUE, '89012345H'),
('F4G3H2I1J0', '4bT3&uP6^gL2*nF7', 'Ladronia', TRUE, '78901234G'),
('J5K8L1M4N7', '5xG4#eN7$sM3%tF2', 'Impunícia', FALSE, NULL),
('U3Y6W9T4S8', '0yH5:qL8!fD3@rC1', 'Impunícia', TRUE, '89012345H'),
('L9H2D5F8B3', NULL, 'Ladronia', FALSE, NULL),
('G5E2C9F4A6', '7hZ4`bN8|qE3qwS6', 'Impunícia', TRUE, '56789012E'),
('N4M1K3J7H8', '2dC5~sV7/oR4@hT8', 'Impunícia', FALSE, NULL);

INSERT INTO pide_c VALUES
('01234567J','2025-03-09','12:45:00','14:45:00','C006'),
('11223344K','2025-03-03','15:00:00','17:00:00','C007'),
('11223344K','2025-03-07','09:15:00','11:15:00','C007'),
('12345678Z','2025-03-07','09:15:00','11:15:00','C006'),
('23456789B','2025-03-08','16:15:00','18:15:00','C007'),
('23456789B','2025-03-09','12:45:00','14:45:00','C007'),
('33445566W','2025-03-05','12:30:00','14:30:00','C008'),
('34567890C','2025-03-03','09:00:00','11:00:00','C010'),
('34567890C','2025-03-04','13:00:00','15:00:00','C007'),
('34567890X','2025-03-03','09:00:00','11:00:00','C007'),
('34567890X','2025-03-06','16:30:00','18:30:00','C007'),
('44556677N','2025-03-08','10:15:00','12:15:00','C010'),
('45678901D','2025-03-04','16:00:00','18:00:00','C007'),
('45678901D','2025-03-06','10:30:00','12:30:00','C008'),
('45678901D','2025-03-09','12:45:00','14:45:00','C009'),
('45678901W','2025-03-06','13:30:00','15:30:00','C008'),
('45678901W','2025-03-06','16:30:00','18:30:00','C006'),
('55667788O','2025-03-03','09:00:00','11:00:00','C008'),
('55667788O','2025-03-04','10:00:00','12:00:00','C008'),
('55667788O','2025-03-09','12:45:00','14:45:00','C008'),
('56789012E','2025-03-06','13:30:00','15:30:00','C006'),
('56789012V','2025-03-05','09:30:00','11:30:00','C008'),
('66778899Z','2025-03-04','10:00:00','12:00:00','C007'),
('77889900Q','2025-03-03','09:00:00','11:00:00','C008'),
('77889900Q','2025-03-08','16:15:00','18:15:00','C008'),
('78901234T','2025-03-03','15:00:00','17:00:00','C010'),
('88990011R','2025-03-09','12:45:00','14:45:00','C007'),
('89012345S','2025-03-09','12:45:00','14:45:00','C010'),
('90123456R','2025-03-08','13:15:00','15:15:00','C006'),
('90123456R','2025-03-09','09:45:00','11:45:00','C008');

INSERT INTO vota_sen VALUES
('3A7F9B4C5D', '56789012E'),
('3A7F9B4C5D', '34567890C'),
('A9B8C7D6E5', '89012345H'),
('B4C6D8E2F9', '12345678A'),
('B4C6D8E2F9', '01234567J'),
('C9D7E5F3G1', '78901234G'),
('C9D7E5F3G1', '23456789B'),
('D1C3E5F7G9', '89012345H'),
('D5E4F3G2H1', '78901234G'),
('E1F2G3H4I5', '12345678A'),
('F4G3H2I1J0', '90123456I'),
('F4G3H2I1J0', '45678901D'),
('F6E8D2C4A9', '45678901D'),
('G1H2I3J4K5', '89012345H'),
('G1H2I3J4K5', '34567890C'),
('G2F4E6D8C3', '23456789B'),
('G5E2C9F4A6', '56789012E'),
('G5E2C9F4A6', '01234567J'),
('H5I4J3K2L1', '78901234G'),
('H5I4J3K2L1', '67890123F'),
('I1J2K3L4M5', '12345678A'),
('J5K4L3M2N1', '78901234G'),
('J5K8L1M4N7', '34567890C'),
('K0L9M8N7O6', '12345678A'),
('K0L9M8N7O6', '34567890C'),
('K1L2M3N4O5', '89012345H'),
('K1L2M3N4O5', '56789012E'),
('L9H2D5F8B3', '78901234G'),
('L9H2D5F8B3', '45678901D'),
('N4M1K3J7H8', '12345678A'),
('N5O4P3Q2R1', '78901234G'),
('N8M6L4K2J7', '78901234G'),
('O1P2Q3R4S5', '12345678A'),
('O3N5M7L9K1', '45678901D'),
('O3N5M7L9K1', '23456789B'),
('P1Q3R5S7T9', '89012345H'),
('P8Q3R6S1T7', '12345678A'),
('P8Q3R6S1T7', '01234567J'),
('Q7R9S3T5U1', '45678901D'),
('Q7R9S3T5U1', '67890123F'),
('R2S5T8Q3P6', '34567890C'),
('S1T2U3V4W5', '89012345H'),
('S6T8Q2R4P9', '67890123F'),
('T5U4V3W2X1', '45678901D'),
('T5U4V3W2X1', '78901234G'),
('U1V2W3X4Y5', '34567890C'),
('U3Y6W9T4S8', '89012345H'),
('W1X3Y5Z7V9', '23456789B'),
('W1X3Y5Z7V9', '45678901D'),
('X5Y4Z3A2B1', '78901234G'),
('X5Y4Z3A2B1', '23456789B'),
('X6Y2Z8W1T9', '01234567J'),
('Y1Z2A3B4C5', '34567890C'),
('Y1Z2A3B4C5', '01234567J'),
('Y2X4Z6W8V1', '01234567J'),
('Z1X4C7V2B9', '90123456I'),
('Z5A4B3C2D1', '67890123F'),
('Z5A4B3C2D1', '23456789B');
