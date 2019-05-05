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
   status               int not null default 0 comment '�Ƿ�ɾ��  -1����ɾ��  0������',
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
   id                   int not null auto_increment comment '����ID',
   name                 varchar(32) not null comment '������',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int not null default 0 comment '0--���� -1--ɾ��',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   id                   int not null auto_increment comment '�˵�ID',
   parent_id            int comment '���˵�ID',
   menu_code            varchar(32) not null comment '�˵�Ȩ�ޱ�ʶ',
   path                 varchar(255) comment 'ǰ��URL',
   icon                 varchar(32) comment 'ͼ��',
   sort                 int comment '����ֵ',
   type                 int comment '�˵����� ��0�˵� 1��ť��',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int not null default 0 comment '0--���� -1--ɾ��',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_menu_lang                                         */
/*==============================================================*/
create table sys_menu_lang
(
   id                   int not null auto_increment comment '����ID',
   menu_id              int not null comment '�˵�ID',
   lang_id              int not null comment '����ID',
   name                 varchar(32) not null comment '�˵���',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   db_source            varchar(64),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int not null auto_increment comment '��ɫID',
   role_code            varchar(32) not null comment '��ɫ��',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int not null default 0 comment '1-������-1-ɾ��',
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
   name                 varchar(64) not null comment '��ɫ��',
   role_desc            varchar(255) comment '��ɫ����',
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
   id                   int not null auto_increment comment '����ID',
   role_id              int comment '��ɫID',
   dept_id              int comment '����ID',
   name                 varchar(32) comment '����',
   identification       varchar(255) comment '���֤',
   phone                varchar(20) not null comment '�绰',
   email                varchar(255) comment '����',
   avatar               varchar(255) comment 'ͷ��',
   status               int not null default 0 comment '0-������-1-����',
   user_name            varchar(255) comment '�û���',
   reset_password_token varchar(255) comment '���������token',
   password_encrypted   varchar(255) not null comment '���ܺ������',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�޸�ʱ��',
   current_token        varchar(255) comment '��ǰ��token',
   current_sign_in_at   timestamp not null default CURRENT_TIMESTAMP comment '��ǰ��¼ʱ��',
   last_sign_in_at      datetime default NULL comment '��һ�ε�¼ʱ��',
   sign_in_count        int not null default 0 comment '�ۻ���¼����',
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

