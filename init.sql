/*
Navicat MySQL Data Transfer

Source Server         : lei
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-20 21:42:23
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
  `level` int(2) DEFAULT NULL COMMENT '角色等级',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', '管理员', null, null);
INSERT INTO `u_role` VALUES ('4', '小组长', null, null);
INSERT INTO `u_role` VALUES ('5', 'aaa', null, null);
INSERT INTO `u_role` VALUES ('6', 'bbb', null, null);
INSERT INTO `u_role` VALUES ('7', '踩踩踩', null, null);
INSERT INTO `u_role` VALUES ('8', 'ddd', null, null);
INSERT INTO `u_role` VALUES ('9', '11111vcv', null, null);
INSERT INTO `u_role` VALUES ('10', '阿瑟东', null, null);
INSERT INTO `u_role` VALUES ('11', '持续', null, null);

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
INSERT INTO `u_role_permission` VALUES ('1', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'admin', null, 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-09-16 01:44:32');
INSERT INTO `u_user` VALUES ('15', '孙磊', '18271691804', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-09-16 01:45:06');
INSERT INTO `u_user` VALUES ('19', 'dddd', '', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-09-16 01:57:43');
INSERT INTO `u_user` VALUES ('20', '跌多', '', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-09-18 22:35:58');

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
INSERT INTO `u_user_role` VALUES ('1', '1');
INSERT INTO `u_user_role` VALUES ('15', '4');
INSERT INTO `u_user_role` VALUES ('19', '7');
INSERT INTO `u_user_role` VALUES ('20', '4');
