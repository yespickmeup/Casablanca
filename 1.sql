-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.63-0ubuntu0.11.10.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_pos_restaurant
--

CREATE DATABASE IF NOT EXISTS db_pos_restaurant;
USE db_pos_restaurant;

--
-- Definition of table `db_pos_restaurant`.`accounts`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`accounts`;
CREATE TABLE  `db_pos_restaurant`.`accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(100) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exp_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`accounts`
--

/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
LOCK TABLES `accounts` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`bank`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`bank`;
CREATE TABLE  `db_pos_restaurant`.`bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`bank`
--

/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
LOCK TABLES `bank` WRITE;
INSERT INTO `db_pos_restaurant`.`bank` VALUES  (1,'Bank of the Philippine Islands');
UNLOCK TABLES;
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`bank_card_type`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`bank_card_type`;
CREATE TABLE  `db_pos_restaurant`.`bank_card_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_id` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`bank_card_type`
--

/*!40000 ALTER TABLE `bank_card_type` DISABLE KEYS */;
LOCK TABLES `bank_card_type` WRITE;
INSERT INTO `db_pos_restaurant`.`bank_card_type` VALUES  (1,1,'Premium'),
 (2,1,'Gold');
UNLOCK TABLES;
/*!40000 ALTER TABLE `bank_card_type` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`cancelled_or`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`cancelled_or`;
CREATE TABLE  `db_pos_restaurant`.`cancelled_or` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cancelled_or`
--

/*!40000 ALTER TABLE `cancelled_or` DISABLE KEYS */;
LOCK TABLES `cancelled_or` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `cancelled_or` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`cancelled_order`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`cancelled_order`;
CREATE TABLE  `db_pos_restaurant`.`cancelled_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `or_num` int(11) DEFAULT NULL,
  `or_date` datetime DEFAULT NULL,
  `prod_name` varchar(100) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cancelled_order`
--

