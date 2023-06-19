-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: rbroDb
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `backhauling`
--

DROP TABLE IF EXISTS `backhauling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backhauling` (
  `returnid` int NOT NULL AUTO_INCREMENT,
  `tweight` int DEFAULT NULL COMMENT 'In KG',
  `tvolume` int DEFAULT NULL COMMENT 'In Litre',
  `reason` varchar(255) DEFAULT NULL,
  `returnquantity` int DEFAULT NULL,
  `pidd` int DEFAULT NULL,
  PRIMARY KEY (`returnid`),
  KEY `pidd_idx` (`pidd`),
  CONSTRAINT `pidd` FOREIGN KEY (`pidd`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backhauling`
--

LOCK TABLES `backhauling` WRITE;
/*!40000 ALTER TABLE `backhauling` DISABLE KEYS */;
INSERT INTO `backhauling` (`returnid`, `tweight`, `tvolume`, `reason`, `returnquantity`, `pidd`) VALUES (1,20,20,'damage',10,1),(2,30,12,'damage',12,3),(3,11,2,'damage',12,5),(4,23,46,'bad',23,1);
/*!40000 ALTER TABLE `backhauling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_order`
--

DROP TABLE IF EXISTS `delivery_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_order` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `volume` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `delivery_address` varchar(150) DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid_idx` (`uid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_order`
--

LOCK TABLES `delivery_order` WRITE;
/*!40000 ALTER TABLE `delivery_order` DISABLE KEYS */;
INSERT INTO `delivery_order` (`oid`, `volume`, `weight`, `date_time`, `delivery_address`, `uid`) VALUES (1,100,100,'2023-01-23 13:34:00','Moratuwa, Colombo',2),(2,150,120,'2023-01-24 16:34:00','Moor Street, Mannar',1),(3,45,23,'2023-01-24 16:34:00','Moor Street, Mannar',1),(4,32,345,'2023-01-24 16:34:00','Moor Street, Mannar',3),(5,45,54,'2023-01-24 16:34:00','Moor Street, Mannar',2),(51,230,230,'2023-06-08 19:01:54','Gampaha',1);
/*!40000 ALTER TABLE `delivery_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driverdelivery`
--

DROP TABLE IF EXISTS `driverdelivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driverdelivery` (
  `ddid` bigint NOT NULL,
  `doid` bigint DEFAULT NULL,
  `did` int DEFAULT NULL,
  PRIMARY KEY (`ddid`),
  KEY `FKa7set2mg0fnkgbnfgo5ry3l6a` (`doid`),
  KEY `FK8cdrm8noowpharstsruj6g6yn` (`did`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driverdelivery`
--

LOCK TABLES `driverdelivery` WRITE;
/*!40000 ALTER TABLE `driverdelivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `driverdelivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driverreturn`
--

DROP TABLE IF EXISTS `driverreturn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driverreturn` (
  `drid` bigint NOT NULL,
  `rrid` bigint DEFAULT NULL,
  `did` int DEFAULT NULL,
  PRIMARY KEY (`drid`),
  KEY `FK94p4jis0aghxwch5k5l3ri3o3` (`rrid`),
  KEY `FKmxoh95l5futwool9e1ecf0yw2` (`did`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driverreturn`
--

LOCK TABLES `driverreturn` WRITE;
/*!40000 ALTER TABLE `driverreturn` DISABLE KEYS */;
/*!40000 ALTER TABLE `driverreturn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `grp_quantity`
--

DROP TABLE IF EXISTS `grp_quantity`;
/*!50001 DROP VIEW IF EXISTS `grp_quantity`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `grp_quantity` AS SELECT 
 1 AS `prodid`,
 1 AS `year`,
 1 AS `month`,
 1 AS `total_quantity`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES (41);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `inv_id` int NOT NULL AUTO_INCREMENT,
  `date_added` date DEFAULT NULL,
  `p_id` int DEFAULT NULL,
  `quantity_added` int DEFAULT NULL,
  PRIMARY KEY (`inv_id`),
  KEY `pid_idx` (`p_id`),
  CONSTRAINT `p_id` FOREIGN KEY (`p_id`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`inv_id`, `date_added`, `p_id`, `quantity_added`) VALUES (4,'2023-01-13',1,20),(5,'2023-01-10',4,45),(6,'2023-02-14',2,30);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_product_quantity` AFTER INSERT ON `inventory` FOR EACH ROW BEGIN
    UPDATE product SET available_quantity = available_quantity + NEW.quantity_added
    WHERE pid = NEW.p_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ordered_item`
--

DROP TABLE IF EXISTS `ordered_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_item` (
  `itemid` int NOT NULL AUTO_INCREMENT,
  `ordered_quantity` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `oid` int DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `oid_idx` (`oid`),
  KEY `pid_idx` (`pid`),
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `delivery_order` (`oid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_item`
--

LOCK TABLES `ordered_item` WRITE;
/*!40000 ALTER TABLE `ordered_item` DISABLE KEYS */;
INSERT INTO `ordered_item` (`itemid`, `ordered_quantity`, `pid`, `oid`) VALUES (1,20,2,1),(2,34,3,2),(3,32,1,3),(4,45,4,1),(11,32,1,4),(12,45,2,5),(16,10,6,51);
/*!40000 ALTER TABLE `ordered_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otp`
--

DROP TABLE IF EXISTS `otp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otp` (
  `otpid` bigint NOT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `created_timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`otpid`),
  KEY `FK654lipm79yh5clk6rfc8qygse` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp`
--

LOCK TABLES `otp` WRITE;
/*!40000 ALTER TABLE `otp` DISABLE KEYS */;
/*!40000 ALTER TABLE `otp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outletbackhauling`
--

DROP TABLE IF EXISTS `outletbackhauling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outletbackhauling` (
  `idretoutlet` int NOT NULL AUTO_INCREMENT,
  `rid` int DEFAULT NULL,
  `outletid` int DEFAULT NULL,
  PRIMARY KEY (`idretoutlet`),
  KEY `outletid_idx` (`outletid`),
  KEY `rid_idx` (`rid`),
  CONSTRAINT `outletid` FOREIGN KEY (`outletid`) REFERENCES `user` (`id`),
  CONSTRAINT `rid` FOREIGN KEY (`rid`) REFERENCES `backhauling` (`returnid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outletbackhauling`
--

LOCK TABLES `outletbackhauling` WRITE;
/*!40000 ALTER TABLE `outletbackhauling` DISABLE KEYS */;
INSERT INTO `outletbackhauling` (`idretoutlet`, `rid`, `outletid`) VALUES (1,1,1),(4,2,1),(5,3,1),(6,4,1);
/*!40000 ALTER TABLE `outletbackhauling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `weight_per_unit` int DEFAULT NULL COMMENT 'In Kg',
  `volume_per_unit` int DEFAULT NULL COMMENT 'In litre',
  `available_quantity` int DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pid`, `product_name`, `weight_per_unit`, `volume_per_unit`, `available_quantity`) VALUES (1,'Item1',1,2,50),(2,'item2',3,2,30),(3,'item3',1,4,11),(4,'item4',2,5,45),(5,'item5',1,2,20),(6,'item6',23,23,32),(7,'wrre2',23,12,20),(8,'wdd1',12,34,23),(9,'skdl',123,12,67),(10,'df',23,12,45),(11,'Item',12,23,-1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rgood`
--

DROP TABLE IF EXISTS `rgood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rgood` (
  `rgid` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `prodid` int DEFAULT NULL,
  PRIMARY KEY (`rgid`),
  KEY `FKdmus78u9hghg1ukevt4k80mbn` (`prodid`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rgood`
--

LOCK TABLES `rgood` WRITE;
/*!40000 ALTER TABLE `rgood` DISABLE KEYS */;
INSERT INTO `rgood` (`rgid`, `date`, `quantity`, `prodid`) VALUES (1,'2023-01-23',24,1),(2,'2023-01-25',32,1),(3,'2023-02-23',34,1),(4,'2023-01-21',23,2),(5,'2023-03-23',34,1),(6,'2023-03-20',20,1),(7,'2023-03-23',20,2),(8,'2023-03-23',42,4),(9,'2023-03-23',25,4),(10,'2023-04-01',24,2),(11,'2023-04-02',35,2),(12,'2023-04-03',34,4),(13,'2023-04-03',24,1),(14,'2023-05-01',13,4),(15,'2023-05-02',34,1),(16,'2023-05-02',24,2),(17,'2023-05-03',32,2),(18,'2023-06-07',23,1),(19,'2023-06-07',25,2),(20,'2023-06-06',20,4),(21,'2023-06-05',14,2);
/*!40000 ALTER TABLE `rgood` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` enum('admin','outletuser','driver','warehouse') NOT NULL,
  `prof_img_url` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `email`, `password`, `role`, `prof_img_url`, `branch`, `phone`) VALUES (1,'Nisho','nisho@gmail.com','1234','outletuser','../../../assets/UserProfile/nish.jpeg','Gampaha','28954930'),(2,'Kumar Sangakkara','kumar@gmail.com','1234','admin','../../../assets/UserProfile/kumar.jpeg',NULL,NULL),(3,'Krishihan R.','krish@gmail.com','@1234Cn1','warehouse','../../../assets/UserProfile/10-profile-picture-ideas-to-make-you-stand-out.webp','Vavuniya','+94756789124'),(4,'Peter','peter@gmail.com','1234','driver','../../../assets/UserProfile/profile-icon-design-free-vector.webp',NULL,NULL),(5,'User','nishclar0@gmail.com','1234567','outletuser',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `vehicleno` varchar(45) NOT NULL,
  `maxvol` int DEFAULT NULL,
  `maxweight` int DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `status` enum('trip','free') NOT NULL COMMENT 'ENUM(''trip'',''free'')',
  PRIMARY KEY (`vehicleno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`vehicleno`, `maxvol`, `maxweight`, `model`, `status`) VALUES ('12dsf',200,280,'Lorry','free'),('14411c',100,150,'Lorry','trip'),('1442b',200,300,'Lorry','free'),('sdfw123',213,12,'Lorry','free'),('wefr3',213,213,'Lorry','trip');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehousebackhauling`
--

DROP TABLE IF EXISTS `warehousebackhauling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehousebackhauling` (
  `idwarehousebackhauling` int NOT NULL AUTO_INCREMENT,
  `warehouseid` int DEFAULT NULL,
  `retid` int DEFAULT NULL,
  PRIMARY KEY (`idwarehousebackhauling`),
  KEY `warehouseid_idx` (`warehouseid`),
  KEY `retid_idx` (`retid`),
  CONSTRAINT `retid` FOREIGN KEY (`retid`) REFERENCES `backhauling` (`returnid`),
  CONSTRAINT `warehouseid` FOREIGN KEY (`warehouseid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehousebackhauling`
--

LOCK TABLES `warehousebackhauling` WRITE;
/*!40000 ALTER TABLE `warehousebackhauling` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehousebackhauling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `grp_quantity`
--

/*!50001 DROP VIEW IF EXISTS `grp_quantity`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `grp_quantity` AS select `p`.`prodid` AS `prodid`,year(`p`.`date`) AS `year`,month(`p`.`date`) AS `month`,sum(`p`.`quantity`) AS `total_quantity` from `rgood` `p` where ((year(`p`.`date`) = year(curdate())) and (month(`p`.`date`) = month(curdate()))) group by `p`.`prodid`,year(`p`.`date`),month(`p`.`date`) limit 0,1000 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-19 16:26:33
