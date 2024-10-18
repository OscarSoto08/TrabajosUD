CREATE TABLE `Evento` (
  `idEvento` int PRIMARY KEY,
  `nombre` varchar(45) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` timestamp NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `aforo` integer
);

CREATE TABLE `Boleta` (
  `idEvento` integer,
  `idBoleta` integer PRIMARY KEY,
  `zona` varchar(45),
  `idTipo_boleta` varchar(45)
);

CREATE TABLE `Tipo_boleta` (
  `idTipo_boleta` int PRIMARY KEY,
  `nombre` varchar(45) NOT NULL
);

CREATE TABLE `Cliente` (
  `idCliente` int PRIMARY KEY,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo` varchar(255) UNIQUE NOT NULL,
  `clave` varchar(255) NOT NULL,
  `fechaNac` date NOT NULL,
  `telefono` int(15),
  `direccion` varchar(255) NOT NULL,
  `Ciudad_idCiudad` int
);

CREATE TABLE `Pais` (
  `idPais` int PRIMARY KEY,
  `nombre` varchar(45)
);

CREATE TABLE `Ciudad` (
  `idPais` int,
  `idCiudad` int PRIMARY KEY,
  `nombre` varchar(45)
);

CREATE TABLE `Proveedor` (
  `idProveedor` int PRIMARY KEY,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `correo` varchar(255) UNIQUE NOT NULL,
  `clave` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL
);

CREATE TABLE `Proveedor_Evento` (
  `idProveedor` int,
  `idEvento` int,
  `rolProveedor` varchar(255),
  PRIMARY KEY (`idProveedor`, `idEvento`)
);

CREATE TABLE `Comprar` (
  `idBoleta` int,
  `idCliente` int,
  `nombreBoleta` varchar(255),
  PRIMARY KEY (`idBoleta`, `idCliente`)
);

ALTER TABLE `Ciudad` ADD FOREIGN KEY (`idPais`) REFERENCES `Pais` (`idPais`);

ALTER TABLE `Boleta` ADD FOREIGN KEY (`idBoleta`) REFERENCES `Tipo_boleta` (`idTipo_boleta`);

ALTER TABLE `Boleta` ADD FOREIGN KEY (`idEvento`) REFERENCES `Evento` (`idEvento`);

ALTER TABLE `Proveedor_Evento` ADD FOREIGN KEY (`idEvento`) REFERENCES `Evento` (`idEvento`);

ALTER TABLE `Proveedor_Evento` ADD FOREIGN KEY (`idProveedor`) REFERENCES `Proveedor` (`idProveedor`);

ALTER TABLE `Ciudad` ADD FOREIGN KEY (`idCiudad`) REFERENCES `Cliente` (`Ciudad_idCiudad`);

ALTER TABLE `Comprar` ADD FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`);

ALTER TABLE `Comprar` ADD FOREIGN KEY (`idBoleta`) REFERENCES `Boleta` (`idBoleta`);
