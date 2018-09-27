/*
Navicat MySQL Data Transfer

Source Server         : lei
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-28 00:03:19
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
