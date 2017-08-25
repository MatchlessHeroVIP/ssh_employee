/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : ssh_employee

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-08-25 10:35:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ddesc` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('3', '部门333', '管理部门3。。。');
INSERT INTO `department` VALUES ('5', '部门5', '管理部门5。。。');
INSERT INTO `department` VALUES ('6', '部门6', '管理部门6。。。');
INSERT INTO `department` VALUES ('7', '部门7', '管理部门7。。。');
INSERT INTO `department` VALUES ('8', '企划部', '做一些企业sdsfdsfdfasdfd手动阀手动阀');
INSERT INTO `department` VALUES ('9', '发', '士大夫');
INSERT INTO `department` VALUES ('11', '是', '身份');
INSERT INTO `department` VALUES ('12', 'sfdasd', 'fsdfasd');
INSERT INTO `department` VALUES ('13', '教学部', '教学');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `brithday` datetime DEFAULT NULL,
  `joinDate` datetime DEFAULT NULL,
  `eno` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `dno` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FK4722E6AE1EA6B5AB` (`dno`),
  CONSTRAINT `FK4722E6AE1EA6B5AB` FOREIGN KEY (`dno`) REFERENCES `department` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('2', '张三', '男', '2017-01-04 14:46:08', '2017-08-24 14:46:21', '2015215231', 'zs', '123', '3');
INSERT INTO `employee` VALUES ('4', '123', '男', '2017-01-04 14:46:08', '2017-01-04 14:46:08', '1231231231', '123', '123', '3');
INSERT INTO `employee` VALUES ('5', '111', '女', '2017-01-04 14:46:08', '2017-01-04 14:46:08', '212312312312', '111', '111', '5');
INSERT INTO `employee` VALUES ('6', '222', '女', '2017-01-04 14:46:08', '2017-01-04 14:46:08', '12312312', '222', '222', '7');
INSERT INTO `employee` VALUES ('7', '333', '男', '2017-01-04 14:46:08', '2017-01-19 14:46:08', '213123123', '333', '333', '9');
INSERT INTO `employee` VALUES ('8', '444', '女', '2017-01-04 14:46:08', '2017-08-16 14:50:16', '343242342', '444', '444', '5');
INSERT INTO `employee` VALUES ('12', '666', '男', '2017-02-12 00:00:00', '2017-12-12 00:00:00', '666666', null, null, '5');
INSERT INTO `employee` VALUES ('13', '梁文祥', '男', '1997-08-22 00:00:00', '2017-08-23 00:00:00', '2015208019', null, null, '8');
INSERT INTO `employee` VALUES ('14', '梁文祥', '男', '2016-08-16 00:00:00', '2017-08-23 00:00:00', '2015208019', null, null, '7');
INSERT INTO `employee` VALUES ('15', '梁文祥', '女', '2016-08-16 00:00:00', '2017-08-23 00:00:00', '2015208019', null, null, '3');
INSERT INTO `employee` VALUES ('17', '张三', '女', '2017-01-04 00:00:00', '2017-08-24 00:00:00', '2015215231', null, null, '3');
INSERT INTO `employee` VALUES ('18', '666', '男', '1997-08-22 00:00:00', '2017-08-23 00:00:00', '666666', null, null, '3');
