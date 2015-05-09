/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015-5-3 23:15:21                            */
/*==============================================================*/


drop table if exists account_type;

drop table if exists remit_log;

drop table if exists reward_rule;

drop table if exists third_user_info;

drop table if exists user_account_info;

drop table if exists user_address;

drop table if exists user_info;

drop table if exists user_relation;

drop table if exists user_reward_day_stat;

drop table if exists user_reward_log;

drop table if exists user_reward_rule;

drop table if exists user_reward_week_stat;

drop table if exists withdraw_log;

/*==============================================================*/
/* Table: account_type                                          */
/*==============================================================*/
create table account_type
(
   account_type         varchar(3) not null comment '账号类型ID',
   account_name         varchar(20) not null comment '账号类型名称',
   status               varchar(2) not null default '0' comment '状态 0-默认，1-可用，2-作废',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (account_type)
);

alter table account_type comment '账号类型';

/*==============================================================*/
/* Table: remit_log                                             */
/*==============================================================*/
create table remit_log
(
   order_id             varchar(20) not null comment '订单号',
   true_name            varchar(10) not null comment '汇款人姓名',
   remit_amt            bigint(20) not null comment '汇款金额',
   bank_no              varchar(20) not null comment '银行ID',
   bank_name            varchar(50) not null comment '银行名称',
   user_card            varchar(20) not null comment '会员卡号',
   mobile               varchar(11) not null comment '联系电话',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (order_id)
);

alter table remit_log comment '汇款登记';

/*==============================================================*/
/* Table: reward_rule                                           */
/*==============================================================*/
create table reward_rule
(
   rule_id              int not null auto_increment comment '奖励规则ID',
   rule_name            varchar(20) not null comment '奖励规则名称',
   max_level            int(10) not null comment '最大层级 0-表示不限制层',
   time_cycle           smallint(2) not null comment '时间周期 0-不限制，1-天，2-周，3-月，4-年',
   limit_max_amt        bigint(20) not null comment '最大金额限制，单位为10000为分',
   unit_amt             bigint(20) not null comment '单位数据奖励金额，10000为1分，其他类同',
   status               varchar(2) not null comment '状态 0-默认，1-可用，2-作废',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (rule_id)
);

alter table reward_rule comment '公共奖励规则表';

/*==============================================================*/
/* Table: third_user_info                                       */
/*==============================================================*/
create table third_user_info;

alter table third_user_info comment '第三方账号信息，如qq、微信、微博等';

/*==============================================================*/
/* Table: user_account_info                                     */
/*==============================================================*/
create table user_account_info
(
   user_id              bigint(20) not null comment '用户ID',
   account_id           varchar(30) not null comment '会员账号ID，可以为银行卡号、支付宝、财付通等',
   account_type         varchar(3) not null comment '账号类型，可以为各大银行、支付宝、财付通等，具体的数参照account_type表',
   true_name            varchar(10) not null comment '姓名',
   account_status       varchar(2) not null default '1' comment '账号状态 1-可用，2不可用',
   comments             varchar(100) comment '说明',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id, account_id, account_type)
);

alter table user_account_info comment '用户账号表';

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
create table user_address;

alter table user_address comment '用户邮件地址表';

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_id              bigint(20) not null comment '用户ID',
   user_name            varchar(20) not null comment '用户名',
   true_name            varchar(10) comment '真实姓名',
   login_password       varchar(50) not null comment '登陆密码',
   cash_password        varchar(50) not null comment '提现密码',
   sex                  varchar(2) not null default '0' comment '性别，0-未设置，1-男，2-女',
   id_no                varchar(20) not null default '0' comment '身份证号',
   mobile               varchar(11) not null default '0' comment '手机号',
   email                varchar(30) not null default '0' comment '电子邮件',
   status               varchar(2) not null default '0' comment '状态 0-默认注册，1-激活，2-冻结，3-作废，4-会员已过期',
   super_id             bigint(20) not null default 0 comment '上级ID',
   position             tinyint(2) not null default 0 comment '位置 0-未设置，1-左，2-右',
   user_address         varchar(100) comment '用户住址',
   vip_start_time       datetime not null default '1970-01-01 00:00:00' comment 'vip开始时间',
   vip_end_time         datetime not null default '1970-01-01 00:00:00' comment 'vip结束时间',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id),
   unique key AK_Key_2 (user_name)
);

alter table user_info comment '用户信息表';

