/*
Navicat MySQL Data Transfer

Source Server         : mytest
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-26 18:19:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for project_task
-- ----------------------------
DROP TABLE IF EXISTS `project_task`;
CREATE TABLE `project_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(20) DEFAULT NULL COMMENT '项目编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `task_no` varchar(10) DEFAULT NULL COMMENT '任务编号',
  `task_name` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `task_type` int(2) DEFAULT '1' COMMENT '任务类型（1大需求；2小需求；3bug）',
  `task_status` int(2) DEFAULT '0' COMMENT '任务类型（0待审核；1待处理；2处理完成待测；3测试完成；4已上线；5挂起；6作废）',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父任务id',
  `task_remark` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `images` varchar(1000) DEFAULT NULL COMMENT '任务图片',
  `files` varchar(1000) DEFAULT NULL COMMENT '任务附件',
  `start_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务开始时间',
  `end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '任务截止期限',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
