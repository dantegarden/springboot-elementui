create user 'test'@'%' identified by '123456';
create database spring_db DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
grant all privileges on `spring_db`.* to 'test'@'%' identified by '123456';
flush privileges;


/*
Navicat MySQL Data Transfer

Source Server         : local_db
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : spring_db

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-12-07 11:54:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户', 'user:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户', 'user:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户', 'user:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('701', 'role', '角色权限', 'role:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('702', 'role', '角色权限', 'role:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('703', 'role', '角色权限', 'role:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('704', 'role', '角色权限', 'role:delete', '删除', '2');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('2', '作家', '2017-11-22 16:24:34', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role` VALUES ('3', '程序员', '2017-11-22 16:28:47', '2018-12-07 11:52:43', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('30', '2', '601', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('31', '2', '602', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('32', '2', '603', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('33', '2', '701', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('34', '2', '702', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('35', '2', '703', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('36', '2', '704', '2018-12-07 11:52:37', '2018-12-07 11:52:37', '1');
INSERT INTO `sys_role_permission` VALUES ('37', '3', '601', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('38', '3', '603', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('39', '3', '701', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('40', '3', '702', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('41', '3', '704', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10017 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10003', 'admin', '123456', '超级用户', '1', '2017-10-30 11:52:38', '2018-12-05 16:52:19', '1');
INSERT INTO `sys_user` VALUES ('10004', 'user', '123456', '莎士比亚', '2', '2017-10-30 16:13:02', '2017-11-18 02:48:24', '1');
INSERT INTO `sys_user` VALUES ('10005', 'aaa', '123456', 'abba', '1', '2017-11-15 14:02:56', '2017-11-17 23:51:42', '1');
INSERT INTO `sys_user` VALUES ('10007', 'test', '123456', '就看看列表', '3', '2017-11-22 16:29:41', '2017-11-22 16:29:41', '1');
INSERT INTO `sys_user` VALUES ('10009', 'lij', '123123', '李xx', '1', '2018-12-05 16:17:13', '2018-12-05 16:50:12', '2');
INSERT INTO `sys_user` VALUES ('10010', 'lijing', '123123', '李倞', '1', '2018-12-05 16:08:17', '2018-12-05 16:08:17', '1');
INSERT INTO `sys_user` VALUES ('10011', 'test1', '123', 'test1', '1', '2018-12-05 16:50:54', '2018-12-05 16:50:54', '1');
INSERT INTO `sys_user` VALUES ('10012', 'test2', '123', 'test2', '1', '2018-12-05 16:51:06', '2018-12-05 16:51:29', '1');
INSERT INTO `sys_user` VALUES ('10013', 'test3', '123', 'test3', '1', '2018-12-05 16:51:22', '2018-12-05 16:51:22', '1');
INSERT INTO `sys_user` VALUES ('10014', 'test4', '123', 'test4', '1', '2018-12-05 16:51:42', '2018-12-05 16:51:42', '1');
INSERT INTO `sys_user` VALUES ('10015', 'test5', '123', 'test5', '1', '2018-12-05 16:51:52', '2018-12-05 16:51:52', '1');
INSERT INTO `sys_user` VALUES ('10016', 'test6', '123', 'test6', '1', '2018-12-05 16:52:01', '2018-12-05 16:52:01', '1');

-- ----------------------------
-- Table structure for demo_customer
-- ----------------------------
DROP TABLE IF EXISTS `demo_customer`;
CREATE TABLE `demo_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `sex` varchar(1) DEFAULT '1' COMMENT '性别  1男  2女',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='示例顾客表';

INSERT INTO `demo_customer` VALUES (null, '刘先生', '1', '北京市丰台区大红门街道123号', sysdate());
INSERT INTO `demo_customer` VALUES (null, '张先生', '1', '北京市海淀区羊坊店路10号', sysdate());

-- ----------------------------
-- Table structure for demo_goods
-- ----------------------------
DROP TABLE IF EXISTS `demo_goods`;
CREATE TABLE `demo_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` DOUBLE DEFAULT 0 COMMENT '单价',
  `detail` varchar(255) DEFAULT NULL COMMENT '详情',
	`picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='示例商品表';

INSERT INTO `demo_goods` VALUES (null, '小米8', '3799', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待','https://imgservice.suning.cn/uimg1/b2c/image/vZXxfEEZ1yYg2Cw2p9Yk0w.jpg_800w_800h_4e', sysdate());
INSERT INTO `demo_goods` VALUES (null, '华为Mate20 pro', '5999', 'HUAWEI/华为Mate 20 极光色 6GB+128GB 麒麟980芯片全面屏徕卡三摄移动联通电信4G手机','https://imgservice.suning.cn/uimg1/b2c/image/FGsGbl26_-wt2dcYaweaPA.jpg_800w_800h_4e', sysdate());

-- ----------------------------
-- Table structure for demo_order
-- ----------------------------
DROP TABLE IF EXISTS `demo_order`;
CREATE TABLE `demo_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
	`customer_id` int(11) DEFAULT NULL COMMENT '顾客id',
  `order_sn` varchar(255) DEFAULT NULL COMMENT '订单号',
	`order_status` varchar(1) DEFAULT '1' COMMENT '订单状态 1 待付款 2 待发货 3 待收货 4 完成',
  `order_price` DOUBLE DEFAULT 0 COMMENT '订单总价',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
	`order_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='示例订单表';

INSERT INTO `demo_order` VALUES (null,10000, 'OSN1111111','1', '3799', '黑色 64G',sysdate(), sysdate());
INSERT INTO `demo_order` VALUES (null,10001, 'OSN2222222','2', '5999', '官方标配 星空蓝',DATE_SUB(sysdate(),INTERVAL 1 DAY), sysdate());


-- ----------------------------

DROP TABLE IF EXISTS `demo_order_goods`;
CREATE TABLE `demo_order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
	`order_id` int(11) DEFAULT NULL COMMENT '订单id',
	`goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='示例订单商品表';

INSERT INTO `demo_order_goods` VALUES (null,10000, 10000, sysdate());
INSERT INTO `demo_order_goods` VALUES (null,10001, 10001, sysdate());
