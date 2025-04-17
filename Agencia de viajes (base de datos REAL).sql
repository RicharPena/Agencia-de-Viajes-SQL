CREATE DATABASE  IF NOT EXISTS `agencia_de_viajes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agencia_de_viajes`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agencia_de_viajes
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asientos`
--

DROP TABLE IF EXISTS `asientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asientos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_asiento` int DEFAULT NULL,
  `id_vuelo` int DEFAULT NULL,
  `id_reserva` int DEFAULT NULL,
  `ocupado` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idVuelo_idx` (`id_vuelo`),
  KEY `fk_idReserva_idx` (`id_reserva`),
  CONSTRAINT `fk_idReserva` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`),
  CONSTRAINT `fk_idVuelo` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asientos`
--

LOCK TABLES `asientos` WRITE;
/*!40000 ALTER TABLE `asientos` DISABLE KEYS */;
INSERT INTO `asientos` VALUES (3,1,2,2,1),(4,3,2,2,1),(7,2,1,3,1),(8,3,1,3,1),(9,4,1,3,1),(10,7,1,3,1),(11,8,1,3,1),(12,9,1,4,1),(13,10,1,4,1),(14,13,1,4,1),(15,14,1,4,1),(16,9,3,5,1),(17,10,3,5,1),(18,13,3,5,1),(19,14,3,5,1),(20,1,1,6,1),(21,5,1,6,1),(22,6,1,6,1);
/*!40000 ALTER TABLE `asientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,'Richar','123'),(2,'Jhonatan','jframe123'),(3,'ADMIN','ADMIN'),(4,'Prueba','prueba'),(5,'Victor','victor'),(6,'Papoman','papoman');
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_usuarios`
--

DROP TABLE IF EXISTS `datos_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `tarjeta` int DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `cedula` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_usuarios`
--

LOCK TABLES `datos_usuarios` WRITE;
/*!40000 ALTER TABLE `datos_usuarios` DISABLE KEYS */;
INSERT INTO `datos_usuarios` VALUES (1,'Richar','Peña',123456789,'rpenac@unicartagena.edu.co','Cartagena',12345678),(2,'Jhonatan',NULL,NULL,NULL,NULL,NULL),(3,'ADMIN',NULL,NULL,NULL,NULL,NULL),(4,'Prueba','1',NULL,'prueba1@gmail.com','Cartagena',123456789),(5,'Victor','Valdelamar',NULL,'victor@gmail.com','Cartagena',123456789),(6,'Papo','Man',NULL,'papoman@champeta.com','Papocity',845678149);
/*!40000 ALTER TABLE `datos_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escalas`
--

DROP TABLE IF EXISTS `escalas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escalas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escalas`
--

LOCK TABLES `escalas` WRITE;
/*!40000 ALTER TABLE `escalas` DISABLE KEYS */;
INSERT INTO `escalas` VALUES (1,'Madrid'),(2,'Paris'),(3,'Miami'),(4,'Emiratos'),(5,'Quito'),(6,'San Salvador');
/*!40000 ALTER TABLE `escalas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escalasxvuelo`
--

DROP TABLE IF EXISTS `escalasxvuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escalasxvuelo` (
  `id_vuelo` int NOT NULL,
  `id_escala` int NOT NULL,
  PRIMARY KEY (`id_vuelo`,`id_escala`),
  KEY `fk_id_escalas_idx` (`id_escala`),
  CONSTRAINT `fk_id_escalas` FOREIGN KEY (`id_escala`) REFERENCES `escalas` (`id`),
  CONSTRAINT `fk_id_vuelo` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escalasxvuelo`
--

LOCK TABLES `escalasxvuelo` WRITE;
/*!40000 ALTER TABLE `escalasxvuelo` DISABLE KEYS */;
INSERT INTO `escalasxvuelo` VALUES (2,1),(2,2),(4,2),(4,3),(4,4);
/*!40000 ALTER TABLE `escalasxvuelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `id_vuelo` int DEFAULT NULL,
  `pago` tinyint DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `fecha_reserva` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_vuelo_idx` (`id_vuelo`),
  KEY `fk_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `cuenta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (2,1,2,0,NULL,'2024-11-11'),(3,2,1,0,NULL,'2024-12-13'),(4,4,1,0,NULL,'2024-12-13'),(5,1,3,0,NULL,'2024-12-13'),(6,1,1,0,NULL,'2024-12-13');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aereolinea` varchar(45) DEFAULT NULL,
  `asientos_disponibles` int DEFAULT NULL,
  `origen` varchar(45) DEFAULT NULL,
  `destino` varchar(45) DEFAULT NULL,
  `fecha_salida` varchar(45) DEFAULT NULL,
  `estado_vuelo` tinyint DEFAULT NULL,
  `tarifa_general` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelos`
--

LOCK TABLES `vuelos` WRITE;
/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` VALUES (1,'Avianca',151,'Cartagena','Miami','2024-12-19',1,1500000),(2,'Fly Emirates',320,'Bogotá','Munich','2024-12-20',1,3500000),(3,'Avianca',162,'Quito','Bogotá','2025-01-10',1,1000000),(4,'Latam Airlines',210,'Barranquilla','Dubai','2025-01-10',1,5000000),(5,'Fly Emirates',322,'Cartagena','Buenos Aires','2024-12-05',0,1000000);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-13 18:53:46
