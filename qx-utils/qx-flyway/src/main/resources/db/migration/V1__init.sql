/*
 Navicat Premium Data Transfer

 Source Server         : mysql01
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 123.207.242.177:3306
 Source Schema         : cloudyslife

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 21/04/2018 23:02:25
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '权限名',
  `module` int(11) NOT NULL DEFAULT 0 COMMENT '模块枚举值',
  `description` varchar(1000) COMMENT '描述',
  `key` varchar(255) NOT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `key`(`key`) USING BTREE,
  INDEX `module`(`module`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '用户权限表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)  NOT NULL COMMENT '角色名',
  `description` varchar(1000) COMMENT '描述',
  `created_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_role_id`(`id`) USING BTREE,
  UNIQUE INDEX `sys_role_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '角色表';

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` int(11),
  `sys_permission_id` int(11),
  `created_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_role_id`(`sys_role_id`) USING BTREE,
  INDEX `sys_permission_id`(`sys_permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '角色权限表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '姓名.',
  `username` varchar(255) NOT NULL COMMENT '用户名.',
  `phone` varchar(20) NOT NULL COMMENT '电话.',
  `email` varchar(255) COMMENT '电子邮件.',
  `password_encrypted` varchar(255) COMMENT '加密后的密码.',
  `identification` varchar(18) COMMENT '身份证.',
  `reset_password_token` varchar(255) COMMENT '重置密码的令牌.',
  `reset_password_sent_at` timestamp(0) COMMENT '令牌生成时间.',
  `sign_in_count` int(11) NOT NULL DEFAULT 0 COMMENT '累积登录次数.',
  `current_sign_in_at` timestamp(0) NULL DEFAULT NULL COMMENT '当前登录时间.',
  `last_sign_in_at` timestamp(0) NULL DEFAULT NULL COMMENT '上一次登录时间.',
  `created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `updated_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `current_token` varchar(1000) COMMENT '当前的认证令牌',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '用户表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` int(11) NOT NULL,
  `sys_user_id` int(11) NOT NULL,
  `created_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_user_id`(`sys_user_id`) USING BTREE,
  INDEX `sys_role_id`(`sys_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '用户角色关联表';

SET FOREIGN_KEY_CHECKS = 1;