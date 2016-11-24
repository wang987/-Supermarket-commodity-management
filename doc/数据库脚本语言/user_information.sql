/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : user_information

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-11-22 14:25:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Database structure for `user_information`
-- ----------------------------

CREATE DATABASE `user_information`;

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userinfoid` int(11) COLLATE utf8_unicode_ci NOT NULL AUTO_INCREMENT,
  `username` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userpassword` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `realname` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `school` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userinfoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of userinfo
-- ----------------------------


-- ----------------------------
-- Table structure for `adminlogin`
-- ----------------------------
DROP TABLE IF EXISTS `adminlogin`;
CREATE TABLE `adminlogin` (
  `adminname` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `adminpassword` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`adminname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of adminlogin
-- ----------------------------

