/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-10 00:57:05
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
INSERT INTO `project_group` VALUES ('3', '11', '11SS', '222', '2018-10-11 23:41:23');

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
INSERT INTO `project_group_user` VALUES ('2', '1', '0');
INSERT INTO `project_group_user` VALUES ('3', '1', '1');
INSERT INTO `project_group_user` VALUES ('1', '14', '0');
INSERT INTO `project_group_user` VALUES ('1', '15', '0');
INSERT INTO `project_group_user` VALUES ('1', '16', '0');
INSERT INTO `project_group_user` VALUES ('1', '13', '0');

-- ----------------------------
-- Table structure for project_task
-- ----------------------------
DROP TABLE IF EXISTS `project_task`;
CREATE TABLE `project_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '所属项目id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `task_no` varchar(10) DEFAULT NULL COMMENT '任务编号',
  `task_name` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `task_type` int(2) DEFAULT '1' COMMENT '任务类型（1大需求；2小需求；3bug）',
  `task_status` int(2) DEFAULT '0' COMMENT '任务类型（0待处理；1正在处理；2处理完成待测；3正在测试；4测试完成；5已上线；6挂起；7作废）',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父任务id',
  `task_remark` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `images` varchar(1000) DEFAULT NULL COMMENT '任务图片',
  `files` varchar(1000) DEFAULT NULL COMMENT '任务附件',
  `start_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务开始时间',
  `end_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务截止期限',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_task
-- ----------------------------
INSERT INTO `project_task` VALUES ('1', '1', 'sunlei', 'TEST1-0001', 'test1', '1', '0', null, '', '16款圆形人物头像矢量图_1540620750914.jpg;', '4610_1540620757633.rar;', '2018-10-28 00:00:00', '2018-10-28 00:00:00', 'admin', '2018-11-01 00:25:02');
INSERT INTO `project_task` VALUES ('2', '2', 'admin', 'TEST2-0001', 'test2', '3', '6', null, 'aaaaaaa', '', '', '2018-10-29 22:51:52', '2018-10-29 21:32:19', 'admin', '2018-10-29 22:51:52');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', '/console/list', 'console', '100', '1', '1', '<i class=\'layui-icon\'>&#xe614;</i>控制台', null, null);
INSERT INTO `u_permission` VALUES ('2', '/task/list', 'task', '200', '1', '1', '<i class=\'layui-icon\'>&#xe60a;</i>任务管理', null, null);
INSERT INTO `u_permission` VALUES ('3', '/console/userList', 'userManager', '110', '1', '2', '用户管理', null, '1');
INSERT INTO `u_permission` VALUES ('4', '/console/roleList', 'roleManager', '120', '1', '2', '角色管理', null, '1');
INSERT INTO `u_permission` VALUES ('5', null, 'addRole', '121', '0', '3', '新增', '增加角色', '4');
INSERT INTO `u_permission` VALUES ('7', '/console/projectList', 'projectManager', '130', '1', '2', '项目管理', null, '1');
INSERT INTO `u_permission` VALUES ('8', null, 'addUser', '111', '0', '3', '新增', '新增用户', '3');
INSERT INTO `u_permission` VALUES ('9', null, 'updateUser', '112', '0', '3', '修改', '修改用户', '3');
INSERT INTO `u_permission` VALUES ('10', null, 'deleteUser', '113', '0', '3', '删除', '删除用户', '3');
INSERT INTO `u_permission` VALUES ('11', null, 'updateRole', '122', '0', '3', '修改', '修改角色', '4');
INSERT INTO `u_permission` VALUES ('12', '', 'deleteRole', '123', '0', '3', '删除', '删除角色', '4');
INSERT INTO `u_permission` VALUES ('13', '', 'addProject', '131', '0', '3', '新增', '新增项目', '7');
INSERT INTO `u_permission` VALUES ('14', '', 'updateProject', '132', '0', '3', '修改', '修改项目', '7');
INSERT INTO `u_permission` VALUES ('15', '', 'deleteProject', '133', '0', '3', '删除', '删除项目', '7');
INSERT INTO `u_permission` VALUES ('16', '/task/taskList', 'taskManager', '210', '1', '2', '任务管理', null, '2');
INSERT INTO `u_permission` VALUES ('17', null, 'addTask', '211', '0', '3', '新增', '新增任务', '16');
INSERT INTO `u_permission` VALUES ('18', '', 'updateTask', '212', '0', '3', '修改', '修改任务', '16');

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
INSERT INTO `u_role_permission` VALUES ('1', '7');
INSERT INTO `u_role_permission` VALUES ('1', '8');
INSERT INTO `u_role_permission` VALUES ('1', '9');
INSERT INTO `u_role_permission` VALUES ('1', '10');
INSERT INTO `u_role_permission` VALUES ('1', '11');
INSERT INTO `u_role_permission` VALUES ('1', '12');
INSERT INTO `u_role_permission` VALUES ('1', '13');
INSERT INTO `u_role_permission` VALUES ('1', '14');
INSERT INTO `u_role_permission` VALUES ('1', '15');
INSERT INTO `u_role_permission` VALUES ('1', '16');
INSERT INTO `u_role_permission` VALUES ('1', '17');
INSERT INTO `u_role_permission` VALUES ('1', '18');
INSERT INTO `u_role_permission` VALUES ('4', '1');
INSERT INTO `u_role_permission` VALUES ('4', '3');
INSERT INTO `u_role_permission` VALUES ('4', '9');
INSERT INTO `u_role_permission` VALUES ('4', '10');
INSERT INTO `u_role_permission` VALUES ('4', '2');
INSERT INTO `u_role_permission` VALUES ('4', '16');
INSERT INTO `u_role_permission` VALUES ('4', '17');
INSERT INTO `u_role_permission` VALUES ('4', '18');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'admin', '2554353621@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-09-17 11:38:19', '/images/head/head1.png');
INSERT INTO `u_user` VALUES ('13', 'sunlei', '18271691804', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-11-01 00:13:40', '/images/head/head1.png');
INSERT INTO `u_user` VALUES ('14', '测试b', '110', 'e10adc3949ba59abbe56e057f20f883e', '0', '2018-11-01 22:51:06', '/images/head/head1.png');
INSERT INTO `u_user` VALUES ('15', '开发a', '120', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-10-14 20:36:23', '/images/head/head1.png');
INSERT INTO `u_user` VALUES ('16', '测试a', '119', 'e10adc3949ba59abbe56e057f20f883e', '1', '2018-10-14 21:34:11', '/images/head/head1.png');

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
INSERT INTO `u_user_role` VALUES ('14', '4');
INSERT INTO `u_user_role` VALUES ('15', '4');
INSERT INTO `u_user_role` VALUES ('16', '4');

-- ----------------------------
-- Table structure for wx_certificate
-- ----------------------------
DROP TABLE IF EXISTS `wx_certificate`;
CREATE TABLE `wx_certificate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(100) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '手机号',
  `certificate` varchar(255) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '认证信息',
  `CT` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(2) DEFAULT '0' COMMENT '0为未处理，1为已处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- ----------------------------
