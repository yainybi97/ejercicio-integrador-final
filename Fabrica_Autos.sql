-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 05-11-2020 a las 16:11:54
-- Versión del servidor: 5.7.32-0ubuntu0.18.04.1-log
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Fabrica_Autos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Auto`
--

CREATE TABLE `Auto` (
  `Id` int(100) NOT NULL,
  `Precio` int(11) NOT NULL,
  `NroOpciones` int(7) NOT NULL,
  `IdVariante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Auto`
--

INSERT INTO `Auto` (`Id`, `Precio`, `NroOpciones`, `IdVariante`) VALUES
(7, 245000, 0, 2),
(8, 316000, 3, 3),
(9, 296000, 2, 3),
(10, 242000, 1, 1),
(12, 230000, 0, 1),
(13, 245000, 0, 2),
(15, 265000, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Opcion`
--

CREATE TABLE `Opcion` (
  `Id` int(100) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  `Precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Opcion`
--

INSERT INTO `Opcion` (`Id`, `Descripcion`, `Precio`) VALUES
(1, 'TC', 12000),
(2, 'AA', 20000),
(3, 'ABS', 14000),
(4, 'AB', 7000),
(5, 'LL', 12000),
(11, 'newOp1', 85);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Variante`
--

CREATE TABLE `Variante` (
  `Id` int(100) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  `Precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Variante`
--

INSERT INTO `Variante` (`Id`, `Descripcion`, `Precio`) VALUES
(1, 'Sedan', 230000),
(2, 'Familiar', 245000),
(3, 'Coupe', 270000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Auto`
--
ALTER TABLE `Auto`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Variante` (`IdVariante`);

--
-- Indices de la tabla `Opcion`
--
ALTER TABLE `Opcion`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `Variante`
--
ALTER TABLE `Variante`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Auto`
--
ALTER TABLE `Auto`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `Opcion`
--
ALTER TABLE `Opcion`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `Variante`
--
ALTER TABLE `Variante`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Auto`
--
ALTER TABLE `Auto`
  ADD CONSTRAINT `FK_Variante` FOREIGN KEY (`IdVariante`) REFERENCES `Variante` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
