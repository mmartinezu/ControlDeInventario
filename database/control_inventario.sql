-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-08-2021 a las 02:37:28
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `control_inventario`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addProcesoValidacion` (IN `titulo` VARCHAR(20), IN `fecha` VARCHAR(15), IN `func` VARCHAR(10), IN `proceso` INT(100))  NO SQL
BEGIN
START TRANSACTION;
INSERT INTO procesosheader (TIT_PRO, FEC_PRO) VALUES(titulo, fecha);
INSERT INTO procesosdetail (ID_FUN_PER, ID_PRO_PER, OBS_REV) VALUES(func, proceso, "REVISAR");
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activos`
--

CREATE TABLE `activos` (
  `ID_ACT` varchar(10) NOT NULL,
  `NOM_ACT` varchar(20) NOT NULL,
  `EST_ACT` varchar(20) NOT NULL,
  `COD_BAR_ACT` varchar(30) NOT NULL,
  `ID_FUN_PER` varchar(10) NOT NULL,
  `REV_ACT` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `activos`
--

INSERT INTO `activos` (`ID_ACT`, `NOM_ACT`, `EST_ACT`, `COD_BAR_ACT`, `ID_FUN_PER`, `REV_ACT`) VALUES
('ACT001', 'Refrigerador', 'Nuevo', '5901234123457', '1802', 'N'),
('ACT002', 'Television', 'Seminuevo', '123456789012', '1802', 'N'),
('ACT003', 'Plancha', 'Nuevo', '1234567890128', '1803', 'N'),
('ACT004', 'Radio', 'Nuevo', '4070071967072', '1803', 'N'),
('ACT005', 'Sillon', 'Seminuevo', '8414533043847', '1804', 'N'),
('ACT006', 'Laptop', 'Nuevo', '7501234567893', '1804', 'N'),
('ACT007', 'Impresora', 'Seminuevo', '51000012517', '1803', 'N');

--
-- Disparadores `activos`
--
DELIMITER $$
CREATE TRIGGER `actualizarNumActivos` AFTER INSERT ON `activos` FOR EACH ROW BEGIN 
    UPDATE FUNCIONARIOS
    SET NUM_ACT_FUN = NUM_ACT_FUN + 1 
    WHERE ID_FUN = NEW.ID_FUN_PER;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionarios`
--

CREATE TABLE `funcionarios` (
  `ID_FUN` varchar(10) NOT NULL,
  `NOM_FUN` varchar(20) NOT NULL,
  `APE_FUN` varchar(20) NOT NULL,
  `NUM_ACT_FUN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `funcionarios`
--

INSERT INTO `funcionarios` (`ID_FUN`, `NOM_FUN`, `APE_FUN`, `NUM_ACT_FUN`) VALUES
('1802', 'John', 'Arcos', 2),
('1803', 'Maria', 'Vargas', 3),
('1804', 'Marco', 'Perez', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesosdetail`
--

CREATE TABLE `procesosdetail` (
  `ID_PRO_DET` int(255) NOT NULL,
  `ID_FUN_PER` varchar(10) NOT NULL,
  `ID_PRO_PER` int(100) NOT NULL,
  `OBS_REV` varchar(300) NOT NULL,
  `EST_PRO` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `procesosdetail`
--

INSERT INTO `procesosdetail` (`ID_PRO_DET`, `ID_FUN_PER`, `ID_PRO_PER`, `OBS_REV`, `EST_PRO`) VALUES
(197, '1802', 1, 'NULL', 'REVISAR'),
(198, '1804', 1, 'NULL', 'REVISAR'),
(199, '1803', 2, '', 'FINALIZADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesosheader`
--

CREATE TABLE `procesosheader` (
  `ID_PRO` int(100) NOT NULL,
  `TIT_PRO` varchar(60) NOT NULL,
  `FEC_PRO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `procesosheader`
--

INSERT INTO `procesosheader` (`ID_PRO`, `TIT_PRO`, `FEC_PRO`) VALUES
(1, 'Proceso 2021 area ventas', 'jul-08-2021'),
(2, 'Proceso 2021 area contable', 'ago-12-2021');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_USU` varchar(10) NOT NULL,
  `NOM_USU` varchar(20) NOT NULL,
  `APE_USU` varchar(20) NOT NULL,
  `CLA_USU` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_USU`, `NOM_USU`, `APE_USU`, `CLA_USU`) VALUES
('1805776208', 'Mateo', 'Martinez', 'mmmm'),
('1808', 'Mateo', 'Martinez', '1efcfaab69');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activos`
--
ALTER TABLE `activos`
  ADD PRIMARY KEY (`ID_ACT`),
  ADD KEY `ID_FUN_PER` (`ID_FUN_PER`);

--
-- Indices de la tabla `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`ID_FUN`);

--
-- Indices de la tabla `procesosdetail`
--
ALTER TABLE `procesosdetail`
  ADD PRIMARY KEY (`ID_PRO_DET`),
  ADD KEY `ID_PRO_PER` (`ID_PRO_PER`),
  ADD KEY `ID_FUN_PER` (`ID_FUN_PER`);

--
-- Indices de la tabla `procesosheader`
--
ALTER TABLE `procesosheader`
  ADD PRIMARY KEY (`ID_PRO`),
  ADD UNIQUE KEY `TIT_PRO` (`TIT_PRO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `procesosdetail`
--
ALTER TABLE `procesosdetail`
  MODIFY `ID_PRO_DET` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=200;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activos`
--
ALTER TABLE `activos`
  ADD CONSTRAINT `activos_ibfk_1` FOREIGN KEY (`ID_FUN_PER`) REFERENCES `funcionarios` (`ID_FUN`);

--
-- Filtros para la tabla `procesosdetail`
--
ALTER TABLE `procesosdetail`
  ADD CONSTRAINT `procesosdetail_ibfk_1` FOREIGN KEY (`ID_PRO_PER`) REFERENCES `procesosheader` (`ID_PRO`),
  ADD CONSTRAINT `procesosdetail_ibfk_2` FOREIGN KEY (`ID_FUN_PER`) REFERENCES `funcionarios` (`ID_FUN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
