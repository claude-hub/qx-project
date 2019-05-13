/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/13 1:28:52                            */
/*==============================================================*/


drop table if exists sys_dept;

drop table if exists sys_dept_lang;

drop table if exists sys_dept_role;

drop table if exists sys_lang;

drop table if exists sys_log;

drop table if exists sys_menu;

drop table if exists sys_menu_lang;

drop table if exists sys_oauth_client_details;

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
   parent_id            int default 0,
   sort                 int,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted              int default 0 comment '�Ƿ�ɾ��  -1����ɾ��  0������',
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
   primary key (id)
);

/*==============================================================*/
/* Table: sys_lang                                              */
/*==============================================================*/
create table sys_lang
(
   id                   int not null auto_increment comment '����ID',
   name                 varchar(32) not null comment '������',
   lang_code            varchar(255) not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   deleted              int default 0 comment '0--���� -1--ɾ��',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   bigint not null auto_increment,
   type                 char(1) comment '��־����',
   title                varchar(255) comment '��־����',
   service_id           varchar(64) comment '����ID',
   create_by            varchar(64) comment '������',
   created_at           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   ip_addr              varchar(64) comment '����IP��ַ',
   request_uri          varchar(255) comment '����URI',
   method               varchar(32) comment '������ʽ',
   params               text comment '�����ύ������',
   time                 bigint comment 'ִ��ʱ��',
   exception            text comment '�쳣��Ϣ',
   deleted              int default 0 comment '1-������-1-ɾ��',
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
   deleted              int default 0 comment '0--���� -1--ɾ��',
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
   primary key (id)
);

/*==============================================================*/
/* Table: sys_oauth_client_details                              */
/*==============================================================*/
create table sys_oauth_client_details
(
   client_id            varchar(255) not null,
   resource_ids         varchar(255),
   client_secret        varchar(255),
   scope                varchar(255),
   authorized_grant_types varchar(255),
   web_server_redirect_uri varchar(255),
   authorities          varchar(255),
   access_token_validity int(11),
   refresh_token_validity int(11),
   additional_information varchar(255),
   autoapprove          varchar(255),
   primary key (client_id)
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
   deleted              int default 0 comment '1-������-1-ɾ��',
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
   locked               int default 0 comment '0-������-1-����',
   deleted              int default 0 comment '0-������-1-����',
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
   primary key (id)
);

