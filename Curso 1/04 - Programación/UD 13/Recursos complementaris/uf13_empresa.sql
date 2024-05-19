-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-04-2023 a las 23:23:40
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `uf13_empresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `NUM_CLIE` double NOT NULL,
  `EMPRESA` varchar(255) DEFAULT NULL,
  `REP_CLIE` double DEFAULT NULL,
  `LIMITE_CREDITO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`NUM_CLIE`, `EMPRESA`, `REP_CLIE`, `LIMITE_CREDITO`) VALUES
(2101, 'Exclusivas Soriano S.A.', 106, 65000),
(2102, 'Exclusivas del Este S.L.', 101, 65000),
(2103, 'Pino S.L.', 105, 50000),
(2105, 'MALB S.A.', 101, 45000),
(2106, 'Construcciones Leon S.A.', 102, 65000),
(2107, 'Distribuciones Sur S.A.', 110, 35000),
(2108, 'Zapater Importaciones S.A.', 109, 55000),
(2109, 'Roda & Castedo S.L.', 103, 25000),
(2111, 'EVBE S.A.', 103, 50000),
(2112, 'Lopez Asociados S.L.', 108, 50000),
(2113, 'Importaciones Martin S.L.', 104, 20000),
(2114, 'Componentes Fernandez S.A.', 102, 20000),
(2115, 'AFS S.A.', 101, 20000),
(2117, 'Hnos. Ramon S.L.', 106, 35000),
(2118, 'Exclusivas Norte S.A.', 108, 60000),
(2119, 'Martinez & Garcia S.L.', 109, 25000),
(2120, 'Distribuciones Montiel S.L.', 102, 50000),
(2121, 'Hernandez & hijos S.L.', 103, 45000),
(2122, 'JPF S.L.', 105, 30000),
(2123, 'Hnos. Martinez S.A.', 102, 40000),
(2124, 'Domingo S.L.', 107, 40000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficinas`
--

CREATE TABLE `oficinas` (
  `OFICINA` double NOT NULL,
  `CIUDAD` varchar(255) DEFAULT NULL,
  `REGION` varchar(255) DEFAULT NULL,
  `DIR` double DEFAULT NULL,
  `OBJETIVO` double DEFAULT NULL,
  `VENTAS` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `oficinas`
--

INSERT INTO `oficinas` (`OFICINA`, `CIUDAD`, `REGION`, `DIR`, `OBJETIVO`, `VENTAS`) VALUES
(11, 'Valencia', 'Este', 106, 52500, 40063),
(12, 'Barcelona', 'Este', 104, 70000, 29328),
(13, 'Alicante', 'Este', 105, 30000, 39327),
(21, 'Madrid', 'Centro', 108, 60000, 81309),
(22, 'Toledo', 'Centro', 108, 27500, 34432);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `NUM_PEDIDO` double NOT NULL,
  `FECHA_PEDIDO` timestamp NULL DEFAULT NULL,
  `CLIE` double DEFAULT NULL,
  `REP` double DEFAULT NULL,
  `FAB` varchar(255) DEFAULT NULL,
  `PRODUCTO` varchar(10) DEFAULT NULL,
  `CANT` double DEFAULT NULL,
  `IMPORTE` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`NUM_PEDIDO`, `FECHA_PEDIDO`, `CLIE`, `REP`, `FAB`, `PRODUCTO`, `CANT`, `IMPORTE`) VALUES
(110036, '0000-00-00 00:00:00', 2107, 110, 'ACI', '4100Z', 9, 22500),
(112961, '0000-00-00 00:00:00', 2117, 106, 'REI', '2A44L', 7, 31500),
(112963, '0000-00-00 00:00:00', 2103, 105, 'ACI', '41004', 28, 3276),
(112968, '0000-00-00 00:00:00', 2102, 101, 'ACI', '41004', 34, 3978),
(112975, '0000-00-00 00:00:00', 2111, 103, 'REI', '2A44G', 6, 2100),
(112979, '0000-00-00 00:00:00', 2114, 102, 'ACI', '4100Z', 6, 15000),
(112983, '0000-00-00 00:00:00', 2103, 105, 'ACI', '41004', 6, 702),
(112987, '0000-00-00 00:00:00', 2103, 105, 'ACI', '4100Y', 11, 27500),
(112989, '0000-00-00 00:00:00', 2101, 106, 'FEA', '114', 6, 1458),
(112992, '0000-00-00 00:00:00', 2118, 108, 'ACI', '41002', 10, 760),
(112993, '0000-00-00 00:00:00', 2106, 102, 'REI', '2A45C ', 24, 1896),
(112997, '0000-00-00 00:00:00', 2124, 107, 'BIC', '41003', 1, 652),
(113003, '0000-00-00 00:00:00', 2108, 109, 'IMM', '779C', 3, 5625),
(113007, '0000-00-00 00:00:00', 2112, 108, 'IMM', '773C', 3, 2825),
(113012, '0000-00-00 00:00:00', 2111, 105, 'ACI', '41003', 35, 3745),
(113013, '0000-00-00 00:00:00', 2118, 108, 'BIC', '41003', 1, 652),
(113024, '0000-00-00 00:00:00', 2114, 108, 'QSA', 'XK47', 20, 7100),
(113027, '0000-00-00 00:00:00', 2103, 105, 'ACI', '41002', 54, 4104),
(113034, '0000-00-00 00:00:00', 2107, 110, 'REI', '2A45C', 8, 632),
(113042, '0000-00-00 00:00:00', 2113, 101, 'REI', '2A44R', 5, 22500),
(113045, '0000-00-00 00:00:00', 2112, 108, 'REI', '2A44R', 10, 45000),
(113048, '0000-00-00 00:00:00', 2120, 102, 'IMM', '779C', 2, 3750),
(113049, '0000-00-00 00:00:00', 2118, 108, 'QSA', 'XK47', 2, 776),
(113051, '0000-00-00 00:00:00', 2118, 108, 'QSA', 'XK47', 4, 1420),
(113055, '0000-00-00 00:00:00', 2108, 101, 'ACI', '4100X', 6, 150),
(113057, '0000-00-00 00:00:00', 2111, 103, 'ACI', '4100X', 24, 600),
(113058, '0000-00-00 00:00:00', 2108, 109, 'FEA', '112', 10, 1480),
(113062, '0000-00-00 00:00:00', 2124, 107, 'FEA', '114', 10, 2430),
(113065, '0000-00-00 00:00:00', 2106, 102, 'QSA', 'XK47', 6, 2130),
(113069, '0000-00-00 00:00:00', 2109, 107, 'IMM', '775C', 22, 31350);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID_FAB` varchar(255) NOT NULL DEFAULT '',
  `ID_PRODUCTO` varchar(10) NOT NULL DEFAULT '',
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  `EXISTENCIAS` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_FAB`, `ID_PRODUCTO`, `DESCRIPCION`, `PRECIO`, `EXISTENCIAS`) VALUES
('ACI', '41001', 'Artículo Tipo 1', 55, 277),
('ACI', '41002', 'Artículo Tipo 2', 76, 167),
('ACI', '41003', 'Artículo Tipo 3', 107, 207),
('ACI', '41004', 'Artículo Tipo 4', 117, 139),
('ACI', '4100X', 'Ajustador', 25, 37),
('ACI ', '4100Y ', 'Extractor', 2750, 25),
('ACI', '4100Z', 'Montador', 2500, 28),
('BIC', '41003', 'Manivela', 652, 3),
('BIC', '41089', 'Reten', 225, 78),
('BIC', '41672', 'Plate', 180, 0),
('FEA', '112', 'Cubierta', 148, 115),
('FEA', '114', 'Bancada Motor', 243, 15),
('IMM', '773C', 'Riostra 1/2-Tm', 975, 28),
('IMM', '775C', 'Riostra 1-Tm', 1425, 5),
('IMM', '779C', 'Riostra 2-Tm', 1875, 9),
('IMM', '887H', 'Soporte Riostra', 54, 223),
('IMM', '887P', 'Perno Riostra', 250, 24),
('IMM', '887X', 'Retenedor Riostra', 475, 32),
('QSA', 'XK47', 'Reductor', 355, 38),
('QSA', 'XK48', 'Reductor', 134, 203),
('QSA', 'XK48A', 'Reductor', 117, 37),
('REI', '2A44G', 'Pasador Bisagra', 350, 14),
('REI', '2A44L', 'Bisagra Izqda.', 4500, 12),
('REI', '2A44R', 'Bisagra Dcha.', 4500, 12),
('REI ', '2A45C', 'V Stago Trinquete', 79, 210);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repventas`
--

CREATE TABLE `repventas` (
  `NUM_EMPL` double NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `EDAD` double DEFAULT NULL,
  `OFICINA_REP` double DEFAULT NULL,
  `TITULO` varchar(255) DEFAULT NULL,
  `CONTRATO` timestamp NULL DEFAULT NULL,
  `DIRECTOR` double DEFAULT NULL,
  `CUOTA` double DEFAULT NULL,
  `VENTAS` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `repventas`
--

INSERT INTO `repventas` (`NUM_EMPL`, `NOMBRE`, `EDAD`, `OFICINA_REP`, `TITULO`, `CONTRATO`, `DIRECTOR`, `CUOTA`, `VENTAS`) VALUES
(101, 'Daniel Gutierrez ', 45, 12, 'Rep. Ventas ', '1996-10-19 20:00:00', 104, 27500, 26628),
(102, 'Soledad Martinez', 48, 21, 'Rep. Ventas ', '1996-12-09 22:00:00', 108, 30000, 22776),
(103, 'Pedro Cruz', 29, 12, 'Rep. Ventas ', '1997-02-28 22:00:00', 104, 25000, 2700),
(104, 'Carlos Martinez', 33, 12, 'Dir. Ventas ', '1997-05-18 20:00:00', 106, 17500, 0),
(105, 'Belen Aguirre', 37, 13, 'Dir. Ventas ', '1998-02-11 22:00:00', 104, 30000, 39327),
(106, 'Jose Maldonado', 52, 11, 'VP Ventas', '1998-06-13 20:00:00', NULL, 25000, 32958),
(107, 'Natalia Martin', 49, 22, 'Rep. Ventas', '1998-11-13 22:00:00', 108, 27500, 34432),
(108, 'Lorenzo Fernandez', 62, 21, 'Dir. Ventas ', '1999-10-11 20:00:00', 106, 30000, 58533),
(109, 'Maria Garcia', 31, 11, 'Rep. Ventas ', '1999-10-11 20:00:00', 106, 27500, 7105),
(110, 'Antonio Valle ', 41, NULL, 'Rep. Ventas ', '2000-01-12 22:00:00', 101, NULL, 23123);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`NUM_CLIE`),
  ADD KEY `REP_CLIE` (`REP_CLIE`);

--
-- Indices de la tabla `oficinas`
--
ALTER TABLE `oficinas`
  ADD PRIMARY KEY (`OFICINA`),
  ADD KEY `DIR` (`DIR`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`NUM_PEDIDO`),
  ADD KEY `CLIE` (`CLIE`),
  ADD KEY `REP` (`REP`),
  ADD KEY `FAB` (`FAB`),
  ADD KEY `PRODUCTO` (`PRODUCTO`),
  ADD KEY `PRODUCTO_2` (`PRODUCTO`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID_FAB`,`ID_PRODUCTO`);

--
-- Indices de la tabla `repventas`
--
ALTER TABLE `repventas`
  ADD PRIMARY KEY (`NUM_EMPL`),
  ADD KEY `OFICINA_REP` (`OFICINA_REP`),
  ADD KEY `DIRECTOR` (`DIRECTOR`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`REP_CLIE`) REFERENCES `repventas` (`NUM_EMPL`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `oficinas`
--
ALTER TABLE `oficinas`
  ADD CONSTRAINT `oficinas_ibfk_1` FOREIGN KEY (`DIR`) REFERENCES `repventas` (`NUM_EMPL`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`CLIE`) REFERENCES `clientes` (`NUM_CLIE`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`REP`) REFERENCES `repventas` (`NUM_EMPL`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pedidos_ibfk_3` FOREIGN KEY (`FAB`) REFERENCES `productos` (`ID_FAB`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `repventas`
--
ALTER TABLE `repventas`
  ADD CONSTRAINT `repventas_ibfk_1` FOREIGN KEY (`OFICINA_REP`) REFERENCES `oficinas` (`OFICINA`) ON UPDATE CASCADE,
  ADD CONSTRAINT `repventas_ibfk_2` FOREIGN KEY (`DIRECTOR`) REFERENCES `repventas` (`NUM_EMPL`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
