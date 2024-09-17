#
Host: 139.198.104.58  (Version 5.7.38)
# Date: 2023-11-24 15:07:48
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Database "valet_coupon"
#

CREATE
DATABASE IF NOT EXISTS `valet_coupon`;
USE
`valet_coupon`;

#
# Structure for table "coupon_info"
#

CREATE TABLE `coupon_info`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `coupon_type`      tinyint(3) NOT NULL DEFAULT '1' COMMENT '优惠卷类型 1 现金券 2 折扣',
    `name`             varchar(100)            DEFAULT NULL COMMENT '优惠卷名字',
    `amount`           decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '金额',
    `discount`         decimal(10, 2)          DEFAULT NULL COMMENT '折扣：取值[1 到 10]',
    `condition_amount` decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '使用门槛 0->没门槛',
    `publish_count`    int(11) NOT NULL DEFAULT '1' COMMENT '发行数量，0->无限制',
    `per_limit`        int(11) NOT NULL DEFAULT '1' COMMENT '每人限领张数，0-不限制 1-限领1张 2-限领2张',
    `use_count`        int(11) NOT NULL DEFAULT '0' COMMENT '已使用数量',
    `receive_count`    int(11) NOT NULL DEFAULT '0' COMMENT '领取数量',
    `expire_time`      datetime                DEFAULT NULL COMMENT '过期时间',
    `description`      varchar(255)            DEFAULT NULL COMMENT '优惠券描述',
    `status`           tinyint(1) DEFAULT NULL COMMENT '状态[0-未发布，1-已发布， -1-已过期]',
    `create_time`      timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`       tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='优惠券信息';

#
# Data for table "coupon_info"
#

#
# Structure for table "customer_coupon"
#

CREATE TABLE `customer_coupon`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `coupon_id`    bigint(20) DEFAULT NULL COMMENT '优惠券ID',
    `customer_id`  bigint(20) DEFAULT NULL COMMENT '乘客ID',
    `status`       tinyint(3) DEFAULT NULL COMMENT '优化券状态（1：未使用 2：已使用）',
    `receive_time` datetime           DEFAULT NULL COMMENT '领取时间',
    `used_time`    datetime           DEFAULT NULL COMMENT '使用时间',
    `order_id`     bigint(20) DEFAULT NULL COMMENT '订单id',
    `expire_time`  datetime           DEFAULT NULL COMMENT '过期时间',
    `create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`   tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY            `idx_coupon_id` (`coupon_id`),
    KEY            `idx_customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='乘客优惠券关联表';

#
# Data for table "customer_coupon"
#

#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#


#
# Database "valet_customer"
#

CREATE
DATABASE IF NOT EXISTS `valet_customer`;
USE
`valet_customer`;

#
# Structure for table "customer_info"
#

CREATE TABLE `customer_info`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `wx_open_id`  varchar(200) NOT NULL DEFAULT '' COMMENT '微信openId',
    `nickname`    varchar(200)          DEFAULT '' COMMENT '客户昵称',
    `gender`      char(1)      NOT NULL DEFAULT '1' COMMENT '性别',
    `avatar_url`  varchar(200)          DEFAULT NULL COMMENT '头像',
    `phone`       char(11)              DEFAULT NULL COMMENT '电话',
    `status`      tinyint(3) DEFAULT '1' COMMENT '1有效，2禁用',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uni_open_id` (`wx_open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户表';

#
# Data for table "customer_info"
#

#
# Structure for table "customer_login_log"
#

