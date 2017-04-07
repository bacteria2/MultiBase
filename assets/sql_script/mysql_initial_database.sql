/*
Navicat MySQL Data Transfer

Source Server         : ydp.winserver
Source Server Version : 50714
Source Host           : ydp.winserver:3306
Source Database       : multi-base

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-04-07 10:34:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `multi_demo_orgnization`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_orgnization`;
CREATE TABLE `multi_demo_orgnization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '组织名称',
  `priority` tinyint(4) NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `parent_id` bigint(20) NOT NULL COMMENT '父id',
  `status` tinyint(4) NOT NULL COMMENT '状态: 0:禁用 1:启用 2:废弃',
  `number` varchar(50) NOT NULL DEFAULT '' COMMENT '组织编号',
  `create_time` datetime NOT NULL DEFAULT now(),
  `update_time` datetime NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_orgnization
-- ----------------------------

-- ----------------------------
-- Table structure for `multi_demo_resource`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_resource`;
CREATE TABLE `multi_demo_resource` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(255) NOT NULL DEFAULT '',
  `priority` varchar(255) NOT NULL DEFAULT '',
  `parent_id` smallint(6) NOT NULL DEFAULT '0',
  `permission` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `multi_demo_role`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_role`;
CREATE TABLE `multi_demo_role` (
  `id` bigint(20) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0' COMMENT '0,1,2,3,4,5,6类型',
  `decription` varchar(255) NOT NULL DEFAULT '' COMMENT '角色说明',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_role
-- ----------------------------
INSERT INTO `multi_demo_role` VALUES ('1', '0', '', '0', '2017-04-07 10:26:09', '2017-04-07 10:26:16');

-- ----------------------------
-- Table structure for `multi_demo_user`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_user`;
CREATE TABLE `multi_demo_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `username` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '',
  `salt` varchar(50) NOT NULL DEFAULT '',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0:禁用,1:启用,2:停用,3:异常,4:ban',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `mobile` int(18) NOT NULL DEFAULT '0' COMMENT '用户手机号',
  `nickName` varchar(50) NOT NULL COMMENT '用户昵称',
  `last_login_ip` varchar(50) NOT NULL DEFAULT '0.0.0.0',
  `last_login_time` datetime NOT NULL,
  `creat_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_user
-- ----------------------------

