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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cash_drawer`
--

/*!40000 ALTER TABLE `cash_drawer` DISABLE KEYS */;
LOCK TABLES `cash_drawer` WRITE;
INSERT INTO `db_pos_restaurant`.`cash_drawer` VALUES  (30,29,'cashier','2012-06-18 00:00:00',100,NULL,NULL),
 (31,30,'cashier','2012-06-19 00:00:00',100,NULL,NULL),
 (32,31,'cashier','2012-07-11 00:00:00',100,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`cashier_sessions`
--

/*!40000 ALTER TABLE `cashier_sessions` DISABLE KEYS */;
LOCK TABLES `cashier_sessions` WRITE;
INSERT INTO `db_pos_restaurant`.`cashier_sessions` VALUES  (29,'cashier',1,0,0,'2012-06-18 00:00:00','2012-06-18 00:00:00','2012-06-18 02:02:33',NULL),
 (30,'cashier',1,0,0,'2012-06-19 00:00:00','2012-06-19 00:00:00','2012-06-19 02:23:38',NULL),
 (31,'cashier',1,0,0,'2012-07-11 00:00:00','2012-07-11 00:00:00','2012-07-11 05:06:53',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
LOCK TABLES `category` WRITE;
INSERT INTO `db_pos_restaurant`.`category` VALUES  (37,1,'BEVERAGES'),
 (38,2,'FOOD'),
 (39,3,'GROCERY ITEMS'),
 (40,4,'ICE CREAM'),
 (41,5,'SOFTDRINKS'),
 (42,6,'TOILETRIES'),
 (43,7,'WATER'),
 (44,8,'SCHOOL SUPPLIES');
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`category_type`
--

/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
LOCK TABLES `category_type` WRITE;
INSERT INTO `db_pos_restaurant`.`category_type` VALUES  (1,1,'COFFEE DRINK','1','BEVERAGES'),
 (2,2,'ENERGY DRINKS','1','BEVERAGES'),
 (3,3,'JUICES','1','BEVERAGES'),
 (4,4,'MILK DRINKS','1','BEVERAGES'),
 (5,5,'BEEF DISHES','2','FOOD'),
 (6,6,'CHICKEN DISHES','2','FOOD'),
 (7,7,'NOODLES','2','FOOD'),
 (8,8,'PORK DISHES','2','FOOD'),
 (9,9,'RICE','2','FOOD'),
 (10,10,'SEAFOOD DISHES','2','FOOD'),
 (11,11,'SNACKS','2','FOOD'),
 (12,12,'VEGETABLES','2','FOOD'),
 (13,13,'CANDY','3','GROCERY ITEMS'),
 (14,14,'CANNED PRODUCTS','3','GROCERY ITEMS'),
 (15,15,'COOKIES','3','GROCERY ITEMS'),
 (16,16,'DRIED PRODUCTS','3','GROCERY ITEMS'),
 (17,17,'HEALTH CARE','3','GROCERY ITEMS'),
 (18,18,'LINIMENT','3','GROCERY ITEMS'),
 (19,19,'MILK PRODUCTS','3','GROCERY ITEMS'),
 (20,20,'PACKED NOODLES','3','GROCERY ITEMS'),
 (21,21,'POWDERED COFFEE','3','GROCERY ITEMS'),
 (22,22,'POWDERED MILK','3','GROCERY ITEMS'),
 (23,23,'SANDWICH SPREADS','3','GROCERY ITEMS'),
 (24,24,'SEASONING','3','GROCERY ITEMS'),
 (25,25,'TEA','3','GROCERY ITEMS'),
 (26,26,'VITAMINS/FOOD SUPPLEMENT','3','GROCERY ITEMS'),
 (27,27,'SELECTA 3-IN-1 SUPREME','4','ICE CREAM'),
 (28,28,'SELECTA DOUBLE SUPREME','4','ICE CREAM'),
 (29,29,'SELECTA GOLD','4','ICE CREAM'),
 (30,30,'SELECTA HERSHEYS','4','ICE CREAM'),
 (31,31,'SELECTA PINOY SORBETES','4','ICE CREAM'),
 (32,32,'SELECTA SUPER THICK','4','ICE CREAM'),
 (33,33,'SELECTA SUPREME','4','ICE CREAM'),
 (34,34,'7-UP','5','SOFTDRINKS'),
 (35,35,'COKE','5','SOFTDRINKS'),
 (36,36,'LIFT','5','SOFTDRINKS'),
 (37,37,'MOUNTAIN DEW','5','SOFTDRINKS'),
 (38,38,'PEPSI','5','SOFTDRINKS'),
 (39,39,'ROYAL','5','SOFTDRINKS'),
 (40,40,'SPRITE','5','SOFTDRINKS'),
 (41,41,'ALCOHOL','6','TOILETRIES'),
 (42,42,'BABY SHAMPOO','6','TOILETRIES'),
 (43,43,'CLEANSER','6','TOILETRIES'),
 (44,44,'MOUTH WASH','6','TOILETRIES'),
 (45,45,'ORAL CARE','6','TOILETRIES'),
 (46,46,'SOAP','6','TOILETRIES'),
 (47,47,'TISSUE','6','TOILETRIES'),
 (48,48,'MINERAL WATER','7','WATER'),
 (49,49,'BALLPEN','8','SCHOOL SUPPLIES'),
 (50,50,'SHIRTS','8','SCHOOL SUPPLIES');
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
) ENGINE=InnoDB AUTO_INCREMENT=2012000904 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`customers`
--

/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
LOCK TABLES `customers` WRITE;
INSERT INTO `db_pos_restaurant`.`customers` VALUES  (2012000001,'ABALOS, Evalyn','SUCN Dumaguete City','','Staff','','1990-01-01','',0,0,1000),
 (2012000002,'ABBOT, Edith',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000003,'ABELLA, Effie',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000004,'ABELLA, Pedro',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000005,'ABELLANOSA, Emmanuel Jr.','CBA Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000006,'ABIL, Anibel',' Portal West Silliman Campus','','Dentist','','1990-01-01','',0,0,1000),
 (2012000007,'ABILAY, Evelyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000008,'ABLIR, Emilia','su cafeteria Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000009,'ABLIR, Isias Q.',' Dumaguete City','','Faculty','','1990-01-01','',1,0,1000),
 (2012000010,'ABLIR, Rosalind','Su Polsci Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000011,'ABLONG, Francisco Jr.','Physics Silliman Campus','','Faculty','','1990-01-01','',1,0,1000),
 (2012000012,'ABREGANA, Betty',' Silliman Campus','','Faculty','','1990-01-01','',0,0,1000),
 (2012000013,'ABRINGE, Rad Cliff','CSIT Dumaguete City, Negros Oriental','','student','','1990-01-01','',1,0,1000),
 (2012000014,'ACADEMIA, Erelyn R.','Divinity sIlliman Campus','','staff','','1990-01-01','',0,0,1000),
 (2012000015,'ACUPANDA, Ma. Arlinie G.','TESTING Center Dumaguete City, Negros Oriental','','staff','','1990-01-01','',0,0,1000),
 (2012000016,'ABRIO, Diomar','copa Tubod, Dgte. City','','Faculty','','1990-01-01','',0,0,1000),
 (2012000017,'ABUGAN, Magdalena',' Motong, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000018,'ADARNA, Ma. Ellaine','SUCN SIlliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000019,'AGIR, Janet','Su Elem Silliman Hiegths,Dgte. City','','Faculty','','1990-01-01','',0,0,1000),
 (2012000020,'AGUILAN, Evangeline',' Kalaoman, Silliman Campus','','Faculty','','1990-01-01','',0,0,1000),
 (2012000021,'AGUILAN, Victor',' SU Campus','','','','1990-01-01','',1,0,1000),
 (2012000022,'AGUILAR, Chin-Chin Maricor',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000023,'AGUIT, Carlito','College of Engineering Dumaguete City, Negros Oriental','','Faculty','','1990-01-01','',1,0,1000),
 (2012000024,'AJERO, Ofelia','BSSW-Grad Bais City, Neg. Or.','','Social Worker-NGO','Farming','1946-04-27','Single',0,0,1000),
 (2012000025,'ALAVA, Moonyen',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000026,'ALBA, Berman B.',' 1063 Calindagan Dumaguete City','225-0643','Salesman','Trucking Services','1953-08-02','Married',1,0,1000),
 (2012000027,'ALBA, Bethel','SUES Dumaguete City, Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000028,'ALBARRACIN, Susan Magdalene T.','SUCN Sitio Ogahong, Palinpinon, Valencia, Neg. Or.','09265075116','Clinical Instructor','','1970-05-29','Married',0,0,1000),
 (2012000029,'ALBINA, Nenita','Bus&Fin. Cantil – e, Dumaguete city','','','','1990-01-01','',0,0,1000),
 (2012000030,'ALCAIDE, Ursina D,',' HRD Silliman Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000031,'ALCANCIA, Mercurio','SU Café silliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000032,'ALCANO, Eulogio',' Villa Pastora , Bantingel, Dgte. City','','','','1990-01-01','',1,0,1000),
 (2012000033,'ALCANTARA, Lealiz Esther','CNAHS silliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000034,'ALCANTARA, Rogen Ferdinand E.','Psychology Duhat Cottage, Silliman Campus','09177060729','Teacher','','1971-07-29','Single',1,0,1000),
 (2012000035,'ALEDIA, N',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000036,'ALFORQUE, Silvestre',' VillaPastora, Batingel Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000037,'ALIH, Verna',' Bantayan, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000038,'ALPUERTO, Judith',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000039,'ALTEJAR, Lorynie C.','Elementary Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000040,'ALVIOLA, Andrea','College of Law Silliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000041,'ALVIOLA, Celia Fe A.',' Brgy. Talungan, B.C.','09062734760','Gov\'t Employee','','1959-02-27','Married',0,0,1000),
 (2012000042,'AMADA, Ramonito C.','Buildings And Grounds sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000043,'AMISCARAY, Jesus',' Sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000044,'AMPONG, Nati Julieta','SPO Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000045,'ANG, Jacklyn Lee','BSN Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000046,'ANG, Krats Chelou Chad',' CBA Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000047,'ANGEL, Janne',' B2 L12 Judyville Subd. Sibulan','09088746214','','Buy and Sell','1977-06-12','Married',0,0,1000),
 (2012000048,'ANGEL, Joji',' B2 L12 Judyville Subd. Sibulan','','','','1990-01-01','',0,0,1000),
 (2012000049,'ANITO, Carmela',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000050,'ANITO, Nelia T.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000051,'ANQUE, Geraldine','Nursing Melrose Rd. Calindagan, Dgte. City','09197138923','Clinical Instructor','','1972-12-31','Single',0,0,1000),
 (2012000052,'ANTOLO, Luzminda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000053,'ANTONIO, Jose Mari Jonathan',' Jonob, Dumaguete city','','','','1990-01-01','',1,0,1000),
 (2012000054,'ANTOSADA, Arlene A.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000055,'APLAON, Azil',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000056,'APLAON, Georgie Cabalida',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000057,'APURA, Lily',' SIlliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000058,'APURA, Princeton',' SIlliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000059,'ARABE, Aida',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000060,'ARAGONES, Kathreen Fabugais',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000061,'ARANAS, Bernie',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000062,'ARANAS, Celestina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000063,'ARANAS, Christian Patrick',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000064,'ARBOLEDA, Melchor',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000065,'ARBON, Ophelia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000066,'AREVALO, Jennifer',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000067,'ARMENTANO, Teresa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000068,'ARNEJO, Leonarda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000069,'ASPILLA, Paulina',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000070,'ASUGAS, Gregorio III',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000071,'ATEGA, Moses',' Silliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000072,'ATILLO, Josephine',' Silliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000073,'AUGUIS, Gleen R.',' ','','','','1990-01-01','',1,0,1000),
 (2012000074,'AVERIA, Leonardo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000075,'AVES, Precencia',' ','','','','1990-01-01','',0,0,1000),
 (2012000076,'AZUELO, Anabelle P.',' Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000077,'BAANG, Henry',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000078,'BABOR, Glen',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000079,'BACAY, Lorelei M.','Nursing Bantayan, Dgte. City','09173271976','Clinical Instructor','','1979-09-17','Married',0,0,1000),
 (2012000080,'BADON, Cyndi Louric',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000081,'BADOY, Brenda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000082,'BAEL, Arthur',' Dauin, Negros Oreintal','','','','1990-01-01','',1,0,1000),
 (2012000083,'BAEL, Paul',' Dauin, Negros Oreintal','','','','1990-01-01','',1,0,1000),
 (2012000084,'BAENA, Alfie del Mar',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000085,'BAENA, Mona del Mar',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000086,'BAGA, Jane',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000087,'BAGTINDON, Veron',' Sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000088,'BAIDIANGO, Benjamin',' Valencia, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000089,'BALAGTAS, Rodney Meg Fritz','CBA Valencia, Neg. Or.','09159066370','Student','','1990-10-15','Single',1,0,1000),
 (2012000090,'BALAGTAS, Rolando de Villa',' Valencia, Neg. Or.','09086975447','Self-Employed/ Farmer','','1990-01-01','Married',1,0,1000),
 (2012000091,'BALASABAS, Clementino',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000092,'BALBUENA, Gloria',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000093,'BALBUENA, Marriane',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000094,'BALCOBERO, Ranilo',' Silliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000095,'BALDADO, Ron Anthony',' Lasola Drive Piapi, Dgte. City','09197008345','','','1983-01-16','Single',1,0,1000),
 (2012000096,'BALINAS, Ernel, ',' Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000097,'BANAGUDOS, Patricia',' Laguna, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000098,'BANAYBANAY, Rudy',' Bag- ong Dalan  Taclobo Dgte.City','','','','1990-01-01','',1,0,1000),
 (2012000099,'BANGALANDO, Ace','CBA Banilad, Dumaguete City','09062962918','Student','','1989-08-05','Single',1,0,1000),
 (2012000100,'BANGCAL, Mary',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000101,'BANLAT, Conchita',' Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000102,'BANLAT, Ellaquim B.',' Soludpan, Bacong, Neg. Or.','09095187843','','','1972-04-05','Married',0,0,1000),
 (2012000103,'BAÑO, Bartolome',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000104,'BANOGON, Aida',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000105,'BANSALAN, Dianita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000106,'BANTUG, Janette S.','Math Soludpan, Bacong, Neg. Or.','09068737691','Instructor','Tutorial','1984-06-15','Married',0,0,1000),
 (2012000107,'BAOL, Rhodora E.','SU Ext. D. Estolloso Res. Laguna Dist. Dgte.','422-8244 / 09215544615','Pre School Teacher','','1956-11-23','Married',0,0,1000),
 (2012000108,'BARBA, Germilina',' Purok 7 Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000109,'BARBAJO, Jaleson',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000110,'BARILIO, Zenaida',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000111,'BAROT, Thelma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000112,'BARTOLO, Prisella',' San Jose Ext., Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000113,'BARTOLO, Regina',' San Jose Ext., Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000114,'BASA, Gloria',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000115,'BASELERES, Rosario',' SIlliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000116,'BATIANCILA, Nidrea Kizza',' Jilocon, San Jose, Neg. Or.','09152064096','Student','','1990-07-04','Single',0,0,1000),
 (2012000117,'BAYLON, Lanie C. - ACIBRON',' SU Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000118,'BAYLON, Modesta',' upper Batingel,Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000119,'BAYLOSIS, Himaya A.',' Rovinil Village, South Bagacay, Dgte. City','422-1463 / 09174544461','Private Employee','','1971-02-03','Married',0,0,1000),
 (2012000120,'BAYNOSA, Ella Maer',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000121,'BEATINGO, Benny',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000122,'BEJARASCO, Marianita',' cadawinonan, Dgte City','','','','1990-01-01','',0,0,1000),
 (2012000123,'BENIGA, Kristill Joy',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000124,'BENJAN, Ilahan',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000125,'BENTRES, Keren Jae','AS-Social Work Azucena Cottage, Faurot Lane, S.U., Dgte. City','09382507415','Student','','1989-07-18','Single',0,0,1000),
 (2012000126,'BERNARDEZ, Melissa Tan',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000127,'BERNARDEZ, Teodora',' Manggatas, Sibulan Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000128,'BERNEJO, Celia',' Bantayan, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000129,'BICOY, Nathaniel',' Silliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000130,'BINAGATAN, Beverly Anne C.','AS  Phase II San Miguel Village Basak Mandaue City','09216132386','','',NULL,'Single',0,0,1000),
 (2012000131,'BOCADI, Rodolfo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000132,'BOHOL, Romel','SUES Tubod, Dgte. City','09279389507','Elem. Instructor','','1987-07-19','Single',1,0,1000),
 (2012000133,'BOLA-DOLA, Brenda',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000134,'BONGANCISO, Rochelle Lynn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000135,'BONIOR, Gina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000136,'BORILLA, Benita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000137,'BORROMEO, Frylim',' Polo, Tanjay Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000138,'BORROMEO, Luigino',' Tanjay, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000139,'BOSCHI, Govie lynn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000140,'BRIONES, Cris','CBA KM3 Batinguel, Dgte. City','09272480288','Student','','1984-12-23','Single',1,0,1000),
 (2012000141,'BRIONES, Eligio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000142,'BRIONES, Leonor M.',' 10 Wagner st., Ideal Subd. Fairview, Q.C.','09175359884','Professor/Chair BOT','','1940-12-16','',0,0,1000),
 (2012000143,'BUCOL, Florinda P.',' Oracion Looc, Dumaguete City','09187456567','Self-Employed','','1973-08-17','Married',0,0,1000),
 (2012000144,'BUCOL, Marito',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000145,'BUENO, Thelma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000146,'BULAGAO, Arlene Nemaria','DepEd Secondary Sacsac Bacong, Negros Oriental','09212294333','Teacher','','1961-03-01','Married',0,0,1000),
 (2012000147,'BULANDRES, Arlene',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000148,'BULANGIS, Lanie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000149,'BUMANLAG, Carmen',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000150,'BURGOS, Christopher',' Su Heights, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000151,'BUSCATO, Merlyn Guzman',' Su heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000152,'BUSS, Anatoly Karpov',' Silliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000153,'BUSTILLO, Theorose June',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000154,'CABALLERO, Amado',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000155,'CABALLO, Renelito C.','SUSBE-HS Pintor Apt. Upper Lukewright St. Dgte. City','09183208373','Teacher','','1973-07-18','Married',1,0,1000),
 (2012000156,'CABANAG, Cynthia',' Laguna, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000157,'CABANAG, Maria Elcon S.','COPA Bantayan, Dgte. City','09064406217','Teacher','','1985-11-12','',0,0,1000),
 (2012000158,'CABIJE, Tessie A.','Engineering 4847 Villaverde Subd. Buñao','','Faculty','','1964-10-11','Married',0,0,1000),
 (2012000159,'CABILDO, Natividad',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000160,'CABRERA, Elsara C.',' Balugo Habitat 2, Dgte. City','','Businesswoman','','1968-02-17','Married',0,0,1000),
 (2012000161,'CABRISTANTE, Vida T.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000162,'CACAS, Francen Anfone',' Dauin, Negros Oreintal','','','','1990-01-01','',1,0,1000),
 (2012000163,'CADALIN, Joveniano',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000164,'CADAPAN, Reymil',' Dumaguete City','','','','1990-01-01','',1,1154,1000),
 (2012000165,'CADELIÑA, Cornelia',' Silliman Campus','','','','1990-01-01','',0,0,1000),
 (2012000166,'CADIENTE, Ronie',' Banmill, Bais City','','','','1990-01-01','',1,0,1000),
 (2012000167,'CADIMAS, Jocelyn',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000168,'CAFÉ, Amado',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000169,'CAFÉ, May Ross',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000170,'CAGARA, Roche C.',' Batinguel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000171,'CAGUINDANGAN, Elman',' Sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000172,'CALINAWAGAN, Iris Gail',' Dumaguete City','',' ','','1990-01-01','',0,0,1000),
 (2012000173,'CALINGACION, Edna',' Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000174,'CALINGACION, Juliet B.',' Magatas Sibulan, Neg. Or.','09154055836','','','1972-12-20','Single',0,0,1000),
 (2012000175,'CALINGACION, Marlenda',' Manggatas, Sibulan Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000176,'CALLET, Cesar V.',' Poblacion, Bindoy, Neg. Or.','','Retired','','1945-07-03','Married',1,0,1000),
 (2012000177,'CALLET, Leonita E.',' Poblacion, Bindoy, Neg. Or.','09177000493','Retired','','1955-06-29','Married',0,0,1000),
 (2012000178,'CALOMADRE, Mizpah Grace',' San Jose Ext., Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000179,'CALUMPANG, Krishna Jane',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000180,'CALUMPANG, Ma. Paz',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000181,'CALUMPANG, Matilde',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000182,'CALUMPONG, Hilconida',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000183,'CALUSCUSAN, Norma',' Talay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000184,'CAMINO - Ebenezer, E.',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000185,'CAMPANALE, Coleta A.',' 93 San Jose st.,Dgte. City','09196947236','Lawyer','Real State','1940-03-06','Married',0,0,1000),
 (2012000186,'CAMPOY, Marnesa',' Canduay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000187,'CANABE, Mario',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000188,'CANOY, Susan',' Looc, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000189,'CANSECO, Flora',' Cadawinonan, Dgte City','','','','1990-01-01','',0,0,1000),
 (2012000190,'CAPAO, Ma. Gemriza',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000191,'CAPILLA, Jeanilyn Grace',' Upper Buñao, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000192,'CAPILLAN, Imelda A.',' Upper Buñao, Dumaguete City','09103746107','Promo-Merchandiser','','1973-08-31','Married',0,0,1000),
 (2012000193,'CAPITAN, Ma. Saloma',' Upper luke wright, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000194,'CAPULONG, Rebecca',' Laguna, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000195,'CARLOS, G.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000196,'CASERES, Florenda',' Mangnao, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000197,'CASTILLO, Agueda T.','CAS Brgy. Combodo, Bacong, Neg. O.r','09215013186','Teacher','','1956-02-27','Married',0,0,1000),
 (2012000198,'CASTRO, Ma. Rosario',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000199,'CATA-AL, Mary Nathalie M.','SUCN 1594 Magallanes St. Tanjay City','09157467595','Faculty','','1974-12-19','Single',0,0,1000),
 (2012000200,'CATADA, Daniel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000201,'CATADA, Florencia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000202,'CATADA, Marie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000203,'CATADA, Michael Fredric Jr.',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000204,'CATALAN, Rose /BG',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000205,'CATAN, Emujin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000206,'CATAPUSAN, Jurlina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000207,'CATARATA, Marne Kristina C.','SUCN 124 Dr. V. Locsin St. Dumaguete City','09177178026','Clinical Instructor','','1984-08-24','Single',0,0,1000),
 (2012000208,'CATCALIN, Melanie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000209,'CATCHO, Hermengido',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000210,'CATIPAY, Baltazar',' San Jose Ext., Dgte. City','','','','1990-01-01','',1,0,1000),
 (2012000211,'CATURAY, Warlito Jr. S.',' Duhat Cottage, Silliman Campus','09279128827','Faculty','','1979-04-30','Single',1,0,1000),
 (2012000212,'CAVARES, Bernadeth',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000213,'CEDROME, Leonora T.','Masscom South Bagacay, Dgte. City','09184766524','Secretary','','1957-07-01','Married',0,0,1000),
 (2012000214,'CELIZ, Gemelin',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000215,'CEPE, Rogielyn Marie P.','SBE-HS 001 Taft ST. Jawa, Valencia, Neg. Or.','09158545606','Office Staff','','1981-01-20','Single',0,0,1000),
 (2012000216,'CHAGAS, Chona',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000217,'CHAVEZ, Ferry',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000218,'CHIONG, Norma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000219,'CHIU, James Vincent',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000220,'CHIU, Jenny',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000221,'CHUA,  Karen P.','SUCN PAI Homes Laguna Silliman, Dgte. City','09163671382','Clinical Instructor','','1981-06-14','Single',0,0,1000),
 (2012000222,'CLEOPE, Earl Jude','College of Education Talay, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000223,'CONCEPCION, Mcdiery A.','SU HS Silliman Campus','09186575780','Teacher','','1975-11-19','Married',0,0,1000),
 (2012000224,'CONDICION, Pablo',' Looc By Pass, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000225,'CONEJOS, Michelle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000226,'CONTREVEROS, Irene',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000227,'CORDA, Alvin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000228,'CORDOVA, Darnalita',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000229,'CORNELIO, Josefina',' Looc, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000230,'CORNELIO, Josemar',' Looc, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000231,'CORRALES, Andro Paulo Drako','COPA Yakal St. Reyes Village, Bugo Cagcayan De Oro','09153287015','Student','','1991-07-30','Single',1,0,1000),
 (2012000232,'CORRO, Celia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000233,'CORSAME, Evelyn',' Bagacay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000234,'CORTEZ, Maria Constancia E.',' c/o Avenue Park Hotel, Perdices st. Dgte, City','422-9177','Call Center Agent','','1982-05-05','Married',0,0,1000),
 (2012000235,'CREDO, Jan Antoni A.','Polsci Dauin, Negros Oreintal','09159665516','Teacher','','1977-01-09','Single',1,0,1000),
 (2012000236,'CUELLO, Freshtille',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000237,'CUEVAS, Ma. Luisa A.',' Km.5 Junob, Dumaguete City, Neg. Or.','09268144303','Concessionaire-Food','OFW','1963-06-21','Married',0,0,1000),
 (2012000238,'CUIZON, Antonieta',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000239,'CULANCULAN, Ma. Cherryl',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000240,'CUSTODIO, Diosdado',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000241,'DADO, Jean Ramuya',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000242,'DADULA, Roy Mae',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000243,'DAEL, Jenny',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000244,'DALES, Dexter',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000245,'DALIGDIG, Angelica',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000246,'DATO, Lynlee',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000247,'DAUELL, Angelie Chiu',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000248,'DAVID, Floranida',' west Bantayan, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000249,'DAVIS, Lucelyn P.',' Villa Pastora','420-0366','Gov\'t Employee','','1965-12-07','Married',0,0,1000),
 (2012000250,'DAYANG, Ledia ',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000251,'DE JESUS, Leonil',' Su Heights, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000252,'DE LEON, Roy',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000253,'DE LOS SANTOS, Marina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000254,'DELA CALZADA, Lorna',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000255,'DELA CERNA, Emma S.',' NORECO Road Mangnao, Dgte. City','09173240220','Private Employee','','1963-11-15','Married',0,0,1000),
 (2012000256,'DELA CRUZ, Jocelyn',' Laguna, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000257,'DELA RAMA, Pablito',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000258,'DELA TORRE, Rebeca',' su Campus','','','','1990-01-01','',0,0,1000),
 (2012000259,'DELAS NIEVES, Brenda',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000260,'DELFIN, Ester',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000261,'DENOY, Lorna',' Cantil – e, Dumaguete city','','','','1990-01-01','',0,0,1000),
 (2012000262,'DENURA, Norberto',' Mangnao, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000263,'DIABO, Baivert M.',' 313 Kaimito St.,Kaimitoville, Valle Verde2, Pasig','09178800496','Businessman','','1971-08-05','Married',1,0,1000),
 (2012000264,'DIAMANTE, Marielle M.','CBA Dela Paz, Panaon, Misamis Occidental','09159966115','Student','','1993-02-14','Single',0,0,1000),
 (2012000265,'DIAO, Clementina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000266,'DIAZ, Christopher V.','Engineering Dumaguete City, Negros Oriental','09296687443','Faculty','','1948-04-28','Married',1,0,1000),
 (2012000267,'DIAZ, Isabelita',' Dauin, Negros Oreintal','','','','1990-01-01','',0,0,1000),
 (2012000268,'DIAZ, Leonor',' Dauin, Negros Oreintal','','','','1990-01-01','',0,0,1000),
 (2012000269,'DIENTE, Maricelle B.',' 351 V&6 Subd. Nangka Consolacion Cebu','032-4239492','Entrepreneur','','1990-01-01','Married',0,0,1000),
 (2012000270,'DIEZ, Michael',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000271,'DINGAL, Rae Ann L.','CBA Blk18 lot15 Villarosa Subd.,Maslog Sibulan','09274632180','Student','','1993-09-24','Single',0,0,1000),
 (2012000272,'DIOCOS, Elvisa Rositte',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000273,'DIPUTADO, June',' Su Heights, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000274,'DIPUTADO, Monina',' magatas Sibulan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000275,'DIPUTADO, Severanio',' Magatas Sibulan, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000276,'DIVINAGRACIA, Cristina',' Cadawinonan, Dgte City','','','','1990-01-01','',0,0,1000),
 (2012000277,'DIVINAGRACIA, Donnabelle',' Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000278,'DIVINAGRACIA, Joseph',' Sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000279,'DIVINAGRACIA, Ma. Fe',' Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000280,'DIVINO, Geronimo Antonio Jr.',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000281,'DIVINO, Simplicio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000282,'DOLOR, Cynthia S.',' Galas, Dipolog City','09177241916','Businesswoman','','1961-04-25','Married',0,0,1000),
 (2012000283,'DOLOR, Primo',' South Curvada Gallas, Dipolog City','09177241159','Businessman','','1966-11-09','Married',1,0,1000),
 (2012000284,'DOMALAON, Lelani',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000285,'DOMEN, Philip',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000286,'DOMINGO, Ernesto',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000287,'DOMINO, Leonardo Dave',' Bagacay, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000288,'DONGCOY, Edna C.',' Purok 7 Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000289,'DOQUILLA, Jobeth',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000290,'DUHAYLUNGSOD, Jennifer T.','Nursing Candanay Norte, Siquijor Siquijor','09161302734','Clinical Instructor','','1972-05-17','Married',0,0,1000),
 (2012000291,'DULNUAN, Mark Anthony',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000292,'DUMALAG, Dalisay',' San Jose Ext., Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000293,'DUMALAG, Tita',' San Jose Ext., Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000294,'DUMANGCAS, Edna',' Calderon subd. Bantayan Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000295,'DUNGO, Al',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000296,'DURAN, Annaliza',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000297,'DURAN, Divina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000298,'DURAN, Hermiesela',' Maayongtubig, Dauin Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000299,'DY, Grace',' Matu-og, Tayasan, Neg. Or.','0916879716','','','1954-04-04','Married',0,0,1000),
 (2012000300,'DY, Ivy',' Matu-og, Tayasan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000301,'DY, Shawn Mark',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000302,'EDJEC, Randolph',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000303,'EHARA, Tony',' Daro, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000304,'EISMA, Rose-lisa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000305,'ELIAS, Allan Roy',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000306,'ELIZAGA, Madonna',' South Bagacay, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000307,'ELMAN, Nichole',' Siaton, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000308,'ELNAR, Ruperto',' Zamboanguita, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000309,'ELTANAL, Annabelle',' Cantil -E, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000310,'ELUM, Elsie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000311,'ELVINIA, Alphonso',' Avenue Park Hotel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000312,'ELVINIA, Chiza L.',' M. Perdices St., Dumaguete City','422-9177','Businesswoman ','','1947-05-31','Married',0,0,1000),
 (2012000313,'ELVINIA, Ma. Constancia',' Avenue Park Hotel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000314,'EMELIA, Robert',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000315,'ENGCOY, Mirabelle',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000316,'ENOJARDO, Perla Maria',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000317,'ENOJO, Alphita',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000318,'ENUMERABELLON, Ma. Editha',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000319,'ERA, Jayant Jared',' 5-B blk.3 L10, Waling-waling St. Makati','09228442904','Businessman','Business','1983-10-21','Single',0,0,1000),
 (2012000320,'ESMERALDA, Grace',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000321,'ESPENAS, Ma. Rosa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000322,'ESTERAS, Rommel',' 852 L31 Ph.2 Southplains','09087988692','Gov\'t Employee','','1974-01-04','Married',1,0,1000),
 (2012000323,'ESTOCADO, Stephanie',' Looc, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000324,'ESTOCONING, Robert',' Duhat Cottage, Silliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000325,'ESTOMAGULANG, Elvie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000326,'ESTREBELLO, Darl Desiree','SUCN Purok Hayahay Babajuba Junob, Dgte. City','09063551295','Student Nurse','','1988-10-24','Single',0,0,1000),
 (2012000327,'ESTRELLA, Rene Vigil',' Batinguel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000328,'ESTURAS, Preciosa',' Bantayan, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000329,'EURAOBA, Carmila',' Pulan Tubig, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000330,'EURAOBA, Edilberto E.',' Sampiniton, Jimalalud, Negros Oriental','','Retired Gov\'t Employee','Farming','1945-02-07','Married',1,0,1000),
 (2012000331,'EVIDA, Gerardo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000332,'FABIO, Gabunaos Jr.',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000333,'FABRO, Lourdes ',' Daro, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000334,'FABURADA, An Lopez',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000335,'FABURADA, Jan Ivory',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000336,'FAMOSO, M.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000337,'FAMOSO, Wilma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000338,'FAROLAN, Mylane',' SU Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000339,'FEROLIN, Glady',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000340,'FEROLINO, Lydia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000341,'FEROLINO, Romana',' Dauin, Negros Oreintal','','','','1990-01-01','',0,0,1000),
 (2012000342,'FERRAREN, Ma. Alinda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000343,'FLAVIANO, Edna',' Valencia, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000344,'FLORENDO, Deborah',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000345,'FLORES, Belendro',' Bangculan Zamboanguita, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000346,'FLORES, Cherry Luna',' Banilad, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000347,'FLORES, Clarissa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000348,'FLORES, Karlo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000349,'FLORES, Lorna/Butch',' Bajumpandan, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000350,'FLORES, Portia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000351,'FLORES, Rommel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000352,'FONTELO, Belinda',' Cangmating, sibulan Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000353,'FONTELO, Cleonico',' Piapi, Dumagute City','','','','1990-01-01','',1,0,1000),
 (2012000354,'FONTELO, Loyda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000355,'FONTILLAS, Jalandoni',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000356,'FORTUITO, Jubie Franz',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000357,'FUTALAN, Gloria',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000358,'GABAS, Julius',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000359,'GABAS, Marvic',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000360,'GALO, Cheryl Lynn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000361,'GALON, Felicidad',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000362,'GALSING, Eralyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000363,'GALVEZ, Barbara Lyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000364,'GANTE, Arnold',' Batingel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000365,'GANTE, Giovanni',' Batinguel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000366,'GANTE, John','SU COOP Batingel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000367,'GANTE, Roy',' Batinguel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000368,'GAOT, Alexis',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000369,'GARATE, Jess Ian',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000370,'GARCIA, Anecito',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000371,'GARCIA, Carlito Jr.','SUCOOP/Physics Upper Talay, Dgte. City','09061911568','Student/Staff','','1990-08-11','Single',1,0,1000),
 (2012000372,'GARCIA, Elmedio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000373,'GARCIA, Ma. Jocelyn',' Banilad, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000374,'GARCIA, Mark',' Sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000375,'GARGANTIEL, Mercedes',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000376,'GARGAR, Genalyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000377,'GARGAS, Samuel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000378,'GATMAITAN, Noel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000379,'GATURIAN, Semper/Lumine',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000380,'GAUDIEL, Caren',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000381,'GAYADEM, Joy',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000382,'GAYO, Jose M.',' Brgy. 9 Tanjay City, Neg. Or.','','Manufacturer','','1990-01-01','',1,0,1000),
 (2012000383,'GENERAL, Rosita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000384,'GENEROSO, Joan','English B6 L6 Pacific Square, Maslog Sibulan, Neg. Or.','09174039547','Teacher','','1965-09-20','Married',0,0,1000),
 (2012000385,'GENEROSO, Jonathan (Teresita)','SU COOP Bunao, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000386,'GENOVE, Ma. Cecilia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000387,'GENTILIZO, Edwin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000388,'GEPTE, Paul Benedict',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000389,'GEROMO, Conan Louis',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000390,'GIGANTE, Jay C.','SUCN Adolfo Homes, San Isidro, Tanjay City','09179998248','Nurse','','1975-04-08','Married',1,0,1000),
 (2012000391,'GIGATARAS, Mercedes Leah W.','SUEP Oracion Subd., Dumaguete City','09197475794','Field Staff','','1977-04-24','Married',0,0,1000),
 (2012000392,'GIO, Anna Lynn',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000393,'GIRASOL, Glady','Early Childhood Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000394,'GLORIA, Grace',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000395,'GO, Jose Mari Ricci',' West Candau-ay, City Limit, Dumaguete City','09057250687','Businessman','','1985-11-06','Single',1,0,1000),
 (2012000396,'GODES,Merlita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000397,'GOLOSINO, Edwin','SUMCFI Lapu-lapu st. Bantayan, Dumaguete City','422-3617','Pastor','','1959-02-19','Widowed',1,0,1000),
 (2012000398,'GOLOSINO, Selah',' Lapu-lapu st. Bantayan, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000399,'GONZAGA, Aurora',' Upper Motong, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000400,'GONZAGA, Perfecto Jr. A.','Engineering Ilaya Tayasan Neg. Or.','09265284117','Student','','1991-12-19','Single',1,0,1000),
 (2012000401,'GONZALES, Jesusa Corazon',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000402,'GRAMPON, Nieves',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000403,'GRAPA, Angelina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000404,'GRAVADOR, Ronald',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000405,'GREGORIO, Cornelia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000406,'GUARTICO, Milagros',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000407,'GUMAHAD, Elmadan',' Cantil -E, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000408,'GUMANDOY, Esmeralda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000409,'GUMAYAN, Vincent C.',' Orchids Daro, Dgte. City','09352479639','Security Guard','','1990-01-01','Single',1,0,1000),
 (2012000410,'GUTIERREZ, Malone S.','SPAG PAL Subd.,Batinguel,Dgte. City','09173141980','Office Secretary','None','1980-04-14','Married',1,0,1000),
 (2012000411,'GUTIERREZ, Susieta',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000412,'HANDUMON, Noel',' Su Heights, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000413,'HEAD, Linda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000414,'HECHANOVA, Roly',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000415,'HILL, Rina Fernandez',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000416,'HIMOYA, Judame Charo',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000417,'HIPONIA, Apolinaria',' Northern Junob, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000418,'HIPONIA, Malcolm Casel','Socio Northern Junob, Dgte. City','09194802257','Student','','1970-09-16','Single',1,0,1000),
 (2012000419,'IBARE, Rey Anthony',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000420,'ICAMEN, Hilma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000421,'IGNACIO, Ruilo',' SU Campus','','','','1990-01-01','',1,0,1000),
 (2012000422,'ILEM, Marilo',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000423,'INDAB, Jojina',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000424,'INQUIG,Connie F.','Engineering Camanjac, Dgte. City','09154059983','Civil Eng\'g/Instructor','','1973-03-09','Married',0,0,1000),
 (2012000425,'JABEL, Amy Salom',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000426,'JACALAN, Annie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000427,'JACULBE, Remedios',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000428,'JALANDONI, Juan Agustin V.','CBA 181North Rd. Bantayan, Dgte. City','09209067530','Part-time Teacher','','1972-08-19','Single',1,0,1000),
 (2012000429,'JALANDO-ON, Roger',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000430,'JAMBORA, Marieta',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000431,'JANDOG, Kathleen Francis',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000432,'JARABE, Lilybelle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000433,'JASOL, Fe',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000434,'JAVIER, Alberto',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000435,'JAVIER, Chona','College of Agriculture Piapi, Dumagute City','','','','1990-01-01','',0,0,1000),
 (2012000436,'JAVIER, Gracia Perla',' Piapi, Dumagute City','','','','1990-01-01','',0,0,1000),
 (2012000437,'JAYME, Jenny',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000438,'JEREZA, Charisse Mae T.',' 1071 Magatas, Sibulan, Neg. Or.','09158586880','Website Developer','Freelancer','1983-10-08','Single',0,0,1000),
 (2012000439,'JEREZA, Charity',' Siaton, Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000440,'JUMALON, Earl Mark P.','Engineering 4674 Calapan Rd., Buñao Dgte. City','09217813903','Engineering Manager','','1979-05-16','Married',1,0,1000),
 (2012000441,'JUMUAD, Harold A.','CAS, Philo. Dept. Silliman Heights','422-1423','College Teacher','','1976-04-04','Single',1,0,1000),
 (2012000442,'JURLANO, Geneive',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000443,'KABRISTANTE, Francis Yap',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000444,'KADILI, Myrna Mary Ann',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000445,'KENNEDY, Bella',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000446,'KHO, Marilou',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000447,'KILAT, Kemmons','Math Dept. Sibulan , Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000448,'KINATAK-AN, Ma. Donata Ameliz M.','Elementary Maslog Sibulan, Neg. Or.','09159047487','Teacher','','1990-01-01','Widow',0,0,1000),
 (2012000449,'KINILITAN, Belen','College of Law Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000450,'KITANE, Gemma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000451,'KONG, Serena',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000452,'La Parilla',' Bacong Neg. O.r','','','','1990-01-01','',0,0,1000),
 (2012000453,'LABRADOR, Norma',' Valencia, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000454,'LACHICA, Loren Ann','CBA San Jose Ext., Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000455,'LACHICA, Orencio D.',' San Jose Ext., Dgte. City','09275796585','Retiree','Pension','1942-08-26','Married',1,0,1000),
 (2012000456,'LACSIAN, Jude Cris',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000457,'LADAGA, Lemuel Cedric',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000458,'LADO, Josefa','SU COOP Cantil -E, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000459,'LADO, Mary Ann',' Cantil -E, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000460,'LADO, Pepito',' Cantil-e, Dgte. City','','','','1990-01-01','',1,0,1000),
 (2012000461,'LAGAHIT, Floranie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000462,'LAGARDE, Arrien C.','SUCN 927A Magatas Sibulan, Neg. Or.','419-9328 / 09183732549','Faculty','','1976-12-10','Single',0,0,1000),
 (2012000463,'LAGARDE, Eduardo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000464,'LAGOS, Peter Chuck',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000465,'LAGRIMAS, Sherro Lee A.','English 165 Hibbard Avenue','09173043399','Teacher','','1973-09-08','Married',0,0,1000),
 (2012000466,'LAGRITO, Leonila',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000467,'LAMOSTE, Gina Mae',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000468,'LAO, Nenita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000469,'LAPASTORA, Joerick',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000470,'LARANJO, Juliet',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000471,'LARENA, Cecelia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000472,'LARO, Elsie C.',' Purok 7 Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000473,'LASTIMADO, Grace S.','SU COOP Camanjac, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000474,'LAURE, Rosale',' Blk 5 lot 9 Cadawinonan, Dumaguete city','','','','1990-01-01','',0,0,1000),
 (2012000475,'LAURETO, Heide Jill Vanessa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000476,'LAW, Rosita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000477,'LAZOLA, Welfredo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000478,'LEBRILLA, Anastacio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000479,'LEDESMA, Mathew Jonathan',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000480,'LEZAMA, Stella','CBA Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000481,'LIBBY, Jaime',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000482,'LIBOON, Elery Vaugh',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000483,'LIGUTOM, E.','Social Works Dept. SU Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000484,'LIM, Feranick Dionaldo','High School Garcia Compound, Motong, Dumaguete City','09158072461','Staff','','1953-04-04','Single',1,0,1000),
 (2012000485,'LIM, Frederick',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000486,'LIM, Freslyn S.','SUCN SU Campus, Dgte. City','422-7053','Clinical Instructor','','1983-06-01','Single',0,0,1000),
 (2012000487,'LIM, Grace',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000488,'LIM, Lanie',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000489,'LIM, Mariam',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000490,'LIMBAGA, Jake M.',' Dumaguete City','09177233007','','','1978-08-18','Single',1,0,1000),
 (2012000491,'LINDSTORM, (Repollo) Eva Rose',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000492,'LINGCONG, Renante','CAS Talay, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000493,'LIRAZAN, Asteria',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000494,'LITORJA, Rouine Kay P.','SUCN 68 Luzuriaga St. Valencia, Neg. Or.','09173140508','Clinical Instructor','','1980-05-08','Married',0,0,1000),
 (2012000495,'LLEGO, Fanny Hayde',' Junob, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000496,'LLEGO, Jonathan','Early Childhood Junob, Dgte. City','','','','1990-01-01','',1,0,1000),
 (2012000497,'LLORENTE, Marjourie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000498,'LOBIANO, Bebelyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000499,'LOGRONIO, Jane','CBA Calindagan,Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000500,'LOPEZ, Arsenia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000501,'LOPEZ, Rosalia M.','CAS 21Mt. Talinis Cottage, Silliman Campus, SU','09064955262','Teacher','','1947-04-25','Married',0,0,1000),
 (2012000502,'LORENTE, Edmund',' Talay, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000503,'LORICO, Jennilene',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000504,'LOZANO, Palma Jane L.',' Tubod, Dgte. City','422-4215','Dentist','','1965-12-01','Married',0,0,1000),
 (2012000505,'LUBCUBAN, Pablita',' SU Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000506,'LUCERO, Briar Lei',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000507,'LUCHAVEZ, Julieta',' Su Farm, Bantayan Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000508,'LUGATIMAN, Cindy M.','CBA Villa Pastora, Batinguel, Dgte. City','225-7456 / 09068293454','Student','','1990-12-25','Single',0,0,1000),
 (2012000509,'LUMAYAG, Lorene','Education 2805B Maslog Sibulan, Neg. Or.','419-9829','Teacher','','1965-10-13','Married',0,0,1000),
 (2012000510,'LUMOGOD, Debbie',' Canday-ong , Dumaguete city','','','','1990-01-01','',0,0,1000),
 (2012000511,'LUNA, Evelyn ',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000512,'LUZADA, Belen',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000513,'MA, Eunice',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000514,'MACALOLOT, Bob James',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000515,'MACALUA, Christy Ann O.','SUCN Brgy. Piapi, Dumaguete City','09262832308','Clinical Instructor','','1982-03-16','Single',0,0,1000),
 (2012000516,'MACIAS, Emilio II (Gov.)',' Siaton, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000517,'MAGALLANES, Russell A.','CBA Nagbagang, Sta. Catalina, Neg. Or.','09062405811','Student','','1991-10-29','single',0,0,1000),
 (2012000518,'MAGASO, Emma',' Fatima Village, Bantayan Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000519,'MAGTOLIS, Karl Mikhail',' Dumaguete City, Negros Oriental','09068896339','Gov\'t Employee','','1987-01-04','Single',1,0,1000),
 (2012000520,'MAGTOLIS, Nona','College of Education Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000521,'MAHILUM, Marion',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000522,'MALIJAN, Niza A.','CAS  Camanjac, Dgte. City','09267738587','Staff','','1964-03-06','Married',0,0,1000),
 (2012000523,'MALONSO, Mariquit',' lower Camanjac, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000524,'MAMHOT, Millard (Alice)',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000525,'MANANGAS, Jay',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000526,'MANANQUIL, Anecita',' Bagacay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000527,'MANANQUIL, Jamie A.','CBA Motong, Dumaguete City','09154370552','Student','','1992-08-11','Single',1,0,1000),
 (2012000528,'MANGAO, Lanie Fe',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000529,'MANGIBIN, Ferdinand M.','Philosophy Duhat Cottage, Silliman Campus','09204288554','Teacher','','1975-02-27','Single',1,0,1000),
 (2012000530,'MANGINSAY, Glynis Wilfa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000531,'MANGORNONG, Pearly Mae',' Brgy. Tinago, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000532,'MANSING, Luis',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000533,'MAPUTI, Dawnie Ray',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000534,'MAPUTI, Mardy Grace',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000535,'MARCIAL, John Marlou',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000536,'MARCIAL, Junny',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000537,'MARCOS, Isagani',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000538,'MARIMAT, Maria',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000539,'MARIÑO, Isabel',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000540,'MARTINEZ, Acher Paldwin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000541,'MARTINEZ, Betty Jane','CBA San  Jose St. Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000542,'MARTINEZ, Prestine',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000543,'MASCARDO, Allen Ryean I.','NORSU Purok Fatima, Buñao, Dumaguete City','09264548648','Student','','1987-01-18','Single',1,0,1000),
 (2012000544,'MASCARDO, Anelita',' Purok Fatima, Buñao, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000545,'MASCARDO, Best Mark','SU COOP Purok Fatima, Buñao, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000546,'MASCARDO, Job Marconi J.','SUCN 043 General Luna St. Dipolog City','09174101585','Student','Allowance','1990-01-01','Single',1,0,1000),
 (2012000547,'MAXINO, Micheal','College of Law Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000548,'MENDEZ, Teresita',' Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000549,'MENDOZA, Ancella Marie L.','CBA Purok Tamsi, Brgy. Pulantubig, Dgte. City','0917314136','Student','','1990-01-01','Single',0,0,1000),
 (2012000550,'MINDAC, Mirabel',' Purok 7 Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000551,'MINGUITA, Alex C.','SUEP Bogo, Dumaguete City','422-7207','Messenger/Driver','House Rental','1971-07-01','Married',1,0,1000),
 (2012000552,'MIRA, Danilo',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000553,'MIRA, Dinnes',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000554,'MIRA, Sandra',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000555,'MIRABUENA, Ronnie B.','COPA Gubat Ilawod, Bagacay, Albay','09287434017','Instructor','','1976-11-24','Single',1,0,1000),
 (2012000556,'MIRAFUENTES, Esperanza',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000557,'MISSION - DINOY, Anna Lisa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000558,'MISSION, Jose Leo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000559,'MONDARTE, Lilian',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000560,'MONGCOPA, Emma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000561,'MONOPOLLO, Generoso','SU STAFF Batinguel, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000562,'MONROY, Venus F.','SUCN B3 L9, Silliman Heights Subd. Dgte. City','09279895978','Clinical Instructor','','1976-09-19','Married',0,0,1000),
 (2012000563,'MONTAÑEZ, Eunice',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000564,'MONTEBON, Marietta',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000565,'MONTEBON, Roberto',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000566,'MONTEBON, Roidil',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000567,'MONTENEGRO, Chuchi',' Mangnao, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000568,'MONTENEGRO, Cresinta',' Mangnao, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000569,'MONTENEGRO, Lemuel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000570,'MONTENEGRO, Muriel',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000571,'MONTENEGRO, Ryan','CBA Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000572,'MORALES, Mae Lyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000573,'MORALES, Marlene',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000574,'MORALES,Bernadette A.','SU Church  Su Parsonage /Dumaguete City','09173140207','Minister','None','1970-07-11','Married',0,0,1000),
 (2012000575,'MORENO, Davita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000576,'MORENO, Gillermo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000577,'MORENTE, Elizabeth Banlat',' Combado, Bacong Negros Orinetal','','','','1990-01-01','',0,0,1000),
 (2012000578,'MORENTE, Gylin','Agriculture Combado Bacong Neg. Or.','09108463765','Agriculturist','','1980-01-18','Single',0,0,1000),
 (2012000579,'MORRIS, Nelcy E.','Agriculture Villa Mariano Subd. Locsin St. Taclobo Dgte. City','422-3568','','','1973-02-20','Married',0,0,1000),
 (2012000580,'MORRO, Rosalina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000581,'MORTE, ANGELO',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000582,'NACUA, Chonita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000583,'NAKAO, Ma. Emelyn Redillas','SPAG upper Bagacay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000584,'NALAM, Jean Cunanan',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000585,'NAPIGKIT, Michelle',' Sta. Catalina, Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000586,'NAQUILLA, Paulette G.','SUCN Polanco, 2 Dn','09107063812','Registered Nurse','Farming','1962-02-27','Married',0,0,1000),
 (2012000587,'NARANJO, Michelle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000588,'NASATAYA, Raychil Dizon',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000589,'NEMARIA, Editha',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000590,'NGOHO, Gilda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000591,'NICHOLA, Kwin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000592,'NOBLE, Vienna Nicolasa','Nursing Dumaguete City, Negros Oriental','421-1192','Faculty','Husband\'s Salary','1965-09-10','Married',0,0,1000),
 (2012000593,'NUEVO, Emalyn',' Blk 21 lot 19 Cadawinonan, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000594,'NUICO, Venancia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000595,'OBANANA, Nenita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000596,'OCAMPOS, Kurt Vileo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000597,'OCAMPOS, Luther Vileo T.',' 1992 Coliseum Rd. Lam-an Osamis City','','Student','','1988-11-14','Single',1,0,1000),
 (2012000598,'OCANG, Joey Henry',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000599,'OCON, Waren V.','COPA B8 L6 Sibulan Country Homes, Maslog Sibulan','09064963406','Student','','1979-11-22','Single',1,0,1000),
 (2012000600,'OGABANG, Phil Anthony',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000601,'OGUIS, Gina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000602,'OLIVA, Lourdes L.','SUCN B17 L9 Judyville Subd. Bolocboloc, Sibulan, Neg. Or.','09177191011','Clinical Instructor','Honorarium','1951-10-11','Married',0,0,1000),
 (2012000603,'OLLADAS, Laurent',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000604,'OMAGUING, Norvic',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000605,'OMANIA, Jomel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000606,'OMICTIN, Delia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000607,'OMICTIN, Ed',' Siquijor – Siquijor','','','','1990-01-01','',1,0,1000),
 (2012000608,'OMNOS, Narcisa',' Blk 7 lot 23 Cadawinonan, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000609,'OMPOY, Dexter',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000610,'ONG, Raquel Lisa S.',' 523 M.F. Perdices St., Dgte. City','225-4315','Self-Employed','Sales Agent','1961-03-18','Married',0,0,1000),
 (2012000611,'ONTAL, Felipe',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000612,'OPEÑA, Mario L.',' Katada St., Dumaguete City','09268253795','Businessman','Peanut','1959-10-24','Married',1,0,1000),
 (2012000613,'OPOC, Joel','SUCOOP Purok Madasigon, Calindagan, Dgte. City','09161989192','Asst. Cook','','1972-05-04','Single',1,0,1000),
 (2012000614,'OPSIMAS, Dorothy',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000615,'ORACION, Enrique',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000616,'ORIZONTE, Agosto',' Balugo , Dgte. City','','','','1990-01-01','',1,0,1000),
 (2012000617,'ORIZONTE, Mary Ann',' Balugo , Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000618,'ORTALIZ, Inocencia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000619,'ORTANEZ, Jericho',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000620,'PAA, Annabelle','Registrar Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000621,'PAALAN, Rene',' Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000622,'PABALATE, Donaliza',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000623,'PACATANG, Ivan T.','Nursing L. Rovira Rd. Bantayan, Dumaguete City','09063445670','Clinical Instructor','','1983-01-22','Single',1,0,1000),
 (2012000624,'PACGUINGAN, T.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000625,'PACULANANG, Arlyn T.',' Tubtubon Sibulan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000626,'PADERNAL, Juliet',' pob.Sibulan, Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000627,'PADIERA, Karl','MedTech Dept Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000628,'PAESTE, Lolita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000629,'PAMARAN, Nerissa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000630,'PANAGUITAN, Emma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000631,'PANES, Jose Marie',' Bag-ong dalan, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000632,'PAREJA, Anna Priscila M.',' Poblacion, San Jose, Negros Oriental','09232030584','Lawyer','','1968-12-28','Single',0,0,1000),
 (2012000633,'PARILLA, Marlene Jane','SU Elem Bacong Neg. O.r','09156507139','Student','','1998-01-24','Single',0,0,1000),
 (2012000634,'PARTOSA, Burtland','Registrar Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000635,'PARTOSA, Fe',' Valencia, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000636,'PARTOSA, Robert James',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000637,'PASTORFIDE, Pio N.',' Cimafranca Subd.,Bantayan, Dgte. City','422-1668','Insurance Underwriter ','CocoLife,AFM Alliance','1929-11-08','Married',1,0,1000),
 (2012000638,'PATEÑO, Germilyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000639,'PATINA, Edna',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000640,'PATROCINIO, Myralona',' Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000641,'PATRON, Michael Jr. A.','Registrar Duhat Cottage, Silliman Campus','09159954198','Dept. Secretary','','1975-08-19','Single',1,0,1000),
 (2012000642,'PATRON, Myla June Tumbokon','English SU Campus, Dgte. City','09062332521','Teacher','','1980-06-28','Single',0,0,1000);
INSERT INTO `db_pos_restaurant`.`customers` VALUES  (2012000643,'PATRON, Nora',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000644,'PERATER, Norlita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000645,'PEREGRINO, Helen',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000646,'PILANGA, Sheena Erica',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000647,'PIÑERO, Dionesio II V.','P.E. Boloc-boloc, Sibulan, Neg. Or.','09158262617','Teacher','','1974-01-27','Married',1,0,1000),
 (2012000648,'PIÑERO, Jocelyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000649,'PIÑERO, Lilibeth',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000650,'PIÑERO, Lito',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000651,'PIÑERO, Roderick',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000652,'PIÑERO, Ruben',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000653,'PIÑERO, Russel Nida',' SU Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000654,'PINO, Evelyn M.',' Bunao, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000655,'PINSOY, Jasmin',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000656,'PINTOR, Jovencia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000657,'PIO, Pastorfide  JR',' Cimafranca Subd.,Bantayan, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000658,'PIOQUINTO, Cedrick',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000659,'PLACENCIA, Lanie','Social Works Dept. Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000660,'PLASABAS, Gemma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000661,'POCOLAN, Robert',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000662,'PON, Cora C.',' Junob, Dgte. City','09275336272','R.N. Self Employed','','1965-03-15','Single',0,0,1000),
 (2012000663,'PONCE, Dioscoro',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000664,'POVADORA, Helen',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000665,'PRANOM, Edmer',' Tubtubon, Sibulan, Neg. Or.','225-9322','Barber','','1974-02-15','',1,0,1000),
 (2012000666,'PURACAN, Anecita',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000667,'PURACAN, Hernando',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000668,'PURACAN, Praxides',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000669,'PUTONG, Cyflor',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000670,'QUE, Estrellita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000671,'QUICOY, Emerson',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000672,'QUIJANO, Ma. Theresa A.',' 2120 Boloc-boloc, Sibulan, Neg. Or.','09177040224','','','1969-01-01','Married',0,0,1000),
 (2012000673,'QUILLANO, Herman',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000674,'QUIMBAO, Ivy Marie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000675,'QUINAMOT, Rene',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000676,'QUINIONES, Arfel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000677,'QUISEL, Jovelyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000678,'QUISUMBING, Maricar',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000679,'QUITAY, Freddie','SUCOOP Siaton, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000680,'QUITAY, Josephine',' Sandulot Siaton, Negros Oriental','','Asst. Cook','','1986-04-15','Single',0,0,1000),
 (2012000681,'RAAKIN, Gina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000682,'RABACA, Virginia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000683,'RAGA, Ceilo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000684,'RAGAY, Emelia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000685,'RAMACHO, Meriam P.M.','P.E. 079 Lower Batinguel','422-6369','Teacher','','1960-04-12','Married',0,0,1000),
 (2012000686,'RAMIREZ, Dondon',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000687,'RAMIREZ, Irene',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000688,'RAMOS, Aurelio Jr. P.',' Manila, Quezon City','','','','1990-01-01','',1,0,1000),
 (2012000689,'RAMOS, Purita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000690,'RANIS, Bertch Ian',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000691,'RATERTA, Pacita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000692,'RAVELLO, Jose',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000693,'REALIZA, Ma. Rosario ',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000694,'REAMBONANZA, Teresita',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000695,'REDILLAS, Jose Belen Q.',' Sibutad Zamboanga del Norte','09175772510','Lawyer','','1971-06-10','Married',1,0,1000),
 (2012000696,'REMOTO, Dina',' Daro , Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000697,'RENDOQUE, Shiela',' Balugo , Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000698,'REQUILNAN, Oliver',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000699,'REU, Ismil',' Bajumpandan, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000700,'RIDAD, Charles',' San Antonio, Sibulan Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000701,'RITO, Barbara',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000702,'RIVERA, Albert',' Bajumpandan, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000703,'RIVERA, Melody',' Bajumpandan, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000704,'RIVERA, Narcisa B.',' Purok 6 Batinguel Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000705,'ROA, Flordelis',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000706,'ROBIN, Lope',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000707,'RODRIGUEZ, Joel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000708,'RODRIGUEZ, Johanna',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000709,'RODRIGUEZ, Sofio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000710,'ROLEDA, Concesa',' Batinguel, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000711,'ROSARIO, Vicky Claudine C.','Early Childhood Jilocon, San Jose, Neg. Or.','09204435236','Teacher','','1968-09-30','Married',0,0,1000),
 (2012000712,'RUBIO, Alfredo','SU COOP Looc By Pass, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000713,'RUBIO, Danilo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000714,'RUBIO, Manuel Jr.',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000715,'RUBIO, Romulo',' Looc, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000716,'RUIZ, Ruth',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000717,'RUPERTO, Niña Rica de Asis',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000718,'RUSIANA, Josefina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000719,'RUSIANA, Violeta',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000720,'SABANAL, Delvitha',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000721,'SABANAL, Geminiano',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000722,'SABANAL, Gilbert',' Su Heights, Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000723,'SABANAL, Jelord',' Jimalalod, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000724,'SADANG, Melvie Lorensela',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000725,'SAGARIO, Emilie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000726,'SAGARIO, Nimfa',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000727,'SALADO, Cayetana B.',' Bongbong Valencia, Neg. Or.','','','','1990-01-01','Married',0,0,1000),
 (2012000728,'SALCEDO, Maria Luz',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000729,'SALDIVAR, Manolito',' SU Campus','','','','1990-01-01','',1,0,1000),
 (2012000730,'SALEM, Deborah',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000731,'SALER, Rufina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000732,'SALETRERO, Joan',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000733,'SALON, Eugene D.',' Bacong, Neg. Or.','09065546454','Lawyer','Teacher','1958-10-10','Married',1,0,1000),
 (2012000734,'SALUDAR, Milburga',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000735,'SAMSON, Alma Leonore',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000736,'SANDIGAN, Teodoro',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000737,'SANTANDER, Ruth',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000738,'SANTISTEBAN, Ana T.','Library System 2261 Purok Rosal, Calindagan, Dumaguete City','422-2164','Librarian','','1976-05-25','Single',0,0,1000),
 (2012000739,'SANTOS, Brian Lois',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000740,'SARABIA, Rodyrick',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000741,'SARABILLO, Michelle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000742,'SARGENTO, Ursula',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000743,'SARITA, Evelyn',' Colon Ext. Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000744,'SARITA, Zosimo',' colon Ext. Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000745,'SAYSON, Rosenda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000746,'SCRIBNER, Gilda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000747,'SEBIAL, Sheryl',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000748,'SEDILLIO, Allan',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000749,'SELIBIO, Jessa',' Talay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000750,'SEÑARA, Ma. Chona',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000751,'SERATE, Deborah',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000752,'SIA, Sidney G.',' Espina St. Taclobo, Dumaguete City','422-4003','Substation Engineer','Piggery','1965-08-25','Married',0,0,1000),
 (2012000753,'SIENES, Aida',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000754,'SIENES, Archife',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000755,'SIENES, Flora Fe',' San  Jose St. Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000756,'SIENES, Florie M.',' B2 L24, Scion Banilad Bacong, Neg. Or.','09212574414','Housewife','Baking pastries','1964-01-31','Married',0,0,1000),
 (2012000757,'SIENES, Perfecto',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000758,'SIENES, Romeo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000759,'SIENES, Sarah Rose C.','SUCN Upper Buñao, Dumaguete City','422-6593 / 09272255463','Clinical Instructor','','1983-10-13','Married',0,0,1000),
 (2012000760,'SIGLOS, Salvador',' Su Power House, Silliman Dgte. City','','','','1990-01-01','',1,0,1000),
 (2012000761,'SILLERO,  Flor',' SU Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000762,'SILORIO, Luciano O.',' San Roque, San Jose, Neg. Or.','09205306149','Security Guard','','1990-01-01','Married',1,0,1000),
 (2012000763,'SILORIO, Vienna',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000764,'SILUD, Mars Ian',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000765,'SILVA, Bonita',' Tanjay, Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000766,'SILVOSA, Jakim',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000767,'SIMILATAN, Niesadel C.','CBA 07340 Purok1B, blk5,Brgy. San Juan, Surigao City ','09359880952','Student','','1993-03-08','Single',0,0,1000),
 (2012000768,'SING, Rose Marie',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000769,'SMC-ABS-CBN c/o Mr. Estoconing',' ','','','','1990-01-01','',1,0,1000),
 (2012000770,'SOJOR, Ellen May',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000771,'SOJOR, Fortunata',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000772,'SOLATORIO, Carol',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000773,'SOLATORIO, Vic Angelo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000774,'SOLINAS, Grace',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000775,'SOLITARIO, Joseph',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000776,'SOLUTA, Andrea',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000777,'SOLVARIA, Welfredo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000778,'SOMOZA, Gerseca',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000779,'SOMOZA, Iraida C.','SUCCI B5 L3 Silliman Heights Subd. Junob Dgte. City','09218013555','Private Employee','','1979-09-22','Married',0,0,1000),
 (2012000780,'SOROTE, Maria Leodel',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000781,'SORRONDA, Elizabeth',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000782,'SUAREZ, Analiza D.',' Tubtubon Sibulan, Neg. Or.','09275479501','Businesswoman','','1972-12-29','Single',0,0,1000),
 (2012000783,'SUAREZ, Susan',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000784,'SUASIN, Aldwin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000785,'SUASIN, Jonathan',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000786,'SUDARIA, Vic Logos',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000787,'SUELTO, Maryflor',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000788,'SUFA ACCOUNT c/o Vic Aguilan',' ','','','','1990-01-01','',1,0,1000),
 (2012000789,'SUMACOT, Marietta V.',' 23 Rovira East Drive, Bantayan, Dgte. City','09205214740','','','2009-09-10','Single',0,0,1000),
 (2012000790,'SUN, Rufino',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000791,'SUNGA, Nila',' Bantayan, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000792,'SUPIL, Katherine',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000793,'SUSA ACCOUNT c/o Aracelli Tan',' ','','','','1990-01-01','',0,0,1000),
 (2012000794,'SY, Imelda',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000795,'SY, Peter',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000796,'TABADA, Callum',' SU Campus','','','','1990-01-01','',1,0,1000),
 (2012000797,'TABADA, Joel',' SU Campus','','','','1990-01-01','',1,0,1000),
 (2012000798,'TABOR, Leizel C.',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000799,'TABURAZA, Lourdez',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000800,'TAGANAS, Haniel Jose',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000801,'TAMAYO, Eleanor',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000802,'TAN, Araceli C.','Chemistry Claytown Daro, Dgte. City','','Staff - SU','Real Properties','1949-10-09','Widowed',0,0,1000),
 (2012000803,'TAN, Armando','Philosophy Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000804,'TAN, Carmensita','Bus&Fin. Sibulan , Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000805,'TAN, Shiela',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000806,'TANTENGCO, Gemma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000807,'TAPANG, Arnold R.',' Purok Santol South Bagacay, Dumaguete City','09109318443','Gov\'t Employee','Buy And Sell Business','1977-10-05','Single',1,0,1000),
 (2012000808,'TAPANG, Jonathan',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000809,'TAPANGAN, Relleta',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000810,'TAPIA, Michael Angelo',' Greenville Subd. Camanjac, Dgte. City','09208913335','Gov\'t Employee','','1971-06-17','Married',1,0,1000),
 (2012000811,'TAYKO, Nenita',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000812,'TAYROS, Elias',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000813,'TAYROS, Fern Ann',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000814,'TE, Jonathan Mark',' Su Campus','','','','1990-01-01','',1,0,1000),
 (2012000815,'TEJERO, Wilma',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000816,'TEMBLOR, Dionaflor',' SU Campus','','','','1990-01-01','',0,0,1000),
 (2012000817,'TEO, James',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000818,'TEVES, Bron Joseph',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000819,'TEVES, Martin Jr.',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000820,'TEVES, Rodney',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000821,'TEVES, Vito P.','NORSU-CAS Bais, City','','Teacher','Business','1961-06-15','Single',1,0,1000),
 (2012000822,'TIBIO, Flora',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000823,'TIEMPO, Leonila',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000824,'TILOS, Romulo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000825,'TIMTIM, Vivian',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000826,'TINAGAN, Tabitha',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000827,'TIOGO, Peter B.','Century Colon Ext. Dumaguete City','09066774877','Security Guard','','1972-07-04','Married',1,0,1000),
 (2012000828,'TIONGSON, Carlos Manuel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000829,'TOBIAS, Benjamin C.','Engineering Lower-Camanjac, Dgte. City','09286275025','Professo-Engineering','Self Made','1946-07-27','Divorced',1,0,1000),
 (2012000830,'TOLENTINO, Ronald ',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000831,'TONELETE, Ian C.','SUMCFI Tampocon I, Ayungon, Neg. Or.','09158723159','Registered Nurse','','1982-05-25','Single',1,0,1000),
 (2012000832,'TORREMOCHA, Estrelita',' Laguna, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000833,'TORRES, Aida',' Su Heights, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000834,'TORTOLA, Lesly Kris',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000835,'TRAGECO, Virginia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000836,'TRAGICO, Eldwin',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000837,'TUATES, Renato A.',' Piapi, Dumagute City','225-0299 / 09189113280','Businessman','','1954-03-08','Married',1,0,1000),
 (2012000838,'TUBIL, Sonia','SU COOP zamboanguita, Negros Oriental','','','','1990-01-01','',0,0,1000),
 (2012000839,'TUBIO, Jocelyn',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000840,'TUPAZ, Edgardo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000841,'TURTAL, Rowena',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000842,'UDARBE, Proceso',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000843,'UMBAC, Rowel',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000844,'URIARTE, Letecia',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000845,'URSOS, Ma. Lourdes',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000846,'UTZURRUM, Blanchie',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000847,'UTZURRUM, Corazaon Addily',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000848,'UTZURRUM, Lorseli',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',0,0,1000),
 (2012000849,'UTZURRUM, Ma. Milagrosa T.',' SU Campus','09163105488','','',NULL,'Married',0,0,1000),
 (2012000850,'UTZURRUM, Manuel III',' Boloc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000851,'UTZURRUM, Manuel Jr.',' BOLoc-boloc, Sibulan, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000852,'UYPITCHING, Ramas Antonio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000853,'VALENCIA, Geraldine',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000854,'VALENCIA, Virgilio',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000855,'VELANO, Concepcion L.','Chem/AS 1022 Tubtubon, Sibulan, Neg. Or.','419-8701','Teacher','','1961-04-08','Married',0,0,1000),
 (2012000856,'VELONTA, Elcazar',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000857,'VIDAD, Crispulo',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000858,'VIDAL, Ida Olga R.','SUCN 3713 Looc Sibulan, Neg. Or.','09066061220','Clinical Instructor','Piggery','1970-09-01','Married',0,0,1000),
 (2012000859,'VILBAR, Merlin',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000860,'VILLA, Gemmalyn T.','Registrar Liptong, Valencia, Neg. Or.','422-8880','Record Coordinator 1','','1984-10-31','Single',0,0,1000),
 (2012000861,'VILLACAMPA, Nestle C.','Ace Logic Bonawon, Siaton, Neg. Or.','09265877997','Computer Technician','','1984-03-27','Single',1,0,1000),
 (2012000862,'VILLAGONZALO, Carmen',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000863,'VILLAGONZALO, Leo','Math Dept. Bacong Neg. O.r','','','','1990-01-01','',1,0,1000),
 (2012000864,'VILLAHERMOSA, Catalino',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000865,'VILLAHERMOSA, Teodorica',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000866,'VILLALBA, Keziah Luren',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000867,'VILLALON, Jessa P.','High School Cantil-e, Dgte. Cityq','09065286031','Teacher','','1987-09-07','Single',0,0,1000),
 (2012000868,'VILLALON, Joanne',' Bagacay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000869,'VILLALUZ, Johnny',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000870,'VILLAMEA, Scarleta',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000871,'VILLAMIL, Myrna',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000872,'VILLANUEVA, Judith Mae',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000873,'VILLARIN, Cheriebelle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000874,'VILLARIN, Karma Dell',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000875,'VILLARIN, Ramon',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000876,'VILLARIN, Silanis',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000877,'VILLARIZA, Dolly',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000878,'VILLARIZA, Sur Bella',' Bagacay, Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000879,'VILLAS, Heditha',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000880,'VILLEGAS, Andrew Y.',' Lower Talay, Dgte. City','09196179084','Minister','','1957-11-30','Married',1,0,1000),
 (2012000881,'VILUAN, Genalyn B.','CBA Unit26 North Town Homes, Talamban Cebu City','09173256563','Student','','2006-02-25','Single',0,0,1000),
 (2012000882,'VINCOY, Antonio/Emily',' Valencia, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000883,'VINCOY, Earl Ryan Kenneth',' Valencia, Neg. Or.','','','','1990-01-01','',1,0,1000),
 (2012000884,'VISTA, Salvador',' SIlliman Campus','','','','1990-01-01','',1,0,1000),
 (2012000885,'WADDINGTON, Myrna Luz',' Su Campus','','','','1990-01-01','',0,0,1000),
 (2012000886,'WALE, Pacita',' Banilad, Dgte. City','','','','1990-01-01','',0,0,1000),
 (2012000887,'WOLFF, Avelina',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000888,'YANEZ, Rosario',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000889,'YAP, Lalaine Briones',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000890,'YAPE, Myrna S.','Languages Banilad, Dgte. City','422-9329','Teacher','','1958-05-28','Married',0,0,1000),
 (2012000891,'YBAÑEZ, Norma',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000892,'YBARLEY, Kerry Anne',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000893,'YGAY, Giselle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000894,'YGAY, Rex','Education KYO, Amigo Subd. Piapi, Dgte City, Neg. Or.','09226654562','Student','Business','1979-11-16','Married',1,0,1000),
 (2012000895,'YGNALAGA, Edgar Jr. S.','Engineering 3285 Cangmating Sibulan, Neg. Or.','09292858426','Faculty','','1967-09-04','Married',1,0,1000),
 (2012000896,'YRAD, Flora M.','Chemistry Magatas Sibulan, Neg. Or.','419-8087','Instructor','','1966-05-10','Married',0,0,1000),
 (2012000897,'YUCOR, Karen Rose R.','Nursing Banilad, Dgte. City','09173242715','Clinical Instructor','','1978-09-15','Single',0,0,1000),
 (2012000898,'YUIPCO, Junabelle',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000899,'YUZON, Eric',' Dumaguete City','','','','1990-01-01','',1,0,1000),
 (2012000900,'ZAMORA, Francis Dianne',' Dumaguete City','','','','1990-01-01','',0,0,1000),
 (2012000901,'ZAMORA, Niño',' Bais, City','','','','1990-01-01','',1,0,1000),
 (2012000902,'ZUNIEGA, Jose Monretz',' Tayasa, Negros Oriental','','','','1990-01-01','',1,0,1000),
 (2012000903,'Ronald Pascua','bagacay','09261625529','wala','wala','1991-02-08','Single',1,1,1000);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`discounts`
--

/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
LOCK TABLES `discounts` WRITE;
INSERT INTO `db_pos_restaurant`.`discounts` VALUES  (1,'Senior Citizen',6),
 (2,'Programmer',10);
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
) ENGINE=MyISAM AUTO_INCREMENT=490 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`endorsements`
--

/*!40000 ALTER TABLE `endorsements` DISABLE KEYS */;
LOCK TABLES `endorsements` WRITE;
INSERT INTO `db_pos_restaurant`.`endorsements` VALUES  (469,'28',104,104,'2012-07-11 12:47:52',9,''),
 (470,'28',3,3,'2012-07-11 12:50:15',13,''),
 (471,'22',8,8,'2012-07-11 12:51:55',9,''),
 (472,'22',8,8,'2012-07-11 12:52:02',13,''),
 (473,'22',8,8,'2012-07-11 12:52:03',14,''),
 (474,'21',1,1,'2012-07-11 12:52:59',9,''),
 (475,'22',5,5,'2012-07-11 12:53:22',15,''),
 (476,'22',5,5,'2012-07-11 12:53:22',16,''),
 (477,'28',2,2,'2012-07-11 12:54:15',14,''),
 (478,'28',2,2,'2012-07-11 12:54:16',15,''),
 (479,'28',2,2,'2012-07-11 12:54:16',16,''),
 (480,'32',7,7,'2012-07-11 01:03:18',9,''),
 (481,'32',7,7,'2012-07-11 01:03:18',13,''),
 (482,'32',7,7,'2012-07-11 01:03:18',14,''),
 (483,'32',7,7,'2012-07-11 01:03:18',15,''),
 (484,'32',7,7,'2012-07-11 01:03:18',16,''),
 (485,'38',4,4,'2012-07-11 01:06:14',9,''),
 (486,'38',4,4,'2012-07-11 01:06:14',13,''),
 (487,'38',4,4,'2012-07-11 01:06:14',14,''),
 (488,'38',4,4,'2012-07-11 01:06:14',15,''),
 (489,'38',4,4,'2012-07-11 01:06:14',16,'');
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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`favorites`
--

/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
LOCK TABLES `favorites` WRITE;
INSERT INTO `db_pos_restaurant`.`favorites` VALUES  (59,'27'),
 (60,'28'),
 (61,'29'),
 (62,'65'),
 (63,'1'),
 (64,'152'),
 (65,'34');
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`inventory2`
--

/*!40000 ALTER TABLE `inventory2` DISABLE KEYS */;
LOCK TABLES `inventory2` WRITE;
INSERT INTO `db_pos_restaurant`.`inventory2` VALUES  (1,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,200,'','2012-06-17 21:08:36',NULL,'COFFEE DRINK','1',NULL,0,NULL,35),
 (2,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,150,'','2012-06-17 21:11:04',NULL,'COFFEE DRINK','1',NULL,0,NULL,30),
 (3,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,200,'','2012-06-17 21:11:55',NULL,'COFFEE DRINK','1',NULL,0,NULL,31),
 (4,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,250,'','2012-06-17 21:12:19',NULL,'COFFEE DRINK','1',NULL,0,NULL,32),
 (5,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,250,'','2012-06-17 21:18:48',NULL,'COFFEE DRINK','1',NULL,0,NULL,33),
 (6,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,300,'','2012-06-17 21:20:35',NULL,'COFFEE DRINK','1',NULL,0,NULL,33),
 (7,NULL,1,'1','NESCAFE ICED COFFEE',31,NULL,1,'','2012-06-17 21:46:38',NULL,'COFFEE DRINK','1',NULL,0,NULL,31),
 (8,NULL,172,'172','(REG./LIGHT/ZERO) 1 L',26,NULL,200,'','2012-07-11 17:40:44',NULL,'COKE','35',NULL,0,NULL,27);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_name` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`inventory2_stocks_left`