CREATE TABLE `customer_login_log`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    `customer_id` varchar(50)        DEFAULT '' COMMENT '客户id',
    `ipaddr`      varchar(128)       DEFAULT '' COMMENT '登录IP地址',
    `status`      tinyint(1) DEFAULT '1' COMMENT '登录状态',
    `msg`         varchar(255)       DEFAULT '' COMMENT '提示信息',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY           `idx_customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户登录记录';

#
# Data for table "customer_login_log"
#


#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#


#
# Database "valet_dispatch"
#

CREATE
DATABASE IF NOT EXISTS `valet_dispatch`;
USE
`valet_dispatch`;

#
# Structure for table "order_job"
#

CREATE TABLE `order_job`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT,
    `order_id`    bigint(20) NOT NULL DEFAULT '0' COMMENT '订单id',
    `job_id`      bigint(11) NOT NULL DEFAULT '0' COMMENT '任务id',
    `parameter`   text COMMENT '参数',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_order_id` (`order_id`),
    UNIQUE KEY `uni_job_id` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单与任务的关联表';

#
# Data for table "order_job"
#

#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#

#
# Structure for table "xxl_job_log"
#

CREATE TABLE `xxl_job_log`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT,
    `job_id`      bigint(11) NOT NULL DEFAULT '0' COMMENT '任务id',
    `status`      int(11) NOT NULL DEFAULT '1' COMMENT '任务状态    0：失败    1：成功',
    `error`       text COMMENT '失败信息',
    `times`       int(11) NOT NULL DEFAULT '0' COMMENT '耗时(单位：毫秒)',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY           `idx_job_id` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "xxl_job_log"
#

#
# Database "valet_driver"
#

CREATE
DATABASE IF NOT EXISTS `valet_driver`;
USE
`valet_driver`;

#
# Structure for table "driver_account"
#

