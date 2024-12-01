

CREATE TABLE `carrito` (
  `IDCarrito` int(11) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `PrecioProducto` decimal(12,8) DEFAULT NULL,
  `IDProducto` int(11) DEFAULT NULL,
  `IDPedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`IDCarrito`, `Cantidad`, `PrecioProducto`, `IDProducto`, `IDPedido`) VALUES
(1, 1, 45.00000000, 1, 1),
(2, 1, 35.00000000, 2, 2),
(3, 1, 18.00000000, 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaproducto`
--

CREATE TABLE `categoriaproducto` (
  `IDCategoria` int(11) NOT NULL,
  `NomCategoria` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoriaproducto`
--

INSERT INTO `categoriaproducto` (`IDCategoria`, `NomCategoria`, `Descripcion`) VALUES
(1, 'Platillos', 'Principales platos peruanos como Lomo Saltado y Ceviche'),
(2, 'Bebidas', 'Bebidas tradicionales como Chicha Morada y Pisco Sour'),
(3, 'Entradas', 'Entradas como Papa a la Huancaína y Causa Limeña'),
(4, 'Postres', 'Postres típicos peruanos como Mazamorra Morada y Arroz con Leche');
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IDCliente` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Apellido` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Contrasena` varchar(350) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IDCliente`, `Nombre`, `Apellido`, `Usuario`, `Correo`, `Contrasena`, `dni`) VALUES
(1, 'gustavo', 'alvarado', 'gustav0', 'gustavo@gmail.com', '4c96f8324e3ba54a99e78249b95daa30', '12121212');
/*LA CONTRASEÑA QUE LE PUSE ES gustavo*/
-- --------------------------------------------------------
-- Estructura de tabla para la tabla `contador`
--

CREATE TABLE `contador` (
  `IDContador` int(11) NOT NULL,
  `Contador` int(11) DEFAULT NULL,
  `IDProducto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delivery`
--

CREATE TABLE `delivery` (
  `IDDelivery` int(11) NOT NULL,
  `Estado` varchar(50) DEFAULT NULL,
  `IDPedido` int(11) DEFAULT NULL,
  `IDEmpleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecliente`
--

CREATE TABLE `detallecliente` (
  `IDDetalleCliente` int(11) NOT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Foto` varchar(100) DEFAULT NULL,
  `IDCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallecliente`
--

INSERT INTO `detallecliente` (`IDDetalleCliente`, `Telefono`, `Correo`, `Foto`, `IDCliente`) VALUES
(1, '987654321', 'carlosg@example.com', 'carlos.jpg', 4),
(2, '987654322', 'mariap@example.com', 'maria.jpg', 5),
(3, '987654323', 'rosav@example.com', 'rosa.jpg', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleempleado`
--

CREATE TABLE `detalleempleado` (
  `IDDetalleEmp` int(11) NOT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Foto` varchar(150) DEFAULT NULL,
  `IDEmpleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `IDDireccion` int(11) NOT NULL,
  `Direccion` varchar(150) DEFAULT NULL,
  `Referencia` varchar(150) DEFAULT NULL,
  `IDDistrito` int(11) DEFAULT NULL,
  `IDCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`IDDireccion`, `Direccion`, `Referencia`, `IDDistrito`, `IDCliente`) VALUES
(1, 'Av. Pardo y Aliaga 640', 'Cerca al parque Olivar', 2, 4),
(2, 'Calle Los Sauces 123', 'Frente al parque central', 1, 5),
(3, 'Av. Grau 450', 'Al lado de la tienda principal', 3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `IDDistrito` int(11) NOT NULL,
  `Distrito` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`IDDistrito`, `Distrito`) VALUES
(1, 'Miraflores'),
(2, 'San Isidro'),
(3, 'Barranco'),
(4, 'Surco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IDEmpleado` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `ApellidoPaterno` varchar(50) DEFAULT NULL,
  `ApellidoMaterno` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(150) DEFAULT NULL,
  `IDRol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IDEmpleado`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `Usuario`, `Contraseña`, `IDRol`) VALUES
(1, 'Juan', 'Ramirez', 'Torres', 'juanr', 'password_hash', 1),
(2, 'Luis', 'Diaz', 'Rojas', 'luisd', 'password_hash', 2),
(3, 'Miguel', 'Soto', 'Castro', 'miguels', 'password_hash', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrega`
--

CREATE TABLE `entrega` (
  `IDEntrega` int(11) NOT NULL,
  `HoraSalida` datetime DEFAULT NULL,
  `HoraEntrega` datetime DEFAULT NULL,
  `IDDelivery` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `IDFactura` int(11) NOT NULL,
  `CostoTotal` decimal(12,8) DEFAULT NULL,
  `FechaPedido` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`IDFactura`, `CostoTotal`, `FechaPedido`) VALUES
(1, 45.00000000, '2024-10-01'),
(2, 35.00000000, '2024-10-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `intentos`
--

CREATE TABLE `intentos` (
  `IDIntentos` int(11) NOT NULL,
  `Fallos` int(11) DEFAULT NULL,
  `Ingresos` int(11) DEFAULT NULL,
  `IDCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `IDPago` int(11) NOT NULL,
  `IDPedido` int(11) DEFAULT NULL,
  `IDTipoPago` int(11) DEFAULT NULL,
  `IDFactura` int(11) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`IDPago`, `IDPedido`, `IDTipoPago`, `IDFactura`, `Estado`) VALUES
(1, 1, 2, NULL, 1),
(2, 2, 1, NULL, 0),
(3, 3, 3, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `IDPedido` int(11) NOT NULL,
  `MontoFinal` decimal(12,8) DEFAULT NULL,
  `IDCliente` int(11) DEFAULT NULL,
  `Estado` varchar(10) DEFAULT NULL,
  `FechaPedido` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`IDPedido`, `MontoFinal`, `IDCliente`, `Estado`, `FechaPedido`) VALUES
(1, 45.00000000, 4, 'Completado', '2024-10-01 12:30:00'),
(2, 35.00000000, 5, 'Pendiente', '2024-10-02 14:00:00'),
(3, 18.00000000, 6, 'En prepara', '2024-10-03 13:45:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IDProducto` int(11) NOT NULL,
  `NomProducto` varchar(100) DEFAULT NULL,
  `PrecioUnitario` decimal(12,8) DEFAULT NULL,
  `FotoProducto` varchar(250) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `FechaProducto` datetime DEFAULT NULL,
  `IDCategoria` int(11) DEFAULT NULL,
  `IDTipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IDProducto`, `NomProducto`, `PrecioUnitario`, `FotoProducto`, `descripcion`, `Cantidad`, `FechaProducto`, `IDCategoria`, `IDTipo`) VALUES
(1, 'Lomo Saltado', 45.00000000, 'lomosaltado', 'Lomo saltado de carne con papas fritas, cebolla y tomate', 100, NULL, 1, NULL),
(2, 'Ceviche de Pescado', 35.00000000, 'ceviche', 'Ceviche de pescado fresco con limón y cebolla', 100, NULL, 1, NULL),
(3, 'Papa a la Huancaína', 15.00000000, NULL, 'Rodajas de papa bañadas en salsa de queso y ají amarillo', 100, NULL, 3, NULL),
(4, 'Causa Limeña', 18.00000000, NULL, 'Causa de papa con relleno de pollo y palta', 100, NULL, 3, NULL),
(5, 'Chicha Morada', 8.00000000, NULL, 'Bebida de maíz morado y frutas', 200, NULL, 2, NULL),
(6, 'Pisco Sour', 20.00000000, NULL, 'Cóctel peruano hecho con pisco, limón y clara de huevo', 100, NULL, 2, NULL),
(7, 'Mazamorra Morada', 10.00000000, NULL, 'Postre peruano de maíz morado y frutas', 50, NULL, 4, NULL),
(8, 'Seco de Cabrito', 38.00000000, 'secocabrito', 'Plato típico peruano de carne de cabrito guisado con frejoles y arroz', 45, '2024-11-15 00:24:28', 1, NULL),
(9, 'Ají de Langostinos', 32.00000000, 'ajidelangostinos', 'Ají amarillo con langostinos, acompañado de arroz blanco', 50, '2024-11-15 00:24:28', 1, NULL),
(10, 'Tiradito de Pescado', 35.00000000, 'tiradito', 'Pescado crudo marinado en limón, ají amarillo y servido con cebollas y cilantro', 60, '2024-11-15 00:24:28', 1, NULL),
(11, 'Chicha de Jora', 6.00000000, 'chichadejora', 'Bebida ancestral peruana fermentada de maíz, con un sabor único y refrescante', 120, '2024-11-15 00:24:28', 2, NULL),
(12, 'Café con Leche', 5.50000000, 'cafeconleche', 'Café peruano de altura, acompañado de leche evaporada', 150, '2024-11-15 00:24:28', 2, NULL),
(13, 'Mote de Queso', 12.00000000, 'motequeso', 'Plato peruano hecho a base de mote de maíz, queso fresco y hierbas aromáticas', 60, '2024-11-15 00:24:28', 1, NULL),
(14, 'Chocotejas', 10.00000000, 'chocotejas', 'Deliciosas bombones rellenos de dulce de leche o manjarblanco, cubiertos de chocolate', 80, '2024-11-15 00:24:28', 4, NULL),
(15, 'Torta de Alcayota', 15.00000000, 'tortaalcayota', 'Postre peruano elaborado con alcayota, un dulce de calabaza con azúcar y especias', 50, '2024-11-15 00:24:28', 4, NULL),
(16, 'Sancochado', 27.00000000, 'sancochado', 'Sopa espesa de carne de res, papas, zanahorias, maíz y hierbas', 40, '2024-11-15 00:24:28', 1, NULL),
(17, 'Te de Muña', 7.00000000, 'temuna', 'Infusión de muña, una planta aromática andina, conocida por sus propiedades digestivas', 100, '2024-11-15 00:24:28', 2, NULL),
(18, 'Choclo con Queso', 8.00000000, 'chocloqueso', 'Mazorca de maíz peruano acompañada de queso fresco', 150, '2024-11-15 00:24:28', 1, NULL),
(19, 'Keke de Pera', 16.00000000, 'kekedapera', 'Delicioso pastel de pera, un postre tradicional peruano', 60, '2024-11-15 00:24:28', 4, NULL),
(20, 'Arroz con Mariscos', 38.00000000, 'arrozconmariscos', 'Plato peruano de arroz con mariscos frescos, sazonado con ají amarillo y hierbas', 40, '2024-11-15 00:24:28', 1, NULL),
(21, 'Choritos a la Chalaca', 25.00000000, 'choritoschalaca', 'Mejillones frescos acompañados de cebolla, tomate, ají y cilantro', 50, '2024-11-15 00:24:28', 1, NULL),
(22, 'Peruanito', 5.00000000, 'peruanito', 'Refresco natural de frutas de temporada con un toque de limón y hierba buena', 100, '2024-11-15 00:24:28', 2, NULL),
(23, 'Cecina de Cerdo', 28.00000000, 'cecinacerdo', 'Plato tradicional amazónico, carne de cerdo ahumada y frita, acompañada de yuca', 40, '2024-11-15 00:24:28', 1, NULL),
(24, 'Helado de Lucuma', 8.00000000, 'heladolucuma', 'Helado artesanal de lúcuma, una fruta autóctona de Perú', 80, '2024-11-15 00:24:28', 4, NULL),
(25, 'Arroz con Leche', 12.00000000, 'arrozconleche', 'Postre tradicional de arroz con leche, preparado con canela y clavo de olor', 60, '2024-11-15 00:24:28', 4, NULL),
(26, 'Sopa Seca', 24.00000000, 'sopaseca', 'Plato peruano de fideos al estilo de arroz con carne y verduras', 50, '2024-11-15 00:24:28', 1, NULL),
(27, 'Tequila Sour', 15.00000000, 'tequilasour', 'Cóctel inspirado en el Pisco Sour, pero preparado con tequila mexicano', 80, '2024-11-15 00:24:28', 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `IDRol` int(11) NOT NULL,
  `NomRol` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`IDRol`, `NomRol`, `Descripcion`) VALUES
(1, 'Administrador', 'Gestiona el restaurante'),
(2, 'Mesero', 'Atiende a los clientes en las mesas'),
(3, 'Cocinero', 'Encargado de preparar los platos')
(4, 'Delivery', 'Encargado de transportar los pedidos');;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopago`
--

CREATE TABLE `tipopago` (
  `IDTipoPago` int(11) NOT NULL,
  `TipoPago` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipopago`
--

INSERT INTO `tipopago` (`IDTipoPago`, `TipoPago`) VALUES
(1, 'Efectivo'),
(2, 'Tarjeta de Crédito'),
(3, 'Tarjeta de Débito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproducto`
--

CREATE TABLE `tipoproducto` (
  `IDTipo` int(11) NOT NULL,
  `NomTipo` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(150) DEFAULT NULL,
  `IDCategoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`IDCarrito`),
  ADD KEY `IDProducto` (`IDProducto`),
  ADD KEY `IDPedido` (`IDPedido`);

--
-- Indices de la tabla `categoriaproducto`
--
ALTER TABLE `categoriaproducto`
  ADD PRIMARY KEY (`IDCategoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IDCliente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `contador`
--
ALTER TABLE `contador`
  ADD PRIMARY KEY (`IDContador`),
  ADD KEY `IDProducto` (`IDProducto`);

--
-- Indices de la tabla `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`IDDelivery`),
  ADD KEY `IDPedido` (`IDPedido`),
  ADD KEY `IDEmpleado` (`IDEmpleado`);

--
-- Indices de la tabla `detallecliente`
--
ALTER TABLE `detallecliente`
  ADD PRIMARY KEY (`IDDetalleCliente`),
  ADD KEY `IDCliente` (`IDCliente`);

--
-- Indices de la tabla `detalleempleado`
--
ALTER TABLE `detalleempleado`
  ADD PRIMARY KEY (`IDDetalleEmp`),
  ADD KEY `IDEmpleado` (`IDEmpleado`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`IDDireccion`),
  ADD KEY `IDCliente` (`IDCliente`),
  ADD KEY `IDDistrito` (`IDDistrito`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`IDDistrito`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IDEmpleado`),
  ADD KEY `IDRol` (`IDRol`);

--
-- Indices de la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD PRIMARY KEY (`IDEntrega`),
  ADD KEY `IDDelivery` (`IDDelivery`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`IDFactura`);

--
-- Indices de la tabla `intentos`
--
ALTER TABLE `intentos`
  ADD PRIMARY KEY (`IDIntentos`),
  ADD KEY `IDCliente` (`IDCliente`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`IDPago`),
  ADD KEY `IDPedido` (`IDPedido`),
  ADD KEY `IDTipoPago` (`IDTipoPago`),
  ADD KEY `IDFactura` (`IDFactura`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`IDPedido`),
  ADD KEY `IDCliente` (`IDCliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IDProducto`),
  ADD KEY `IDCategoria` (`IDCategoria`),
  ADD KEY `IDTipo` (`IDTipo`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`IDRol`);

--
-- Indices de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  ADD PRIMARY KEY (`IDTipoPago`);

--
-- Indices de la tabla `tipoproducto`
--
ALTER TABLE `tipoproducto`
  ADD PRIMARY KEY (`IDTipo`),
  ADD KEY `IDCategoria` (`IDCategoria`);

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IDCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `entrega`
--
ALTER TABLE `entrega`
  MODIFY `IDEntrega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`IDProducto`) REFERENCES `producto` (`IDProducto`),
  ADD CONSTRAINT `carrito_ibfk_2` FOREIGN KEY (`IDPedido`) REFERENCES `pedido` (`IDPedido`);

--
-- Filtros para la tabla `contador`
--
ALTER TABLE `contador`
  ADD CONSTRAINT `contador_ibfk_1` FOREIGN KEY (`IDProducto`) REFERENCES `producto` (`IDProducto`);

--
-- Filtros para la tabla `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_ibfk_1` FOREIGN KEY (`IDPedido`) REFERENCES `pedido` (`IDPedido`),
  ADD CONSTRAINT `delivery_ibfk_2` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`IDEmpleado`);

--
-- Filtros para la tabla `detallecliente`
--
ALTER TABLE `detallecliente`
  ADD CONSTRAINT `detallecliente_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `cliente` (`IDCliente`);

--
-- Filtros para la tabla `detalleempleado`
--
ALTER TABLE `detalleempleado`
  ADD CONSTRAINT `detalleempleado_ibfk_1` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`IDEmpleado`);

--
-- Filtros para la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD CONSTRAINT `direccion_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `cliente` (`IDCliente`),
  ADD CONSTRAINT `direccion_ibfk_2` FOREIGN KEY (`IDDistrito`) REFERENCES `distrito` (`IDDistrito`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`IDRol`) REFERENCES `roles` (`IDRol`);

--
-- Filtros para la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD CONSTRAINT `entrega_ibfk_1` FOREIGN KEY (`IDDelivery`) REFERENCES `delivery` (`IDDelivery`);

--
-- Filtros para la tabla `intentos`
--
ALTER TABLE `intentos`
  ADD CONSTRAINT `intentos_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `cliente` (`IDCliente`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`IDPedido`) REFERENCES `pedido` (`IDPedido`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`IDTipoPago`) REFERENCES `tipopago` (`IDTipoPago`),
  ADD CONSTRAINT `pago_ibfk_3` FOREIGN KEY (`IDFactura`) REFERENCES `factura` (`IDFactura`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `cliente` (`IDCliente`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`IDCategoria`) REFERENCES `categoriaproducto` (`IDCategoria`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`IDTipo`) REFERENCES `tipoproducto` (`IDTipo`);

--
-- Filtros para la tabla `tipoproducto`
--
ALTER TABLE `tipoproducto`
  ADD CONSTRAINT `tipoproducto_ibfk_1` FOREIGN KEY (`IDCategoria`) REFERENCES `categoriaproducto` (`IDCategoria`);
COMMIT;

