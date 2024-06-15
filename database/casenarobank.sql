-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2024 a las 18:23:00
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
-- Base de datos: `casenarobank`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costumer`
--

CREATE TABLE `costumer` (
  `id_costumer` int(11) NOT NULL,
  `costumer_name` varchar(55) NOT NULL,
  `costumer_last_name` varchar(55) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `mail` varchar(55) NOT NULL,
  `passw` varchar(8) NOT NULL,
  `balance` double NOT NULL,
  `product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `costumer`
--

INSERT INTO `costumer` (`id_costumer`, `costumer_name`, `costumer_last_name`, `phone`, `mail`, `passw`, `balance`, `product`) VALUES
(1, 'Carolina', 'Hincapie', '3217813303', 'caro@gmail.com', '1017', 1910, 1),
(10, 'SEbas', 'Rios', '45859', 'carojasdj', '5263', 100, 1),
(1000, 'Marlon', 'Cejas ', '323124541', 'marlon@cesde', '2522', 100, 1),
(1020, 'Natalia', 'Hincapie', '319562536', 'natalia@mail.com', '1980', 50, 1),
(1202, 'Sara', 'Perez', '4561324', 'sara', '1023', 10, 1),
(2525, 'Alex', 'Gallego', '2563633', 'alex@gmail.com', '9875', 200, 1),
(3256, 'Andrea', 'Ramirez', '458569', 'andrea@mail.com', '5623', 100, 1),
(102030, 'Raul', 'Cruz', '46523364', 'raul@gmail.com', '6589', 770, 1),
(236523, 'Javier', 'Barrera', '78456', 'javier@gmail.com', '4587', 50, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL,
  `id_costumer` varchar(50) DEFAULT NULL,
  `movimiento` varchar(255) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`id`, `id_costumer`, `movimiento`, `fecha`) VALUES
(1, '1', 'Abono de $20.0', '2024-05-15 23:59:28'),
(2, '1', 'Abono de $100.0', '2024-05-16 00:05:54'),
(3, '1', 'Retiro de $20.0', '2024-05-16 00:06:09'),
(4, '1', 'Abono de $500.0', '2024-05-16 00:18:06'),
(5, '1', 'Retiro de $20.0', '2024-05-16 00:18:21'),
(6, '102030', 'Abono de $200.0', '2024-05-16 00:54:17'),
(7, '102030', 'Retiro de $30.0', '2024-05-16 00:54:25'),
(8, '1', 'Abono de $50.0', '2024-05-17 20:03:04'),
(9, '1', 'Abono de $600.0', '2024-05-17 20:03:16'),
(10, '1', 'Retiro de $20.0', '2024-05-17 20:03:23'),
(11, '1', 'Abono de $500.0', '2024-05-17 21:42:10'),
(12, '1', 'Abono de $200.0', '2024-05-17 21:47:19'),
(13, '1', 'Retiro de $50.0', '2024-05-17 21:47:44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `product_name` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id_product`, `product_name`) VALUES
(1, 'Ahorro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `costumer`
--
ALTER TABLE `costumer`
  ADD PRIMARY KEY (`id_costumer`),
  ADD KEY `fk_product` (`product`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `costumer`
--
ALTER TABLE `costumer`
  ADD CONSTRAINT `fk_product` FOREIGN KEY (`product`) REFERENCES `product` (`id_product`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
