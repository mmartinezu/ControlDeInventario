-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-07-2021 a las 04:17:47
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
-- Estructura de tabla para la tabla `activos`
--

CREATE TABLE `activos` (
  `ID_ACT` varchar(10) NOT NULL,
  `NOM_ACT` varchar(20) NOT NULL,
  `EST_ACT` varchar(20) NOT NULL,
  `COD_BAR_ACT` varchar(30) NOT NULL,
  `ID_FUN_PER` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `activos`
--

INSERT INTO `activos` (`ID_ACT`, `NOM_ACT`, `EST_ACT`, `COD_BAR_ACT`, `ID_FUN_PER`) VALUES
('ACT001', 'Refrigerador', 'Nuevo', '123456789', '1802'),
('ACT002', 'Television', 'Seminuevo', '987654321', '1802'),
('ACT003', 'Plancha', 'Nuevo', '123789456', '1803');

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
('1802', 'John', 'Arcos', 10),
('1803', 'Maria', 'Vargas', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesosdetail`
--

CREATE TABLE `procesosdetail` (
  `ID_PRO_DET` varchar(10) NOT NULL,
  `ID_FUN_PER` varchar(10) NOT NULL,
  `EST_ACT` varchar(15) NOT NULL,
  `ID_PRO_PER` varchar(10) NOT NULL,
  `OBS_REV` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesosheader`
--

CREATE TABLE `procesosheader` (
  `ID_PRO` varchar(10) NOT NULL,
  `TIT_PRO` varchar(20) NOT NULL,
  `FEC_PRO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
('1805776208', 'Mateo', 'Martinez', 'mmmm');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
