/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : fishshop

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-24 12:45:31
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
  `unit` varchar(255) DEFAULT NULL,
  `totalSellNumber` bigint(20) DEFAULT NULL,
  `skuList` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  `hotDegree` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  KEY `FK_t5q79q343h5dagly7r5avs1wj` (`parentId`),
  CONSTRAINT `FK_t5q79q343h5dagly7r5avs1wj` FOREIGN KEY (`parentId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '鱼类', '鱼类', '3', 'fishcategory', null, 'category/fish.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('2', '虾类', '虾类', '3', 'shrimpscategory', null, 'category/xia.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('3', '蟹类', '鱼类', '3', 'fishcategory', null, 'category/pangxie.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('4', '贝类', '鱼类', '3', 'fishcategory', null, 'category/beike.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('5', '鱿鱼类', '鱼类', '3', 'fishcategory', null, 'category/aaa.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('6', '人参类', '鱼类', '3', 'fishcategory', null, 'category/haishen.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('7', '东星白班鱼', '东星白班鱼', '3', 'whitefish', '1', 'localhost:8080//aaa.jpg', '斤', '53', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('8', '小黄鱼', '小黄鱼', '3', 'yellowfish', '1', 'localhost:8080//aaa.jpg', '只', '26', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('9', '小黑鱼', '小黑鱼', '3', 'smallblackfish', '1', 'localhost:8080//aaa.jpg', '斤', '1', null, '2015-11-04 13:41:32', null, '', '1', null);

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
  `identityId` bigint(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`checkoutId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkout
-- ----------------------------
INSERT INTO `checkout` VALUES ('1', '1', '1', '2015-11-05 11:10:37', null, '', '1', null, '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `ordersId` bigint(20) DEFAULT NULL,
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
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `forntIdentityPhoto` varchar(255) DEFAULT NULL,
  `backIdentityPhoto` varchar(255) DEFAULT NULL,
  `addressPhoto` varchar(255) DEFAULT NULL,
  `aquacultureLicense` varchar(255) DEFAULT NULL,
  `multiGetType` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`farmersId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmers
-- ----------------------------
INSERT INTO `farmers` VALUES ('1', '1', '广东海洋大学', '234.4', '344.6', '/fishshop/aaa.jpg', 'fs.jpg', 'dflj.jpg', '23409232408', '4;2;3', '2015-11-17 11:17:58', null, null, '1');

-- ----------------------------
-- Table structure for `fishman`
-- ----------------------------
DROP TABLE IF EXISTS `fishman`;
CREATE TABLE `fishman` (
  `fishmanId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `getType` int(11) DEFAULT NULL,
  `frontIdentityPhoto` varchar(255) DEFAULT NULL,
  `backIdentityPhoto` varchar(255) DEFAULT NULL,
  `seaPassPhoto` varchar(255) DEFAULT NULL,
  `shipPhoto` varchar(255) DEFAULT NULL,
  `enginePower` bigint(20) DEFAULT NULL,
  `homePort` bigint(20) DEFAULT NULL,
  `shipCreateTime` date DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `tonnage` bigint(20) DEFAULT NULL,
  `fishingLicense` varchar(255) DEFAULT NULL,
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
-- Table structure for `getaddress`
-- ----------------------------
DROP TABLE IF EXISTS `getaddress`;
CREATE TABLE `getaddress` (
  `getAddressId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `provinceId` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`getAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getaddress
-- ----------------------------
INSERT INTO `getaddress` VALUES ('1', '1', 'yilinfeng', '广东海洋大学', '18719425973', '524000', '1', '2015-11-24 10:57:48', null, '', '1');

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
  PRIMARY KEY (`getTypeId`),
  KEY `FK_9f7xf2br1n8grrcimp8o6is2k` (`parentId`),
  CONSTRAINT `FK_9f7xf2br1n8grrcimp8o6is2k` FOREIGN KEY (`parentId`) REFERENCES `gettype` (`getTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gettype
-- ----------------------------
INSERT INTO `gettype` VALUES ('1', '捕捞方式', null, '2015-11-05 08:13:31', null, '', '1');
INSERT INTO `gettype` VALUES ('2', '养殖方式', null, '2015-11-05 08:13:43', null, '', '1');
INSERT INTO `gettype` VALUES ('3', '撒网式', '1', '2015-11-05 08:14:17', null, '', '1');
INSERT INTO `gettype` VALUES ('4', '水箱式', '2', '2015-11-05 08:14:41', null, '', '1');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shopId` bigint(20) DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `goodsQuality` int(11) DEFAULT NULL,
  `hotDegree` bigint(20) DEFAULT NULL,
  `getType` int(11) DEFAULT NULL,
  `sku` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `nowNumber` bigint(20) DEFAULT '0',
  `unit` int(11) DEFAULT NULL,
  `sellNumber` bigint(20) DEFAULT '0',
  `creatorId` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', '7', '3', null, null, null, '34.5', '910', null, '165', null, '2015-11-16 22:13:25', '', '1');
INSERT INTO `goods` VALUES ('2', '1', '7', '5', null, '1', '1', '40', '1000', '1', '0', null, '2015-11-17 09:40:12', '', '0');
INSERT INTO `goods` VALUES ('3', '2', '8', '5', null, '1', '1', '40', '1000', '1', '0', null, '2015-11-17 09:41:23', '', '1');
INSERT INTO `goods` VALUES ('4', '2', '9', '5', null, '1', '1', '40', '1000', '1', '0', null, '2015-11-17 09:41:23', '', '1');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `shopId` bigint(20) DEFAULT NULL,
  `seaRecordId` bigint(20) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `buyerName` varchar(255) DEFAULT NULL,
  `shopKeeperName` varchar(255) DEFAULT NULL,
  `sendAddress` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `orderNumber` varchar(255) DEFAULT NULL,
  `provinceId` bigint(20) DEFAULT NULL,
  `postagePrice` double DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`ordersId`)
) ENGINE=InnoDB AUTO_INCREMENT=11111122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('11111120', '1', '1', '5', '30.5', '1', 'yilinfeng', '海格hao', '广东海洋大学', 'yilinfeng', '18719425973', null, null, '80', '2015-11-24 11:25:52', null, '', '1');

-- ----------------------------
-- Table structure for `ordersdetail`
-- ----------------------------
DROP TABLE IF EXISTS `ordersdetail`;
CREATE TABLE `ordersdetail` (
  `ordersDetailId` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) DEFAULT NULL,
  `shopId` bigint(20) DEFAULT NULL,
  `goodsId` bigint(20) DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `fishPhoto` varchar(255) DEFAULT NULL,
  `goodsType` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `skuId` bigint(20) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `postage` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`ordersDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersdetail
-- ----------------------------
INSERT INTO `ordersdetail` VALUES ('28', '11111120', '5', '1', '7', 'sdfsd', null, '养殖', '40', null, '中等大小', null, '斤', '5', null, '2015-11-24 11:25:52', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('29', '11111120', '5', '1', '7', 'sdfsd', null, '野生', '40', null, '中等大小', null, '斤', '5', null, '2015-11-24 11:25:52', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('30', '11111120', '3', '1', '8', 'sdfsd', null, '2343', '40', null, '中等大小', null, '斤', '5', null, '2015-11-24 11:25:52', null, '', '1');

-- ----------------------------
-- Table structure for `postage`
-- ----------------------------
DROP TABLE IF EXISTS `postage`;
CREATE TABLE `postage` (
  `postageId` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstWeigh` double DEFAULT NULL,
  `increasePrice` double DEFAULT NULL,
  `provinceName` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`postageId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postage
-- ----------------------------
INSERT INTO `postage` VALUES ('1', '10', '5', '广东省', '2015-11-24 11:05:18', null, '', '1');

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
  `shipportName` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`seaRecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of searecord
-- ----------------------------
INSERT INTO `searecord` VALUES ('1', '2', '2015-11-24 08:34:55', '2015-11-26 08:34:55', '3', null, '湛江港口', '34.6', '2349.5', '2015-11-24 08:34:55', null, '', '1');

-- ----------------------------
-- Table structure for `shipport`
-- ----------------------------
DROP TABLE IF EXISTS `shipport`;
CREATE TABLE `shipport` (
  `shipportId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shipportName` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`shipportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipport
-- ----------------------------

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `shopName` varchar(255) DEFAULT NULL,
  `getType` varchar(255) DEFAULT NULL,
  `grade` int(15) DEFAULT NULL,
  `weightQuality` float DEFAULT NULL,
  `freshQuality` float DEFAULT NULL,
  `speedQuality` float DEFAULT NULL,
  `shopType` int(11) DEFAULT NULL,
  `sendPrice` double DEFAULT NULL,
  `onSell` bit(1) DEFAULT NULL,
  `shipPort` varchar(255) DEFAULT NULL,
  `portTime` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `seaRecordId` bigint(20) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`shopId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '1', '海格号', '[2,3,4]', '5', null, null, null, '1', '40.5', '', null, null, '广东海洋大学', null, '234.4', '344.6', null, '', '2015-11-17 11:18:57', '1');
INSERT INTO `shop` VALUES ('2', '2', '泰坦尼克号', '[4]', '5', null, null, null, '1', '40.5', '', null, null, '广东海洋大学', '1', '234.4', '344.6', null, '', '2015-11-17 11:18:57', '1');

-- ----------------------------
-- Table structure for `sku`
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `skuId` bigint(20) NOT NULL AUTO_INCREMENT,
  `unitId` bigint(20) DEFAULT NULL,
  `skuName` varchar(255) DEFAULT NULL,
  `lowscale` double DEFAULT NULL,
  `highscale` double DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`skuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES ('1', '1', '中等大小', null, null, '2015-11-04 22:58:42', null, '', '1');
INSERT INTO `sku` VALUES ('2', '1', '大号', null, null, '2015-11-04 22:59:08', null, '', '1');
INSERT INTO `sku` VALUES ('3', '1', '小号', null, null, '2015-11-04 22:59:32', null, '', '1');

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
INSERT INTO `unit` VALUES ('1', '条', '2015-11-04 13:41:33', null, '', '1');
INSERT INTO `unit` VALUES ('2', '斤', '2015-11-04 13:41:33', null, '', '1');
INSERT INTO `unit` VALUES ('3', '只', '2015-11-04 13:41:33', null, '', '1');
INSERT INTO `unit` VALUES ('4', '包', '2015-11-04 13:41:33', null, '', '1');

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
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2', '1', '2', '易临风', '798555920', '18719425973', './aaa.jpg', '2015-11-05 11:12:04', null, '', '1');
INSERT INTO `user` VALUES ('2', '1', '1', '1', 'Imissyou', '798555920', '18320489492', './aaa.jpg', '2015-11-05 11:12:04', null, '', '1');
INSERT INTO `user` VALUES ('3', '2', '1', '1', '', '798555920', '18765432104', './aaa.jpg', '2015-11-15 09:54:21', null, '', '1');
INSERT INTO `user` VALUES ('4', '2', '2', '2', null, '328499605', '18312687412', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1');
