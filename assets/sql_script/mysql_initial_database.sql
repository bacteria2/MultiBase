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
DROP TABLE IF EXISTS `multi_demo_organization`;
CREATE TABLE `multi_demo_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `priority` tinyint(4) NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父id',
  `root_path` varchar (255) NOT NULL DEFAULT '' COMMENT '树路径 ' ,
  `status` tinyint(4) NOT NULL  DEFAULT '0' COMMENT '状态: 0:禁用 1:启用 2:废弃 3:登录异常' ,
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `number` varchar(50) NOT NULL DEFAULT '' COMMENT '编号',
  `creator`  varchar(60) NOT NULL DEFAULT '' COMMENT '创建者',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
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
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '资源名',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '资源类型 1:url,2:按钮 ',
  `priority` int(255) NOT NULL DEFAULT '0' COMMENT'排序',
  `parent_id` smallint(6) NOT NULL DEFAULT '0',
  `permission` varchar(255) NOT NULL DEFAULT '权限等级',
  `resource` varchar(255) NOT NULL DEFAULT '资源定义',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态: 0:禁用 1:启用 2:废弃',
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `creator` varchar(60) NOT NULL DEFAULT '' COMMENT '创建者',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
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
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `name` VARCHAR(60) not NULL DEFAULT '' COMMENT '角色名称',
  `role` int(11) NOT NULL DEFAULT '0' COMMENT '0,1,2,3,4,5,6类型',
  `decription` varchar(255) NOT NULL DEFAULT '' COMMENT '角色说明',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:',
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `creator` varchar(60) NULL DEFAULT '' COMMENT '创建者',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_role
-- ----------------------------

-- ----------------------------
-- Table structure for `multi_demo_user`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_user`;
CREATE TABLE `multi_demo_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `username` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '用户密码',
  `salt` varchar(50) NOT NULL DEFAULT '' ,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0:禁用,1:启用,2:停用,3:异常,4:ban',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `mobile` varchar(40) NOT NULL DEFAULT '0' COMMENT '用户手机号',
  `nickName` varchar(50) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `person_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `last_login_ip` varchar(50) NOT NULL DEFAULT '0.0.0.0' COMMENT '最后一次登录IP',
  `last_login_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次登录时间',
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `creator` varchar(60) NULL DEFAULT '' COMMENT '创建者',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_user
-- ----------------------------



-- ----------------------------
-- Table structure for `multi_demo_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_role_resource`;
CREATE TABLE `multi_demo_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `role_id` varchar(60) NOT NULL DEFAULT ''  COMMENT '角色ID',
  `resource_id` varchar(60) NOT NULL DEFAULT '' COMMENT'资源ID',
  `creator` varchar(60) NULL DEFAULT '' COMMENT '创建者',
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_role_resource
-- ----------------------------


-- ----------------------------
-- Table structure for `multi_demo_user_resource_deny`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_role_resource`;
CREATE TABLE `multi_demo_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `user_id` varchar(60) NOT NULL DEFAULT ''  COMMENT '用户ID',
  `resource_id` varchar(60) NOT NULL DEFAULT '' COMMENT'资源ID',
  `creator` varchar(60) NULL DEFAULT '' COMMENT '创建者',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_user_resource_deny
-- ----------------------------


-- ----------------------------
-- Table structure for `multi_demo_user_resource_permit`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_role_resource`;
CREATE TABLE `multi_demo_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `user_id` varchar(60) NOT NULL DEFAULT ''  COMMENT '用户ID',
  `resource_id` varchar(60) NOT NULL DEFAULT '' COMMENT'资源ID',
  `creator` varchar(60) NULL DEFAULT '' COMMENT '创建者',
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_user_resource_permit
-- ----------------------------


-- ----------------------------
-- Table structure for `multi_demo_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `multi_demo_user_role`;
CREATE TABLE `multi_demo_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `role_id` varchar(60) NOT NULL DEFAULT ''  COMMENT '角色ID',
  `user_id` varchar(60) NOT NULL DEFAULT ''  COMMENT '用户ID',
  `creator` varchar(60) NULL DEFAULT '' COMMENT '创建者',
  `deleted` INT(4) NOT NULL  DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  `last_modifier`  varchar(60) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
  `create_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970/1/1 0:00:00' COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of multi_demo_user_role
-- ----------------------------
