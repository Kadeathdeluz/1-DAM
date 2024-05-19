DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

--
-- Table structure for table `biblioteca`.`amigo`
--

-- DROP TABLE IF EXISTS `amigo`;
CREATE TABLE `amigo` (
  `NUM` int NOT NULL,
  `NOMBRE` varchar(60) default NULL,
  `TELEFONO` varchar(10) default NULL,
  PRIMARY KEY  (`NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `biblioteca`.`autor`
--

-- DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `AUTOR_ID` varchar(4) NOT NULL,
  `NOMBRE` varchar(35) default NULL,
  `NACIONALIDAD` varchar(20) default NULL,
  PRIMARY KEY  (`AUTOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `biblioteca`.`libro`
--

-- DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `ID_LIB` varchar(10) NOT NULL,
  `TITULO` varchar(80) default NULL,
  `AÑO` int default NULL,
  `VARIAS_OBRAS` int default NULL,
  PRIMARY KEY  (`ID_LIB`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `biblioteca`.`prestamo`
--

-- DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE `prestamo` (
  `NUM` int NOT NULL,
  `ID_LIB` varchar(10) NOT NULL,
  PRIMARY KEY  (`NUM`,`ID_LIB`),
  CONSTRAINT FK_P_A FOREIGN KEY (`NUM`) REFERENCES `amigo` (`NUM`),
  CONSTRAINT FK_P_L FOREIGN KEY (`ID_LIB`) REFERENCES `libro` (`ID_LIB`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `biblioteca`.`tema`
--

-- DROP TABLE IF EXISTS `tema`;
CREATE TABLE `tema` (
  `TEMATICA` varchar(20) NOT NULL,
  `DESCRIPCION` varchar(50) default NULL,
  PRIMARY KEY  (`TEMATICA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `biblioteca`.`obra`
--

-- DROP TABLE IF EXISTS `obra`;
CREATE TABLE `obra` (
  `COD_OB` double NOT NULL,
  `TITULO` varchar(80) default NULL,
  `TEMATICA` varchar(20) default NULL,
  PRIMARY KEY  (`COD_OB`),
  CONSTRAINT FK_O_T FOREIGN KEY (`TEMATICA`) REFERENCES `tema` (`TEMATICA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `biblioteca`.`escribir`
--

-- DROP TABLE IF EXISTS `escribir`;
CREATE TABLE `escribir` (
  `AUTOR_ID` varchar(4) NOT NULL,
  `COD_OB` double NOT NULL,
  PRIMARY KEY  (`AUTOR_ID`,`COD_OB`),
  CONSTRAINT FK_E_A FOREIGN KEY (`AUTOR_ID`) REFERENCES `autor` (`AUTOR_ID`),
  CONSTRAINT FK_E_O FOREIGN KEY (`COD_OB`) REFERENCES `obra` (`COD_OB`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `biblioteca`.`esta_en`
--


-- DROP TABLE IF EXISTS `esta_en`;
CREATE TABLE `esta_en` (
  `COD_OB` double NOT NULL,
  `ID_LIB` varchar(10) NOT NULL,
  PRIMARY KEY  (`COD_OB`,`ID_LIB`),
  CONSTRAINT FK_ES_L FOREIGN KEY (`ID_LIB`) REFERENCES `libro` (`ID_LIB`),
  CONSTRAINT FK_ES_O FOREIGN KEY (`COD_OB`) REFERENCES `obra` (`COD_OB`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



