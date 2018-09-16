/*
Navicat MySQL Data Transfer

Source Server         : lei
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-09 23:06:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for u_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `is_menu` int(1) DEFAULT NULL COMMENT '是否为菜单',
  `level` int(1) DEFAULT NULL COMMENT '级别',
  `content` varchar(500) DEFAULT NULL COMMENT '页面内容',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', '/console/list', 'console', '100', '1', '1', '<i class=\'layui-icon\'>&#xe614;</i>控制台', null, null);
INSERT INTO `u_permission` VALUES ('2', '/task/list', 'task', '200', '1', '1', '<i class=\'layui-icon\'>&#xe60a;</i>任务管理', null, null);
INSERT INTO `u_permission` VALUES ('3', '/console/userList', 'usermanager', '110', '1', '2', '用户管理', null, '1');
INSERT INTO `u_permission` VALUES ('4', '/console/roleList', 'rolemanager', '120', '1', '2', '角色管理', null, '1');
INSERT INTO `u_permission` VALUES ('5', null, 'addrole', '121', '0', '3', '新增', '增加角色', '4');

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', '管理员', null);
INSERT INTO `u_role` VALUES ('4', '小组长', null);
INSERT INTO `u_role` VALUES ('5', 'aaa', null);
INSERT INTO `u_role` VALUES ('6', 'bbb', null);
INSERT INTO `u_role` VALUES ('7', '踩踩踩', null);
INSERT INTO `u_role` VALUES ('8', 'ddd', null);
INSERT INTO `u_role` VALUES ('9', '11111vcv', null);
INSERT INTO `u_role` VALUES ('10', '阿瑟东', null);
INSERT INTO `u_role` VALUES ('11', '持续', null);
INSERT INTO `u_role` VALUES ('12', '宝宝v', null);
INSERT INTO `u_role` VALUES ('13', '复古风格', null);

-- ----------------------------
-- Table structure for u_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES ('1', '1');
INSERT INTO `u_role_permission` VALUES ('1', '3');
INSERT INTO `u_role_permission` VALUES ('1', '4');
INSERT INTO `u_role_permission` VALUES ('1', '5');
INSERT INTO `u_role_permission` VALUES ('4', '1');
INSERT INTO `u_role_permission` VALUES ('4', '3');
INSERT INTO `u_role_permission` VALUES ('4', '4');
INSERT INTO `u_role_permission` VALUES ('4', '5');

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  `login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', '管理员', 'admin', 'df655ad8d3229f3269fad2a8bab59b6c', '1', '2018-07-21 17:12:06');
INSERT INTO `u_user` VALUES ('2', 'admin', '2554353621@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-07-24 23:37:38');
INSERT INTO `u_user` VALUES ('11', 'soso', '8446666@qq.com', 'd57ffbe486910dd5b26d0167d034f9ad', '1', '2018-07-21 17:12:06');
INSERT INTO `u_user` VALUES ('12', '8446666', '8446666', '4afdc875a67a55528c224ce088be2ab8', '1', '2018-07-21 17:12:06');

-- ----------------------------
-- Table structure for u_user_role
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES ('2', '1');
