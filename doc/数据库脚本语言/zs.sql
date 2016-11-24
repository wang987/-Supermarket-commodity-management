/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : zs

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-11-22 14:24:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Database structure for `zs`
-- ----------------------------

CREATE DATABASE `zs`;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` int(11) COLLATE utf8_unicode_ci NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `bid` decimal(20,2) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `profit` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `productsales`
-- ----------------------------
DROP TABLE IF EXISTS `productsales`;
CREATE TABLE `productsales` (
  `productsalesid` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salesid` int(11) DEFAULT NULL,
  PRIMARY KEY (`productsalesid`),
  FOREIGN KEY (`productid`) REFERENCES `product` (`productid`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`salesid`) REFERENCES `sales` (`salesid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of productsales
-- ----------------------------

-- ----------------------------
-- Table structure for `sales`
-- ----------------------------
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `salesid` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `salecount` int(11) DEFAULT NULL,
  PRIMARY KEY (`salesid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sales
-- ----------------------------
