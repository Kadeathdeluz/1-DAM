DROP DATABASE IF EXISTS musica;
CREATE DATABASE musica;
USE musica;

--
-- Table structure for table `musica`.`artista`
--

-- DROP TABLE IF EXISTS `artista`;
CREATE TABLE `artista` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `musica`.`cancion`
--

-- DROP TABLE IF EXISTS `cancion`;
CREATE TABLE `cancion` (
  `cod` integer NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `duracion` double default NULL,
  PRIMARY KEY  (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `musica`.`companyia`
--

-- DROP TABLE IF EXISTS `companyia`;
CREATE TABLE `companyia` (
  `cod` varchar(3) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `dir` varchar(30) default NULL,
  `fax` varchar(15) default NULL,
  `tfno` varchar(15) default NULL,
  PRIMARY KEY  (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `musica`.`grupo`
--

-- DROP TABLE IF EXISTS `grupo`;
CREATE TABLE `grupo` (
  `cod` varchar(3) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fecha` datetime default NULL,
  `pais` varchar(10) default NULL,
  PRIMARY KEY  (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `musica`.`disco`
--

-- DROP TABLE IF EXISTS `disco`;
CREATE TABLE `disco` (
  `cod` varchar(3) NOT NULL,
  `nombre` varchar(30) default NULL,
  `fecha` datetime default NULL,
  `cod_comp` varchar(3) NOT NULL,
  `cod_gru` varchar(3) NOT NULL,
      CONSTRAINT FK_D_G FOREIGN KEY (`cod_gru`) REFERENCES `grupo` (`cod`),
            CONSTRAINT FK_D_C FOREIGN KEY (`cod_comp`) REFERENCES `companyia` (`cod`),
  PRIMARY KEY  (`cod`)  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `musica`.`club`
--

-- DROP TABLE IF EXISTS `club`;
CREATE TABLE `club` (
  `cod` varchar(3) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `sede` varchar(30) default NULL,
  `num` smallint default NULL,
  `cod_gru` varchar(3) NOT NULL,
    CONSTRAINT FK_C_G FOREIGN KEY (`cod_gru`) REFERENCES `grupo` (`cod`),
  PRIMARY KEY  (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `musica`.`pertenece`
--

-- DROP TABLE IF EXISTS `pertenece`;
CREATE TABLE `pertenece` (
  `dni` varchar(10) NOT NULL,
  `cod` varchar(3) NOT NULL,
  `funcion` varchar(15) default NULL,
  PRIMARY KEY  (`dni`,`cod`),
  CONSTRAINT FK_P_A FOREIGN KEY (`dni`) REFERENCES `artista` (`dni`),
  CONSTRAINT FK_P_G FOREIGN KEY (`cod`) REFERENCES `grupo` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `musica`.`esta`
--

-- DROP TABLE IF EXISTS `esta`;
CREATE TABLE `esta` (
  `can` integer NOT NULL,
  `cod` varchar(3) NOT NULL,
  PRIMARY KEY  (`can`,`cod`),
  CONSTRAINT FK_E_C FOREIGN KEY (`can`) REFERENCES `cancion` (`cod`),
  CONSTRAINT FK_E_G FOREIGN KEY (`cod`) REFERENCES `disco` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

