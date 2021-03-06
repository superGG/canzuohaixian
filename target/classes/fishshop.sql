/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : fishshop

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-12-07 22:56:44
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '鱼类', '鱼类', '3', 'fishcategory', null, 'category/fish.jpg', '斤', '0', null, '2015-10-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('2', '虾类', '虾类', '3', 'shrimpscategory', null, 'category/xia.jpg', '斤', '0', null, '2015-10-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('3', '蟹类', '鱼类', '3', 'fishcategory', null, 'category/pangxie.jpg', '斤', '0', null, '2015-10-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('4', '贝类', '鱼类', '3', 'fishcategory', null, 'category/beike.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('5', '鱿鱼类', '鱼类', '3', 'fishcategory', null, 'category/xia.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('6', '人参类', '鱼类', '3', 'fishcategory', null, 'category/haishen.jpg', '斤', '0', null, '2015-11-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('7', '东星白班鱼', '东星白班鱼', '3', 'whitefish', '1', 'category/haishen.jpg', '斤', '338', '[1,3]', '2015-10-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('8', '小黄鱼', '小黄鱼', '3', 'yellowfish', '1', 'category/fish.jpg', '个', '41', '[1,2,3]', '2015-10-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('9', '小黑鱼', '小黑鱼', '3', 'smallblackfish', '1', 'category/beike.jpg', '条', '16', '[2,3]', '2015-10-04 13:41:32', null, '', '1', null);
INSERT INTO `category` VALUES ('10', '大头虾', '大头虾', '3', 'bigHeadXia', '2', 'category/xia.jpg', '斤', '0', '[2,3]', '2015-11-26 12:58:27', null, '', '1', null);

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
  `phoneNumber` varchar(255) DEFAULT NULL,
  `ordersId` bigint(20) DEFAULT NULL,
  `commentType` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `anonymity` int(11) DEFAULT NULL,
  `weightQuality` float DEFAULT NULL,
  `freshQuality` float DEFAULT NULL,
  `speedQuality` float DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('22', '1', '1', '匿名', '11111110', '-1', '不错。我只是来测试而已', '1', '3', '2', '4', '2015-11-27 16:49:31', null, '', '0');
INSERT INTO `comment` VALUES ('23', '1', '1', '匿名', '11111110', '-1', '不错。我只是来测试而已', '1', '3', '2', '4', '2015-11-27 16:50:26', null, '', '0');
INSERT INTO `comment` VALUES ('24', '1', '1', '匿名', '11111110', '-1', '不错。我只是来测试而已', '1', '3', '2', '4', '2015-11-27 16:51:42', null, '', '0');
INSERT INTO `comment` VALUES ('26', '1', '4', '匿名', '11111120', '-1', 'Imissyou有评论', '1', '5', '4.5', '4', '2015-11-27 17:32:55', null, '', '0');
INSERT INTO `comment` VALUES ('27', '1', '4', '匿名', '11111120', '0', '技术的激发了圣诞节费电话费的说法', '1', '3.5', '3.5', '3.5', '2015-11-27 22:38:14', null, '', '0');
INSERT INTO `comment` VALUES ('28', '1', '4', '匿名', '11111120', '1', '不好！不哈话', '1', '4', '3.5', '3.5', '2015-11-28 11:18:42', null, '', '0');
INSERT INTO `comment` VALUES ('29', '1', '4', '匿名', '11111120', '1', '胡大垃圾发电水立方角度来看\n不hi啊好不', '1', '1', '1', '1', '2015-11-28 11:21:00', null, '', '0');
INSERT INTO `comment` VALUES ('30', '1', '4', '匿名', '11111120', '1', '456419135156/urrrrrr', '1', '1.5', '1.5', '1', '2015-11-28 11:21:32', null, '', '0');
INSERT INTO `comment` VALUES ('41', '1', '4', '18312687412', '11111131', '0', '…', '0', '5', '5', '4.5', '2015-12-07 21:42:30', null, '', '0');
INSERT INTO `comment` VALUES ('42', '1', '4', '18312687412', '11111132', '1', '的', '0', '5', '5', '5', '2015-12-07 21:44:38', null, '', '0');
INSERT INTO `comment` VALUES ('43', '1', '4', '匿名', '11111135', '0', '啦啦啦', '1', '3.5', '4', '4.5', '2015-12-07 22:29:48', null, '', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmers
-- ----------------------------
INSERT INTO `farmers` VALUES ('1', '2', '广东海洋大学', '234.4', '344.6', '/fishshop/aaa.jpg', 'fs.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '23409232408', '4;2;3', '2015-11-17 11:17:58', null, '', '1');
INSERT INTO `farmers` VALUES ('2', '6', '岭南师范学院', '234.4', '344.6', '/fishshop/aaa.jpg', 'fs.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '23409232408', '4;2;3', '2015-11-17 11:17:58', null, '', '1');
INSERT INTO `farmers` VALUES ('3', '7', '北京大学', '234.4', '344.6', '/fishshop/aaa.jpg', 'fs.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '23409232408', '4;2;3', '2015-11-17 11:17:58', null, '', '1');
INSERT INTO `farmers` VALUES ('4', '8', '清华大学', '234.4', '344.6', '/fishshop/aaa.jpg', 'fs.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '23409232408', '4;2;3', '2015-11-17 11:17:58', null, '', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fishman
-- ----------------------------
INSERT INTO `fishman` VALUES ('1', '1', '1', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '20', '23409232408', '2015-11-17', 'superGG', '123456789', 'sdsdfsdf', '2015-11-17 11:17:58', null, '', '0');
INSERT INTO `fishman` VALUES ('2', '2', '1', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '20', '23409232408', '2015-11-17', 'superGG', '123456789', 'sdsdfsdf', '2015-11-17 11:17:58', null, '', '0');
INSERT INTO `fishman` VALUES ('3', '3', '2', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '20', '23409232408', '2015-11-17', 'superGG', '123456789', 'sdsdfsdf', '2015-11-17 11:17:58', null, '', '0');
INSERT INTO `fishman` VALUES ('4', '4', '2', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '/fishshop/aaa.jpg', '[\"user/aaa.jpg\",\"user/bbb.jpg\",\"user/ccc.jpg\"]\r\n', '20', '23409232408', '2015-11-17', 'superGG', '123456789', 'sdsdfsdf', '2015-11-17 11:17:58', null, '', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getaddress
-- ----------------------------
INSERT INTO `getaddress` VALUES ('22', '1', '黄祥谦', '广东省湛江市广东海洋大学', '18719425973', '524000', null, '2015-12-05 20:36:17', null, '', '1');
INSERT INTO `getaddress` VALUES ('23', '28', '第三方第三方', '范德萨发的是电风扇1', '128946541964641', '鼎折覆餗', null, '2015-12-05 22:43:34', null, '', '1');

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
  `unit` varchar(255) DEFAULT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsPhoto` varchar(255) DEFAULT NULL,
  `sellNumber` bigint(20) DEFAULT '0',
  `creatorId` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', '7', '3', null, '1', '1', '366.5', '529', '斤', '白星鱼', 'goods/aaa.jpg', '480', null, '2015-11-16 22:13:25', '', '1');
INSERT INTO `goods` VALUES ('2', '2', '7', '5', null, '1', '1', '40', '1000', '只', '东邦鱼', 'goods/bbb.jpg', '35', null, '2015-11-17 09:40:12', '', '0');
INSERT INTO `goods` VALUES ('3', '2', '8', '5', null, '1', '1', '40', '1000', '只', '美人鱼1', 'goods/aaa.jpg', '46', null, '2015-11-17 09:41:23', '', '1');
INSERT INTO `goods` VALUES ('4', '5', '8', '5', null, '1', '1', '336.5', '55', '只', '美人鱼2', 'goods/aaa.jpg', '46', null, '2015-11-17 09:41:23', '', '1');
INSERT INTO `goods` VALUES ('5', '6', '8', '5', null, '1', '1', '40', '1000', '只', '美人鱼3', 'goods/aaa.jpg', '46', null, '2015-11-17 09:41:23', '', '1');
INSERT INTO `goods` VALUES ('6', '7', '8', '5', null, '1', '1', '40', '1000', '只', '美人鱼4', 'goods/aaa.jpg', '46', null, '2015-11-17 09:41:23', '', '1');
INSERT INTO `goods` VALUES ('7', '8', '9', '5', null, '1', '1', '40', '1000', '只', '死鱼', 'goods/bbb.jpg', '66', null, '2015-11-17 09:41:23', '', '1');
INSERT INTO `goods` VALUES ('8', '2', '7', '5', null, '1', '2', '25', '200', '只', '东邦鱼22', 'goods/ccc.jpg', '25', null, '2015-12-03 20:01:29', '', '1');
INSERT INTO `goods` VALUES ('9', '1', '1', '0', null, '3', '1', '34.5', '0', '斤', '鱼类', 'goods/7f45522d-78c5-4173-975c-b07b60c7a68e.png', '0', null, '2015-12-07 16:45:50', '', '0');
INSERT INTO `goods` VALUES ('10', '1', '1', '0', null, '3', '2', '35.5', '0', '斤', '鱼类', 'goods/7f45522d-78c5-4173-975c-b07b60c7a68e.png', '0', null, '2015-12-07 16:45:50', '', '0');
INSERT INTO `goods` VALUES ('11', '1', '1', '0', null, '3', '1', '34.5', '0', '斤', '鱼类', 'goods/0c03b0b5-14f5-49b1-8b9b-b16b9e114b1f.png', '0', null, '2015-12-07 16:48:50', '', '0');
INSERT INTO `goods` VALUES ('12', '1', '1', '0', null, '3', '2', '35.5', '0', '斤', '鱼类', 'goods/0c03b0b5-14f5-49b1-8b9b-b16b9e114b1f.png', '0', null, '2015-12-07 16:48:50', '', '0');
INSERT INTO `goods` VALUES ('13', '1', '1', '0', null, '3', '1', '34.5', '0', '斤', '鱼类', 'goods/db47959f-de96-48d9-bd54-5bb46c8f67f0.png', '0', null, '2015-12-07 16:49:41', '', '0');
INSERT INTO `goods` VALUES ('14', '1', '1', '0', null, '3', '2', '35.5', '0', '斤', '鱼类', 'goods/db47959f-de96-48d9-bd54-5bb46c8f67f0.png', '0', null, '2015-12-07 16:49:41', '', '0');

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
  `sordersNumber` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`ordersId`)
) ENGINE=InnoDB AUTO_INCREMENT=11122238 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('11111110', '4', '1', '6', '31.5', '4', 'yilinfeng', '海格号', '广东省湛江市广东海洋大学', '易临风', '18719425973', '123456789', '20', '5.5', '10', '2015-11-16 22:14:31', null, null, '5');
INSERT INTO `orders` VALUES ('11111120', '5', '4', '5', '32.5', '4', 'yilinfeng', '海格hao', '广东海洋大学', 'yilinfeng', '18719425973', null, null, '80', '5', '2015-11-24 11:25:52', null, '', '5');
INSERT INTO `orders` VALUES ('11111122', '4', '1', '3', '33.5', '4', 'yilinfeng', '海格号222', '广东海洋大学', 'yilinfeng', '18719425973', '719121392152', null, '80', '3', '2015-11-24 22:07:40', null, '', '2');
INSERT INTO `orders` VALUES ('11111123', '4', '4', '6', '34.5', '1', 'yilinfeng', '迷之海格号', '广东海洋大学', 'yilinfeng', '18719425973', '719121392152', null, '80', '3', '2015-11-26 22:27:07', null, '', '1');
INSERT INTO `orders` VALUES ('11111124', '4', '1', '6', '340.5', '0', 'yilinfeng', '海格号222', '广东海洋大学', 'yilinfeng', '18719425973', null, null, '80', '3', '2015-11-27 09:37:24', null, '', '1');
INSERT INTO `orders` VALUES ('11111125', '4', '1', '5', '517.5', '1', 'yilinfeng', '111', '广东海洋大学', 'yilinfeng', '18719425973', '719121392152', null, '80', '3', '2015-11-29 20:02:11', null, '', '0');
INSERT INTO `orders` VALUES ('11111126', '4', '1', '5', '517.5', '1', 'yilinfeng', '222', '广东海洋大学', 'yilinfeng', '18719425973', null, null, '80', '3', '2015-11-29 20:18:40', null, '', '0');
INSERT INTO `orders` VALUES ('11111127', '4', '1', '5', '597.5', '1', 'yilinfeng', '333', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 22:13:32', null, '', '0');
INSERT INTO `orders` VALUES ('11111128', '4', '1', '5', '597.5', '1', 'yilinfeng', '海格号1', '广东省海洋大学', 'yilinfeng', '18719425973', null, '1', '80', '3', '2015-11-29 22:28:33', null, '', '0');
INSERT INTO `orders` VALUES ('11111129', '4', '1', '5', '597.5', '0', 'yilinfeng', '海格号2', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 22:51:19', null, '', '0');
INSERT INTO `orders` VALUES ('11111130', '4', '1', '5', '597.5', '1', 'yilinfeng', '海格号3', '广东省海洋大学', 'yilinfeng', '18719425973', null, '1', '80', '3', '2015-11-29 22:52:48', null, '', '0');
INSERT INTO `orders` VALUES ('11111131', '4', '1', '5', '597.5', '4', 'yilinfeng', '海格号4', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 22:53:05', null, '', '1');
INSERT INTO `orders` VALUES ('11111132', '4', '1', '5', '567.5', '4', 'yilinfeng', '海格号5', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 22:54:13', null, '', '1');
INSERT INTO `orders` VALUES ('11111134', '4', '1', '5', '537.5', '1', 'yilinfeng', '海格号7', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 22:55:47', null, '', '0');
INSERT INTO `orders` VALUES ('11111135', '4', '1', '5', '597.5', '4', 'yilinfeng', '海格号8', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 23:23:31', null, '', '1');
INSERT INTO `orders` VALUES ('11111136', '4', '1', '5', '597.5', '1', 'yilinfeng', '海格号9', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 23:30:44', null, '', '0');
INSERT INTO `orders` VALUES ('11111137', '4', '1', '5', '597.5', '1', 'yilinfeng', '海格号0', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-29 23:39:59', null, '', '0');
INSERT INTO `orders` VALUES ('11111138', '28', '1', '5', '597.5', '1', 'yilinfeng', '海格号11', '广东省海洋大学', 'yilinfeng', '18719425973', '719121392152', '1', '80', '3', '2015-11-30 20:50:53', null, '', '0');
INSERT INTO `orders` VALUES ('11111139', '28', '1', '5', '597.5', '1', 'yilinfeng', '海格号12', '广东省海洋大学', 'yilinfeng', '18719425973', null, '1', '80', '3', '2015-12-01 17:54:27', null, '', '0');
INSERT INTO `orders` VALUES ('11111140', '28', '1', '5', '5577.5', '2', 'yilinfeng', '海格号', '广东省海洋大学', 'yilinfeng', '18719425973', null, '1', '80', '3', '2015-12-05 19:23:27', null, '', '0');
INSERT INTO `orders` VALUES ('11122222', '3', '3', '7', '10000', '3', 'Imissyou', '海豚音', '广东省湛江市广东海洋大学', 'Imissyou', '13763012723', '123456789', '1', null, '4', '2015-12-06 20:23:02', null, '', '1');
INSERT INTO `orders` VALUES ('11122234', '28', '3', '5', '5577.5', '1', 'yilinfeng', '海格号', '范德萨发的是电风扇1', '第三方第三方', '128946541964641', null, '1', '80', '3', '2015-12-06 22:08:17', null, '', '0');
INSERT INTO `orders` VALUES ('11122237', '4', '1', '5', '5577.5', '2', 'yilinfeng', '海格号', '范德萨发的是电风扇1', '第三方第三方', '128946541964641', null, '1', '80', '3', '2015-12-07 21:53:42', null, '', '0');

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
  `goodsPhoto` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `skuId` bigint(20) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`ordersDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersdetail
-- ----------------------------
INSERT INTO `ordersdetail` VALUES ('28', '11111110', '5', '1', '7', 'sdfsd', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-11-24 11:25:52', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('29', '11111110', '5', '1', '7', 'sdfsd', 'goods/bbb.jpg', '46', '172.5', '中等大小', '1', '斤', '5', '2015-11-24 11:25:52', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('30', '11111110', '3', '1', '8', 'sdfsd', 'goods/aaa.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-10-24 11:25:52', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('34', '11111122', '5', '1', '8', 'sdfsd', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-11-24 22:07:40', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('35', '11111110', '5', '1', '7', 'sdfsd', 'goods/aaa.jpg', '43', '172.5', '中等大小', '1', '斤', '5', '2015-10-24 22:07:40', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('36', '11111122', '3', '1', '9', '白星东邦鱼', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-10-24 22:07:40', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('37', '11111123', '5', '1', '8', 'sdfsd', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-11-26 22:27:07', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('38', '11111123', '5', '1', '7', 'sdfsd', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-11-26 22:27:07', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('39', '11111123', '3', '1', '9', '白星东邦鱼', 'goods/bbb.jpg', '41', '172.5', '中等大小', '1', '斤', '5', '2015-11-26 22:27:07', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('40', '11111124', '5', '1', '8', 'sdfsd', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-11-27 09:37:25', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('41', '11111124', '5', '1', '7', 'sdfsd', 'goods/bbb.jpg', '40', '172.5', '中等大小', '1', '斤', '5', '2015-11-27 09:37:25', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('42', '11111124', '3', '1', '9', '白星东邦鱼', 'goods/bbb.jpg', '47', '172.5', '中等大小', '1', '斤', '5', '2015-11-27 09:37:25', null, '', '1');
INSERT INTO `ordersdetail` VALUES ('43', '11111125', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 20:02:11', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('44', '11111125', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 20:02:11', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('45', '11111125', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 20:02:11', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('46', '11111126', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 20:18:40', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('47', '11111126', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 20:18:40', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('48', '11111126', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 20:18:40', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('49', '11111127', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:13:32', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('50', '11111127', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:13:32', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('51', '11111127', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:13:32', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('52', '11111128', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:28:33', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('53', '11111128', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:28:33', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('54', '11111128', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:28:34', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('55', '11111129', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:51:19', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('56', '11111129', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:51:19', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('57', '11111129', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:51:19', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('58', '11111130', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:52:48', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('59', '11111130', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:52:48', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('60', '11111130', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:52:48', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('61', '11111131', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:53:05', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('62', '11111131', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:53:05', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('63', '11111131', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:53:05', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('64', '11111132', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:54:13', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('65', '11111132', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:54:13', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('66', '11111132', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:54:13', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('67', '11111133', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:55:03', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('68', '11111133', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:55:03', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('69', '11111133', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:55:03', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('70', '11111134', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:55:47', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('71', '11111134', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:55:47', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('72', '11111134', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 22:55:47', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('73', '11111135', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:23:31', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('74', '11111135', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:23:31', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('75', '11111135', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:23:31', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('76', '11111136', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:30:44', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('77', '11111136', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:30:44', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('78', '11111136', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:30:44', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('79', '11111137', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:39:59', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('80', '11111137', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:39:59', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('81', '11111137', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-29 23:39:59', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('82', '11111138', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-30 20:50:53', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('83', '11111138', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-30 20:50:53', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('84', '11111138', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-11-30 20:50:53', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('85', '11111139', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-12-01 17:54:28', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('86', '11111139', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-12-01 17:54:28', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('87', '11111139', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '34.5', '172.5', '中等大小', '1', '斤', '5', '2015-12-01 17:54:28', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('88', '11111140', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-05 19:23:27', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('89', '11111140', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-05 19:23:27', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('90', '11111140', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-05 19:23:27', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('91', '11122234', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-06 22:08:17', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('92', '11122234', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-06 22:08:18', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('93', '11122234', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-06 22:08:18', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('94', '11122237', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-07 21:53:42', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('95', '11122237', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-07 21:53:42', null, '', '0');
INSERT INTO `ordersdetail` VALUES ('96', '11122237', '1', '1', '7', '白星鱼', 'goods/aaa.jpg', '366.5', '1832.5', '中等大小', '1', '斤', '5', '2015-12-07 21:53:42', null, '', '0');

-- ----------------------------
-- Table structure for `postage`
-- ----------------------------
DROP TABLE IF EXISTS `postage`;
CREATE TABLE `postage` (
  `postageId` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstWeigh` double DEFAULT NULL,
  `increasePrice` double DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`postageId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postage
-- ----------------------------
INSERT INTO `postage` VALUES ('1', '10', '5', '1:1','1:1', '2015-11-24 11:05:18', null, '', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of searecord
-- ----------------------------
INSERT INTO `searecord` VALUES ('1', '2', '2015-11-24 08:34:55', '2015-12-10 17:13:30', '3', '1', '湛江港口', '34.6', '2349.5', '2015-11-24 08:34:55', null, '', '6');
INSERT INTO `searecord` VALUES ('2', '2', '2015-11-24 08:34:55', '2015-12-08 17:13:30', null, '0', '湛江港口', '334', '234', '2015-12-04 21:13:08', null, '', '1');
INSERT INTO `searecord` VALUES ('3', '1', '2015-12-04 17:13:30', '2015-12-05 17:13:30', null, null, null, null, null, '2015-12-04 17:14:12', null, '', '0');
INSERT INTO `searecord` VALUES ('4', '1', '2015-12-04 17:13:30', '2015-12-05 17:13:30', null, null, null, null, null, '2015-12-04 17:42:24', null, '', '0');
INSERT INTO `searecord` VALUES ('5', '1', '2015-12-04 17:13:30', '2015-12-05 17:13:30', null, '0', '湛江港口', '344.3', '238.4', '2015-12-04 17:55:56', null, '', '0');

-- ----------------------------
-- Table structure for `shipport`
-- ----------------------------
DROP TABLE IF EXISTS `shipport`;
CREATE TABLE `shipport` (
  `shipportId` bigint(20) NOT NULL AUTO_INCREMENT,
  `shipportName` varchar(255) DEFAULT NULL,
  `addresscode` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`shipportId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipport
-- ----------------------------
INSERT INTO `shipport` VALUES ('1', '湛江港口','1:1' ,'344.3', '238.4', '2015-12-04 15:33:33', null, '', '1');
INSERT INTO `shipport` VALUES ('2', '海口港口','1:1' ,'234.5', '3948.3', '2015-12-04 15:33:51', null, '', '1');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `shopName` varchar(255) DEFAULT NULL,
  `addresscode` varchar(255) DEFAULT NULL,
  `shopPhoto` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '1', '海格号','1:1' ,'shop/aaa.jpg', '[3]', '3', '3.81636', '3.64697', '4.00305', '0', '40.5', '', null, null, '', '5', '234.4', '344.6', null, '', '2015-11-17 11:18:57', '14');
INSERT INTO `shop` VALUES ('2', '2', '养殖户商店1','1:1', 'shop/aaa.jpg', '[4]', '5', '4.5', '4', '5', '1', '40.5', '', null, null, '广东海洋大学', null, '234.4', '344.6', null, '', '2015-11-17 11:18:57', '2');
INSERT INTO `shop` VALUES ('3', '3', '渔户商店1', '1:1','shop/aaa.jpg', '[4]', '5', '1', '4.5', '4.5', '0', '40.5', '', null, null, '', '3', '234.4', '344.6', null, '', '2015-11-17 11:18:57', '2');
INSERT INTO `shop` VALUES ('4', '4', '养殖户商店2','1:1', 'shop/aaa.jpg', '[2,3,4]', '5', '3.5', '1', '4', '1', '40.5', '', null, null, '广东海洋大学', null, '234.4', '344.6', null, '', '2015-11-17 11:18:57', '2');
INSERT INTO `shop` VALUES ('5', '5', '渔户商店2', '1:1','shop/aaa.jpg', '[4]', '5', '1.9', '3.2', '2', '0', '40.5', '', null, null, '', '5', '234.4', '344.6', null, '', '2015-11-17 11:18:57', '2');
INSERT INTO `shop` VALUES ('6', '6', '渔户商店3', '1:1','shop/aaa.jpg', '[4]', '5', '4.5', '4.8', '4.5', '0', '40.5', '', null, null, '', '1', '234.4', '344.6', null, '', '2015-11-17 11:18:57', '1');
INSERT INTO `shop` VALUES ('7', '7', '渔户商店4', '1:1','shop/aaa.jpg', '[4]', '5', '5', '4.6', '4', '0', '40.5', '', null, null, '', null, '234.4', '344.6', null, '', '2015-11-17 11:18:57', '1');
INSERT INTO `shop` VALUES ('8', '8', '渔户商店5', '1:1','shop/aaa.jpg', '[4]', '5', '4.5', '4.5', '3', '0', '40.5', '', null, null, '', '1', '234.4', '344.6', null, '', '2015-11-17 11:18:57', '1');

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
INSERT INTO `sku` VALUES ('1', '1', '中等大小', '3', '5', '2015-11-04 22:58:42', null, '', '1');
INSERT INTO `sku` VALUES ('2', '1', '大号', '4', '8', '2015-11-04 22:59:08', null, '', '1');
INSERT INTO `sku` VALUES ('3', '1', '小号', '2', '8', '2015-11-04 22:59:32', null, '', '1');

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
  `getAddressId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '易临风', 'e10adc3949ba59abbe56e057f20f883e', '18719425973', 'user/bbb.jpg', '2015-11-05 11:12:04', null, '', '1', '22');
INSERT INTO `user` VALUES ('2', '2', '1', '1', 'sdf', 'e10adc3949ba59abbe56e057f20f883e', '123123', 'user/bbb.jpg', '2015-12-05 21:21:08', null, '', '1', null);
INSERT INTO `user` VALUES ('4', '2', '4', '1', '詹命天子', 'e10adc3949ba59abbe56e057f20f883e', '18312687412', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '5', null);
INSERT INTO `user` VALUES ('5', '2', '1', '1', '詹命天子', '328499605', '18312687413', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1', '16');
INSERT INTO `user` VALUES ('6', '2', '2', '1', '詹命天子', 'e10adc3949ba59abbe56e057f20f883e', '18312687414', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1', '16');
INSERT INTO `user` VALUES ('7', '2', '3', '1', '詹命天子', 'e10adc3949ba59abbe56e057f20f883e', '18312687415', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1', '16');
INSERT INTO `user` VALUES ('8', '2', '4', '1', '詹命天子', 'e10adc3949ba59abbe56e057f20f883e', '18312687416', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1', '16');
INSERT INTO `user` VALUES ('9', '2', '5', '2', '詹命天子', 'e10adc3949ba59abbe56e057f20f883e', '18312687417', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1', '17');
INSERT INTO `user` VALUES ('10', '2', '6', '2', '詹命天子', 'e10adc3949ba59abbe56e057f20f883e', '1831268752', 'user/aaa.jpg', '2015-11-24 12:45:15', null, '', '1', '18');
INSERT INTO `user` VALUES ('12', '0', null, null, '15811707583', 'sidoubi2014', '15811707583', 'user/aaa.jpg', '2015-11-26 22:45:07', null, '', '0', null);
INSERT INTO `user` VALUES ('28', '0', null, null, '13763012723', 'e10adc3949ba59abbe56e057f20f883e', '13763012723', 'user/aaa.jpg', '2015-12-03 21:20:23', null, '', '0', '23');
INSERT INTO `user` VALUES ('32', '0', null, null, '18320489492', 'e10adc3949ba59abbe56e057f20f883e', '18320489492', 'user/ddd.jpg', '2015-12-05 21:14:41', null, '', '0', null);

-- ----------------------------
-- Table structure for `verifycode`
-- ----------------------------
DROP TABLE IF EXISTS `verifycode`;
CREATE TABLE `verifycode` (
  `verifycodeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `verifyCode` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creatorId` bigint(20) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`verifycodeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verifycode
-- ----------------------------
INSERT INTO `verifycode` VALUES ('4', '242109', '15811707583', '2015-11-26 12:08:17', null, '', '1');
INSERT INTO `verifycode` VALUES ('5', '744441', '13763012723', '2015-11-26 12:26:04', null, '', '4');
INSERT INTO `verifycode` VALUES ('6', '564395', '18312687412', '2015-11-26 12:32:21', null, '', '0');
INSERT INTO `verifycode` VALUES ('7', '652235', '18320489492', '2015-12-05 21:11:07', null, '', '0');