/*==============================================================*/
/* Table: user_relation                                         */
/*==============================================================*/
create table user_relation
(
   user_id              bigint(20) not null comment '用户ID',
   user_name            varchar(20) not null comment '用户名',
   super_id             bigint(20) not null comment '上级ID',
   super_name           varchar(20) not null comment '上级名称',
   super_position       tinyint(2) not null comment '上级位置',
   super_level_num      int(10) not null comment '上级层次',
   status               varchar(2) not null default '1' comment '状态 0-默认，1-可用，2-不可用',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id, super_id)
);

alter table user_relation comment '用户关系表';

/*==============================================================*/
/* Table: user_reward_day_stat                                  */
/*==============================================================*/
create table user_reward_day_stat
(
   user_id              bigint(20) not null comment '用户ID',
   stat_date            date not null comment '统计日期',
   left_num             int not null default 0 comment '左位置数',
   right_num            int not null default 0 comment '右位置数',
   zhitui_amt           bigint(20) not null default 0 comment '直推奖',
   jiandian_amt         bigint(20) not null default 0 comment '见点奖',
   duipeng_amt          bigint(20) not null default 0 comment '对碰奖',
   tax_amt              bigint(20) not null default 0 comment '扣税',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id, stat_date)
);

alter table user_reward_day_stat comment '用户日奖励统计';

/*==============================================================*/
/* Table: user_reward_log                                       */
/*==============================================================*/
create table user_reward_log
(
   user_id              bigint(20) not null comment '用户ID',
   user_name            varchar(20) comment '用户名',
   super_id             bigint(20) not null comment '奖励人ID',
   super_name           varchar(20) not null comment '奖励人名称',
   rule_id              int not null comment '奖励ID',
   reward_amt           bigint(20) not null comment '奖励金额',
   super_position       tinyint(2) not null comment '上层位置',
   super_level_num      int(10) not null comment '上级层数',
   reward_status        varchar(2) not null comment '奖励状态 0-未奖励，1-已奖励，2-作废',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id, super_id, rule_id)
);

alter table user_reward_log comment '用户奖励日志表';

/*==============================================================*/
/* Table: user_reward_rule                                      */
/*==============================================================*/
create table user_reward_rule
(
   user_id              bigint(20) not null comment '用户ID',
   rule_id              int not null comment '奖励规则ID，对应reward_rule中的rule_id',
   rule_name            varchar(20) not null comment '奖励规则名称',
   max_level            int(10) not null comment '最大层级 0-表示不限制层',
   time_cycle           smallint(2) not null comment '时间周期 0-不限制，1-天，2-周，3-月，4-年',
   limit_max_amt        bigint(20) not null comment '最大金额限制，单位为10000为分',
   unit_amt             bigint(20) not null comment '单位数据奖励金额，10000为1分，其他类同',
   status               varchar(2) not null comment '状态 0-默认，1-可用，2-作废',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id, rule_id)
);

alter table user_reward_rule comment '用户奖励规则表';

/*==============================================================*/
/* Table: user_reward_week_stat                                 */
/*==============================================================*/
create table user_reward_week_stat
(
   user_id              bigint(20) not null comment '用户ID',
   stat_week            varchar(4) not null comment '年',
   week_num             int not null comment '期数',
   left_num             int not null default 0 comment '左位置数',
   right_num            int not null default 0 comment '右位置数',
   zhitui_amt           bigint(20) not null default 0 comment '直推奖',
   jiandian_amt         bigint(20) not null default 0 comment '见点奖',
   duipeng_amt          bigint(20) not null default 0 comment '对碰奖',
   tax_amt              bigint(20) not null default 0 comment '扣税',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (user_id, stat_week, week_num)
);

alter table user_reward_week_stat comment '用户周奖励统计';

/*==============================================================*/
/* Table: withdraw_log                                          */
/*==============================================================*/
create table withdraw_log
(
   order_id             varchar(20) not null comment '订单ID',
   withdraw_user_id     bigint(20) not null comment '用户ID',
   withdraw_user_name   varchar(20) not null comment '用户名',
   withdraw_true_name   varchar(10) not null comment '提现人姓名',
   withdraw_account_id  varchar(20) not null comment '提现账号，支付宝账号或银行卡号等',
   withdraw_type        varchar(3) not null comment '提现账号类型，与account_type表类型对应',
   withdraw_amt         bigint(20) not null comment '提现金额',
   pay_true_name        varchar(10) comment '打款人姓名',
   pay_account_id       varchar(20) comment '打款人账号，支付宝账号或银行卡号等',
   pay_type             varchar(3) comment '提现账号类型，与account_type表类型对应',
   pay_amt              bigint(20) not null default 0 comment '打款金额',
   insert_time          datetime not null comment '插入时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (order_id)
);

alter table withdraw_log comment '提现登记';