-- Records of wx_certificate
-- ----------------------------
INSERT INTO `wx_certificate` VALUES ('25', 'o5YJlxIHp1-FhHiLUsHd3JemzJjY', '18271691804', '123', '2018-01-10 23:39:31', '0');
INSERT INTO `wx_certificate` VALUES ('26', 'o5YJlxIkBCkc2JYw0ES-DqvXMmx4', '13018033359', '雅雅', '2018-01-17 21:46:49', '0');
INSERT INTO `wx_certificate` VALUES ('27', 'o5YJlxIHp1-FhHiLUsHd3JemzJjY', '18271691804', '孙磊', '2018-01-22 20:56:32', '0');

-- ----------------------------
-- Table structure for wx_msg
-- ----------------------------
DROP TABLE IF EXISTS `wx_msg`;
CREATE TABLE `wx_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '内容',
  `url` varchar(255) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '链接',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发送时间',
  `status` int(2) DEFAULT '0' COMMENT '状态1：查看，0：未查看',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- ----------------------------
-- Records of wx_msg
-- ----------------------------
INSERT INTO `wx_msg` VALUES ('1', '2', '认证信息', '有新的认证信息如下，请尽快处理：<br/>手机号：18271691804<br/>认证信息：孙磊', '/wxmsg/msgdetail?msgid=1', '2018-01-22 20:56:31', '0');

-- ----------------------------
-- Table structure for wx_service_menu
-- ----------------------------
DROP TABLE IF EXISTS `wx_service_menu`;
CREATE TABLE `wx_service_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(255) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '服务名',
  `service_img` varchar(500) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '图标',
  `service_url` varchar(500) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '服务链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- ----------------------------
-- Records of wx_service_menu
-- ----------------------------
INSERT INTO `wx_service_menu` VALUES ('1', '天气预报', '/images/service/weather.png', '/func/weather');

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(100) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '手机号',
  `wxname` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '微信昵称',
  `headimg` varchar(255) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '微信头像',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `login_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登录时间',
  `status` int(2) DEFAULT '0' COMMENT '0为未认证，1为已认证',
  `remark` varchar(255) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES ('2', 'o5YJlxIHp1-FhHiLUsHd3JemzJjY', '18271691804', '孙磊', null, '2018-01-22 21:32:24', '2018-01-22 21:32:24', '1', null);
INSERT INTO `wx_user` VALUES ('3', 'o5YJlxIkBCkc2JYw0ES-DqvXMmx4', null, null, null, '2018-01-17 21:47:26', '2018-01-17 21:47:26', '1', null);
INSERT INTO `wx_user` VALUES ('4', 'o5YJlxH0yHdyYvpElx6dbQgGjSf4', null, null, null, '2018-01-21 16:49:33', null, '0', null);

-- ----------------------------
-- Table structure for wx_user_service
-- ----------------------------
DROP TABLE IF EXISTS `wx_user_service`;
CREATE TABLE `wx_user_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户主键',
  `service_id` int(11) DEFAULT NULL COMMENT '服务主键',
  `service_sort` int(11) DEFAULT NULL COMMENT '服务排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- ----------------------------
-- Records of wx_user_service
-- ----------------------------
INSERT INTO `wx_user_service` VALUES ('1', '2', '1', '1');