/*!40000 ALTER TABLE `cancelled_order` DISABLE KEYS */;
LOCK TABLES `cancelled_order` WRITE;
INSERT INTO `db_pos_restaurant`.`cancelled_order` VALUES  (1,1,'2012-06-18 01:59:39','BEEF STRIPS',1,35);
UNLOCK TABLES;
/*!40000 ALTER TABLE `cancelled_order` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`cash_drawer`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`cash_drawer`;
CREATE TABLE  `db_pos_restaurant`.`cash_drawer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cashier_session_id` int(11) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cash_in` double DEFAULT NULL,
  `cash_out` double DEFAULT NULL,
  `addtl_cash` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cash_drawer`
--

/*!40000 ALTER TABLE `cash_drawer` DISABLE KEYS */;
LOCK TABLES `cash_drawer` WRITE;
INSERT INTO `db_pos_restaurant`.`cash_drawer` VALUES  (34,33,'cashier','2012-06-29 00:00:00',100,NULL,NULL),
 (35,34,'cashier','2012-07-06 00:00:00',100,NULL,NULL),
 (36,35,'cashier','2012-07-07 00:00:00',100,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `cash_drawer` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`cash_in`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`cash_in`;
CREATE TABLE  `db_pos_restaurant`.`cash_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cashier_name` varchar(100) DEFAULT NULL,
  `cashier_session_id` int(11) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cash_in`
--

/*!40000 ALTER TABLE `cash_in` DISABLE KEYS */;
LOCK TABLES `cash_in` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `cash_in` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`cashier_sessions`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`cashier_sessions`;
CREATE TABLE  `db_pos_restaurant`.`cashier_sessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cashier_name` varchar(100) DEFAULT NULL,
  `login_status` int(11) DEFAULT NULL,
  `cash_count` double DEFAULT '0',
  `additional_cash` double DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `logout_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cashier_sessions`
--

/*!40000 ALTER TABLE `cashier_sessions` DISABLE KEYS */;
LOCK TABLES `cashier_sessions` WRITE;
INSERT INTO `db_pos_restaurant`.`cashier_sessions` VALUES  (33,'cashier',1,0,0,'2012-06-29 00:00:00','2012-06-29 00:00:00','2012-06-29 10:36:13',NULL),
 (34,'cashier',1,0,0,'2012-07-06 00:00:00','2012-07-06 00:00:00','2012-07-06 05:40:46',NULL),
 (35,'cashier',1,0,0,'2012-07-07 00:00:00','2012-07-07 00:00:00','2012-07-07 10:17:12',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `cashier_sessions` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`category`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`category`;
CREATE TABLE  `db_pos_restaurant`.`category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_num` int(11) DEFAULT NULL,
  `cat_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
LOCK TABLES `category` WRITE;
INSERT INTO `db_pos_restaurant`.`category` VALUES  (1,1,'TOILETRIES'),
 (2,2,'SCHOOL SUPPLIES'),
 (3,3,'GROCERIES'),
 (4,4,'SNACKS'),
 (5,5,'DESSERTS'),
 (6,6,'DRINKS'),
 (7,7,'CATERING'),
 (8,8,'NESTLE ICE CREAM'),
 (9,9,'HOME MADE ICE CREAM'),
 (10,10,'BAKERY'),
 (11,11,'BUKO'),
 (12,12,'VENDING MACHINE');
UNLOCK TABLES;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`category_type`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`category_type`;
CREATE TABLE  `db_pos_restaurant`.`category_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_num` int(11) DEFAULT NULL,
  `type_name` varchar(200) DEFAULT NULL,
  `cat_num` varchar(100) DEFAULT NULL,
  `cat_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`category_type`
--

/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
LOCK TABLES `category_type` WRITE;
INSERT INTO `db_pos_restaurant`.`category_type` VALUES  (1,1,'FLOOR WAX','1','TOILETRIES'),
 (3,3,'REG. SAFEGUARD','1','TOILETRIES'),
 (4,4,'SANITARY NAPKINS','1','TOILETRIES'),
 (5,5,'TOILET PAPER','1','TOILETRIES'),
 (6,6,'BALLPEN','2','SCHOOL SUPPLIES'),
 (7,7,'CARTOLINA','2','SCHOOL SUPPLIES'),
 (8,8,'CRAYON','2','SCHOOL SUPPLIES'),
 (9,9,'DRAWING BOOK','2','SCHOOL SUPPLIES'),
 (10,10,'ENVELOPE','2','SCHOOL SUPPLIES'),
 (11,11,'FOLDER','2','SCHOOL SUPPLIES'),
 (12,12,'GLUE','2','SCHOOL SUPPLIES'),
 (13,13,'ILLUSTRATION BOARD','2','SCHOOL SUPPLIES'),
 (14,14,'NOTEBOOK','2','SCHOOL SUPPLIES'),
 (15,15,'PAPER','2','SCHOOL SUPPLIES'),
 (16,16,'PASTE','2','SCHOOL SUPPLIES'),
 (17,17,'PENCIL','2','SCHOOL SUPPLIES'),
 (18,18,'PENTEL PEN ','2','SCHOOL SUPPLIES'),
 (19,19,'PLASTIC COVER','2','SCHOOL SUPPLIES'),
 (20,20,'PLASTIC FASTENER','2','SCHOOL SUPPLIES'),
 (21,21,'PROTRACTOR','2','SCHOOL SUPPLIES'),
 (23,23,'RE TOUCH','2','SCHOOL SUPPLIES'),
 (24,24,'RULER','2','SCHOOL SUPPLIES'),
 (25,25,'SCISSORS','2','SCHOOL SUPPLIES'),
 (26,26,'SHARPENER','2','SCHOOL SUPPLIES'),
 (27,27,'LUCKY ME','3','GROCERIES'),
 (28,28,'COFFEE','3','GROCERIES'),
 (29,29,'CANDY','4','SNACKS'),
 (30,30,'CHOCO SNACKS','4','SNACKS'),
 (31,31,'COOKIES','4','SNACKS'),
 (32,32,'PEANUTS','4','SNACKS'),
 (33,33,'HALO-HALO','5','DESSERTS'),
 (34,34,'SHAKE','5','DESSERTS'),
 (35,35,'FRUIT MIX','5','DESSERTS'),
 (36,36,'SNOW CREAM','5','DESSERTS'),
 (37,37,'BANANA SPLIT','5','DESSERTS'),
 (38,38,'TEMPURA','5','DESSERTS'),
 (39,39,'FRENCH FRIES','5','DESSERTS'),
 (40,40,'CHOCOLATE DRINKS','6','DRINKS'),
 (41,41,'JUICE','6','DRINKS'),
 (42,42,'MILK DRINKS','6','DRINKS'),
 (43,43,'WATER','6','DRINKS'),
 (44,44,'7-UP','6','DRINKS'),
 (45,45,'MIRINDA','6','DRINKS'),
 (46,46,'MOUNTAIN DEW','6','DRINKS'),
 (47,47,'PEPSI','6','DRINKS'),
 (48,48,'BEEF','7','CATERING'),
 (49,49,'BREAKFAST MEALS','7','CATERING'),
 (50,50,'CHICKEN','7','CATERING'),
 (51,51,'FISH','7','CATERING'),
 (52,52,'NOODLES/PASTA','7','CATERING'),
 (53,53,'PORK','7','CATERING'),
 (54,54,'VEGETABLES','7','CATERING'),
 (55,55,'SORBETES','8','NESTLE ICE CREAM'),
 (56,56,'UBE CUPS','8','NESTLE ICE CREAM'),
 (57,57,'VANILLA LOADED','8','NESTLE ICE CREAM'),
 (58,58,'REG ICE CREAM','9','HOME MADE ICE CREAM'),
 (59,59,'Band aid','1','TOILETRIES'),
 (60,60,'safety pin','1','TOILETRIES'),
 (61,61,'johnson ','1','TOILETRIES'),
 (62,62,'close up','1','TOILETRIES'),
 (63,63,'colgate','1','TOILETRIES');
UNLOCK TABLES;
/*!40000 ALTER TABLE `category_type` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`ci_no`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`ci_no`;
CREATE TABLE  `db_pos_restaurant`.`ci_no` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ci_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`ci_no`
--

/*!40000 ALTER TABLE `ci_no` DISABLE KEYS */;
LOCK TABLES `ci_no` WRITE;
INSERT INTO `db_pos_restaurant`.`ci_no` VALUES  (1,1000),
 (2,14),
 (3,14),
 (4,1001),
 (5,1002),
 (6,1003),
 (7,1004),
 (8,1005),
 (9,1006),
 (10,1007),
 (11,1008),
 (12,1009),
 (13,1010),
 (14,1011),
 (15,1011),
 (16,1012),
 (17,1012),
 (18,1013),
 (19,1014),
 (20,1015),
 (21,1016),
 (22,1017),
 (23,1018),
 (24,1019);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ci_no` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`commission`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`commission`;
CREATE TABLE  `db_pos_restaurant`.`commission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_id` int(11) DEFAULT NULL,
  `total_sales` double DEFAULT NULL,
  `commission` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`commission`
--

/*!40000 ALTER TABLE `commission` DISABLE KEYS */;
LOCK TABLES `commission` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `commission` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`credits`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`credits`;
CREATE TABLE  `db_pos_restaurant`.`credits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `or_no` varchar(100) DEFAULT NULL,
  `bank_name` varchar(200) DEFAULT NULL,
  `card_type` varchar(100) DEFAULT NULL,
  `card_holder` varchar(200) DEFAULT NULL,
  `card_no` varchar(200) DEFAULT NULL,
  `approval_code` varchar(200) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`credits`
--

/*!40000 ALTER TABLE `credits` DISABLE KEYS */;
LOCK TABLES `credits` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `credits` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`customer_charges`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`customer_charges`;
CREATE TABLE  `db_pos_restaurant`.`customer_charges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_num` varchar(100) DEFAULT NULL,
  `cust_name` varchar(100) DEFAULT NULL,
  `or_num` varchar(100) DEFAULT NULL,
  `ci_num` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `is_payed` varchar(100) DEFAULT NULL,
  `date_payed` datetime DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`customer_charges`
--

/*!40000 ALTER TABLE `customer_charges` DISABLE KEYS */;
LOCK TABLES `customer_charges` WRITE;
INSERT INTO `db_pos_restaurant`.`customer_charges` VALUES  (6,'2012000164','CADAPAN, Reymil','0','1000',27,'2012-06-03 05:17:57','yes','2012-06-16 00:00:00','cashier','1'),
 (7,'2012000164','CADAPAN, Reymil','0','1001',27,'2012-06-03 05:18:52','yes','2012-06-16 00:00:00','cashier','1'),
 (8,'2012000163','CADALIN, Joveniano','0','1002',13.5,'2012-06-03 05:19:22','yes','2012-06-18 00:00:00','cashier','1'),
 (9,'2012000164','CADAPAN, Reymil','0','1001',13.5,'2012-06-04 02:35:02','yes','2012-06-16 00:00:00','cashier','1'),
 (10,'2012000164','CADAPAN, Reymil','0','1002',27,'2012-06-04 02:36:02','yes','2012-06-18 00:00:00','cashier','1'),
 (11,'2012000164','CADAPAN, Reymil','0','1003',46,'2012-06-04 05:47:16','yes','2012-06-18 00:00:00','cashier','1'),
 (12,'2012000164','CADAPAN, Reymil','0','1004',46,'2012-06-04 05:49:33','yes','2012-06-18 00:00:00','cashier','1'),
 (13,'2012000164','CADAPAN, Reymil','0','1005',46,'2012-06-04 06:05:05','yes','2012-06-18 00:00:00','cashier','1'),
 (14,'2012000164','CADAPAN, Reymil','0','1006',46,'2012-06-04 06:21:55','no',NULL,'cashier','1'),
 (15,'2012000164','CADAPAN, Reymil','0','1007',46,'2012-06-04 06:23:46','no',NULL,'cashier','1'),
 (16,'2012000164','CADAPAN, Reymil','0','1008',46,'2012-06-04 06:26:16','no',NULL,'cashier','1'),
 (17,'2012000164','CADAPAN, Reymil','0','1009',71,'2012-06-05 10:27:46','no',NULL,'cashier','1'),
 (18,'2012000164','CADAPAN, Reymil','0','1010',13.5,'2012-06-05 05:21:25','no',NULL,'cashier','1'),
 (19,'2012000164','CADAPAN, Reymil','0','1011',13.5,'2012-06-05 05:29:01','no',NULL,'cashier','1'),
 (20,'2012000164','CADAPAN, Reymil','0','1011',13.5,'2012-06-05 05:29:26','no',NULL,'cashier','1'),
 (21,'2012000164','CADAPAN, Reymil','0','1012',113.5,'2012-06-05 05:36:05','no',NULL,'cashier','1'),
 (22,'2012000164','CADAPAN, Reymil','0','1012',113.5,'2012-06-05 05:36:20','no',NULL,'cashier','1'),
 (23,'2012000164','CADAPAN, Reymil','0','1013',113.5,'2012-06-05 05:39:22','no',NULL,'cashier','1'),
 (24,'2012000164','CADAPAN, Reymil','0','1014',100,'2012-06-05 05:39:50','no',NULL,'cashier','1'),
 (25,'2012000164','CADAPAN, Reymil','0','1015',1000,'2012-06-06 03:03:09','no',NULL,'0','1'),
 (26,'2012000164','CADAPAN, Reymil','0','1016',1500,'2012-06-06 03:04:06','no',NULL,'0','1'),
 (27,'2012000164','CADAPAN, Reymil','29','1017',270,'2012-06-15 11:45:01','no',NULL,'cashier','1'),
 (28,'2012000903','Ronald Pascua','34','1018',145,'2012-06-16 02:33:25','no',NULL,'cashier','1'),
 (29,'2012000903','Ronald Pascua','36','1019',100,'2012-06-16 02:34:25','no',NULL,'cashier','1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `customer_charges` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`customer_tables`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`customer_tables`;
CREATE TABLE  `db_pos_restaurant`.`customer_tables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `or_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`customer_tables`
--

/*!40000 ALTER TABLE `customer_tables` DISABLE KEYS */;
LOCK TABLES `customer_tables` WRITE;
INSERT INTO `db_pos_restaurant`.`customer_tables` VALUES  (15,'1','2012-06-13 03:00:07',795,'27');
UNLOCK TABLES;
/*!40000 ALTER TABLE `customer_tables` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`customer_tables_details`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`customer_tables_details`;
CREATE TABLE  `db_pos_restaurant`.`customer_tables_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_no_id` varchar(100) DEFAULT NULL,
  `or_no` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`customer_tables_details`
--

/*!40000 ALTER TABLE `customer_tables_details` DISABLE KEYS */;
LOCK TABLES `customer_tables_details` WRITE;
INSERT INTO `db_pos_restaurant`.`customer_tables_details` VALUES  (51,'1','27',6,'4564654',100,600),
 (52,'1','27',3,'2345345345',50,150),
 (53,'1','27',1,'234234',45,45);
UNLOCK TABLES;
/*!40000 ALTER TABLE `customer_tables_details` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`customers`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`customers`;
CREATE TABLE  `db_pos_restaurant`.`customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contact` varchar(200) DEFAULT NULL,
  `occupation` varchar(200) DEFAULT NULL,
  `income` varchar(200) DEFAULT NULL,
  `b_date` date DEFAULT NULL,
  `civil_status` varchar(200) DEFAULT NULL,
  `is_male` tinyint(4) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `credit_limit` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20120095 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`customers`
--

/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
LOCK TABLES `customers` WRITE;
INSERT INTO `db_pos_restaurant`.`customers` VALUES  (20120001,'Abello Raymund','','','','','1990-01-01','',0,0,1000),
 (20120002,'Alcoran Elsie','','','','','1990-01-01','',0,0,1000),
 (20120003,'Aranas Lealee','','','','','1990-01-01','',0,0,1000),
 (20120004,'Asignar Stanley','','','','','1990-01-01','',0,0,1000),
 (20120005,'Banagua Artemio','','','','','1990-01-01','',0,0,1000),
 (20120006,'Banua  Isabel','','','','','1990-01-01','',0,0,1000),
 (20120007,'Barrera Judalyn','','','','','1990-01-01','',0,0,1000),
 (20120008,'Batiancila Nidrea Kizza','','','','','1990-01-01','',0,0,1000),
 (20120009,'Bato Ellen','','','','','1990-01-01','',0,0,1000),
 (20120010,'Boladola Absalon','','','','','1990-01-01','',0,0,1000),
 (20120011,'Budiongan Mirasol','','','','','1990-01-01','',0,0,1000),
 (20120012,'Cabrera Elna Janiel','','','','','1990-01-01','',0,0,1000),
 (20120013,'Cadavez Anna Marie','','','','','1990-01-01','',0,0,1000),
 (20120014,'Cadavez Evangeline','','','','','1990-01-01','',0,0,1000),
 (20120015,'Callora Alona','','','','','1990-01-01','',0,0,1000),
 (20120016,'Calunod Reylan','','','','','1990-01-01','',0,0,1000),
 (20120017,'Cavales Catherine','','','','','1990-01-01','',0,0,1000),
 (20120018,'Chiu Francis Vincent','','','','','1990-01-01','',0,0,1000),
 (20120019,'Cornelia Arlene','','','','','1990-01-01','',0,0,1000),
 (20120020,'Deciar Jaydawn','','','','','1990-01-01','',0,0,1000),
 (20120021,'Dequito Amethyst Edda','','','','','1990-01-01','',0,0,1000),
 (20120022,'Divino Fritz','','','','','1990-01-01','',0,0,1000),
 (20120023,'Duhaylungsod Lil','','','','','1990-01-01','',0,0,1000),
 (20120024,'Duran Estelita','','','','','1990-01-01','',0,0,1000),
 (20120025,'Felisco Carol','','','','','1990-01-01','',0,0,1000),
 (20120026,'Fernandez Percie Joy','','','','','1990-01-01','',0,0,1000),
 (20120027,'Flores Edgardo','','','','','1990-01-01','',0,0,1000),
 (20120028,'Gabutero Liznil','','','','','1990-01-01','',0,0,1000),
 (20120029,'Galsing Lexiebeth','','','','','1990-01-01','',0,0,1000),
 (20120030,'Garibay Leizel','','','','','1990-01-01','',0,0,1000),
 (20120031,'Hurtado Jeanette','','','','','1990-01-01','',0,0,1000),
 (20120032,'Hurtado Sandy','','','','','1990-01-01','',0,0,1000),
 (20120033,'Katada Corazon','','','','','1990-01-01','',0,0,1000),
 (20120034,'Ladura Riza','','','','','1990-01-01','',0,0,1000),
 (20120035,'Lareña Roxanne','','','','','1990-01-01','',0,0,1000),
 (20120036,'Lasola Wilmer','','','','','1990-01-01','',0,0,1000),
 (20120037,'Manzano Noreen','','','','','1990-01-01','',0,0,1000),
 (20120038,'Maquiling Beatriz','','','','','1990-01-01','',0,0,1000),
 (20120039,'Marimat Alpha Omega','','','','','1990-01-01','',0,0,1000),
 (20120040,'Mongcopa Chona','','','','','1990-01-01','',0,0,1000),
 (20120041,'Navera Elvira','','','','','1990-01-01','',0,0,1000),
 (20120042,'Nocete Zillah','','','','','1990-01-01','',0,0,1000),
 (20120043,'Nuique Jose Roel','','','','','1990-01-01','',0,0,1000),
 (20120044,'Opsima  Lourdes','','','','','1990-01-01','',0,0,1000),
 (20120045,'Orellana Mary Lou','','','','','1990-01-01','',0,0,1000),
 (20120046,'Ortega Rona','','','','','1990-01-01','',0,0,1000),
 (20120047,'Pabatang Anthnolette','','','','','1990-01-01','',0,0,1000),
 (20120048,'Panday Janisa','','','','','1990-01-01','',0,0,1000),
 (20120049,'Piñero Vanessa ','','','','','1990-01-01','',0,0,1000),
 (20120050,'Puspus Jocelyn','','','','','1990-01-01','',0,0,1000),
 (20120051,'Quinamot Rene','','','','','1990-01-01','',0,0,1000),
 (20120052,'Rangaig Mona Lisa','','','','','1990-01-01','',0,0,1000),
 (20120053,'Saluria Raymart Anthony','','','','','1990-01-01','',0,0,1000),
 (20120054,'Santillan Miraluna','','','','','1990-01-01','',0,0,1000),
 (20120055,'Silva Ma.Theresa','','','','','1990-01-01','',0,0,1000),
 (20120056,'Tan Joan Ann','','','','','1990-01-01','',0,0,1000),
 (20120057,'Tenorio Mae','','','','','1990-01-01','',0,0,1000),
 (20120058,'Valencia Lizbeth','','','','','1990-01-01','',0,0,1000),
 (20120059,'Velez Cherry Ann','','','','','1990-01-01','',0,0,1000),
 (20120060,'Villordon Jeanette','','','','','1990-01-01','',0,0,1000),
 (20120061,'Vintola Ma.Irmina','','','','','1990-01-01','',0,0,1000),
 (20120062,'Waleson Bart','','','','','1990-01-01','',0,0,1000),
 (20120063,'Waleson Butch','','','','','1990-01-01','',0,0,1000),
 (20120064,'Yusi Catherine','','','','','1990-01-01','',0,0,1000),
 (20120065,'Cabrera Bayani','','','','','1990-01-01','',0,0,1000),
 (20120066,'Cabrera Elna Janiel','','','','','1990-01-01','',0,0,1000),
 (20120067,'Cadimas Stephen','','','','','1990-01-01','',0,0,1000),
 (20120068,'Casipong Jemar','','','','','1990-01-01','',0,0,1000),
 (20120069,'Diputado Ginara','','','','','1990-01-01','',0,0,1000),
 (20120070,'Rufiño Elpidio Jr.','','','','','1990-01-01','',0,0,1000),
 (20120071,'Vendiola Ma.Victoria','','','','','1990-01-01','',0,0,1000),
 (20120072,'Ada Claro','','','','','1990-01-01','',0,0,1000),
 (20120073,'Amil Gerardo Sr.','','','','','1990-01-01','',0,0,1000),
 (20120074,'Amorganda Reggie','','','','','1990-01-01','',0,0,1000),
 (20120075,'Batigulao Jose','','','','','1990-01-01','',0,0,1000),
 (20120076,'Catamora Jimboy','','','','','1990-01-01','',0,0,1000),
 (20120077,'Catamora Reynaldo','','','','','1990-01-01','',0,0,1000),
 (20120078,'Estoconing Dennis','','','','','1990-01-01','',0,0,1000),
 (20120079,'Geromo Valentino','','','','','1990-01-01','',0,0,1000),
 (20120080,'Infante Angelito','','','','','1990-01-01','',0,0,1000),
 (20120081,'Infante Gualberto','','','','','1990-01-01','',0,0,1000),
 (20120082,'Samson Orlando','','','','','1990-01-01','',0,0,1000),
 (20120083,'Sombrio Rolando','','','','','1990-01-01','',0,0,1000),
 (20120084,'Amil Marilyn','','','','','1990-01-01','',0,0,1000),
 (20120085,'Angot Anecita','','','','','1990-01-01','',0,0,1000),
 (20120086,'Banquerigo Elma','','','','','1990-01-01','',0,0,1000),
 (20120087,'Doño Eufemio','','','','','1990-01-01','',0,0,1000),
 (20120088,'Duran Florence','','','','','1990-01-01','',0,0,1000),
 (20120089,'Labayen Josephine','','','','','1990-01-01','',0,0,1000),
 (20120090,'Saraña Leonila','','','','','1990-01-01','',0,0,1000),
 (20120091,'Saraña Mario','','','','','1990-01-01','',0,0,1000),
 (20120092,'Soledad Lida','','','','','1990-01-01','',0,0,1000),
 (20120093,'Uy Mila','','','','','1990-01-01','',0,0,1000),
 (20120094,'Carcusia Oscar','','','','','1990-01-01','',0,0,1000);
UNLOCK TABLES;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`dates`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`dates`;
CREATE TABLE  `db_pos_restaurant`.`dates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`dates`
--

/*!40000 ALTER TABLE `dates` DISABLE KEYS */;
LOCK TABLES `dates` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `dates` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`discounts`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`discounts`;
CREATE TABLE  `db_pos_restaurant`.`discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`discounts`
--

/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
LOCK TABLES `discounts` WRITE;
INSERT INTO `db_pos_restaurant`.`discounts` VALUES  (1,'Senior Citizen',6),
 (2,'Programmer',10),
 (3,'adada',1),
 (4,'adad',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`endorsements`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`endorsements`;
CREATE TABLE  `db_pos_restaurant`.`endorsements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(100) DEFAULT NULL,
  `qty_endorsed` double DEFAULT NULL,
  `qty_left` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cashier_id` int(11) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=235 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`endorsements`
--

/*!40000 ALTER TABLE `endorsements` DISABLE KEYS */;
LOCK TABLES `endorsements` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `endorsements` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`favorites`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`favorites`;
CREATE TABLE  `db_pos_restaurant`.`favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`favorites`
--

/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
LOCK TABLES `favorites` WRITE;
INSERT INTO `db_pos_restaurant`.`favorites` VALUES  (59,'27'),
 (60,'28'),
 (61,'29'),
 (62,'65'),
 (63,'1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`head_endorsements`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`head_endorsements`;
CREATE TABLE  `db_pos_restaurant`.`head_endorsements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_delivered` datetime DEFAULT NULL,
  `no_of_heads_endorsed` double DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `no_of_products_per_head` double DEFAULT NULL,
  `total_kilos` double DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `remarks2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`head_endorsements`
--

/*!40000 ALTER TABLE `head_endorsements` DISABLE KEYS */;
LOCK TABLES `head_endorsements` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `head_endorsements` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`inventory`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`inventory`;
CREATE TABLE  `db_pos_restaurant`.`inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `beg` double DEFAULT NULL,
  `end` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `physical_count` double DEFAULT NULL,
  `variance` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`inventory`
--

/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
LOCK TABLES `inventory` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`inventory2`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`inventory2`;
CREATE TABLE  `db_pos_restaurant`.`inventory2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lookup_code` varchar(20) DEFAULT NULL,
  `prod_num` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `qty_per_head` double DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime DEFAULT NULL,
  `types` varchar(100) DEFAULT NULL,
  `types_num` varchar(100) DEFAULT NULL,
  `updated_by` varchar(100) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `is_vat` tinyint(4) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`inventory2`
--

/*!40000 ALTER TABLE `inventory2` DISABLE KEYS */;
LOCK TABLES `inventory2` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `inventory2` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`inventory2_stocks_left`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`inventory2_stocks_left`;
CREATE TABLE  `db_pos_restaurant`.`inventory2_stocks_left` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lookup_code` varchar(20) DEFAULT NULL,
  `prod_num` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `types` varchar(100) DEFAULT NULL,
  `types_num` varchar(100) DEFAULT NULL,
  `is_vat` varchar(100) DEFAULT NULL,
  `prod_assembly` tinyint(4) DEFAULT NULL,
  `is_linient` tinyint(4) DEFAULT NULL,
  `w_commission` tinyint(4) DEFAULT NULL,
  `comm_amount` double DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`inventory2_stocks_left`
--

/*!40000 ALTER TABLE `inventory2_stocks_left` DISABLE KEYS */;
LOCK TABLES `inventory2_stocks_left` WRITE;
INSERT INTO `db_pos_restaurant`.`inventory2_stocks_left` VALUES  (3,'3',3,'3','REG. SAFEGUARD',30,0,'REG. SAFEGUARD','3','0',0,0,0,0,1),
 (4,'4',4,'4','MODESS DARK BLUE (REG)',7,0,'SANITARY NAPKINS','4','0',0,0,0,0,1),
 (5,'5',5,'5','WHISPER BLUE (REG.)',7,0,'SANITARY NAPKINS','4','0',0,0,0,0,1),
 (6,'6',6,'6','WHISPER WINGS VIOLET (REG)',7,0,'SANITARY NAPKINS','4','0',0,0,0,0,1),
 (7,'7',7,'7','ACE TOILET PAPER',12,0,'TOILET PAPER','5','0',0,0,0,0,1),
 (8,'8',8,'8','JADE TOILET PAPER',10,0,'TOILET PAPER','5','0',0,0,0,0,1),
 (9,'9',9,'9','JOY TOILET PAPER',15,0,'TOILET PAPER','5','0',0,0,0,0,1),
 (10,'10',10,'10','ToILY TOILET PAPER',10,0,'TOILET PAPER','5','0',0,0,0,0,1),
 (12,'12',12,'12','NEON CARTOLINA',8,0,'CARTOLINA','7','0',0,0,0,0,2),
 (14,'14',14,'14','GINUIS CRAYON 16',20,0,'CRAYON','8','0',0,0,0,0,2),
 (15,'15',15,'15','MONGOL CRAYON 8',15,0,'CRAYON','8','0',0,0,0,0,2),
 (16,'16',16,'16','BIG VERSIONS DRAWING BOOK',15,0,'DRAWING BOOK','9','0',0,0,0,0,2),
 (17,'17',17,'17','LONG BROWN ENVELOPE',2.5,0,'ENVELOPE','10','0',0,0,0,0,2),
 (18,'18',18,'18','LONG PLASTIC ENVELOPE',7,0,'ENVELOPE','10','0',0,0,0,0,2),
 (19,'19',19,'19','SHORT BROWN ENVELOPE',2,0,'ENVELOPE','10','0',0,0,0,0,2),
 (20,'20',20,'20','LONG SLIDING FOLDER',8,0,'FOLDER','11','0',0,0,0,0,2),
 (21,'21',21,'21','SHORT FOLDER ord.',5,0,'FOLDER','11','0',0,0,0,0,2),
 (22,'22',22,'22','SHORT SLIDING FOLDER',7,0,'FOLDER','11','0',0,0,0,0,2),
 (23,'23',23,'23','ELMER\'S GLUE SMALL',22,0,'GLUE','12','0',0,0,0,0,2),
 (24,'24',24,'24','illustration board 1/4',10,0,'ILLUSTRATION BOARD','13','0',0,0,0,0,2),
 (25,'25',25,'25','illustration board 1/8',7,0,'ILLUSTRATION BOARD','13','0',0,0,0,0,2),
 (28,'28',28,'28','spiral note book 80',15,0,'NOTEBOOK','14','0',0,0,0,0,2),
 (30,'30',30,'30','ASPEN NOTEBOOK 40',10,0,'NOTEBOOK','14','0',0,0,0,0,2),
 (31,'31',31,'31','AVENGERS NOTEBOOK40',10,0,'NOTEBOOK','14','0',0,0,0,0,2),
 (32,'32',32,'32','spiral advance  knd 40',15,0,'NOTEBOOK','14','0',0,0,0,0,2),
 (35,'35',35,'35','GRADE 1 hapi pad',15,0,'PAPER','15','0',0,0,0,0,2),
 (36,'36',36,'36','INTERMEDIATE PAPER',20,0,'PAPER','15','0',0,0,0,0,2),
 (37,'37',37,'37','WRITING PIXEL80',15,0,'NOTEBOOK','14','0',0,0,0,0,2),
 (38,'38',38,'38','S. PASTE',3,0,'PASTE','16','0',0,0,0,0,2),
 (39,'39',39,'39','MONGOL PENCIL',10,0,'PENCIL','17','0',0,0,0,0,2),
 (40,'40',40,'40','PILOT PENTEL PEN BLACK',35,0,'PENTEL PEN ','18','0',0,0,0,0,2),
 (41,'41',41,'41','PLASTIC COVER ',15,0,'PLASTIC COVER','19','0',0,0,0,0,2),
 (42,'42',42,'42','PLASTIC FASTENER',1.5,0,'PLASTIC FASTENER','20','0',0,0,0,0,2),
 (43,'43',43,'43','PROTRACTOR40',6,0,'PROTRACTOR','21','0',0,0,0,0,2),
 (46,'46',46,'46','TRANSPARENT RULER',7,0,'RULER','24','0',0,0,0,0,2),
 (47,'47',47,'47','SCISSORS sml.',10,0,'SCISSORS','25','0',0,0,0,0,2),
 (48,'48',48,'48','SHARPENER new',10,0,'SHARPENER','26','0',0,0,0,0,2),
 (49,'49',49,'49','LUCKY ME BIG',30,0,'LUCKY ME','27','0',0,0,0,0,3),
 (51,'51',51,'51','LUCKY ME SMALL',22,0,'LUCKY ME','27','0',0,0,0,0,3),
 (53,'53',53,'53','NESCAFE 3-IN-1 w/o',7,0,'COFFEE','28','0',0,0,0,0,3),
 (54,'54',54,'54','BIG BANG',8,0,'CANDY','29','0',0,0,0,0,3),
 (55,'55',55,'55','FLAT TOPS',3,0,'CANDY','29','0',0,0,0,0,3),
 (56,'56',56,'56','FUJI bar CHOCOLATE',8,0,'CANDY','29','0',0,0,0,0,3),
 (57,'57',57,'57','JELLY ACE',2,0,'CANDY','29','0',0,0,0,0,3),
 (58,'58',58,'58','KENDIMENT',1,0,'CANDY','29','0',0,0,0,0,3),
 (59,'59',59,'59','KOPIKO',1,0,'CANDY','29','0',0,0,0,0,3),
 (61,'61',61,'61','KRIMSTICK REFILL',1.5,0,'CANDY','29','0',0,0,0,0,3),
 (62,'62',62,'62','MAXX CANDY',1,0,'CANDY','29','0',0,0,0,0,3),
 (63,'63',63,'63','MILK POLVORON',2,0,'CANDY','29','0',0,0,0,0,3),
 (64,'64',64,'64','MILKITA CANDY',1,0,'CANDY','29','0',0,0,0,0,3),
 (65,'65',65,'65','MILKITA LOLLY POP',6,0,'CANDY','29','0',0,0,0,0,3),
 (66,'66',66,'66','NIPS TIE',4,0,'CANDY','29','0',0,0,0,0,3),
 (67,'67',67,'67','SOFT CANDY ORANGE',1,0,'CANDY','29','0',0,0,0,0,3),
 (68,'68',68,'68','SOFT CANDY STARBERRY',1,0,'CANDY','29','0',0,0,0,0,3),
 (69,'69',69,'69','SUPER STICK JR.',1.5,0,'CANDY','29','0',0,0,0,0,3),
 (70,'70',70,'70','WHITE RABBIT',1,0,'CANDY','29','0',0,0,0,0,3),
 (71,'71',71,'71','WHY NUTS MILK',2,0,'CANDY','29','0',0,0,0,0,3),
 (72,'72',72,'72','XO CANDY',1,0,'CANDY','29','0',0,0,0,0,3),
 (73,'73',73,'73','ZUPPER-ZUPPER',1,0,'CANDY','29','0',0,0,0,0,3),
 (74,'74',74,'74','CHOEY CHOCO',2,0,'CANDY','29','0',0,0,0,0,3),
 (75,'75',75,'75','CHOEY TAFEE',2,0,'CANDY','29','0',0,0,0,0,3),
 (76,'76',76,'76','CHUBBY CHOCO CHOEY',2,0,'CANDY','29','0',0,0,0,0,3),
 (77,'77',77,'77','CHUBBY MILK CHOEY',2,0,'CANDY','29','0',0,0,0,0,3),
 (78,'78',78,'78','CLOUD 9',8,0,'CANDY','29','0',0,0,0,0,3),
 (79,'79',79,'79','NISSIN STICK CHOCOLATE',6,0,'CHOCO SNACKS','30','0',0,0,0,0,3),
 (80,'80',80,'80','PINIPIG',22,0,'CHOCO SNACKS','30','0',0,0,0,0,8),
 (81,'81',81,'81','CHOCO PRETZELS',8,0,'CHOCO SNACKS','30','0',0,0,0,0,3),
 (82,'82',82,'82','CHOCO NUTS CHARO ',8,0,'CHOCO SNACKS','30','0',0,0,0,0,3),
 (83,'83',83,'83','MILKY NUTS',8,0,'CHOCO SNACKS','30','0',0,0,0,0,3),
 (84,'84',84,'84','COOKIE CRUNCH',6,0,'COOKIES','31','0',0,0,0,0,3),
 (85,'85',85,'85','CHOCO CRUNCHES',6,0,'COOKIES','31','0',0,0,0,0,3),
 (86,'86',86,'86','CHOCO CUPS',22,0,'COOKIES','31','0',0,0,0,0,3),
 (87,'87',87,'87','CHUnkie COOKIES',8,0,'COOKIES','31','0',0,0,0,0,3),
 (88,'88',88,'88','CREAM O CHOCO stick',8,0,'COOKIES','31','0',0,0,0,0,3),
 (89,'89',89,'89','CREAM O CHOCOLATE',8,0,'COOKIES','31','0',0,0,0,0,3),
 (90,'90',90,'90','CREAM O VANILLA',8,0,'COOKIES','31','0',0,0,0,0,3),
 (91,'91',91,'91','DREAMSTICK STRAWBERRY',22,0,'COOKIES','31','0',0,0,0,0,3),
 (92,'92',92,'92','DRUMSTICK DOO VANILLA',22,0,'SORBETES','55','0',0,0,0,0,8),
 (93,'93',93,'93','DYNAMIC CHOCO',2,0,'COOKIES','31','0',0,0,0,0,3),
 (94,'94',94,'94','EXTREAMS REBISCO',8,0,'COOKIES','31','0',0,0,0,0,3),
 (95,'95',95,'95','Fast BREak',6,0,'COOKIES','31','0',0,0,0,0,3),
 (96,'96',96,'96','GRAHAM',6,0,'COOKIES','31','0',0,0,0,0,3),
 (97,'97',97,'97','HANSEL CHOCOLATE',6,0,'COOKIES','31','0',0,0,0,0,3),
 (98,'98',98,'98','HIRO',6,0,'COOKIES','31','0',0,0,0,0,3),
 (99,'99',99,'99','MAGIC CREAM CHOCOLATE',6,0,'COOKIES','31','0',0,0,0,0,3),
 (100,'100',100,'100','PRESTO CREAM',6,0,'COOKIES','31','0',0,0,0,0,3),
 (101,'101',101,'101','SKY FLAKES',5,0,'COOKIES','31','0',0,0,0,0,3),
 (102,'102',102,'102','UR-CHIPS WARYO',24,0,'COOKIES','31','0',0,0,0,0,3),
 (103,'103',103,'103','VOICE CHOCOLATE',6,0,'COOKIES','31','0',0,0,0,0,3),
 (104,'104',104,'104','WAFER TIMES',5,0,'COOKIES','31','0',0,0,0,0,3),
 (105,'105',105,'105','HAPPY PEANUTS',1.5,0,'PEANUTS','32','0',0,0,0,0,3),
 (107,'107',107,'107','HALO-HALO',25,0,'HALO-HALO','33','0',0,0,0,0,5),
 (110,'110',110,'110','SNOW CREAM',0,0,'SNOW CREAM','36','0',0,0,0,0,5),
 (112,'112',112,'112','TEMPURA',5,0,'TEMPURA','38','0',0,0,0,0,5),
 (113,'113',113,'113','FRENCH FRIES',20,0,'CANDY','29','0',0,0,0,0,5),
 (114,'114',114,'114','KING SIZE',24,0,'JUICE','41','0',0,0,0,0,6),
 (115,'115',115,'115','L LEMON 450mL',24,0,'JUICE','41','0',0,0,0,0,6),
 (116,'116',116,'116','L LEMON REG',24,0,'JUICE','41','0',0,0,0,0,6),
 (117,'117',117,'117','L RED 450mL',24,0,'JUICE','41','0',0,0,0,0,6),
 (118,'118',118,'118','LIPTON ICE TEA',24,0,'JUICE','41','0',0,0,0,0,6),
 (119,'119',119,'119','L-SEY APPLE 500ml',24,0,'JUICE','41','0',0,0,0,0,6),
 (120,'120',120,'120','L-Z ST. LEMON 500ml',24,0,'JUICE','41','0',0,0,0,0,6),
 (121,'121',121,'121','M. ORANGE',10,0,'JUICE','41','0',0,0,0,0,6),
 (122,'122',122,'122','MANGO CUPS',24,0,'JUICE','41','0',0,0,0,0,6),
 (123,'123',123,'123','P. REG. 300',24,0,'JUICE','41','0',0,0,0,0,6),
 (124,'124',124,'124','PF JUMBO',24,0,'JUICE','41','0',0,0,0,0,6),
 (125,'125',125,'125','S  REG  500ml',24,0,'JUICE','41','0',0,0,0,0,6),
 (126,'126',126,'126','T-FRUIT BURST 355ml',24,0,'JUICE','41','0',0,0,0,0,6),
 (127,'127',127,'127','T-FRUIT ORANGE 355ml',24,0,'JUICE','41','0',0,0,0,0,6),
 (128,'128',128,'128','SPONGEBOB GG MILK 180ml',22,0,'MILK DRINKS','42','0',0,0,0,0,6),
 (129,'129',129,'129','Premier  WATER500 ml',14,0,'WATER','43','0',0,0,0,0,6),
 (130,'130',130,'130','Premier water 350 ml',12,0,'WATER','43','0',0,0,0,0,6),
 (133,'133',133,'133','7-UP 8oz',10,0,'7-UP','44','0',0,0,0,0,6),
 (134,'134',134,'134','7-UP 500ml',24,0,'7-UP','44','0',0,0,0,0,6),
 (135,'135',135,'135','MIRINDA 8oz',10,0,'MIRINDA','45','0',0,0,0,0,6),
 (136,'136',136,'136','MIRINDA 500ml',24,0,'MIRINDA','45','0',0,0,0,0,6),
 (137,'137',137,'137','MOUNTAIN DEW 8 oz',10,0,'MOUNTAIN DEW','46','0',0,0,0,0,6),
 (138,'138',138,'138','MOUNTAIN DEW 12oz',12,0,'MOUNTAIN DEW','46','0',0,0,0,0,6),
 (139,'139',139,'139','MOUNTAIN DEW 500ml',24,0,'MOUNTAIN DEW','46','0',0,0,0,0,6),
 (140,'140',140,'140','PEPSI 8oz',10,0,'PEPSI','47','0',0,0,0,0,6),
 (143,'143',143,'143','POTCHERO',15,0,'BEEF','48','0',0,0,0,0,7),
 (144,'144',144,'144','BOILED EGG',10,0,'CHICKEN','50','0',0,0,0,0,7),
 (145,'145',145,'145','BURGER WITH VEGETABLE SAUCE',30,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (146,'146',146,'146','CHOLETAS',30,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (147,'147',147,'147','CHORIZO',8,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (148,'148',148,'148','FRIED EGG',10,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (149,'149',149,'149','HOTDOG',10,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (150,'150',150,'150','LUMPIA SHANGHAI',30,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (151,'151',151,'151','LUNCHEON MEAT',10,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (152,'152',152,'152','PICADILLO',30,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (153,'153',153,'153','SWEET AND SOUR MEAT BALLS',30,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (154,'154',154,'154','SWEET HAM',10,0,'BREAKFAST MEALS','49','0',0,0,0,0,7),
 (155,'155',155,'155','CHICKEN INASAL',55,0,'CHICKEN','50','0',0,0,0,0,7),
 (156,'156',156,'156','CHICKEN STRIPS',30,0,'CHICKEN','50','0',0,0,0,0,7),
 (157,'157',157,'157','FRIED CHICKEN',30,0,'CHICKEN','50','0',0,0,0,0,7),
 (158,'158',158,'158','SPICY CHICKEN WITH YOUNGCORN SAUCE',30,0,'CHICKEN','50','0',0,0,0,0,7),
 (159,'159',159,'159','TINOLANG MANOK',15,0,'CHICKEN','50','0',0,0,0,0,7),
 (160,'160',160,'160','FISH FILLET',15,0,'FISH','51','0',0,0,0,0,7),
 (161,'161',161,'161','SWEET AND SOUR FISH',30,0,'FISH','51','0',0,0,0,0,7),
 (162,'162',162,'162','BIHON GUISADO',15,0,'NOODLES/PASTA','52','0',0,0,0,0,7),
 (163,'163',163,'163','BAM-E',15,0,'NOODLES/PASTA','52','0',0,0,0,0,7),
 (164,'164',164,'164','PANCIT GUISADO',15,0,'NOODLES/PASTA','52','0',0,0,0,0,7),
 (165,'165',165,'165','SPAGHETTI NOODLES WITH WHITE SAUCE',35,0,'NOODLES/PASTA','52','0',0,0,0,0,7),
 (166,'166',166,'166','MENUDO',30,0,'PORK','53','0',0,0,0,0,7),
 (167,'167',167,'167','PORK ADOBO',30,0,'PORK','53','0',0,0,0,0,7),
 (168,'168',168,'168','PORK CURRY',30,0,'PORK','53','0',0,0,0,0,7),
 (169,'169',169,'169','PORK CURRY',30,0,'PORK','53','0',0,0,0,0,7),
 (170,'170',170,'170','PORK CUTLET',30,0,'PORK','53','0',0,0,0,0,7),
 (171,'171',171,'171','PORK SINIGANG',15,0,'PORK','53','0',0,0,0,0,7),
 (172,'172',172,'172','PORK WITH PECHAY',15,0,'PORK','53','0',0,0,0,0,7),
 (173,'173',173,'173','PORK WITH PINEAPPLE',30,0,'PORK','53','0',0,0,0,0,7),
 (174,'174',174,'174','PORK WITH POTATO',30,0,'PORK','53','0',0,0,0,0,7),
 (175,'175',175,'175','PORK WITH WHITE ONION SAUCE',30,0,'PORK','53','0',0,0,0,0,7),
 (176,'176',176,'176','SLICED PORK WITH CABBAGE SOUP',15,0,'PORK','53','0',0,0,0,0,7),
 (177,'177',177,'177','TABEYONG',15,0,'PORK','53','0',0,0,0,0,7),
 (178,'178',178,'178',' baguio beans guisado',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (179,'179',179,'179','CHOPSUEY',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (180,'180',180,'180','GIATAANG SARI SARI GULAY',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (181,'181',181,'181','GINISANG MONGGO',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (182,'182',182,'182','MIX VEGETABLE GISADO',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (183,'183',183,'183','PINAKBET',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (184,'184',184,'184','SAYOTE GUISADO',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (185,'185',185,'185','STRING BEANS GUISADO',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (186,'186',186,'186','TORTANG TALONG',15,0,'VEGETABLES','54','0',0,0,0,0,7),
 (188,'188',188,'188','SORBETES STICK',10,0,'SORBETES','55','0',0,0,0,0,8),
 (189,'189',189,'189','UBE CUPS',0,0,'UBE CUPS','56','0',0,0,0,0,8),
 (191,'191',191,'191','REG homemade ice cream',8,0,'REG ICE CREAM','58','0',0,0,0,0,9),
 (192,'192',192,'192','sml.safeguard',20,0,'REG. SAFEGUARD','3','Yes',0,0,0,0,1),
 (193,'193',192,'193','reg.bond aid',2,0,'Band aid','59','Yes',0,0,0,0,1),
 (194,'194',193,'194','safety pin sml.',0.75,0,'safety pin','60','Yes',0,0,0,0,1),
 (195,'195',194,'195','johnson baby pwder',20,0,'johnson ','61','Yes',0,0,0,0,1),
 (196,'196',195,'196','close up',8,0,'close up','62','Yes',0,0,0,0,1),
 (197,'197',196,'197','colgate',8,0,'colgate','63','Yes',0,0,0,0,1),
 (199,'199',197,'199','flair ballpen',8,0,'BALLPEN','6','Yes',0,0,0,0,2),
 (201,'201',199,'201','GINUIS CRAYON 16',20,0,'BALLPEN','6','Yes',0,0,0,0,2),
 (202,'202',201,'202','Ord.envelope long',1,0,'ENVELOPE','10','Yes',0,0,0,0,2),
 (203,'203',202,'203','ord.envelope short',0.75,0,'ENVELOPE','10','Yes',0,0,0,0,2),
 (204,'204',203,'204','folder long ord.',6,0,'FOLDER','11','Yes',0,0,0,0,2),
 (205,'205',204,'205','grd. 4 pad',15,0,'PAPER','15','Yes',0,0,0,0,2),
 (206,'206',205,'206','grd.3 pad paper',15,0,'PAPER','15','Yes',0,0,0,0,2),
 (207,'207',206,'207','grd. 2 pad paper',15,0,'PAPER','15','Yes',0,0,0,0,2),
 (208,'208',207,'208','1/2 crosswise',8,0,'PAPER','15','Yes',0,0,0,0,2),
 (209,'209',208,'209','1/4 pad paper',5,0,'PAPER','15','Yes',0,0,0,0,2),
 (210,'210',209,'210','nescafe 3n1 w/',10,0,'COFFEE','28','Yes',0,0,0,0,3),
 (211,'211',210,'211','kopiko w/',10,0,'COFFEE','28','Yes',0,0,0,0,3),
 (212,'212',211,'212','kopiko w/o',8,0,'COFFEE','28','Yes',0,0,0,0,3),
 (213,'213',212,'213','why nut chocolate',2,0,'CANDY','29','Yes',0,0,0,0,3),
 (214,'214',213,'214','homemade peanuts',5,0,'PEANUTS','32','Yes',0,0,0,0,3),
 (215,'215',214,'215','yemas',1,0,'CANDY','29','Yes',0,0,0,0,3),
 (216,'216',215,'216','shake',20,0,'HALO-HALO','33','Yes',0,0,0,0,5),
 (217,'217',216,'217','fruit mix',10,0,'HALO-HALO','33','Yes',0,0,0,0,5),
 (218,'218',217,'218','banana split',30,0,'HALO-HALO','33','Yes',0,0,0,0,5),
 (219,'219',218,'219','snow cream',10,0,'HALO-HALO','33','Yes',0,0,0,0,5),
 (220,'220',219,'220','chocolate milk 250ml',24,0,'MILK DRINKS','42','Yes',0,0,0,0,6),
 (221,'221',220,'221','chuckie 250ml',24,0,'MILK DRINKS','42','Yes',0,0,0,0,6),
 (222,'222',221,'222','pepsi 500ml',24,0,'PEPSI','47','Yes',0,0,0,0,6),
 (223,'223',222,'223','pepsi cups',10,0,'PEPSI','47','Yes',0,0,0,0,6),
 (224,'224',223,'224','mt.dew cups',10,0,'MOUNTAIN DEW','46','Yes',0,0,0,0,6),
 (225,'225',224,'225','mirinda cups',10,0,'MIRINDA','45','Yes',0,0,0,0,6),
 (226,'226',225,'226','7 up cups',10,0,'7-UP','44','Yes',0,0,0,0,6),
 (227,'227',226,'227','rice',10,0,'BREAKFAST MEALS','49','Yes',0,0,0,0,7),
 (228,'228',227,'228','fried rice',20,0,'BREAKFAST MEALS','49','Yes',0,0,0,0,7),
 (229,'229',228,'229','pork longganisa',5,0,'BREAKFAST MEALS','49','Yes',0,0,0,0,7),
 (230,'230',229,'230','fish stick',30,0,'FISH','51','Yes',0,0,0,0,7),
 (231,'231',230,'231','burger steak',30,0,'PORK','53','Yes',0,0,0,0,7),
 (233,NULL,231,'232','HAMBURGER',20,0,'FLOOR WAX','1','Yes',0,0,0,0,4),
 (234,NULL,232,'234','CHEESE BURGER',25,0,'CANDY','29','Yes',0,0,0,0,4),
 (235,NULL,233,'235','HAM AND EGG',20,0,'FLOOR WAX','1','Yes',0,0,0,0,4),
 (236,NULL,234,'236','SANDWICH LOAF',15,0,'FLOOR WAX','1','Yes',0,0,0,0,4),
 (237,NULL,235,'237','SPAGHETTI BREAD',15,0,'FLOOR WAX','1','Yes',0,0,0,0,4),
 (238,NULL,236,'238','SPAGHETTI BOWL',15,0,'FLOOR WAX','1','Yes',0,0,0,0,4),
 (239,NULL,237,'239','TOCINO',10,0,'FLOOR WAX','1','Yes',0,0,0,0,4),
 (240,NULL,238,'240','FRENCH FRIES',20,0,'FLOOR WAX','1','Yes',0,0,0,0,4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `inventory2_stocks_left` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`inventory_dates`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`inventory_dates`;
CREATE TABLE  `db_pos_restaurant`.`inventory_dates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_added` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`inventory_dates`
--

/*!40000 ALTER TABLE `inventory_dates` DISABLE KEYS */;
LOCK TABLES `inventory_dates` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `inventory_dates` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`key_products`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`key_products`;
CREATE TABLE  `db_pos_restaurant`.`key_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key_number` int(11) DEFAULT NULL,
  `key_size` int(11) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`key_products`
--

/*!40000 ALTER TABLE `key_products` DISABLE KEYS */;
LOCK TABLES `key_products` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `key_products` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`member_charges`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`member_charges`;
CREATE TABLE  `db_pos_restaurant`.`member_charges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cashier_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_id` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `is_payed` varchar(100) DEFAULT NULL,
  `date_payed` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`member_charges`
--

/*!40000 ALTER TABLE `member_charges` DISABLE KEYS */;
LOCK TABLES `member_charges` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `member_charges` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`pending_order_details`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`pending_order_details`;
CREATE TABLE  `db_pos_restaurant`.`pending_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pending_order_id` int(11) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`pending_order_details`
--

/*!40000 ALTER TABLE `pending_order_details` DISABLE KEYS */;
LOCK TABLES `pending_order_details` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `pending_order_details` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`pending_orders`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`pending_orders`;
CREATE TABLE  `db_pos_restaurant`.`pending_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_name` (`customer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`pending_orders`
--

/*!40000 ALTER TABLE `pending_orders` DISABLE KEYS */;
LOCK TABLES `pending_orders` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `pending_orders` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`product_supplier`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`product_supplier`;
CREATE TABLE  `db_pos_restaurant`.`product_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(200) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `rep` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`product_supplier`
--

/*!40000 ALTER TABLE `product_supplier` DISABLE KEYS */;
LOCK TABLES `product_supplier` WRITE;
INSERT INTO `db_pos_restaurant`.`product_supplier` VALUES  (1,'Lee Supper PLAZAa','adad','adad1',NULL),
 (2,'Synapse','adaad','23234243',NULL),
 (3,'adad','sdfas','adad',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `product_supplier` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`product_uom`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`product_uom`;
CREATE TABLE  `db_pos_restaurant`.`product_uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uom` varchar(100) DEFAULT NULL,
  `uom_amount` double DEFAULT NULL,
  `prod_num` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`product_uom`
--

/*!40000 ALTER TABLE `product_uom` DISABLE KEYS */;
LOCK TABLES `product_uom` WRITE;
INSERT INTO `db_pos_restaurant`.`product_uom` VALUES  (8,'box',12,'1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `product_uom` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`products`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`products`;
CREATE TABLE  `db_pos_restaurant`.`products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lookup_code` varchar(20) DEFAULT NULL,
  `prod_num` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `qty_per_head` double DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `product_qty2` double DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime DEFAULT NULL,
  `types` varchar(100) DEFAULT NULL,
  `types_num` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lookup_code` (`lookup_code`),
  UNIQUE KEY `product_name` (`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
LOCK TABLES `products` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`receipt_discount`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`receipt_discount`;
CREATE TABLE  `db_pos_restaurant`.`receipt_discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `or_number` varchar(100) DEFAULT NULL,
  `disc_no` int(11) DEFAULT NULL,
  `disc_name` varchar(100) DEFAULT NULL,
  `disc_percent` double DEFAULT NULL,
  `disc_rate` double DEFAULT NULL,
  `cust_name` varchar(100) DEFAULT NULL,
  `cust_no` varchar(100) DEFAULT NULL,
  `cust_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`receipt_discount`
--

/*!40000 ALTER TABLE `receipt_discount` DISABLE KEYS */;
LOCK TABLES `receipt_discount` WRITE;
INSERT INTO `db_pos_restaurant`.`receipt_discount` VALUES  (1,'3',1,'Senior Citizen',6,70.2,'ronald Pascua','3452354345','bagacay'),
 (2,'4',1,'Senior Citizen',6,8.22,'ron','234234234234234','asdasd'),
 (3,'0',1,'Programmer',10,26.2,'ronald Pascua','2342','awdasdad'),
 (4,'0',1,'Senior Citizen',6,3.72,'ronald Pascua','23424','23423424'),
 (5,'0',1,'Senior Citizen',6,3.72,'ronald Pascua','23424','23423424'),
 (6,'0',1,'Senior Citizen',6,2.7,'Rond','34234','adda'),
 (7,'0',1,'Senior Citizen',6,2.76,'ron','F','D'),
 (8,'3',1,'Senior Citizen',6,42.6,'adadad','adad','adadad'),
 (9,'18',1,'Senior Citizen',6,8.52,'adad','adad','cadadad'),
 (10,'27',1,'Senior Citizen',6,16.2,'Ronald Pascua','asdasdasd','adadad');
UNLOCK TABLES;
/*!40000 ALTER TABLE `receipt_discount` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`receipt_items`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`receipt_items`;
CREATE TABLE  `db_pos_restaurant`.`receipt_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_id` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `type_name` varchar(200) DEFAULT NULL,
  `cat_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`receipt_items`
--

/*!40000 ALTER TABLE `receipt_items` DISABLE KEYS */;
LOCK TABLES `receipt_items` WRITE;
INSERT INTO `db_pos_restaurant`.`receipt_items` VALUES  (12,1,'1',31,5,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (13,1,'2',42.5,8,'ENERGY DRINKS','BEVERAGES','ROCKSTAR ENERGY DRINK'),
 (14,2,'1',31,1,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (15,2,'2',42.5,2,'ENERGY DRINKS','BEVERAGES','ROCKSTAR ENERGY DRINK'),
 (16,3,'1',31,4,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (17,3,'2',42.5,5,'ENERGY DRINKS','BEVERAGES','ROCKSTAR ENERGY DRINK'),
 (18,4,'1',31,4,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE');
UNLOCK TABLES;
/*!40000 ALTER TABLE `receipt_items` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`receipts`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`receipts`;
CREATE TABLE  `db_pos_restaurant`.`receipts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cashier_session_id` int(11) DEFAULT NULL,
  `tendered` double DEFAULT NULL,
  `or_number` int(11) DEFAULT NULL,
  `receipt_status` int(11) DEFAULT '0',
  `receipt_date` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `approval_code` varchar(200) DEFAULT NULL,
  `member_id` varchar(100) DEFAULT NULL,
  `is_payed` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`receipts`
--

/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
LOCK TABLES `receipts` WRITE;
INSERT INTO `db_pos_restaurant`.`receipts` VALUES  (58,33,495,1,0,'2012-06-29 10:36:21',0,0,'','0',NULL),
 (59,33,116,2,0,'2012-06-29 10:37:21',0,0,'','0',NULL),
 (60,33,336.5,3,0,'2012-06-29 10:38:30',0,0,'','0',NULL),
 (61,33,124,4,0,'2012-06-29 13:09:23',0,0,'','0',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `receipts` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`sales`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`sales`;
CREATE TABLE  `db_pos_restaurant`.`sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(100) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `qty_sold` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cashierid` int(11) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`sales`
--

/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
LOCK TABLES `sales` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`stock_out`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`stock_out`;
CREATE TABLE  `db_pos_restaurant`.`stock_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_num` varchar(200) DEFAULT NULL,
  `prod_name` varchar(200) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cashier_name` varchar(100) DEFAULT NULL,
  `cashier_id` varchar(100) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`stock_out`
--

/*!40000 ALTER TABLE `stock_out` DISABLE KEYS */;
LOCK TABLES `stock_out` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `stock_out` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`system_date`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`system_date`;
CREATE TABLE  `db_pos_restaurant`.`system_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curr_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`system_date`
--

/*!40000 ALTER TABLE `system_date` DISABLE KEYS */;
LOCK TABLES `system_date` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `system_date` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`tables`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`tables`;
CREATE TABLE  `db_pos_restaurant`.`tables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`tables`
--

/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
LOCK TABLES `tables` WRITE;
INSERT INTO `db_pos_restaurant`.`tables` VALUES  (1,'1'),
 (2,'2'),
 (3,'3'),
 (4,'4'),
 (5,'5'),
 (6,'6'),
 (7,'7'),
 (8,'8'),
 (9,'9'),
 (10,'10'),
 (11,'11'),
 (12,'12'),
 (13,'13'),
 (14,'14'),
 (15,'15'),
 (16,'16'),
 (17,'17'),
 (18,'18'),
 (19,'19'),
 (21,'20'),
 (22,'21'),
 (23,'22'),
 (24,'23'),
 (25,'24'),
 (26,'25'),
 (27,'26'),
 (28,'27'),
 (29,'28'),
 (30,'29'),
 (31,'30'),
 (32,'31'),
 (33,'32'),
 (34,'32'),
 (35,'34'),
 (36,'35'),
 (37,'36'),
 (38,'37'),
 (39,'38'),
 (40,'39'),
 (41,'40'),
 (42,'41'),
 (43,'42'),
 (44,'43'),
 (45,'44'),
 (46,'45'),
 (47,'46'),
 (48,'47'),
 (49,'48'),
 (50,'49'),
 (51,'50'),
 (52,'51');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`uom`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`uom`;
CREATE TABLE  `db_pos_restaurant`.`uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uom` varchar(100) DEFAULT NULL,
  `uom_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`uom`
--

/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
LOCK TABLES `uom` WRITE;
INSERT INTO `db_pos_restaurant`.`uom` VALUES  (1,'box',11),
 (2,'pack',15);
UNLOCK TABLES;
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;


--
-- Definition of table `db_pos_restaurant`.`users`
--

DROP TABLE IF EXISTS `db_pos_restaurant`.`users`;
CREATE TABLE  `db_pos_restaurant`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(20) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `db_pos_restaurant`.`users` VALUES  (8,'admin','admin','admin',1,NULL,'2012-07-03 17:09:17',NULL),
 (9,'cashier1','cashier1','cashier1',0,NULL,'2012-07-03 17:09:17',NULL),
 (13,'cashier2','cashier2','cashier2',0,NULL,'2012-07-10 13:34:44',NULL),
 (14,'cashier3','cashier3','cashier3',0,NULL,'2012-07-10 13:34:59',NULL),
 (15,'cashier4','cashier4','cashier4',0,NULL,'2012-07-10 13:35:39',NULL),
 (16,'ballfield','ballfield','ballfield',0,NULL,'2012-07-10 13:35:54',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
