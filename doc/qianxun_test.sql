/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 123.207.242.177:3306
 Source Schema         : qianxun_test

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 30/07/2018 10:22:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` int(20) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (11, NULL, 'qwqeqe', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单权限标识',
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端URL',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'VUE页面组件名',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int(11) NULL DEFAULT 1 COMMENT '排序值',
  `type` int(11) NULL DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '0--正常 1--删除',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, NULL, '系统设置', 'SYSTEM', '', NULL, 'icon-system', 1, NULL, '2018-07-02 03:33:58', '2018-07-03 12:30:07', NULL);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'USER', '/admin/user', NULL, 'icon-yonghushezhi', 1, NULL, '2018-07-01 07:21:53', '2018-07-03 08:21:35', NULL);
INSERT INTO `sys_menu` VALUES (3, 2, '添加用户', 'USER_ADD', NULL, NULL, NULL, 1, 1, '2018-07-01 07:31:47', '2018-07-02 03:34:11', NULL);
INSERT INTO `sys_menu` VALUES (4, 2, '删除用户', 'USER_DEL', NULL, NULL, NULL, 1, 1, '2018-07-01 07:34:52', '2018-07-02 12:15:07', NULL);
INSERT INTO `sys_menu` VALUES (5, 2, '修改用户', 'USER_UPDATE', NULL, NULL, NULL, 1, 1, '2018-07-01 07:35:41', '2018-07-02 03:34:14', NULL);
INSERT INTO `sys_menu` VALUES (6, 2, '重置密码', 'USER_RESET', NULL, NULL, NULL, 1, 1, '2018-07-01 07:39:30', '2018-07-02 03:34:15', NULL);
INSERT INTO `sys_menu` VALUES (7, 2, '冻结用户', 'USER_FREEZE', NULL, NULL, NULL, 1, 1, '2018-07-01 07:42:47', '2018-07-02 03:34:16', NULL);
INSERT INTO `sys_menu` VALUES (8, 2, '解除冻结用户', 'USER_UNFREEZE', NULL, NULL, NULL, 1, 1, '2018-07-01 07:43:22', '2018-07-02 03:34:18', NULL);
INSERT INTO `sys_menu` VALUES (9, 2, '分配角色', 'USER_SETROLES', NULL, NULL, NULL, 1, 1, '2018-07-01 07:44:01', '2018-07-02 03:34:21', NULL);
INSERT INTO `sys_menu` VALUES (10, 1, '角色管理', 'ROLE', '/admin/role', NULL, 'icon-jueseguanli', 1, NULL, '2018-07-01 07:23:04', '2018-07-03 12:40:58', NULL);
INSERT INTO `sys_menu` VALUES (11, 1, '菜单管理', 'MENU', '/admin/menu', NULL, 'icon-caidanshezhi', 1, NULL, '2018-07-01 07:24:05', '2018-07-03 12:41:06', NULL);
INSERT INTO `sys_menu` VALUES (12, 1, '部门管理', 'DEPT', '/admin/dept', NULL, 'icon-bumenguanli', 1, NULL, '2018-07-05 10:15:31', '2018-07-05 10:17:23', NULL);
INSERT INTO `sys_menu` VALUES (13, 1, '日志管理', 'LOG', '/admin/log', NULL, 'icon-rizhiguanli', 1, NULL, '2018-07-05 10:27:42', '2018-07-05 10:29:26', NULL);
INSERT INTO `sys_menu` VALUES (14, NULL, '代码生成器', 'CODE', '/code', NULL, 'icon-daimashengchengqi', 1, NULL, '2018-07-05 10:31:26', NULL, NULL);
INSERT INTO `sys_menu` VALUES (15, 14, '配置模板', 'COED_TEMP', '/code/temp', NULL, 'icon-peizhimuban', 1, NULL, '2018-07-05 10:32:50', '2018-07-05 10:33:57', NULL);
INSERT INTO `sys_menu` VALUES (16, 14, '代码生成', 'CODE_GENERATE', '/code/generate', NULL, 'icon-code', 1, NULL, '2018-07-05 10:35:19', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名',
  `role_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色码',
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色描述',
  `created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `status` int(11) NULL DEFAULT NULL COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_idx1_role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROLE_ADMIN', '超级管理员，拥有所有权限', '2018-06-29 09:29:55', '2018-06-29 13:16:35', NULL);
INSERT INTO `sys_role` VALUES (2, '测试', 'ROLE_TEST', NULL, '2018-07-01 07:08:19', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与部门对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `identification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `status` int(11) NULL DEFAULT NULL COMMENT '0-正常，-1-冻结',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `reset_password_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重置密码的token',
  `password_encrypted` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密后的密码',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `current_token` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前的token',
  `current_sign_in_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前登录时间',
  `last_sign_in_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上一次登录时间',
  `sign_in_count` int(11) NOT NULL COMMENT '累积登录次数',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 1, '张云鹏', NULL, '123456', '314705487@qq.com', '/images/head.jpg', NULL, 'cloudy', NULL, '$2a$10$tdBj8lS.GW8BlvfgHQfv6es0y0rzMK0UvM35oyd7DsmKacas7vBba', NULL, '2018-07-06 18:44:20', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjM0NTYiLCJ1c2VyX2lkIjoxLCJleHAiOjE1MzE1MDc0NTksImlhdCI6MTUzMDkwMjY1OX0.RH5WoNXDdR2-eH0iZGQIGlUZP-84rNLJDUTn6Y-PPdSJxZT9beB82rAJZ5tbgJehVxIqNsNnu0XOhWwx7Ur3pw', '2018-07-06 18:44:20', '2018-07-06 03:42:52', 118);
INSERT INTO `sys_user` VALUES (2, 2, '测试账号', NULL, '15223246130', NULL, '/images/test.jpg', 1, NULL, NULL, '$2a$10$KsNCGzkDxjl.K.xRD/OBMetLwBFbKNrnrlijq0TA5J/Mdov5OZCtG', NULL, '2018-07-06 03:11:03', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTIyMzI0NjEzMCIsInVzZXJfaWQiOjIsImV4cCI6MTUzMTQ1MTQ2MCwiaWF0IjoxNTMwODQ2NjYwfQ.AR-1X7IfMiQeFGP3XEGD2AYdCkzQhgaenqOtA5WmjtDmQM5_B60k6CsXP7vLlbhyuhA8jFtmKIyCEKfJ9yebYQ', '2018-07-06 03:11:03', '2018-07-06 02:46:55', 5);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
