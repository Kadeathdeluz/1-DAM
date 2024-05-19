CREATE DATABASE IF NOT EXISTS DBSuministros CHARACTER SET utf8 COLLATE utf8_spanish_ci;

USE DBSuministros;

-- -----------------------
-- Metadatos (DDL)
-- -----------------------
-- Tabla proveedor (suministrador)
CREATE TABLE IF NOT EXISTS suministrador (
scod            VARCHAR(5) PRIMARY KEY,
snombre         VARCHAR(20) NOT NULL,
estado          INTEGER,
ciudad          VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS pieza (
pcod            VARCHAR(6) PRIMARY KEY,
pnombre         VARCHAR(20) NOT NULL,
color           VARCHAR(10),
peso            FLOAT DEFAULT 0.0,
ciudad          VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS suministropieza (
scod        VARCHAR(5),
pcod        VARCHAR(6),
cantidad    INTEGER DEFAULT 0,
CONSTRAINT sum_sp_pk PRIMARY KEY(scod, pcod),
CONSTRAINT sum_sco_fk FOREIGN KEY(scod) REFERENCES suministrador(scod) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT sum_pco_fk FOREIGN KEY(pcod) REFERENCES pieza(pcod) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------
-- Datos (DML)
-- -----------------------

INSERT INTO suministrador (scod, snombre, estado, ciudad) VALUES
('s1', 'Smith', 20, 'Londres'),
('s2', 'Jones', 10, 'París'),
('s3', 'Blake', 30, 'París'),
('s4', 'Clark', 20, 'Londres'),
('s5', 'Adams', 30, 'Atenas');

INSERT INTO pieza (pcod, pnombre, color, peso, ciudad) VALUES
('p1','Tuerca','Rojo', 12,'Londres'),
('p2','Clavija','Verde', 17,'París'),
('p3','Tornillo','Azul', 17,'Roma'),
('p4','Tornillo','Rojo', 14,'Londres'),
('p5','Leva','Azul', 12,'París'),
('p6','Diente','Rojo', 19,'Londres');

INSERT INTO suministropieza (scod, pcod, cantidad) VALUES
('s1','p1', 300),
('s1','p2', 200),
('s1','p3', 400),
('s1','p4', 200),
('s1','p5', 100),
('s1','p6', 100),
('s2','p1', 300),
('s2','p2', 400),
('s3','p2', 200),
('s4','p1', 200),
('s4','p4', 300),
('s4','p5', 400);