--

/*!40000 ALTER TABLE `inventory2_stocks_left` DISABLE KEYS */;
LOCK TABLES `inventory2_stocks_left` WRITE;
INSERT INTO `db_pos_restaurant`.`inventory2_stocks_left` VALUES  (1,'0',1,'1','NESCAFE ICED COFFEE',31,94,'COFFEE DRINK','1','0',0,1,0,0,0),
 (2,'0',2,'2','ROCKSTAR ENERGY DRINK',42.5,100,'ENERGY DRINKS','2','0',0,1,0,0,0),
 (3,'0',3,'3','STING Plastic Bottle',20,100,'ENERGY DRINKS','2','0',0,1,0,0,0),
 (4,'0',4,'4','STING Bottle',15,100,'ENERGY DRINKS','2','0',0,1,0,0,0),
 (5,'0',5,'5','POWERADE 500 ml',35,100,'ENERGY DRINKS','2','0',0,1,0,0,0),
 (6,'0',6,'6','POWERADE 350 ml',25,100,'ENERGY DRINKS','2','0',0,1,0,0,0),
 (7,'0',7,'7','TROPICANA Bottle',15,100,'JUICES','3','0',0,1,0,0,0),
 (8,'0',8,'8','TROPICANA Plastic Bottle',25,100,'JUICES','3','0',0,1,0,0,0),
 (9,'0',9,'9','TROPICANA 1 L',75,100,'JUICES','3','0',0,1,0,0,0),
 (10,'0',10,'10','GATORADE 500 ml',35,100,'JUICES','3','0',0,1,0,0,0),
 (11,'0',11,'11','GATORADE 335 ml',25,100,'JUICES','3','0',0,1,0,0,0),
 (12,'0',12,'12','GATORADE 1 L',75,100,'JUICES','3','0',0,1,0,0,0),
 (13,'0',13,'13','MINUTE MAID Plastic Bottle',25,100,'JUICES','3','0',0,1,0,0,0),
 (14,'0',14,'14','MINUTE MAID 1 L',75,100,'JUICES','3','0',0,1,0,0,0),
 (15,'0',15,'15','FIT N RIGHT FIT N RIGHT',25,100,'JUICES','3','0',0,1,0,0,0),
 (16,'0',16,'16','C2 335 ml',20,100,'JUICES','3','0',0,1,0,0,0),
 (17,'0',17,'17','C2 solo',10,100,'JUICES','3','0',0,1,0,0,0),
 (18,'0',18,'18','DEL MONTE IN CAN ',25,100,'JUICES','3','0',0,1,0,0,0),
 (19,'0',19,'19','REAL LEAF ICE TEA',25,100,'JUICES','3','0',0,1,0,0,0),
 (20,'0',20,'20','KALAMANSI JUICE per glass',10,100,'JUICES','3','0',0,1,0,0,0),
 (21,'0',21,'21','ALASKA SWEET MILK ',18.5,100,'MILK DRINKS','4','0',0,1,0,0,0),
 (22,'0',22,'22','ALASKA CHOCO ALASKA CHOCO',18.5,100,'MILK DRINKS','4','0',0,1,0,0,0),
 (23,'0',23,'23','NESTLE FRESH MILK',29,100,'MILK DRINKS','4','0',0,1,0,0,0),
 (24,'0',24,'24','CHOCOLAIT CHOCOLAIT',24.5,100,'MILK DRINKS','4','0',0,1,0,0,0),
 (25,'0',25,'25','CHUCKIE CHUCKIE',24.6,100,'MILK DRINKS','4','0',0,1,0,0,0),
 (26,'0',26,'26','COW BELL 300 ml',32,100,'MILK DRINKS','4','0',0,1,0,0,0),
 (27,'0',27,'27','BEEF STEAK',35,98,'BEEF DISHES','5','0',0,1,0,0,0),
 (28,'0',28,'28','BEEF W/ BROCCOLI',35,99,'BEEF DISHES','5','0',0,1,0,0,0),
 (29,'0',29,'29','BEEF STRIPS',35,99,'BEEF DISHES','5','0',0,1,0,0,0),
 (30,'0',30,'30','NILAT-AN',35,100,'BEEF DISHES','5','0',0,1,0,0,0),
 (31,'0',31,'31','MECHADO',35,100,'BEEF DISHES','5','0',0,1,0,0,0),
 (32,'0',32,'32','AFRITADA',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (33,'0',33,'33','CHICKEN CURRY ',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (34,'0',34,'34','CHICKEN ADOBO',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (35,'0',35,'35','GRILLED CHICKEN',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (36,'0',36,'36','BREADED CHICKEN',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (37,'0',37,'37','SWEET & SOUR',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (38,'0',38,'38','HALANG-HALANG',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (39,'0',39,'39','TINOLA',35,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (40,'0',40,'40','LEVER W/ EGG',28,100,'CHICKEN DISHES','6','0',0,1,0,0,0),
 (41,'0',41,'41','SPAGHETTI',25,100,'NOODLES','7','0',0,1,0,0,0),
 (42,'0',42,'42','SOTANGHON (GISADO/SOUP)',25,100,'NOODLES','7','0',0,1,0,0,0),
 (43,'0',43,'43','BAM-E',25,100,'NOODLES','7','0',0,1,0,0,0),
 (44,'0',44,'44','FRESH PANCIT',25,100,'NOODLES','7','0',0,1,0,0,0),
 (45,'0',45,'45','BIHON',25,100,'NOODLES','7','0',0,1,0,0,0),
 (46,'0',46,'46','CARBONARA',25,100,'NOODLES','7','0',0,1,0,0,0),
 (47,'0',47,'47','PORK MENUDO',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (48,'0',48,'48','AFRITADA',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (49,'0',49,'49','DINUGUAN',30,100,'PORK DISHES','8','0',0,1,0,0,0),
 (50,'0',50,'50','GRILLED PORK',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (51,'0',51,'51','HUMBA',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (52,'0',52,'52','LECHON KAWALI',40,100,'PORK DISHES','8','0',0,1,0,0,0),
 (53,'0',53,'53','MEATBALL',25,100,'PORK DISHES','8','0',0,1,0,0,0),
 (54,'0',54,'54','PATATIN',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (55,'0',55,'55','PICADILLO',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (56,'0',56,'56','PORK & BEANS',25,100,'PORK DISHES','8','0',0,1,0,0,0),
 (57,'0',57,'57','PORK NILAT-AN',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (58,'0',58,'58','PORK STEAK',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (59,'0',59,'59','PORK TOCINO',15,100,'PORK DISHES','8','0',0,1,0,0,0),
 (60,'0',60,'60','PORK W/ POTATO',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (61,'0',61,'61','PORK-CHOP',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (62,'0',62,'62','SINIGANG',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (63,'0',63,'63','SISIG',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (64,'0',64,'64','SWEET & SOUR PORK',35,100,'PORK DISHES','8','0',0,1,0,0,0),
 (65,'0',65,'65','PLAIN RICE',8,94,'RICE','9','0',0,1,0,0,0),
 (66,'0',66,'66','FISH TINOLA',35,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (67,'0',67,'67','FRIED FISH',25,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (68,'0',68,'68','GRILLED FISH',35,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (69,'0',69,'69','PAKSIW',30,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (70,'0',70,'70','FISH FILLET',35,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (71,'0',71,'71','ESCABECHE',30,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (72,'0',72,'72','STEAMED FISH',35,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (73,'0',73,'73','KINILAW',35,100,'SEAFOOD DISHES','10','0',0,1,0,0,0),
 (74,'0',74,'74','DURUKAN LOLLIPOP',8,100,'SNACKS','11','0',0,1,0,0,0),
 (75,'0',75,'75','TABLE BANANA',3,100,'SNACKS','11','0',0,1,0,0,0),
 (76,'0',76,'76','CAKE',25,100,'SNACKS','11','0',0,1,0,0,0),
 (77,'0',77,'77','BINANGKAL',25,100,'SNACKS','11','0',0,1,0,0,0),
 (78,'0',78,'78','CASSAVA PUDDING',25,100,'SNACKS','11','0',0,1,0,0,0),
 (79,'0',79,'79','PUTO CASSAVA',25,100,'SNACKS','11','0',0,1,0,0,0),
 (80,'0',80,'80','MAJA BLANCA',25,100,'SNACKS','11','0',0,1,0,0,0),
 (81,'0',81,'81','BANANA TORON',25,100,'SNACKS','11','0',0,1,0,0,0),
 (82,'0',82,'82','BREAD ROLL',25,100,'SNACKS','11','0',0,1,0,0,0),
 (83,'0',83,'83','BANANA/KAMOTE QUE',25,100,'SNACKS','11','0',0,1,0,0,0),
 (84,'0',84,'84','COMBO',25,100,'SNACKS','11','0',0,1,0,0,0),
 (85,'0',85,'85','SWEETENED BANANA',25,100,'SNACKS','11','0',0,1,0,0,0),
 (86,'0',86,'86','LECHE PLAN',25,100,'SNACKS','11','0',0,1,0,0,0),
 (87,'0',87,'87','NILUYANG',25,100,'SNACKS','11','0',0,1,0,0,0),
 (88,'0',88,'88','KUTSINTA',25,100,'SNACKS','11','0',0,1,0,0,0),
 (89,'0',89,'89','PALITAW',25,100,'SNACKS','11','0',0,1,0,0,0),
 (90,'0',90,'90','BURGER',20,100,'SNACKS','11','0',0,1,0,0,0),
 (91,'0',91,'91','PIAYA UBE Big',42,100,'SNACKS','11','0',0,1,0,0,0),
 (92,'0',92,'92','PIAYA UBE Small',28,100,'SNACKS','11','0',0,1,0,0,0),
 (93,'0',93,'93','PIAYA ORIGINAL Big',39.6,100,'SNACKS','11','0',0,1,0,0,0),
 (94,'0',94,'94','PIAYA ORIGINAL Small',25,100,'SNACKS','11','0',0,1,0,0,0),
 (95,'0',95,'95','BARQUIRON 25pcs.',25.2,100,'SNACKS','11','0',0,1,0,0,0),
 (96,'0',96,'96','BANANACHIPS 200g',45.6,100,'SNACKS','11','0',0,1,0,0,0),
 (97,'0',97,'97','CHICHARON PACK ',35,100,'SNACKS','11','0',0,1,0,0,0),
 (98,'0',98,'98','GARLIC CRUNCH ',70,100,'SNACKS','11','0',0,1,0,0,0),
 (99,'0',99,'99','BENG – BENG 1 Box',84,100,'SNACKS','11','0',0,1,0,0,0),
 (100,'0',100,'100','BENG – BENG individual ',7,100,'SNACKS','11','0',0,1,0,0,0),
 (101,'0',101,'101','CHEESE STICK ',7,100,'SNACKS','11','0',0,1,0,0,0),
 (102,'0',102,'102','TORTA CAKE ',15,100,'SNACKS','11','0',0,1,0,0,0),
 (103,'0',103,'103','CHOP-SUEY',25,100,'VEGETABLES','12','0',0,1,0,0,0),
 (104,'0',104,'104','PINAKBET',25,100,'VEGETABLES','12','0',0,1,0,0,0),
 (105,'0',105,'105','MIX. VEGETABLES',25,100,'VEGETABLES','12','0',0,1,0,0,0),
 (106,'0',106,'106','AMPALAYA',25,100,'VEGETABLES','12','0',0,1,0,0,0),
 (107,'0',107,'107','EGGPLANT OMELET',18,100,'VEGETABLES','12','0',0,1,0,0,0),
 (108,'0',108,'108','LAW-UY',15,100,'VEGETABLES','12','0',0,1,0,0,0),
 (109,'0',109,'109','VEGETABLE GISADO',25,100,'VEGETABLES','12','0',0,1,0,0,0),
 (110,'0',110,'110','MILKITA CANDY',1,100,'CANDY','13','0',0,1,0,0,0),
 (111,'0',111,'111','MILKITA LOLLIPOP',5,100,'CANDY','13','0',0,1,0,0,0),
 (112,'0',112,'112','DURUKAN LOLLIPOP',8,100,'CANDY','13','0',0,1,0,0,0),
 (113,'0',113,'113','TABLE BANANA',3,100,'CANDY','13','0',0,1,0,0,0),
 (114,'0',114,'114','SUGUS',12,100,'CANDY','13','0',0,1,0,0,0),
 (115,'0',115,'115','TONG GARDEN HONEY ALMONDS',39,100,'CANDY','13','0',0,1,0,0,0),
 (116,'0',116,'116','TONG GARDEN CASHEW',39,100,'CANDY','13','0',0,1,0,0,0),
 (117,'0',117,'117','SUGUS',12,100,'CANDY','13','0',0,1,0,0,0),
 (118,'0',118,'118','TODAY\'S FRUIT MIX',179,100,'CANNED PRODUCTS','14','0',0,1,0,0,0),
 (119,'0',119,'119','CHIPS DELIGHTS 40g',10.5,100,'COOKIES','15','0',0,1,0,0,0),
 (120,'0',120,'120','DRIED DANGIT 200g',250,100,'DRIED PRODUCTS','16','0',0,1,0,0,0),
 (121,'0',121,'121','BAND AID',1,100,'HEALTH CARE','17','0',0,1,0,0,0),
 (122,'0',122,'122','OMEGA PAIN KILLER 120 ml',110.65,100,'LINIMENT','18','0',0,1,0,0,0),
 (123,'0',123,'123','OMEGA PAIN KILLER 60 ml',60.25,100,'LINIMENT','18','0',0,1,0,0,0),
 (124,'0',124,'124','OMEGA PAIN KILLER 30 ml',32,100,'LINIMENT','18','0',0,1,0,0,0),
 (125,'0',125,'125','EFFICASCENT OIL 100ml',83.7,100,'LINIMENT','18','0',0,1,0,0,0),
 (126,'0',126,'126','ALASKA POWDER 300g',92,100,'MILK PRODUCTS','19','0',0,1,0,0,0),
 (127,'0',127,'127','ALASKA EVAP 370 ml',23.7,100,'MILK PRODUCTS','19','0',0,1,0,0,0),
 (128,'0',128,'128','ALASKA CONDENSADA 387 ml',38,100,'MILK PRODUCTS','19','0',0,1,0,0,0),
 (129,'0',129,'129','SOTANGHON  1Kg',192.5,100,'PACKED NOODLES','20','0',0,1,0,0,0),
 (130,'0',130,'130','NESCAFE 25g',21.75,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (131,'0',131,'131','MASTER\'S BLEND SACHET',20,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (132,'0',132,'132','DXN COFFEE SACHET',22,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (133,'0',133,'133','KOPIKO BLACK ',6,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (134,'0',134,'134','KOPIKO BROWN ',7,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (135,'0',135,'135','NESCAFE 3 IN 1 Pack',171,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (136,'0',136,'136','NESCAFE 3 IN 2 individual sachet',6,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (137,'0',137,'137','NESCAFE stick',2,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (138,'0',138,'138','COFFEE 3 IN 1',20,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (139,'0',139,'139','COFFEE BLACK',20,100,'POWDERED COFFEE','21','0',0,1,0,0,0),
 (140,'0',140,'140','MILO 20g',6,100,'POWDERED MILK','22','0',0,1,0,0,0),
 (141,'0',141,'141','BEAR BRAND 80g',27.75,100,'POWDERED MILK','22','0',0,1,0,0,0),
 (142,'0',142,'142','PEANUT BUTTER ',150,100,'SANDWICH SPREADS','23','0',0,1,0,0,0),
 (143,'0',143,'143','MAGIC SINIGANG sachet',39.5,100,'SEASONING','24','0',0,1,0,0,0),
 (144,'0',144,'144','CLASSIQUE TEA 1 Box',280,100,'TEA','25','0',0,1,0,0,0),
 (145,'0',145,'145','CLASSIQUE TEA individual sachet',14,100,'TEA','25','0',0,1,0,0,0),
 (146,'0',146,'146','ENERGEN 30g',6,100,'VITAMINS/FOOD SUPPLEMENT','26','0',0,1,0,0,0),
 (147,'0',147,'147','FIT RIGHT CAPSULE',22,100,'VITAMINS/FOOD SUPPLEMENT','26','0',0,1,0,0,0),
 (148,'0',148,'148','LECIT-E CAPSULE',9.25,100,'VITAMINS/FOOD SUPPLEMENT','26','0',0,1,0,0,0),
 (149,'0',149,'149','1.66 L',365,100,'SELECTA GOLD','29','0',0,1,0,0,0),
 (150,'0',150,'150','800ml',115,100,'SELECTA GOLD','29','0',0,1,0,0,0),
 (151,'0',151,'151','100ml',50,100,'SELECTA GOLD','29','0',0,1,0,0,0),
 (152,'0',152,'152','1.5 L',440,100,'SELECTA HERSHEYS','30','0',0,1,0,0,0),
 (153,'0',153,'153','800ml',165,100,'SELECTA HERSHEYS','30','0',0,1,0,0,0),
 (154,'0',154,'154','3.0L',440,100,'SELECTA SUPREME','33','0',0,1,0,0,0),
 (155,'0',155,'155','1.5 L',255,100,'SELECTA SUPREME','33','0',0,1,0,0,0),
 (156,'0',156,'156','800ml',150,100,'SELECTA SUPREME','33','0',0,1,0,0,0),
 (157,'0',157,'157','3.0L',445,100,'SELECTA DOUBLE SUPREME','28','0',0,1,0,0,0),
 (158,'0',158,'158','1.5 L',260,100,'SELECTA DOUBLE SUPREME','28','0',0,1,0,0,0),
 (159,'0',159,'159','750ml',140,100,'SELECTA DOUBLE SUPREME','28','0',0,1,0,0,0),
 (160,'0',160,'160','3.0L',410,100,'SELECTA SUPER THICK','32','0',0,1,0,0,0),
 (161,'0',161,'161','1.5 L',235,100,'SELECTA SUPER THICK','32','0',0,1,0,0,0),
 (162,'0',162,'162','3.0L',340,100,'SELECTA 3-IN-1 SUPREME','27','0',0,1,0,0,0),
 (163,'0',163,'163','1.5 L',185,100,'SELECTA 3-IN-1 SUPREME','27','0',0,1,0,0,0),
 (164,'0',164,'164','1 L',119,100,'SELECTA PINOY SORBETES','31','0',0,1,0,0,0),
 (165,'0',165,'165','1.5 L',165,100,'SELECTA PINOY SORBETES','31','0',0,1,0,0,0),
 (166,'0',166,'166','750ml',99,100,'SELECTA PINOY SORBETES','31','0',0,1,0,0,0),
 (167,'0',167,'167','1.5 L',40,100,'7-UP','34','0',0,1,0,0,0),
 (168,'0',168,'168','1 L',22,100,'7-UP','34','0',0,1,0,0,0),
 (169,'0',169,'169','8 oz',10,100,'7-UP','34','0',0,1,0,0,0),
 (170,'0',170,'170','CAN',25,100,'7-UP','34','0',0,1,0,0,0),
 (171,'0',171,'171','(REG./LIGHT/ZERO) 1.5 L',48,100,'COKE','35','0',0,1,0,0,0),
 (172,'0',172,'172','(REG./LIGHT/ZERO) 1 L',26,300,'COKE','35','0',0,1,0,0,0),
 (173,'0',173,'173','(REG./LIGHT/ZERO) 12 oz',15,100,'COKE','35','0',0,1,0,0,0),
 (174,'0',174,'174','(REG./LIGHT/ZERO) 8 oz',12,100,'COKE','35','0',0,1,0,0,0),
 (175,'0',175,'175','COKE (REG./LIGHT/ZERO) sakto',8,100,'COKE','35','0',0,1,0,0,0),
 (176,'0',176,'176','(REG./LIGHT/ZERO) CAN',25,100,'COKE','35','0',0,1,0,0,0),
 (177,'0',177,'177','12 oz',12,100,'LIFT','36','0',0,1,0,0,0),
 (178,'0',178,'178','1.5 L',40,100,'MOUNTAIN DEW','37','0',0,1,0,0,0),
 (179,'0',179,'179','12 oz',12,100,'MOUNTAIN DEW','37','0',0,1,0,0,0),
 (180,'0',180,'180','CAN',25,100,'MOUNTAIN DEW','37','0',0,1,0,0,0),
 (181,'0',181,'181','(REG./MAX) 1.5 L',40,100,'PEPSI','38','0',0,1,0,0,0),
 (182,'0',182,'182','(REG./MAX) 1 L',22,100,'PEPSI','38','0',0,1,0,0,0),
 (183,'0',183,'183','(REG./MAX) 8 oz',10,100,'PEPSI','38','0',0,1,0,0,0),
 (184,'0',184,'184','(REG./MAX) Can',25,100,'PEPSI','38','0',0,1,0,0,0),
 (185,'0',185,'185','(REG./MAX) 12 oz',12,100,'PEPSI','38','0',0,1,0,0,0),
 (186,'0',186,'186','1.5 L',48,100,'ROYAL','39','0',0,1,0,0,0),
 (187,'0',187,'187','1 L',26,100,'ROYAL','39','0',0,1,0,0,0),
 (188,'0',188,'188','12 oz',15,100,'ROYAL','39','0',0,1,0,0,0),
 (189,'0',189,'189','8 oz',12,100,'ROYAL','39','0',0,1,0,0,0),
 (190,'0',190,'190','SAKTO',8,100,'ROYAL','39','0',0,1,0,0,0),
 (191,'0',191,'191','CAN',25,100,'ROYAL','39','0',0,1,0,0,0),
 (192,'0',192,'192','1.5 L',48,100,'SPRITE','40','0',0,1,0,0,0),
 (193,'0',193,'193','1 L',26,100,'SPRITE','40','0',0,1,0,0,0),
 (194,'0',194,'194','12 oz',15,100,'SPRITE','40','0',0,1,0,0,0),
 (195,'0',195,'195','8 oz',12,100,'SPRITE','40','0',0,1,0,0,0),
 (196,'0',196,'196','SAKTO',8,100,'SPRITE','40','0',0,1,0,0,0),
 (197,'0',197,'197','CAN',25,100,'SPRITE','40','0',0,1,0,0,0),
 (198,'0',198,'198','CASINO 150ml',30,100,'ALCOHOL','41','0',0,1,0,0,0),
 (199,'0',199,'199','CASINO 250ml',41.25,100,'ALCOHOL','41','0',0,1,0,0,0),
 (200,'0',200,'200','CASINO 500ml',76.25,100,'ALCOHOL','41','0',0,1,0,0,0),
 (201,'0',201,'201','ZWITSAL 100g',89,100,'BABY SHAMPOO','42','0',0,1,0,0,0),
 (202,'0',202,'202','BABY CARE 100 ml',89,100,'BABY SHAMPOO','42','0',0,1,0,0,0),
 (203,'0',203,'203','KIDS SHAMPOO 100 ml',99,100,'BABY SHAMPOO','42','0',0,1,0,0,0),
 (204,'0',204,'204','ZIP 900 ml',150,100,'CLEANSER','43','0',0,1,0,0,0),
 (205,'0',205,'205','PLANTEX 500 ml',150,100,'CLEANSER','43','0',0,1,0,0,0),
 (206,'0',206,'206','TUFF DWL 270 ml',70,100,'CLEANSER','43','0',0,1,0,0,0),
 (207,'0',207,'207','TUFF GERMBAN 250 ml',130,100,'CLEANSER','43','0',0,1,0,0,0),
 (208,'0',208,'208','TUFF TBC 500 ml',95,100,'CLEANSER','43','0',0,1,0,0,0),
 (209,'0',209,'209','TUFF TBC 700 ml',265,100,'CLEANSER','43','0',0,1,0,0,0),
 (210,'0',210,'210','TUPPER CLEAN TBC 300 ml',99,100,'CLEANSER','43','0',0,1,0,0,0),
 (211,'0',211,'211','TUPPER CLEAN MULTI-PURPOSE CLEANSER 500 ml',249,100,'CLEANSER','43','0',0,1,0,0,0),
 (212,'0',212,'212','TUPPER CLEAN POWER DETERGENT 1Kg',259,100,'CLEANSER','43','0',0,1,0,0,0),
 (213,'0',213,'213','WINNER DETERGENT CLEANSER 200g',20.4,100,'CLEANSER','43','0',0,1,0,0,0),
 (214,'0',214,'214','FAST MOUTH WASH 100 ml',99,100,'MOUTH WASH','44','0',0,1,0,0,0),
 (215,'0',215,'215','TOOTH BRUSH',15,100,'ORAL CARE','45','0',0,1,0,0,0),
 (216,'0',216,'216','CLASSIQUE SOAP100g',133,100,'SOAP','46','0',0,1,0,0,0),
 (217,'0',217,'217','BATHROOM TISSUE',9,100,'TISSUE','47','0',0,1,0,0,0),
 (218,'0',218,'218','1 L',20,100,'MINERAL WATER','48','0',0,1,0,0,0),
 (219,'0',219,'219','500 ml',15,100,'MINERAL WATER','48','0',0,1,0,0,0),
 (220,'0',220,'220','350 ml',10,100,'MINERAL WATER','48','0',0,1,0,0,0),
 (221,'0',221,'221','PROPEL 500 ml',18,100,'MINERAL WATER','48','0',0,1,0,0,0),
 (222,'0',222,'222','ANY BRAND',6,100,'BALLPEN','49','0',0,1,0,0,0),
 (223,'0',223,'223','PE T-SHIRT (S M L)',180,100,'SHIRTS','50','0',0,1,0,0,0),
 (224,'0',224,'224','PE T-SHIRT (XL 2XL)',200,100,'SHIRTS','50','0',0,1,0,0,0),
 (225,'0',225,'225','PE SHORT (S M L)',325,100,'SHIRTS','50','0',0,1,0,0,0),
 (226,'0',226,'226','PE SHORT (XL 2XL)',350,100,'SHIRTS','50','0',0,1,0,0,0),
 (227,'0',227,'227','SOUVENIR T-SHIRT (14 to S)',180,100,'SHIRTS','50','0',0,1,0,0,0),
 (228,'0',228,'228','SOUVENIR T-SHIRT (M L)',190,100,'SHIRTS','50','0',0,1,0,0,0),
 (229,'0',229,'229','SOUVENIR T-SHIRT (XL 2XL)',200,100,'SHIRTS','50','0',0,1,0,0,0),
 (230,'0',230,'230','PE T-SHIRT (12 to 20)',170,100,'SHIRTS','50','0',0,1,0,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`pending_order_details`
--

/*!40000 ALTER TABLE `pending_order_details` DISABLE KEYS */;
LOCK TABLES `pending_order_details` WRITE;
INSERT INTO `db_pos_restaurant`.`pending_order_details` VALUES  (7,3,'ronald',2,'1',31,62);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`pending_orders`
--

/*!40000 ALTER TABLE `pending_orders` DISABLE KEYS */;
LOCK TABLES `pending_orders` WRITE;
INSERT INTO `db_pos_restaurant`.`pending_orders` VALUES  (3,'ronald','2012-07-11 17:25:10');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`receipt_items`
--

/*!40000 ALTER TABLE `receipt_items` DISABLE KEYS */;
LOCK TABLES `receipt_items` WRITE;
INSERT INTO `db_pos_restaurant`.`receipt_items` VALUES  (10,1,'1',31,10,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (11,1,'27',35,10,'BEEF DISHES','FOOD','BEEF STEAK'),
 (12,2,'1',31,1,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (13,3,'1',31,1,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (14,3,'27',35,2,'BEEF DISHES','FOOD','BEEF STEAK'),
 (15,3,'28',35,1,'BEEF DISHES','FOOD','BEEF W/ BROCCOLI'),
 (16,3,'29',35,1,'BEEF DISHES','FOOD','BEEF STRIPS'),
 (17,4,'1',31,2,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (18,5,'1',31,2,'COFFEE DRINK','BEVERAGES','NESCAFE ICED COFFEE'),
 (19,5,'65',8,6,'RICE','FOOD','PLAIN RICE');
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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`receipts`
--

/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
LOCK TABLES `receipts` WRITE;
INSERT INTO `db_pos_restaurant`.`receipts` VALUES  (55,31,660,1,0,'2012-07-11 17:11:13',0,0,'','0',NULL),
 (56,31,31,2,0,'2012-07-11 17:13:14',0,0,'','0',NULL),
 (57,31,171,3,0,'2012-07-11 17:16:40',0,171,'','2012000164',NULL),
 (58,31,62,4,0,'2012-07-11 17:24:57',0,0,'','0',NULL),
 (59,31,110,5,0,'2012-07-11 17:29:17',0,0,'','2012000155',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`stock_out`
--

/*!40000 ALTER TABLE `stock_out` DISABLE KEYS */;
LOCK TABLES `stock_out` WRITE;
INSERT INTO `db_pos_restaurant`.`stock_out` VALUES  (1,'1','NESCAFE ICED COFFEE',200,31,'2012-06-17 09:49:59',NULL,'',NULL),
 (2,'1','NESCAFE ICED COFFEE',199,31,'2012-06-17 10:02:19',NULL,'','');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_pos_restaurant`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `db_pos_restaurant`.`users` VALUES  (1,'administrator','admin','admin',1,NULL,'2012-05-28 15:36:28',NULL),
 (2,'cashier','cashier','cashier',0,NULL,'2012-05-28 15:36:28',NULL),
 (3,'cashier2','cashier2','cashier2',0,NULL,'2012-05-28 22:55:36',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
