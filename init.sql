/*
Navicat MySQL Data Transfer

Source Server         : mytest
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-09 11:21:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for project_group
-- ----------------------------
DROP TABLE IF EXISTS `project_group`;
CREATE TABLE `project_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `project_no` varchar(50) DEFAULT NULL COMMENT '项目组编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '项目建立时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_group
-- ----------------------------
INSERT INTO `project_group` VALUES ('1', '测试1', 'TEST1', '测试项目1', '2018-10-02 21:13:23');
INSERT INTO `project_group` VALUES ('2', '打算呆', 'TEST2', '打算呆', '2018-10-02 22:44:54');
INSERT INTO `project_group` VALUES ('3', '11', '11SS', '111', '2018-10-02 22:46:03');

-- ----------------------------
-- Table structure for project_group_user
-- ----------------------------
DROP TABLE IF EXISTS `project_group_user`;
CREATE TABLE `project_group_user` (
  `gid` bigint(20) DEFAULT NULL COMMENT '项目组id',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户id',
  `is_admin` int(2) DEFAULT '0' COMMENT '是否为项目管理员'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_group_user
-- ----------------------------
INSERT INTO `project_group_user` VALUES ('1', '1', '1');
INSERT INTO `project_group_user` VALUES ('2', '1', '1');
INSERT INTO `project_group_user` VALUES ('3', '1', '1');

-- ----------------------------
-- Table structure for project_task
-- ----------------------------
DROP TABLE IF EXISTS `project_task`;
CREATE TABLE `project_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `task_type` int(2) DEFAULT '1' COMMENT '任务类型（1大需求；2小需求；3bug）',
  `task_status` int(2) DEFAULT '0' COMMENT '任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父任务id',
  `task_remark` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `images` varchar(1000) DEFAULT NULL COMMENT '任务图片',
  `docs` varchar(1000) DEFAULT NULL COMMENT '任务附件',
  `start_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务开始时间',
  `end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务截止期限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_task
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', '/console/list', 'console', '100', '1', '1', '<i class=\'layui-icon\'>&#xe614;</i>控制台', null, null);
INSERT INTO `u_permission` VALUES ('2', '/task/list', 'task', '200', '1', '1', '<i class=\'layui-icon\'>&#xe60a;</i>任务管理', null, null);
INSERT INTO `u_permission` VALUES ('3', '/console/userList', 'userManager', '110', '1', '2', '用户管理', null, '1');
INSERT INTO `u_permission` VALUES ('4', '/console/roleList', 'roleManager', '120', '1', '2', '角色管理', null, '1');
INSERT INTO `u_permission` VALUES ('5', null, 'addRole', '121', '0', '3', '新增', '增加角色', '4');
INSERT INTO `u_permission` VALUES ('6', '/console/taskList', null, null, null, null, null, null, null);
INSERT INTO `u_permission` VALUES ('7', '/console/projectList', 'projectManager', '130', '1', '2', '项目管理', null, '1');

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  `level` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', '管理员', null, '1');
INSERT INTO `u_role` VALUES ('4', '小组长', null, '1');

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
INSERT INTO `u_role_permission` VALUES ('1', '2');
INSERT INTO `u_role_permission` VALUES ('4', '1');
INSERT INTO `u_role_permission` VALUES ('4', '3');
INSERT INTO `u_role_permission` VALUES ('4', '2');
INSERT INTO `u_role_permission` VALUES ('1', '7');

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
  `head_img` varchar(255) DEFAULT '/images/head/head1.png' COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'admin', '2554353621@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-09-17 11:38:19', '/images/head/head1.png');
INSERT INTO `u_user` VALUES ('13', 'sunlei', '18271691804', 'e10adc3949ba59abbe56e057f20f883e', '0', '2018-09-18 09:48:33', '/images/head/head1.png');

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
INSERT INTO `u_user_role` VALUES ('13', '4');
