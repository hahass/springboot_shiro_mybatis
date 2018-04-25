DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_sys_resource`;
CREATE TABLE `t_sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  `iconcls` varchar(100) DEFAULT NULL,
  `DISPLAY_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_sys_resource_parent_ids` (`parent_ids`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_sys_user_login`;
CREATE TABLE `t_sys_user_login` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `ip_addr` varchar(50) DEFAULT NULL COMMENT '登录IP',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `logout_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '退出时间',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户编号',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户角色';

DROP TABLE IF EXISTS `t_sys_role_resource`;
CREATE TABLE `t_sys_role_resource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色编号',
  `RESOURCE_ID` int(11) DEFAULT NULL COMMENT '资源编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';
/*密码：123456*/
INSERT INTO `t_sys_user` (`username`, `password`, `salt`, `locked`) VALUES ('admin', 'ab19a11b74b01786fce6fd2e8bfa412d', 'b56eae846a5c43d2c462b336400bb5ba', NULL);
INSERT INTO `t_sys_role` (`role_name`, `description`, `available`) VALUES ('admin', '超级管理员', '1');
INSERT INTO `t_sys_resource` (`name`, `type`, `url`, `parent_id`, `parent_ids`, `permission`, `available`, `iconcls`, `DISPLAY_ORDER`) VALUES ('权限管理', 'menu', '', '0', '', NULL, '0', 'ace-icon glyphicon glyphicon-user', '4');
INSERT INTO `t_sys_resource` (`name`, `type`, `url`, `parent_id`, `parent_ids`, `permission`, `available`, `iconcls`, `DISPLAY_ORDER`) VALUES ('用户管理', 'menu', '/admin/user', '1', '0/1/', NULL, '1', '', '1');
INSERT INTO `t_sys_resource` (`name`, `type`, `url`, `parent_id`, `parent_ids`, `permission`, `available`, `iconcls`, `DISPLAY_ORDER`) VALUES ('角色管理', 'menu', '/admin/role', '1', '0/1/', NULL, '1', '', '2');
INSERT INTO `t_sys_resource` (`name`, `type`, `url`, `parent_id`, `parent_ids`, `permission`, `available`, `iconcls`, `DISPLAY_ORDER`) VALUES ('资源管理', 'menu', '/admin/resource', '1', '0/1/', NULL, '1', '', '3');
INSERT INTO `t_sys_user_role` (`USER_ID`, `ROLE_ID`) VALUES ('1', '1');
INSERT INTO `t_sys_role_resource` (`ROLE_ID`, `RESOURCE_ID`) VALUES ('1', '1');
INSERT INTO `t_sys_role_resource` (`ROLE_ID`, `RESOURCE_ID`) VALUES ('1', '2');
INSERT INTO `t_sys_role_resource` (`ROLE_ID`, `RESOURCE_ID`) VALUES ('1', '3');
INSERT INTO `t_sys_role_resource` (`ROLE_ID`, `RESOURCE_ID`) VALUES ('1', '4');


drop table if exists traffic_manager_project;
/*==============================================================*/
/* Table: traffic_manager_project                               */
/*==============================================================*/
create table traffic_manager_project
(
   project_id           int not null AUTO_INCREMENT,
   project_name         varchar(64),
   project_city         varchar(64),
   contract_no          varchar(64),
   project_status       int,
   project_desc         varchar(128),
   file_name            varchar(64),
   code_file_name varchar(64),
   add_time             date,
   update_time          date,
   primary key (project_id)
);


drop table if exists traffic_manager_interface;

/*==============================================================*/
/* Table: traffic_manager_interface                             */
/*==============================================================*/
create table traffic_manager_interface
(
   id                   int not null AUTO_INCREMENT,
   interface_id         varchar(32),
   interface_name       varchar(64),
   dailyvisits          int,
   dailydata            varchar(64),
   interface_status     int,
   interface_desc       varchar(128),
   add_time             date,
   update_time          date,
   Column_9             char(10),
   Column_11            char(10),
   primary key (id)
);

drop table if exists t_sys_config;

/*==============================================================*/
/* Table: t_sys_config                                          */
/*==============================================================*/
create table t_sys_config
(
   config_id            int not null AUTO_INCREMENT,
   config_key           varchar(64),
   config_value         varchar(64),
   config_desc          varchar(64),
   Column_5             char(10),
   Column_6             char(10),
   primary key (config_id)
);

insert into t_sys_config(config_key , config_value)values('special_id','1|8');
insert into t_sys_config(config_key , config_value)values('standed_id','303');

drop table if exists traffic_file_operation_inform;

/*==============================================================*/
/* Table: traffic_file _ operation _inform                               */
/*==============================================================*/
create table traffic_file_operation_inform
(
   id              int not null   auto_increment,
   file_name           varchar(50),
   user_id           int,
   operation_type        int,
   created_time             date,
   resaveds1         varchar(32),
   resaveds2         varchar(32),
   resaveds3         varchar(32),
   primary key (id)
);








