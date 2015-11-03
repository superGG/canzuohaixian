-- MySQL dump 10.10
--
-- Host: localhost    Database: fishshop
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Database 
--
DROP DATABASE IF EXISTS `fishshop`;

CREATE DATABASE `fishshop`;

USE `fishshop`;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` bigint(20) NOT NULL auto_increment,
  `categorySimpleName` varchar(255) default NULL,
  `categoryAcademicName` varchar(255) default NULL,
  `getType` int(11) default NULL,
  `categoryEnglishName` varchar(255) default NULL,
  `parentId` bigint(20) default NULL,
  `fishPhoto` varchar(255) default NULL,
  `lowPrice` varchar(255) default NULL,
  `unit` int(11) default NULL,
  `totalSellNumber` bigint(20) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--


/*!40000 ALTER TABLE `category` DISABLE KEYS */;
LOCK TABLES `category` WRITE;
INSERT INTO `category` VALUES (1,'鱼类','鱼类',3,'fishcategory',NULL,'localhost:8080//aaa.jpg',NULL,1,0,'2015-11-03 13:41:32',NULL,NULL,NULL),(2,'东星白班鱼','东星白班鱼',3,'whitefish',1,'localhost:8080//aaa.jpg',NULL,1,0,'2015-11-03 13:41:32',NULL,NULL,NULL),(3,'小黄鱼','小黄鱼',3,'yellowfish',1,'localhost:8080//aaa.jpg',NULL,1,0,'2015-11-03 13:41:32',NULL,NULL,NULL),(4,'小黑鱼','小黑鱼',3,'smallblackfish',1,'localhost:8080//aaa.jpg',NULL,1,0,'2015-11-03 13:41:32',NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL auto_increment,
  `goodsId` bigint(20) default NULL,
  `commentType` int(11) default NULL,
  `content` varchar(255) default NULL,
  `weightQuality` float default NULL,
  `freshQuality` float default NULL,
  `speedQuality` float default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--


/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
LOCK TABLES `comment` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

--
-- Table structure for table `farmers`
--

DROP TABLE IF EXISTS `farmers`;
CREATE TABLE `farmers` (
  `farmersId` bigint(20) NOT NULL auto_increment,
  `shopId` bigint(20) default NULL,
  `address` varchar(255) default NULL,
  `identityPhoto` varchar(255) default NULL,
  `addressPhoto` varchar(255) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`farmersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `farmers`
--


/*!40000 ALTER TABLE `farmers` DISABLE KEYS */;
LOCK TABLES `farmers` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `farmers` ENABLE KEYS */;

--
-- Table structure for table `fishman`
--

DROP TABLE IF EXISTS `fishman`;
CREATE TABLE `fishman` (
  `fishmanId` bigint(20) NOT NULL auto_increment,
  `shopId` bigint(20) default NULL,
  `getType` int(11) default NULL,
  `identityPhoto` varchar(255) default NULL,
  `seaPassPhoto` varchar(255) default NULL,
  `shipPhoto` varchar(255) default NULL,
  `enginePower` bigint(20) default NULL,
  `tonnage` bigint(20) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`fishmanId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fishman`
--


/*!40000 ALTER TABLE `fishman` DISABLE KEYS */;
LOCK TABLES `fishman` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `fishman` ENABLE KEYS */;

--
-- Table structure for table `gettype`
--

DROP TABLE IF EXISTS `gettype`;
CREATE TABLE `gettype` (
  `getTypeId` bigint(20) NOT NULL auto_increment,
  `getName` varchar(255) default NULL,
  `parentId` bigint(20) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`getTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gettype`
--


/*!40000 ALTER TABLE `gettype` DISABLE KEYS */;
LOCK TABLES `gettype` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `gettype` ENABLE KEYS */;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` bigint(20) NOT NULL auto_increment,
  `shopId` bigint(20) default NULL,
  `goodsCategory` int(11) default NULL,
  `goodsQuality` int(11) default NULL,
  `hotDegree` bigint(20) default NULL,
  `getType` int(11) default NULL,
  `price` double default NULL,
  `nowNumber` bigint(20) default NULL,
  `unit` int(11) default NULL,
  `sellNumber` bigint(20) default NULL,
  `creatorId` bigint(20) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods`
--


/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
LOCK TABLES `goods` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersId` bigint(20) NOT NULL auto_increment,
  `shopId` bigint(20) default NULL,
  `totalprice` bigint(20) default NULL,
  `state` int(11) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`ordersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--


/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
LOCK TABLES `orders` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

--
-- Table structure for table `searecord`
--

DROP TABLE IF EXISTS `searecord`;
CREATE TABLE `searecord` (
  `seaRecordId` bigint(20) NOT NULL auto_increment,
  `shopId` bigint(20) default NULL,
  `startSeeTime` datetime default NULL,
  `endSeeTime` datetime default NULL,
  `spendDay` int(11) default NULL,
  `state` int(11) default NULL,
  `anchorPoint` int(11) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`seaRecordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `searecord`
--


/*!40000 ALTER TABLE `searecord` DISABLE KEYS */;
LOCK TABLES `searecord` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `searecord` ENABLE KEYS */;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` bigint(20) NOT NULL auto_increment,
  `shopName` varchar(255) default NULL,
  `getType` varchar(255) default NULL,
  `weightQuality` float default NULL,
  `freshQuality` float default NULL,
  `speedQuality` float default NULL,
  `shopType` int(11) default NULL,
  `sendPrice` double default NULL,
  `onSell` bit(1) default NULL,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`shopId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shop`
--


/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
LOCK TABLES `shop` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;

--
-- Table structure for table `sku`
--

DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `skuId` bigint(20) NOT NULL auto_increment,
  `unitId` bigint(20) default NULL,
  `skuName` varchar(255) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`skuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sku`
--


/*!40000 ALTER TABLE `sku` DISABLE KEYS */;
LOCK TABLES `sku` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `sku` ENABLE KEYS */;

--
-- Table structure for table `sorders`
--

DROP TABLE IF EXISTS `sorders`;
CREATE TABLE `sorders` (
  `sordersId` bigint(20) NOT NULL auto_increment,
  `orderId` bigint(20) default NULL,
  `shopId` bigint(20) default NULL,
  `goodsId` bigint(20) default NULL,
  `goodsName` varchar(255) default NULL,
  `goodsType` varchar(255) default NULL,
  `price` double default NULL,
  `totalprice` double default NULL,
  `sku` varchar(255) default NULL,
  `unit` varchar(255) default NULL,
  `sellNumber` bigint(20) default NULL,
  `number` bigint(20) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`sordersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sorders`
--


/*!40000 ALTER TABLE `sorders` DISABLE KEYS */;
LOCK TABLES `sorders` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `sorders` ENABLE KEYS */;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `unitId` bigint(20) NOT NULL auto_increment,
  `unitName` varchar(255) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unit`
--


/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
LOCK TABLES `unit` WRITE;
INSERT INTO `unit` VALUES (1,'条','2015-11-03 13:41:33',NULL,'\0',1),(2,'斤','2015-11-03 13:41:33',NULL,'\0',1),(3,'只','2015-11-03 13:41:33',NULL,'\0',1),(4,'包','2015-11-03 13:41:33',NULL,'\0',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL auto_increment,
  `userType` int(11) default NULL,
  `identityId` bigint(20) default NULL,
  `state` int(11) default NULL,
  `userName` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `phoneNumber` varchar(255) default NULL,
  `headImage` varchar(255) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `creatorId` bigint(20) default NULL,
  `isDelete` bit(1) default NULL,
  `version` bigint(20) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