CREATE TABLE `driver_account`
(
    `id`                  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `driver_id`           bigint(20) NOT NULL DEFAULT '0' COMMENT '司机id',
    `total_amount`        decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '账户总金额',
    `lock_amount`         decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '锁定金额',
    `available_amount`    decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '可用金额',
    `total_income_amount` decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '总收入',
    `total_pay_amount`    decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '总支出',
    `create_time`         timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`          tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uni_driver_id` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='司机账户';

#
# Data for table "driver_account"
#


#
# Structure for table "driver_account_detail"
#

CREATE TABLE `driver_account_detail`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `driver_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '司机id',
    `content`     varchar(100)   NOT NULL DEFAULT '' COMMENT '交易内容',
    `trade_type`  varchar(10)    NOT NULL DEFAULT '' COMMENT '交易类型：1-奖励 2-补贴 3-提现',
    `amount`      decimal(16, 2) NOT NULL DEFAULT '0.00' COMMENT '金额',
    `trade_no`    varchar(50)             DEFAULT NULL COMMENT '交易编号',
    `create_time` timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  varchar(2)     NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY           `idx_driver_id` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='司机账户明细';

#
# Data for table "driver_account_detail"
#


#
# Structure for table "driver_face_recognition"
#

CREATE TABLE `driver_face_recognition`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `driver_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '司机id',
    `face_date`   date               DEFAULT NULL COMMENT '识别日期',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    KEY           `idx_driver_id` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='司机人脸识别记录表';

#
# Data for table "driver_face_recognition"
#

#
# Structure for table "driver_info"
#

CREATE TABLE `driver_info`
(
    `id`                        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `wx_open_id`                varchar(200)   NOT NULL DEFAULT '' COMMENT '微信openId',
    `nickname`                  varchar(200)   NOT NULL COMMENT '昵称',
    `avatar_url`                varchar(200)            DEFAULT NULL COMMENT '头像',
    `phone`                     char(11)                DEFAULT NULL COMMENT '电话',
    `name`                      varchar(20)             DEFAULT NULL COMMENT '姓名',
    `gender`                    char(1)        NOT NULL DEFAULT '1' COMMENT '性别 1:男 2：女',
    `birthday`                  date                    DEFAULT NULL COMMENT '生日',
    `idcard_no`                 varchar(18)             DEFAULT NULL COMMENT '身份证号码',
    `idcard_address`            varchar(200)            DEFAULT NULL COMMENT '身份证地址',
    `idcard_expire`             date                    DEFAULT NULL COMMENT '身份证有效期',
    `idcard_front_url`          varchar(200)            DEFAULT NULL COMMENT '身份证正面',
    `idcard_back_url`           varchar(200)            DEFAULT NULL COMMENT '身份证背面',
    `idcard_hand_url`           varchar(200)            DEFAULT NULL COMMENT '手持身份证',
    `driver_license_class`      varchar(20)             DEFAULT NULL COMMENT '准驾车型',
    `driver_license_no`         varchar(100)            DEFAULT NULL COMMENT '驾驶证证件号',
    `driver_license_expire`     date                    DEFAULT NULL COMMENT '驾驶证有效期',
    `driver_license_issue_date` date                    DEFAULT NULL COMMENT '驾驶证初次领证日期',
    `driver_license_front_url`  varchar(200)            DEFAULT NULL COMMENT '驾驶证正面',
    `driver_license_back_url`   varchar(200)            DEFAULT NULL COMMENT '行驶证副页正面',
    `driver_license_hand_url`   varchar(200)            DEFAULT NULL COMMENT '手持驾驶证',
    `contact_name`              varchar(20)             DEFAULT NULL COMMENT '紧急联系人',
    `contact_phone`             char(11)                DEFAULT NULL COMMENT '紧急联系人电话',
    `contact_relationship`      varchar(20)             DEFAULT NULL COMMENT '紧急联系人关系',
    `face_model_id`             varchar(100)            DEFAULT NULL COMMENT '腾讯云人脸模型id',
    `job_no`                    varchar(50)             DEFAULT NULL COMMENT '司机工号',
    `score`                     decimal(10, 2) NOT NULL DEFAULT '9.00' COMMENT '评分',
    `order_count`               int(11) NOT NULL DEFAULT '0' COMMENT '订单量统计',
    `auth_status`               tinyint(3) NOT NULL DEFAULT '0' COMMENT '认证状态 0:未认证  1：审核中 2：认证通过 -1：认证未通过',
    `status`                    tinyint(3) NOT NULL DEFAULT '1' COMMENT '状态，1正常，2禁用',
    `create_time`               timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`               timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`                tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='司机表';

#
# Data for table "driver_info"
#

#
# Structure for table "driver_login_log"
#

CREATE TABLE `driver_login_log`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    `driver_id`   varchar(50)        DEFAULT '' COMMENT '司机id',
    `ipaddr`      varchar(128)       DEFAULT '' COMMENT '登录IP地址',
    `status`      tinyint(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    `msg`         varchar(255)       DEFAULT '' COMMENT '提示信息',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY           `idx_driver_id` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='司机登录记录';

#
# Data for table "driver_login_log"
#


#
# Structure for table "driver_set"
#

CREATE TABLE `driver_set`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `driver_id`       bigint(20) NOT NULL COMMENT '司机ID',
    `service_status`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '服务状态 1：开始接单 0：未接单',
    `order_distance`  decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '订单里程设置',
    `accept_distance` decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '接单里程设置',
    `is_auto_accept`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否自动接单',
    `create_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`      tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uni_driver_id` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='司机设置表';

#
# Data for table "driver_set"
#

#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#


#
# Database "valet_order"
#

CREATE
DATABASE IF NOT EXISTS `valet_order`;
USE
`valet_order`;

#
# Structure for table "order_bill"
#

CREATE TABLE `order_bill`
(
    `id`                         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`                   bigint(20) NOT NULL COMMENT '订单ID',
    `fee_rule_id`                varchar(255)            DEFAULT NULL COMMENT '费用规则id',
    `total_amount`               decimal(10, 2)          DEFAULT '0.00' COMMENT '总金额',
    `pay_amount`                 decimal(10, 2)          DEFAULT '0.00' COMMENT '应付款金额',
    `distance_fee`               decimal(10, 2)          DEFAULT '0.00' COMMENT '里程费',
    `wait_fee`                   decimal(10, 2)          DEFAULT '0.00' COMMENT '等时费用',
    `long_distance_fee`          decimal(10, 2)          DEFAULT '0.00' COMMENT '远程费',
    `toll_fee`                   decimal(10, 2)          DEFAULT '0.00' COMMENT '路桥费',
    `parking_fee`                decimal(10, 2)          DEFAULT '0.00' COMMENT '停车费',
    `other_fee`                  decimal(10, 2)          DEFAULT '0.00' COMMENT '其他费用',
    `favour_fee`                 decimal(10, 2)          DEFAULT '0.00' COMMENT '顾客好处费',
    `reward_fee`                 decimal(10, 2)          DEFAULT '0.00' COMMENT '系统奖励费',
    `reward_rule_id`             bigint(20) DEFAULT NULL COMMENT '系统奖励规则id',
    `coupon_amount`              decimal(10, 2)          DEFAULT NULL COMMENT '优惠券金额',
    `base_distance`              smallint(6) NOT NULL DEFAULT '0' COMMENT '基础里程（公里）',
    `base_distance_fee`          decimal(10, 2)          DEFAULT NULL COMMENT '基础里程费',
    `exceed_distance`            varchar(255)            DEFAULT NULL COMMENT '超出基础里程的里程（公里）',
    `exceed_distance_price`      decimal(10, 2)          DEFAULT NULL COMMENT '超出基础里程的价格',
    `base_wait_minute`           smallint(6) NOT NULL DEFAULT '0' COMMENT '基础等时分钟',
    `exceed_wait_minute`         smallint(6) DEFAULT NULL COMMENT '超出基础等时的分钟',
    `exceed_wait_minute_price`   decimal(10, 2)          DEFAULT NULL COMMENT '超出基础分钟的价格',
    `base_long_distance`         smallint(6) NOT NULL DEFAULT '0' COMMENT '基础远途里程（公里）',
    `exceed_long_distance`       decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '超出基础远程里程的里程',
    `exceed_long_distance_price` decimal(10, 2)          DEFAULT NULL COMMENT '超出基础远程里程的价格',
    `create_time`                timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`                timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`                 tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uni_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单账单表';

#
# Data for table "order_bill"
#

#
# Structure for table "order_comment"
#

CREATE TABLE `order_comment`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`    bigint(20) NOT NULL COMMENT '订单ID',
    `driver_id`   bigint(20) NOT NULL COMMENT '司机ID',
    `customer_id` bigint(20) NOT NULL COMMENT '顾客ID',
    `rate`        tinyint(4) NOT NULL COMMENT '评分，1星~5星',
    `remark`      varchar(200)       DEFAULT NULL COMMENT '备注',
    `status`      tinyint(4) NOT NULL COMMENT '状态，1未申诉，2已申诉，3申诉失败，4申诉成功',
    `instance_id` varchar(100)       DEFAULT NULL COMMENT '申诉工作流ID',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    KEY           `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单评价表';

#
# Data for table "order_comment"
#


#
# Structure for table "order_info"
#

CREATE TABLE `order_info`
(
    `id`                    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `customer_id`           bigint(20) NOT NULL DEFAULT '0' COMMENT '客户ID',
    `order_no`              varchar(50)    NOT NULL DEFAULT '' COMMENT '订单号',
    `start_location`        varchar(200)   NOT NULL DEFAULT '' COMMENT '起始地点',
    `start_point_longitude` decimal(10, 7) NOT NULL DEFAULT '0.0000000' COMMENT '起始地点经度',
    `start_point_latitude`  decimal(10, 7) NOT NULL DEFAULT '0.0000000' COMMENT '起始点伟度',
    `end_location`          varchar(200)   NOT NULL DEFAULT '' COMMENT '结束地点',
    `end_point_longitude`   decimal(10, 7) NOT NULL DEFAULT '0.0000000' COMMENT '结束地点经度',
    `end_point_latitude`    decimal(10, 7) NOT NULL DEFAULT '0.0000000' COMMENT '结束地点经度',
    `expect_distance`       decimal(10, 2)          DEFAULT NULL COMMENT '预估里程',
    `real_distance`         decimal(10, 2)          DEFAULT NULL COMMENT '实际里程',
    `expect_amount`         decimal(10, 2)          DEFAULT NULL COMMENT '预估订单金额',
    `real_amount`           decimal(10, 2)          DEFAULT NULL COMMENT '实际订单金额',
    `favour_fee`            decimal(10, 2) NOT NULL DEFAULT '0.00' COMMENT '顾客好处费',
    `driver_id`             bigint(20) DEFAULT NULL COMMENT '司机ID',
    `accept_time`           datetime                DEFAULT NULL COMMENT '司机接单时间',
    `arrive_time`           datetime                DEFAULT NULL COMMENT '司机到达时间',
    `start_service_time`    datetime                DEFAULT NULL COMMENT '开始服务时间',
    `end_service_time`      datetime                DEFAULT NULL COMMENT '结束服务时间',
    `pay_time`              datetime                DEFAULT NULL COMMENT '微信付款时间',
    `cancel_rule_id`        bigint(20) DEFAULT NULL COMMENT '订单取消规则ID',
    `car_license`           varchar(20)    NOT NULL DEFAULT '' COMMENT '车牌号',
    `car_type`              varchar(20)    NOT NULL DEFAULT '' COMMENT '车型',
    `car_front_url`         varchar(200)            DEFAULT NULL COMMENT '司机到达拍照：车前照',
    `car_back_url`          varchar(200)            DEFAULT NULL COMMENT '司机到达拍照：车后照',
    `transaction_id`        varchar(50)             DEFAULT NULL COMMENT '微信支付订单号',
    `job_id`                bigint(20) DEFAULT NULL,
    `status`                tinyint(3) NOT NULL DEFAULT '1' COMMENT '订单状态：1等待接单，2已接单，3司机已到达，4开始代驾，5结束代驾，6未付款，7已付款，8订单已结束，9顾客撤单，10司机撤单，11事故关闭，12其他',
    `remark`                varchar(200)            DEFAULT NULL COMMENT '订单备注信息',
    `create_time`           timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`           timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`            tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uni_order_no` (`order_no`),
    KEY                     `idx_customer_id` (`customer_id`),
    KEY                     `idx_driver_id` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';

#
# Data for table "order_info"
#

#
# Structure for table "order_monitor"
#

CREATE TABLE `order_monitor`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `order_id`    bigint(20) NOT NULL DEFAULT '0' COMMENT '订单ID',
    `file_num`    int(11) NOT NULL DEFAULT '0' COMMENT '文件个数',
    `audit_num`   int(3) NOT NULL DEFAULT '0' COMMENT '需要审核的个数',
    `is_alarm`    tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否报警',
    `status`      tinyint(3) NOT NULL DEFAULT '0' COMMENT '状态',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单监控表';

#
# Data for table "order_monitor"
#


#
# Structure for table "order_monitor_record"
#

CREATE TABLE `order_monitor_record`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `order_id`    bigint(20) DEFAULT NULL COMMENT '订单ID',
    `file_url`    varchar(200) NOT NULL DEFAULT '0' COMMENT '文件路径',
    `content`     text         NOT NULL COMMENT '内容',
    `result`      tinyint(3) DEFAULT NULL COMMENT '审核结果',
    `keywords`    text COMMENT '风险关键词',
    `status`      tinyint(3) DEFAULT NULL COMMENT '状态',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY           `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单监控记录表';

#
# Data for table "order_monitor_record"
#


#
# Structure for table "order_profitsharing"
#

CREATE TABLE `order_profitsharing`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`        bigint(20) NOT NULL COMMENT '订单ID',
    `rule_id`         bigint(20) NOT NULL COMMENT '规则ID',
    `order_amount`    decimal(10, 2)          DEFAULT NULL COMMENT '订单金额',
    `payment_rate`    decimal(10, 2)          DEFAULT NULL COMMENT '微信支付平台费率',
    `payment_fee`     decimal(10, 2)          DEFAULT NULL COMMENT '微信支付平台费用',
    `driver_tax_rate` decimal(10, 2)          DEFAULT NULL COMMENT '代驾司机代缴个税税率',
    `driver_tax_fee`  decimal(10, 2)          DEFAULT NULL COMMENT '代驾司机税率支出费用',
    `platform_income` decimal(10, 2)          DEFAULT NULL COMMENT '平台分账收入',
    `driver_income`   decimal(10, 2) NOT NULL COMMENT '司机分账收入',
    `status`          tinyint(3) NOT NULL DEFAULT '1' COMMENT '分账状态，1未分账，2已分账',
    `create_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`      tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uni_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单分账表';

#
# Data for table "order_profitsharing"
#

#
# Structure for table "order_status_log"
#

CREATE TABLE `order_status_log`
(
    `id`           bigint(11) NOT NULL AUTO_INCREMENT,
    `order_id`     bigint(11) DEFAULT NULL,
    `order_status` varchar(11)        DEFAULT NULL,
    `operate_time` datetime           DEFAULT NULL,
    `create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`   tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY            `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单状态日志记录表';

#
# Data for table "order_status_log"
#

#
# Structure for table "order_track"
#

CREATE TABLE `order_track`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `order_id`    bigint(20) DEFAULT NULL COMMENT '订单id',
    `driver_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '司机id',
    `customer_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '客户id',
    `longitude`   decimal(10, 7)     DEFAULT NULL COMMENT '经度',
    `latitude`    decimal(10, 7)     DEFAULT NULL COMMENT '纬度',
    `speed`       decimal(10, 2)     DEFAULT NULL COMMENT '速度',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY           `uniq_order_no` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单追踪表';

#
# Data for table "order_track"
#


#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#


#
# Database "valet_payment"
#

CREATE
DATABASE IF NOT EXISTS `valet_payment`;
USE
`valet_payment`;

#
# Structure for table "payment_info"
#

CREATE TABLE `payment_info`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `customer_open_id` varchar(50)          DEFAULT NULL COMMENT '乘客微信openid',
    `driver_open_id`   varchar(50)          DEFAULT NULL COMMENT '司机微信openid',
    `order_no`         varchar(50) NOT NULL DEFAULT '0' COMMENT '订单号',
    `pay_way`          tinyint(3) NOT NULL DEFAULT '0' COMMENT '付款方式：1-微信',
    `transaction_id`   varchar(50)          DEFAULT NULL COMMENT '微信支付订单号',
    `amount`           decimal(10, 2)       DEFAULT NULL COMMENT '支付金额',
    `content`          varchar(200)         DEFAULT NULL COMMENT '交易内容',
    `payment_status`   tinyint(3) DEFAULT NULL COMMENT '支付状态：0-未支付 1-已支付',
    `callback_time`    datetime             DEFAULT NULL COMMENT '回调时间',
    `callback_content` text COMMENT '回调信息',
    `create_time`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`       tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='付款信息表';

#
# Data for table "payment_info"
#


#
# Structure for table "profitsharing_info"
#

CREATE TABLE `profitsharing_info`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `driver_id`       bigint(20) DEFAULT NULL COMMENT '司机id',
    `order_no`        varchar(50) NOT NULL DEFAULT '0' COMMENT '订单号',
    `transaction_id`  varchar(50)          DEFAULT NULL COMMENT '微信支付订单号',
    `out_trade_no`    varchar(50)          DEFAULT NULL COMMENT '商户分账单号',
    `amount`          decimal(10, 2)       DEFAULT NULL COMMENT '司机分账金额',
    `state`           varchar(10)          DEFAULT NULL COMMENT '分账单状态 PROCESSING：处理中  FINISHED：分账完成',
    `respone_content` text COMMENT '返回信息',
    `create_time`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`      tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分账信息表';

#
# Data for table "profitsharing_info"
#


#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#


#
# Database "valet_rule"
#

CREATE
DATABASE IF NOT EXISTS `valet_rule`;
USE
`valet_rule`;

#
# Structure for table "cancel_rule"
#

CREATE TABLE `cancel_rule`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(200) NOT NULL COMMENT '规则名称',
    `rule`        text         NOT NULL COMMENT '规则代码',
    `status`      tinyint(4) NOT NULL DEFAULT '2' COMMENT '状态代码，1有效，2关闭',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单取消规则表';

#
# Data for table "cancel_rule"
#


#
# Structure for table "fee_rule"
#

CREATE TABLE `fee_rule`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(200) NOT NULL COMMENT '规则名称',
    `rule`        text         NOT NULL COMMENT '规则代码',
    `status`      tinyint(3) NOT NULL DEFAULT '1' COMMENT '状态代码，1有效，2关闭',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='代驾费用规则表';

#
# Data for table "fee_rule"
#

#
# Structure for table "profitsharing_rule"
#

CREATE TABLE `profitsharing_rule`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(200) NOT NULL COMMENT '规则名称',
    `rule`        text         NOT NULL COMMENT '规则代码',
    `status`      tinyint(4) NOT NULL DEFAULT '2' COMMENT '状态代码，1有效，2关闭',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='分账规则表';

#
# Data for table "profitsharing_rule"
#

#
# Structure for table "reward_rule"
#

CREATE TABLE `reward_rule`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(200) NOT NULL COMMENT '规则名称',
    `rule`        text         NOT NULL COMMENT '规则代码',
    `status`      tinyint(3) NOT NULL DEFAULT '1' COMMENT '状态代码，1有效，2关闭',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='奖励规则表';

#
# Data for table "reward_rule"
#

#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#


#
# Database "valet_system"
#

CREATE
DATABASE IF NOT EXISTS `valet_system`;
USE
`valet_system`;

#
# Structure for table "sys_dept"
#

CREATE TABLE `sys_dept`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(50) NOT NULL DEFAULT '' COMMENT '部门名称',
    `parent_id`   bigint(20) DEFAULT '0' COMMENT '上级部门id',
    `tree_path`   varchar(255)         DEFAULT ',' COMMENT '树结构',
    `sort_value`  int(11) DEFAULT '1' COMMENT '排序',
    `leader`      varchar(20)          DEFAULT NULL COMMENT '负责人',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '电话',
    `status`      tinyint(1) DEFAULT '1' COMMENT '状态（1正常 0停用）',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2020 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='组织机构';

#
# Data for table "sys_dept"
#

#
# Structure for table "sys_login_log"
#

CREATE TABLE `sys_login_log`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    `username`    varchar(50)        DEFAULT '' COMMENT '用户账号',
    `ipaddr`      varchar(128)       DEFAULT '' COMMENT '登录IP地址',
    `status`      tinyint(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    `msg`         varchar(255)       DEFAULT '' COMMENT '提示信息',
    `access_time` datetime           DEFAULT NULL COMMENT '访问时间',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

#
# Data for table "sys_login_log"
#



#
# Structure for table "sys_menu"
#

CREATE TABLE `sys_menu`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `parent_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '所属上级',
    `name`        varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
    `type`        tinyint(3) NOT NULL DEFAULT '0' COMMENT '类型(0:目录,1:菜单,2:按钮)',
    `path`        varchar(100)         DEFAULT NULL COMMENT '路由地址',
    `component`   varchar(100)         DEFAULT NULL COMMENT '组件路径',
    `perms`       varchar(100)         DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100)         DEFAULT NULL COMMENT '图标',
    `sort_value`  int(11) DEFAULT NULL COMMENT '排序',
    `active_menu` varchar(255)         DEFAULT NULL COMMENT '高亮的 path',
    `is_hide`     tinyint(1) NOT NULL DEFAULT '0',
    `status`      tinyint(4) DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY           `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

#
# Data for table "sys_menu"
#



#
# Structure for table "sys_oper_log"
#

CREATE TABLE `sys_oper_log`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
    `title`          varchar(50)        DEFAULT '' COMMENT '模块标题',
    `business_type`  varchar(20)        DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
    `method`         varchar(100)       DEFAULT '' COMMENT '方法名称',
    `request_method` varchar(10)        DEFAULT '' COMMENT '请求方式',
    `operator_type`  varchar(20)        DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
    `oper_name`      varchar(50)        DEFAULT '' COMMENT '操作人员',
    `dept_name`      varchar(50)        DEFAULT '' COMMENT '部门名称',
    `oper_url`       varchar(255)       DEFAULT '' COMMENT '请求URL',
    `oper_ip`        varchar(128)       DEFAULT '' COMMENT '主机地址',
    `oper_param`     varchar(2000)      DEFAULT '' COMMENT '请求参数',
    `json_result`    varchar(2000)      DEFAULT '' COMMENT '返回参数',
    `status`         int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
    `error_msg`      varchar(2000)      DEFAULT '' COMMENT '错误消息',
    `oper_time`      datetime           DEFAULT NULL COMMENT '操作时间',
    `create_time`    timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time`    timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`     tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

#
# Data for table "sys_oper_log"
#


#
# Structure for table "sys_post"
#

CREATE TABLE `sys_post`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
    `post_code`   varchar(64)  NOT NULL COMMENT '岗位编码',
    `name`        varchar(50)  NOT NULL DEFAULT '' COMMENT '岗位名称',
    `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
    `status`      tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

#
# Data for table "sys_post"
#



#
# Structure for table "sys_role"
#

CREATE TABLE `sys_role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
    `role_name`   varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
    `role_code`   varchar(20)          DEFAULT NULL COMMENT '角色编码',
    `description` varchar(255)         DEFAULT NULL COMMENT '描述',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='角色';

#
# Data for table "sys_role"
#



#
# Structure for table "sys_role_menu"
#

CREATE TABLE `sys_role_menu`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`     bigint(20) NOT NULL DEFAULT '0',
    `menu_id`     bigint(11) NOT NULL DEFAULT '0',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY           `idx_role_id` (`role_id`),
    KEY           `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=709 DEFAULT CHARSET=utf8 COMMENT='角色菜单';

#
# Data for table "sys_role_menu"
#



#
# Structure for table "sys_user"
#

CREATE TABLE `sys_user`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
    `username`    varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
    `name`        varchar(50)          DEFAULT NULL COMMENT '姓名',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '手机',
    `head_url`    varchar(200)         DEFAULT NULL COMMENT '头像地址',
    `dept_id`     bigint(20) DEFAULT NULL COMMENT '部门id',
    `post_id`     bigint(20) DEFAULT NULL COMMENT '岗位id',
    `description` varchar(255)         DEFAULT NULL COMMENT '描述',
    `status`      tinyint(3) DEFAULT NULL COMMENT '状态（1：正常 0：停用）',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

#
# Data for table "sys_user"
#



#
# Structure for table "sys_user_role"
#

CREATE TABLE `sys_user_role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `role_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
    `user_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    PRIMARY KEY (`id`),
    KEY           `idx_role_id` (`role_id`),
    KEY           `idx_admin_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户角色';

#
# Data for table "sys_user_role"
#



#
# Structure for table "undo_log"
#

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "undo_log"
#

