-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-10-2024 a las 07:43:10
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cabecera_venta`
--

CREATE TABLE `tb_cabecera_venta` (
  `cab_id` int(11) NOT NULL,
  `cab_cantidad` int(11) NOT NULL,
  `cab_fecha` date NOT NULL,
  `cli_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_categoria`
--

CREATE TABLE `tb_categoria` (
  `categ_id` int(11) NOT NULL,
  `categ_descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `cli_id` int(11) NOT NULL,
  `cli_nombre` varchar(30) NOT NULL,
  `cli_apellido` varchar(30) NOT NULL,
  `cli_DNI` varchar(8) NOT NULL,
  `cli_telefono` varchar(9) NOT NULL,
  `cli_correo` varchar(50) NOT NULL,
  `cli_direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_detalle_venta`
--

CREATE TABLE `tb_detalle_venta` (
  `det_id` int(11) NOT NULL,
  `det_cantidad` int(11) NOT NULL,
  `det_precio` double(10,2) NOT NULL,
  `det_total` double(10,2) NOT NULL,
  `prd_id` int(11) DEFAULT NULL,
  `cab_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_producto`
--

CREATE TABLE `tb_producto` (
  `prd_id` int(11) NOT NULL,
  `prd_nombre` varchar(100) NOT NULL,
  `prd_cantidad` int(11) DEFAULT NULL,
  `prd_precio` float DEFAULT NULL,
  `prd_descripcion` varchar(100) DEFAULT NULL,
  `categ_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_producto`
--

INSERT INTO `tb_producto` (`prd_id`, `prd_nombre`, `prd_cantidad`, `prd_precio`, `prd_descripcion`, `categ_id`) VALUES
(1, 'cocacola', 10, 5.5, 'bebida', NULL),
(2, 'Pepsi', 10, 6.5, 'bebida', NULL),
(3, 'Aloe Vera', 100, 45.9, 'Hidratante', NULL),
(4, 'Alcohol', 100, 79.9, 'Desinfectante', NULL),
(5, 'peras', 31, 20, 'frutas', NULL),
(6, 'Sublime', 14, 3.5, 'Golosina', NULL),
(7, 'Agua', 21, 5.2, 'hidratante', NULL),
(8, 'Abrilar', 1, 54.2, 'Medicina', NULL),
(9, 'Tuinies', 4, 27.5, 'Medicina', NULL),
(10, 'Huevo', 24, 38, 'Abarrote', NULL),
(11, 'Fluimicil2', 1, 100, 'jarabe2', NULL),
(12, 'Pruebs', 20, 20.9, 'prueba', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `usr_id` int(11) NOT NULL,
  `usr_nombre` varchar(30) NOT NULL,
  `usr_apellido` varchar(30) NOT NULL,
  `usr_usuario` varchar(30) NOT NULL,
  `usr_password` varchar(30) NOT NULL,
  `usr_telefono` int(9) DEFAULT NULL,
  `usr_rol` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`usr_id`, `usr_nombre`, `usr_apellido`, `usr_usuario`, `usr_password`, `usr_telefono`, `usr_rol`) VALUES
(1, 'Cesar', 'Nunja', 'cnunja', 'password', 999888999, 'admin'),
(2, 'Cristian', 'Chauca', 'cchauca', 'password', 888999888, 'admin'),
(4, 'Dina', 'Boluarte', 'dboluarte', 'password', 666666666, 'Terrorismo de Imagen');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_cabecera_venta`
--
ALTER TABLE `tb_cabecera_venta`
  ADD PRIMARY KEY (`cab_id`),
  ADD KEY `cli_id` (`cli_id`);

--
-- Indices de la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  ADD PRIMARY KEY (`categ_id`);

--
-- Indices de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`cli_id`);

--
-- Indices de la tabla `tb_detalle_venta`
--
ALTER TABLE `tb_detalle_venta`
  ADD PRIMARY KEY (`det_id`),
  ADD KEY `prd_id` (`prd_id`),
  ADD KEY `cab_id` (`cab_id`);

--
-- Indices de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD PRIMARY KEY (`prd_id`),
  ADD KEY `fk_categoria_producto` (`categ_id`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`usr_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_cabecera_venta`
--
ALTER TABLE `tb_cabecera_venta`
  MODIFY `cab_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  MODIFY `categ_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `cli_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_detalle_venta`
--
ALTER TABLE `tb_detalle_venta`
  MODIFY `det_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  MODIFY `prd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `usr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_cabecera_venta`
--
ALTER TABLE `tb_cabecera_venta`
  ADD CONSTRAINT `tb_cabecera_venta_ibfk_1` FOREIGN KEY (`cli_id`) REFERENCES `tb_cliente` (`cli_id`);

--
-- Filtros para la tabla `tb_detalle_venta`
--
ALTER TABLE `tb_detalle_venta`
  ADD CONSTRAINT `tb_detalle_venta_ibfk_1` FOREIGN KEY (`prd_id`) REFERENCES `tb_producto` (`prd_id`),
  ADD CONSTRAINT `tb_detalle_venta_ibfk_2` FOREIGN KEY (`cab_id`) REFERENCES `tb_cabecera_venta` (`cab_id`);

--
-- Filtros para la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD CONSTRAINT `fk_categoria_producto` FOREIGN KEY (`categ_id`) REFERENCES `tb_categoria` (`categ_id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
