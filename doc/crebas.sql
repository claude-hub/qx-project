/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/4/27 9:40:56                            */
/*==============================================================*/


drop table if exists sys_dept;

drop table if exists sys_dept_lang;

drop table if exists sys_dept_role;

drop table if exists sys_lang;

drop table if exists sys_menu;

drop table if exists sys_menu_lang;

drop table if exists sys_role;

drop table if exists sys_role_lang;

drop table if exists sys_role_menu;

drop table if exists sys_user;

drop table if exists sys_user_menu;

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   id                   int not null auto_increment,
   parent_id            int not null default 0,
   sort                 int,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   status               int not null default 0 comment '是否删除  -1：已删除  0：正常',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_dept_lang                                         */
/*==============================================================*/
create table sys_dept_lang
(
   id                   int not null auto_increment,
   dept_id              int not null,
   lang_id              int not null,
   name                 varchar(64) not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_dept_role                                         */
/*==============================================================*/
create table sys_dept_role
(
   id                   int not null auto_increment,
   dept_id              int not null,
   role_id              int not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_lang                                              */
/*==============================================================*/
create table sys_lang
(
   id                   int not null auto_increment comment '主键ID',
   name                 varchar(32) not null comment '语言名',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int not null default 0 comment '0--正常 -1--删除',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   id                   int not null auto_increment comment '菜单ID',
   parent_id            int comment '父菜单ID',
   menu_code            varchar(32) not null comment '菜单权限标识',
   path                 varchar(255) comment '前端URL',
   icon                 varchar(32) comment '图标',
   sort                 int comment '排序值',
   type                 int comment '菜单类型 （0菜单 1按钮）',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int not null default 0 comment '0--正常 -1--删除',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_menu_lang                                         */
/*==============================================================*/
create table sys_menu_lang
(
   id                   int not null auto_increment comment '主键ID',
   menu_id              int not null comment '菜单ID',
   lang_id              int not null comment '语言ID',
   name                 varchar(32) not null comment '菜单名',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int not null auto_increment comment '角色ID',
   role_code            varchar(32) not null comment '角色码',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int not null default 0 comment '1-正常，-1-删除',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role_lang                                         */
/*==============================================================*/
create table sys_role_lang
(
   id                   int not null auto_increment,
   role_id              int not null,
   lang_id              int not null,
   name                 varchar(64) not null comment '角色名',
   role_desc            varchar(255) comment '角色描述',
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   id                   int not null auto_increment,
   role_id              int not null,
   menu_id              int not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   int not null auto_increment comment '主键ID',
   role_id              int comment '角色ID',
   dept_id              int comment '部门ID',
   name                 varchar(32) comment '姓名',
   identification       varchar(255) comment '身份证',
   phone                varchar(20) not null comment '电话',
   email                varchar(255) comment '邮箱',
   avatar               varchar(255) comment '头像',
   status               int not null default 0 comment '0-正常，-1-冻结',
   user_name            varchar(255) comment '用户名',
   reset_password_token varchar(255) comment '重置密码的token',
   password_encrypted   varchar(255) not null comment '加密后的密码',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   current_token        varchar(255) comment '当前的token',
   current_sign_in_at   timestamp not null default CURRENT_TIMESTAMP comment '当前登录时间',
   last_sign_in_at      datetime default NULL comment '上一次登录时间',
   sign_in_count        int not null default 0 comment '累积登录次数',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_user_menu                                         */
/*==============================================================*/
create table sys_user_menu
(
   id                   int not null auto_increment,
   user_id              int not null,
   menu_id              int not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   db_source            varchar(64),
   primary key (id)
);

