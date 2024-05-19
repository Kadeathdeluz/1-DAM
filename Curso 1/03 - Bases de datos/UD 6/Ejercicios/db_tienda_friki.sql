CREATE DATABASE IF NOT EXISTS db_tienda_friki
CHARACTER SET utf8mb4 COLLATE utf8mb4_es_0900_as_cs;

USE db_tienda_friki;

CREATE TABLE IF NOT EXISTS proveedor (
cod_prov     VARCHAR(10) PRIMARY KEY,
nombre_prov  VARCHAR(30),
cod_postal   VARCHAR(5)
);

CREATE TABLE IF NOT EXISTS producto (
ref_prod     VARCHAR(10) PRIMARY KEY,
nombre_prod  VARCHAR(30),
precio       DECIMAL(5,2)
);

CREATE TABLE IF NOT EXISTS pedido (
num_ped      INTEGER PRIMARY KEY,
fecha        DATE,
cod_prov     VARCHAR(10),
CONSTRAINT ped_prv_fk FOREIGN KEY (cod_prov) REFERENCES proveedor (cod_prov)
);

CREATE TABLE IF NOT EXISTS detalle_pedido (
num_ped      INTEGER,
ref_prod     VARCHAR(10),
cantidad     INTEGER,
PRIMARY KEY (num_ped, ref_prod),
CONSTRAINT dep_ped_fk FOREIGN KEY (num_ped) REFERENCES pedido (num_ped),
CONSTRAINT dep_prd_fk FOREIGN KEY (ref_prod) REFERENCES producto (ref_prod)
);

INSERT INTO proveedor (cod_prov,nombre_prov,cod_postal) VALUES ('TO342','JUGUETOS, S.A.','45600');
INSERT INTO proveedor (cod_prov,nombre_prov,cod_postal) VALUES ('MA280','TOYPLAY, S.A.','28005');
INSERT INTO proveedor (cod_prov,nombre_prov,cod_postal) VALUES ('BA843','CARMELO DIAZ, S.L.','06004');
INSERT INTO proveedor (cod_prov,nombre_prov,cod_postal) VALUES ('SE391','ARTEAND, S.L.','41400');

INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('NPP10','NAIPES PETER PARKER',3.00);
INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('P3R20','PATINETE 3 RUEDAS',22.50);
INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('AFK11','AVION FK20',31.75);
INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('PM30','PELUCHE MAYA',15.00);
INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('HM12','HOOP MUSICAL',12.80);
INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('BB75','BOLA BOOM',22.20);
INSERT INTO producto (ref_prod,nombre_prod,precio) VALUES ('PT50','PETER PAN',25.00);

INSERT INTO pedido (num_ped,fecha,cod_prov) VALUES (1,'2013-06-10','TO342');
INSERT INTO pedido (num_ped,fecha,cod_prov) VALUES (2,'2013-06-10','MA280');
INSERT INTO pedido (num_ped,fecha,cod_prov) VALUES (3,'2013-06-12','BA843');
INSERT INTO pedido (num_ped,fecha,cod_prov) VALUES (4,'2013-06-14','TO342');
INSERT INTO pedido (num_ped,fecha,cod_prov) VALUES (5,'2013-06-14','MA280');

INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (1,'NPP10',10);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (1,'AFK11',12);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (2,'P3R20',15);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (3,'P3R20',10);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (3,'PM30',20);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (3,'HM12',10);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (4,'AFK11',30);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (4,'BB75',12);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (5,'P3R20',18);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (5,'NPP10',3);
INSERT INTO detalle_pedido (num_ped,ref_prod,cantidad) VALUES (5,'BB75',5);
