-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-07-2021 a las 04:03:20
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesosdetail`
--

CREATE TABLE `procesosdetail` (
  `ID_PRO_DET` int(255) NOT NULL,
  `ID_FUN_PER` varchar(10) NOT NULL,
  `ID_PRO_PER` int(100) NOT NULL,
  `OBS_REV` varchar(50) NOT NULL,
  `EST_PRO` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `procesosdetail`
--

INSERT INTO `procesosdetail` (`ID_PRO_DET`, `ID_FUN_PER`, `ID_PRO_PER`, `OBS_REV`, `EST_PRO`) VALUES
(1, '1802', 1, 'NULL', 'REVISAR'),
(2, '1803', 2, 'NULL', 'REVISAR'),
(88, '1802', 3, 'NULL', 'REVISAR'),
(89, '1803', 3, 'NULL', 'REVISAR');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `procesosdetail`
--
ALTER TABLE `procesosdetail`
  ADD PRIMARY KEY (`ID_PRO_DET`),
  ADD KEY `ID_PRO_PER` (`ID_PRO_PER`),
  ADD KEY `ID_FUN_PER` (`ID_FUN_PER`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `procesosdetail`
--
ALTER TABLE `procesosdetail`
  MODIFY `ID_PRO_DET` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- Restricciones para tablas volcadas
--

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
