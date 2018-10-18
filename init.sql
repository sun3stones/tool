/*
Navicat MySQL Data Transfer

Source Server         : lei
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-18 23:53:20
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

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
INSERT INTO `u_permission` VALUES ('15', '', 'daleteProject', '133', '0', '3', '删除', '删除项目', '7');

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
INSERT INTO `u_role_permission` VALUES ('4', '1');
INSERT INTO `u_role_permission` VALUES ('4', '3');
INSERT INTO `u_role_permission` VALUES ('4', '9');
INSERT INTO `u_role_permission` VALUES ('4', '10');
INSERT INTO `u_role_permission` VALUES ('4', '2');
INSERT INTO `u_role_permission` VALUES ('1', '8');
INSERT INTO `u_role_permission` VALUES ('1', '9');
INSERT INTO `u_role_permission` VALUES ('1', '10');
INSERT INTO `u_role_permission` VALUES ('1', '11');
INSERT INTO `u_role_permission` VALUES ('1', '12');
INSERT INTO `u_role_permission` VALUES ('1', '13');
INSERT INTO `u_role_permission` VALUES ('1', '14');
INSERT INTO `u_role_permission` VALUES ('1', '15');
