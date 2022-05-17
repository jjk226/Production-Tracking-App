-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_entries
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `db_entries`
--
use heroku_fc0c0ebc27dc82b

DROP TABLE IF EXISTS `db_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `db_entries` (
  `id` int NOT NULL,
  `employee_id` int DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `production_order` int DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `serial_number` int DEFAULT '0',
  `operation` varchar(255) DEFAULT NULL,
  `tool_id` int DEFAULT NULL,
  `time_diff` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq597awjc1whloqbit2hhc0exb` (`tool_id`),
  CONSTRAINT `FKq597awjc1whloqbit2hhc0exb` FOREIGN KEY (`tool_id`) REFERENCES `db_tools` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_entries`
--

LOCK TABLES `db_entries` WRITE;
/*!40000 ALTER TABLE `db_entries` DISABLE KEYS */;
INSERT INTO `db_entries` VALUES (6,1347,'2022-04-27 23:49:27.387000',161080,'2021-12-02 16:21:04.656000','CLOSED',1440,'MECHANICAL',14,0),(7,3580,'2022-04-19 15:03:41.009000',162372,'2021-11-22 15:12:53.101000','CLOSED',1440,'ELECTRICAL',14,0),(8,1528,'2022-04-19 15:04:01.529000',155426,'2021-12-02 16:20:33.304000','CLOSED',1440,'MECHANICAL',14,0),(9,4321,'2022-04-19 15:15:30.059000',161093,'2021-12-03 10:54:26.215000','CLOSED',1440,'ELECTRICAL',14,0),(10,1567,'2022-01-19 16:35:45.085000',161095,'2021-12-03 11:06:37.675000','CLOSED',1440,NULL,NULL,0),(11,1567,NULL,161094,'2021-12-03 11:07:33.806000','OPEN',0,NULL,NULL,0),(12,0,'2022-04-19 14:54:08.137000',0,'2021-12-23 14:28:27.290000','CLOSED',0,'ELECTRICAL',NULL,0),(19,1212,NULL,123456,'2022-04-19 13:28:57.186000','OPEN',0,NULL,NULL,0),(20,1111,NULL,456789,'2022-04-19 13:33:38.324000','OPEN',0,NULL,NULL,0),(21,1234,NULL,0,'2022-04-19 16:44:42.623000','OPEN',0,'MECHANICAL',NULL,0),(22,0,NULL,0,'2022-04-19 16:45:25.988000','OPEN',0,'MECHANICAL',NULL,0),(23,0,NULL,0,'2022-04-19 16:52:27.634000','OPEN',1440,NULL,NULL,0),(24,1111,NULL,0,'2022-04-19 16:52:40.556000','OPEN',0,'MECHANICAL',NULL,0),(25,1111,NULL,0,'2022-04-19 16:53:24.201000','OPEN',0,'MECHANICAL',NULL,0),(26,0,NULL,0,'2022-04-19 16:55:34.256000','OPEN',1440,NULL,NULL,0),(33,1456,'2022-04-27 23:49:46.428000',0,'2022-04-21 14:47:17.958000','CLOSED',1440,'MECHANICAL',14,0),(34,1111,'2022-04-27 01:30:29.981000',0,'2022-04-21 14:49:02.135000','CLOSED',1462,'ELECTRICAL',17,0),(35,1111,'2022-04-26 23:21:30.260000',0,'2022-04-22 16:16:10.984000','CLOSED',1462,'MECHANICAL',17,0),(36,0,'2022-04-27 01:39:01.637000',0,'2022-04-27 01:30:32.372000','CLOSED',1462,'0',17,0),(37,0,'2022-04-27 01:52:21.053000',0,'2022-04-27 01:51:14.879000','CLOSED',1462,'0',17,0),(38,0,NULL,0,'2022-04-28 00:16:09.869000','OPEN',1480,NULL,18,0),(39,1111,'2022-04-29 14:12:51.933000',0,'2022-04-29 14:12:11.764000','CLOSED',1480,'MECHANICAL',18,0),(40,1234,'2022-04-29 14:20:08.538000',0,'2022-04-29 14:13:40.017000','CLOSED',1480,'ELECTRICAL',18,0),(41,0,NULL,0,'2022-04-29 14:19:41.646000','OPEN',1480,NULL,18,0),(42,0,'2022-04-29 14:24:20.119000',0,'2022-04-29 14:24:01.757000','CLOSED',1440,'WETDRYTEST',14,0),(43,0,'2022-05-09 10:26:06.419000',0,'2022-05-03 21:50:55.254000','CLOSED',1440,'0',14,0);
/*!40000 ALTER TABLE `db_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_tools`
--

DROP TABLE IF EXISTS `db_tools`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `db_tools` (
  `id` int NOT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_line` varchar(255) DEFAULT NULL,
  `serial_number` int DEFAULT NULL,
  `part_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_tools`
--

LOCK TABLES `db_tools` WRITE;
/*!40000 ALTER TABLE `db_tools` DISABLE KEYS */;
INSERT INTO `db_tools` VALUES (14,'Samsung','Intel NM Libra K351 LAU613','Libra',1440,'ZLQFE3510-002'),(17,'TSMC','TSMC Fab18 802 #9','QSF',1462,'ZQSF802FM-002S'),(18,'TSMC','TSMC Fab18B N3 Prima #13','PRIMA',1480,'ZQPR1000-1091');
/*!40000 ALTER TABLE `db_tools` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_tools_entries`
--

DROP TABLE IF EXISTS `db_tools_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `db_tools_entries` (
  `tool_id` int NOT NULL,
  `entries_id` int NOT NULL,
  UNIQUE KEY `UK_fcutfj1343mxwx1uuic9kblq8` (`entries_id`),
  KEY `FKt7xcjjnpa4o9by8x76e4b3hk` (`tool_id`),
  CONSTRAINT `FKae2wqkjbk9kuvaehkwee5syjh` FOREIGN KEY (`entries_id`) REFERENCES `db_entries` (`id`),
  CONSTRAINT `FKt7xcjjnpa4o9by8x76e4b3hk` FOREIGN KEY (`tool_id`) REFERENCES `db_tools` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_tools_entries`
--

LOCK TABLES `db_tools_entries` WRITE;
/*!40000 ALTER TABLE `db_tools_entries` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_tools_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `employee_id` int unsigned NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Taofik','Ajibola'),(2,'Mike','Patel'),(3,'Yaron','Ashkenazi'),(4,'Peter','Veligursky'),(5,'Oleksandr','Korolov'),(6,'Sal','Haddad'),(7,'John','Lamy'),(8,'Charles','Ford'),(9,'Bina','Raval'),(10,'Edwin','Cabanero'),(20,'Leszek','Muraczewski'),(21,'Greg','Jasionek'),(22,'Steven','Hergert'),(23,'Andrew','Tyannikov'),(24,'Richard','Zakrzewski'),(25,'Oleg','Popov'),(40,'Marian','Wadie'),(41,'Oleg','Chernomazov'),(42,'James','Novak'),(43,'Robert','Miguel'),(44,'Denys','Popov'),(45,'Justin','Benway'),(46,'Jonathan','Bendarsky'),(47,'Patrick','Bautista');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (44);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-17 15:49:53
