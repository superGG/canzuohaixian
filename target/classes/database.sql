/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : fishshop

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 19:03:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorySimpleName` varchar(255) DEFAULT NULL,
  `categoryAcademicName` varchar(255) DEFAULT NULL,
  `getType` int(11) DEFAULT NULL,
  `categoryEnglishName` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  `fishPhoto` varchar(255) DEFAULT NULL,
  `lowPrice` varchar(255) DEFAULT NULL,
  `unit` int(11) DEFAULT NULL,
  `totalSellNumber` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '鱼类', '鱼类', '3', 'fishcategory', null, 'localhost:8080//aaa.jpg', null, '1', '0', '2015-11-03 21:41:32', null, null, null);
INSERT INTO `category` VALUES ('2', '东星白班鱼', '东星白班鱼', '3', 'whitefish', '1', 'localhost:8080//aaa.jpg', null, '1', '0', '2015-11-03 21:41:32', null, null, null);
INSERT INTO `category` VALUES ('3', '小黄鱼', '小黄鱼', '3', 'yellowfish', '1', 'localhost:8080//aaa.jpg', null, '1', '0', '2015-11-03 21:41:32', null, null, null);
INSERT INTO `category` VALUES ('4', '小黑鱼', '小黑鱼', '3', 'smallblackfish', '1', 'localhost:8080//aaa.jpg', null, '1', '0', '2015-11-03 21:41:32', null, null, null);

-- ----------------------------
-- Table structure for `checkout`
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout` (
  `checkoutId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`checkoutId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkout
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsId` bigint(20) DEFAULT NULL,
  `commentType` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `weightQuality` float DEFAULT NULL,
  `freshQuality` float DEFAULT NULL,
  `speedQuality` float DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `farmers`
-- ----------------------------
DROP TABLE IF EXISTS `farmers`;
CREATE TABLE `farmers` (
  `farmersId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `identityPhoto` varchar(255) DEFAULT NULL,
  `addressPhoto` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`farmersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmers
-- ----------------------------

-- ----------------------------
-- Table structure for `fishman`
-- ----------------------------
DROP TABLE IF EXISTS `fishman`;
CREATE TABLE `fishman` (
  `fishmanId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `getType` int(11) DEFAULT NULL,
  `identityPhoto` varchar(255) DEFAULT NULL,
  `seaPassPhoto` varchar(255) DEFAULT NULL,
  `shipPhoto` varchar(255) DEFAULT NULL,
  `enginePower` bigint(20) DEFAULT NULL,
  `tonnage` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`fishmanId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fishman
-- ----------------------------

-- ----------------------------
-- Table structure for `gettype`
-- ----------------------------
DROP TABLE IF EXISTS `gettype`;
CREATE TABLE `gettype` (
  `getTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `getName` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`getTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gettype
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `goodsCategory` int(11) DEFAULT NULL,
  `goodsQuality` int(11) DEFAULT NULL,
  `hotDegree` bigint(20) DEFAULT NULL,
  `getType` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `nowNumber` bigint(20) DEFAULT '0',
  `unit` int(11) DEFAULT NULL,
  `sellNumber` bigint(20) DEFAULT '0',
  `creatorId` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `totalprice` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`ordersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `searecord`
-- ----------------------------
DROP TABLE IF EXISTS `searecord`;
CREATE TABLE `searecord` (
  `seaRecordId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `startSeeTime` datetime DEFAULT NULL,
  `endSeeTime` datetime DEFAULT NULL,
  `spendDay` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `anchorPoint` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`seaRecordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of searecord
-- ----------------------------

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopName` varchar(255) DEFAULT NULL,
  `getType` varchar(255) DEFAULT NULL,
  `weightQuality` float DEFAULT NULL,
  `freshQuality` float DEFAULT NULL,
  `speedQuality` float DEFAULT NULL,
  `shopType` int(11) DEFAULT NULL,
  `sendPrice` double DEFAULT NULL,
  `onSell` bit(1) DEFAULT NULL,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`shopId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for `sku`
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `skuId` bigint(20) NOT NULL AUTO_INCREMENT,
  `unitId` bigint(20) DEFAULT NULL,
  `skuName` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`skuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES ('1', '1', '中等大小(10-15)', '2015-11-04 06:58:42', null, '', '1');
INSERT INTO `sku` VALUES ('2', '1', '大号(15-20)', '2015-11-04 06:59:08', null, '', '1');
INSERT INTO `sku` VALUES ('3', '1', '小号(5-10)', '2015-11-04 06:59:32', null, '', '1');

-- ----------------------------
-- Table structure for `sorders`
-- ----------------------------
DROP TABLE IF EXISTS `sorders`;
CREATE TABLE `sorders` (
  `sordersId` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) DEFAULT NULL,
  `shopId` bigint(20) DEFAULT NULL,
  `goodsId` bigint(20) DEFAULT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsType` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `sellNumber` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`sordersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sorders
-- ----------------------------

-- ----------------------------
-- Table structure for `unit`
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `unitId` bigint(20) NOT NULL AUTO_INCREMENT,
  `unitName` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`unitId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES ('1', '条', '2015-11-03 21:41:33', null, '', '1');
INSERT INTO `unit` VALUES ('2', '斤', '2015-11-03 21:41:33', null, '', '1');
INSERT INTO `unit` VALUES ('3', '只', '2015-11-03 21:41:33', null, '', '1');
INSERT INTO `unit` VALUES ('4', '包', '2015-11-03 21:41:33', null, '', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userType` int(11) DEFAULT NULL,
  `identityId` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `headImage` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
