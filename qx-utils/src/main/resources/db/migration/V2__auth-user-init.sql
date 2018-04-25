SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
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
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)  NOT NULL COMMENT '角色名',
  `description` varchar(1000) COMMENT '描述',
  `created_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_role_id`(`id`) USING BTREE,
  UNIQUE INDEX `auth_role_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '角色表';

-- ----------------------------
-- Table structure for auth_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_permission`;
CREATE TABLE `auth_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_role_id` int(11),
  `auth_permission_id` int(11),
  `created_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `auth_role_id`(`auth_role_id`) USING BTREE,
  INDEX `auth_permission_id`(`auth_permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '角色权限表';

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
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
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_role_id` int(11) NOT NULL,
  `auth_user_id` int(11) NOT NULL,
  `created_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `auth_user_id`(`auth_user_id`) USING BTREE,
  INDEX `auth_role_id`(`auth_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '用户角色关联表';

SET FOREIGN_KEY_CHECKS = 1;