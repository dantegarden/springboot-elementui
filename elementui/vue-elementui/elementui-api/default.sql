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
) ENGINE=InnoDB AUTO_INCREMENT=10122 DEFAULT CHARSET=utf8 COMMENT='示例顾客表';

-- ----------------------------
-- Records of demo_customer
-- ----------------------------
INSERT INTO `demo_customer` VALUES ('10000', '刘先生', '1', '北京市丰台区大红门街道123号', '2018-12-07 14:43:18');
INSERT INTO `demo_customer` VALUES ('10001', '张先生', '1', '北京市海淀区羊坊店路10号', '2018-12-07 14:43:18');
INSERT INTO `demo_customer` VALUES ('10002', '阎忙图', '1', '十梅庵街45号-18-7', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10003', '陈亭', '2', '滋阳街56号-18-1', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10004', '胶藐', '1', '青威高速76号-4-2', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10005', '胶腋', '2', '大港纬一路61号-1-3', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10006', '胶兰', '1', '常州街53号-16-1', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10007', '殳茏郡', '1', '巨野大厦141号-11-4', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10008', '殳谵滗', '2', '香港西大厦142号-5-7', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10009', '殳朦扈', '2', '博兴路71号-19-4', '2018-12-10 17:50:32');
INSERT INTO `demo_customer` VALUES ('10010', '殳铤睿', '1', '合江路108号-11-2', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10011', '乌弃隈', '2', '安邱街95号-7-4', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10012', '乌逆剐', '1', '泰兴广场68号-2-2', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10013', '乌棹震', '2', '泰山广场130号-8-5', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10014', '乌野郜', '2', '天台二路64号-15-9', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10015', '乌陕兴', '1', '临淄路53号-1-3', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10016', '乌缆鹰', '2', '浙江路116号-17-2', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10017', '奚刘', '2', '咸阳广场80号-13-1', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10018', '奚佃', '2', '青大街66号-20-2', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10019', '奚澌', '1', '徐州大厦22号-12-7', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10020', '奚侨', '1', '海门路113号-5-10', '2018-12-10 17:50:33');
INSERT INTO `demo_customer` VALUES ('10021', '奚堋', '2', '博兴路144号-19-8', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10022', '过饮', '1', '港环路25号-15-10', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10023', '过夷', '1', '浦口广场85号-2-3', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10024', '成偕', '2', '华山路90号-6-3', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10025', '成墩', '1', '丹东街63号-8-5', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10026', '成癜', '2', '长兴街46号-20-5', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10027', '成胭', '2', '巢湖街27号-4-8', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10028', '成奂', '2', '南九水街100号-5-10', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10029', '成楼', '1', '台东三街81号-15-9', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10030', '成粢', '1', '泰城街67号-13-7', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10031', '成建', '1', '晓望街15号-13-6', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10032', '成罔', '2', '红岛路115号-9-6', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10033', '成系', '2', '延安三路69号-12-2', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10034', '查玢盍', '1', '屏东广场39号-16-4', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10035', '查囔囡', '2', '京山广场148号-16-10', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10036', '查除觞', '2', '三明路84号-1-9', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10037', '查渤筐', '2', '东海西路86号-4-9', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10038', '查栳挞', '1', '城武大厦13号-9-4', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10039', '查鲡蒽', '1', '新田路83号-12-1', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10040', '查刳诘', '2', '嫩江广场69号-1-3', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10041', '查究橱', '2', '瑞云街57号-19-2', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10042', '查坻篪', '1', '重庆大厦60号-7-2', '2018-12-10 17:50:34');
INSERT INTO `demo_customer` VALUES ('10043', '束礴规', '1', '重庆大厦44号-17-6', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10044', '束镍午', '1', '黄海街113号-20-2', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10045', '束芤叶', '1', '鱼山广场40号-11-10', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10046', '束客琛', '1', '刘家峡路114号-6-10', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10047', '束涟破', '2', '兴阳路88号-6-5', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10048', '束馇鹎', '2', '莘县路57号-19-1', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10049', '束圉啡', '2', '中川路45号-17-6', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10050', '束迁纥', '2', '团岛二路55号-10-2', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10051', '束枪辰', '1', '广西街63号-7-1', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10052', '束停艳', '1', '屏东支路68号-6-8', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10053', '徐熘', '1', '仙山街148号-19-2', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10054', '徐砻', '1', '珠海一广场137号-4-3', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10055', '徐痛', '2', '崇阳街51号-17-4', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10056', '徐葶', '2', '青海支路130号-14-5', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10057', '徐崾', '2', '王家麦岛22号-13-10', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10058', '徐灯', '2', '洮南大厦126号-14-5', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10059', '徐恨', '2', '仙游路111号-19-1', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10060', '徐笺', '1', '风岗街111号-15-4', '2018-12-10 17:50:35');
INSERT INTO `demo_customer` VALUES ('10061', '徐坯', '1', '雒口大厦26号-12-4', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10062', '冯资崾', '1', '掖县路28号-11-7', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10063', '冯崭莆', '2', '大港沿82号-6-8', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10064', '冯儆倔', '2', '章丘路51号-3-3', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10065', '冯缸辙', '1', '泗水大厦24号-19-10', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10066', '冯耷膻', '1', '云霄大厦96号-18-7', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10067', '冯伊鹱', '1', '天台路90号-12-9', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10068', '冯蓑咦', '1', '广饶支街44号-8-5', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10069', '冯皑症', '2', '西陵峡三路54号-1-3', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10070', '冯藕泼', '2', '宁国一支广场48号-4-4', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10071', '佘锆岢', '2', '大港一广场133号-17-2', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10072', '佘乙洇', '2', '绣城路69号-14-2', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10073', '佘氍芍', '2', '宁国四街113号-2-4', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10074', '佘椽毹', '1', '寿张街79号-7-5', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10075', '佘诀袂', '2', '重庆大厦91号-13-8', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10076', '莘绊', '2', '黄海街105号-18-6', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10077', '莘戍', '1', '淄川广场117号-3-1', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10078', '莘苍', '1', '宁国四街107号-13-5', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10079', '莘发', '1', '乐清广场73号-20-10', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10080', '莘河', '1', '曲阜街56号-8-7', '2018-12-10 17:50:36');
INSERT INTO `demo_customer` VALUES ('10081', '莘速', '2', '观城路104号-1-6', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10082', '莘喵', '2', '孟庄广场113号-6-3', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10083', '包铝', '1', '港环路67号-7-7', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10084', '包松', '1', '滋阳街111号-19-7', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10085', '包淞', '1', '海川路46号-15-2', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10086', '包乐', '2', '吴兴大厦113号-7-5', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10087', '包陟', '1', '即墨路74号-6-6', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10088', '包倒', '2', '西江广场64号-13-1', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10089', '包抿', '1', '刘家峡路39号-8-9', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10090', '包荃', '1', '德盛街106号-7-7', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10091', '包疗', '1', '鱼山支街95号-7-2', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10092', '奚芜帛', '2', '标山路49号-15-1', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10093', '奚堙柏', '1', '宁国一大厦108号-20-4', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10094', '奚淦凇', '1', '红岛支大厦74号-15-9', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10095', '奚嘞迷', '2', '掖县路53号-11-4', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10096', '奚较殷', '1', '澳门七广场98号-15-7', '2018-12-10 17:50:37');
INSERT INTO `demo_customer` VALUES ('10097', '奚琢缇', '1', '荷泽三大厦118号-14-1', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10098', '奚痊彭', '1', '春城街96号-6-7', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10099', '奚内喊', '2', '观海二广场118号-12-5', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10100', '奚浪负', '2', '苏州街134号-1-10', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10101', '奚忄麸', '2', '长兴街121号-14-4', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10102', '奚卧臀', '1', '漳浦广场96号-17-9', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10103', '胶叨沙', '1', '丰县广场132号-10-5', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10104', '胶堪虎', '2', '太平角五路45号-1-5', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10105', '胶永襟', '1', '大学广场123号-18-3', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10106', '胶催域', '1', '红岛支大厦125号-6-3', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10107', '胶闶舟', '2', '宁国一大厦138号-11-9', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10108', '胶襄墨', '2', '西陵峡三路58号-3-9', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10109', '胶跎俺', '1', '广西街146号-1-1', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10110', '胶嘏缗', '1', '大名路136号-17-5', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10111', '胶殳匀', '2', '古田路147号-9-2', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10112', '瞿邰', '1', '巫峡大厦67号-7-1', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10113', '瞿里', '1', '蒙阴大厦125号-9-10', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10114', '瞿覃', '2', '仙山街12号-6-2', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10115', '瞿闰', '2', '济南街27号-6-9', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10116', '瞿泪', '2', '徐家麦岛函谷关广场105号-10-2', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10117', '瞿跆', '1', '福山大厦102号-11-8', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10118', '瞿咎', '2', '兴安支街70号-4-1', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10119', '瞿塘', '1', '台南路36号-6-9', '2018-12-10 17:50:38');
INSERT INTO `demo_customer` VALUES ('10120', '瞿敬', '1', '仰口街50号-2-2', '2018-12-10 17:50:39');
INSERT INTO `demo_customer` VALUES ('10121', '瞿靡', '2', '天台东二街113号-19-5', '2018-12-10 17:50:39');

-- ----------------------------
-- Table structure for demo_goods
-- ----------------------------
DROP TABLE IF EXISTS `demo_goods`;
CREATE TABLE `demo_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT '0' COMMENT '单价',
  `detail` varchar(255) DEFAULT NULL COMMENT '详情',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8 COMMENT='示例商品表';

-- ----------------------------
-- Records of demo_goods
-- ----------------------------
INSERT INTO `demo_goods` VALUES ('10000', '小米8', '3799', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', 'https://imgservice.suning.cn/uimg1/b2c/image/vZXxfEEZ1yYg2Cw2p9Yk0w.jpg_800w_800h_4e', '2018-12-01 14:43:18');
INSERT INTO `demo_goods` VALUES ('10001', '华为Mate20 pro', '5999', 'HUAWEI/华为Mate 20 极光色 6GB+128GB 麒麟980芯片全面屏徕卡三摄移动联通电信4G手机', 'https://imgservice.suning.cn/uimg1/b2c/image/FGsGbl26_-wt2dcYaweaPA.jpg_800w_800h_4e', '2018-12-07 14:43:18');
INSERT INTO `demo_goods` VALUES ('10002', '魅族 16th', '2698', '骁龙845 AI加速 屏幕下指纹 AI双摄光学防抖', 'https://openfile.meizu.com/group1/M00/05/E1/Cgbj0FtqgmuAHzQbAAflWG0_wvs749.png680x680.jpg', '2018-12-10 09:45:21');

-- ----------------------------
-- Table structure for demo_order
-- ----------------------------
DROP TABLE IF EXISTS `demo_order`;
CREATE TABLE `demo_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL COMMENT '顾客id',
  `order_sn` varchar(255) DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(1) DEFAULT '1' COMMENT '订单状态 1 待付款 2 待发货 3 待收货 4 完成',
  `order_price` double DEFAULT '0' COMMENT '订单总价',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `order_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10075 DEFAULT CHARSET=utf8 COMMENT='示例订单表';

-- ----------------------------
-- Records of demo_order
-- ----------------------------
INSERT INTO `demo_order` VALUES ('10000', '10000', 'OSN1111111', '1', '3799', '黑色 64G', '2018-12-07 14:48:17', '2018-12-07 14:48:17');
INSERT INTO `demo_order` VALUES ('10001', '10001', 'OSN2222222', '2', '5999', '官方标配 星空蓝', '2018-12-06 14:48:17', '2018-12-07 14:48:17');
INSERT INTO `demo_order` VALUES ('10002', '10004', 'OSN80510312', '4', '3799', '黑色 64G', '2018-12-10 18:13:40', '2018-12-10 18:13:40');
INSERT INTO `demo_order` VALUES ('10003', '10017', 'OSN93633374', '4', '3799', '黑色 64G', '2018-12-10 18:13:40', '2018-12-10 18:13:40');
INSERT INTO `demo_order` VALUES ('10004', '10024', 'OSN27653729', '3', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10005', '10061', 'OSN47728401', '3', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10006', '10059', 'OSN92402286', '2', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10007', '10113', 'OSN34195869', '3', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10008', '10039', 'OSN04429246', '4', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10009', '10080', 'OSN11928400', '2', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10010', '10101', 'OSN16000741', '2', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10011', '10091', 'OSN49661065', '1', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10012', '10038', 'OSN08237282', '1', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10013', '10024', 'OSN34181899', '1', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10014', '10098', 'OSN07883860', '1', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10015', '10042', 'OSN42685896', '1', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10016', '10037', 'OSN21001570', '4', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10017', '10066', 'OSN26407456', '2', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10018', '10088', 'OSN32759571', '3', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10019', '10078', 'OSN04137251', '1', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10020', '10006', 'OSN97092584', '4', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10021', '10064', 'OSN58239265', '2', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10022', '10006', 'OSN90287547', '3', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10023', '10094', 'OSN01933580', '4', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10024', '10101', 'OSN08735679', '3', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10025', '10010', 'OSN19145770', '4', '3799', '黑色 64G', '2018-12-10 18:13:41', '2018-12-10 18:13:41');
INSERT INTO `demo_order` VALUES ('10026', '10079', 'OSN67849827', '2', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10027', '10037', 'OSN91840949', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10028', '10014', 'OSN43712435', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10029', '10087', 'OSN47514024', '2', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10030', '10100', 'OSN41755729', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10031', '10038', 'OSN70178658', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10032', '10109', 'OSN96374397', '2', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10033', '10107', 'OSN33832915', '3', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10034', '10050', 'OSN57231147', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10035', '10030', 'OSN41621112', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10036', '10087', 'OSN94666884', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10037', '10037', 'OSN06969429', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10038', '10026', 'OSN17959200', '2', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10039', '10028', 'OSN15796843', '2', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10040', '10006', 'OSN53289620', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10041', '10028', 'OSN43064911', '3', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10042', '10087', 'OSN78460900', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10043', '10031', 'OSN74566189', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10044', '10066', 'OSN00253407', '2', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10045', '10030', 'OSN54699711', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10046', '10105', 'OSN07949408', '4', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10047', '10037', 'OSN79874981', '1', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10048', '10099', 'OSN14370894', '3', '3799', '黑色 64G', '2018-12-10 18:13:42', '2018-12-10 18:13:42');
INSERT INTO `demo_order` VALUES ('10049', '10094', 'OSN64922542', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10050', '10080', 'OSN01313588', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10051', '10092', 'OSN45980780', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10052', '10037', 'OSN37873548', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10053', '10065', 'OSN49609706', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10054', '10060', 'OSN56832515', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10055', '10119', 'OSN31253021', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10056', '10091', 'OSN57095288', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10057', '10029', 'OSN92614265', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10058', '10065', 'OSN00202906', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10059', '10119', 'OSN21334261', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10060', '10012', 'OSN83283978', '1', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10061', '10086', 'OSN36656961', '1', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10062', '10055', 'OSN45929462', '1', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10063', '10091', 'OSN68941207', '4', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10064', '10059', 'OSN09113662', '1', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10065', '10117', 'OSN04513909', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10066', '10023', 'OSN21040669', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10067', '10069', 'OSN76171779', '4', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10068', '10017', 'OSN84774767', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10069', '10054', 'OSN42741676', '2', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10070', '10098', 'OSN70641881', '3', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10071', '10011', 'OSN11636750', '1', '3799', '黑色 64G', '2018-12-10 18:13:43', '2018-12-10 18:13:43');
INSERT INTO `demo_order` VALUES ('10072', '10046', 'OSN35927250', '2', '3799', '黑色 64G', '2018-12-10 18:13:44', '2018-12-10 18:13:44');
INSERT INTO `demo_order` VALUES ('10073', '10013', 'OSN00415777', '1', '3799', '黑色 64G', '2018-12-10 18:13:44', '2018-12-10 18:13:44');
INSERT INTO `demo_order` VALUES ('10074', '10051', 'OSN58408076', '1', '3799', '黑色 64G', '2018-12-10 18:13:44', '2018-12-10 18:13:44');

-- ----------------------------
-- Table structure for demo_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `demo_order_goods`;
CREATE TABLE `demo_order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10076 DEFAULT CHARSET=utf8 COMMENT='示例订单商品表';

-- ----------------------------
-- Records of demo_order_goods
-- ----------------------------
INSERT INTO `demo_order_goods` VALUES ('10000', '10000', '10000', '2018-12-07 15:08:03');
INSERT INTO `demo_order_goods` VALUES ('10001', '10001', '10001', '2018-12-07 15:08:03');
INSERT INTO `demo_order_goods` VALUES ('10002', '10001', '10002', '2018-12-10 09:45:21');
INSERT INTO `demo_order_goods` VALUES ('10003', '10002', '10001', '2018-12-10 18:13:40');
INSERT INTO `demo_order_goods` VALUES ('10004', '10003', '10002', '2018-12-10 18:13:40');
INSERT INTO `demo_order_goods` VALUES ('10005', '10004', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10006', '10005', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10007', '10006', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10008', '10007', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10009', '10008', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10010', '10009', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10011', '10010', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10012', '10011', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10013', '10012', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10014', '10013', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10015', '10014', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10016', '10015', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10017', '10016', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10018', '10017', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10019', '10018', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10020', '10019', '10000', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10021', '10020', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10022', '10021', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10023', '10022', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10024', '10023', '10002', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10025', '10024', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10026', '10025', '10001', '2018-12-10 18:13:41');
INSERT INTO `demo_order_goods` VALUES ('10027', '10026', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10028', '10027', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10029', '10028', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10030', '10029', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10031', '10030', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10032', '10031', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10033', '10032', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10034', '10033', '10002', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10035', '10034', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10036', '10035', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10037', '10036', '10002', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10038', '10037', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10039', '10038', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10040', '10039', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10041', '10040', '10002', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10042', '10041', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10043', '10042', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10044', '10043', '10002', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10045', '10044', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10046', '10045', '10002', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10047', '10046', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10048', '10047', '10000', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10049', '10048', '10001', '2018-12-10 18:13:42');
INSERT INTO `demo_order_goods` VALUES ('10050', '10049', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10051', '10050', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10052', '10051', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10053', '10052', '10002', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10054', '10053', '10002', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10055', '10054', '10002', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10056', '10055', '10002', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10057', '10056', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10058', '10057', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10059', '10058', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10060', '10059', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10061', '10060', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10062', '10061', '10002', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10063', '10062', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10064', '10063', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10065', '10064', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10066', '10065', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10067', '10066', '10002', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10068', '10067', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10069', '10068', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10070', '10069', '10001', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10071', '10070', '10000', '2018-12-10 18:13:43');
INSERT INTO `demo_order_goods` VALUES ('10072', '10071', '10000', '2018-12-10 18:13:44');
INSERT INTO `demo_order_goods` VALUES ('10073', '10072', '10002', '2018-12-10 18:13:44');
INSERT INTO `demo_order_goods` VALUES ('10074', '10073', '10001', '2018-12-10 18:13:44');
INSERT INTO `demo_order_goods` VALUES ('10075', '10074', '10000', '2018-12-10 18:13:44');

-- ----------------------------
-- Table structure for sys_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_key` varchar(255) DEFAULT NULL COMMENT '字典键',
  `code_type` varchar(255) DEFAULT NULL COMMENT '字典类型',
  `code_name` varchar(255) DEFAULT NULL COMMENT '字典名',
  `code_value` varchar(255) DEFAULT NULL COMMENT '字典值',
  `order_number` int(3) DEFAULT '0' COMMENT '排序',
  `enabled` varchar(1) DEFAULT '1' COMMENT '生效标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10009 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_code
-- ----------------------------
INSERT INTO `sys_code` VALUES ('10000', 'S1', 'OrderStatus', '待付款', '1', '1', '1');
INSERT INTO `sys_code` VALUES ('10001', 'S2', 'OrderStatus', '待发货', '2', '2', '1');
INSERT INTO `sys_code` VALUES ('10002', 'S3', 'OrderStatus', '待收货', '3', '3', '1');
INSERT INTO `sys_code` VALUES ('10003', 'S4', 'OrderStatus', '已收货', '4', '4', '1');
INSERT INTO `sys_code` VALUES ('10004', 'S5', 'OrderStatus', '退款', '5', '5', '1');
INSERT INTO `sys_code` VALUES ('10005', 'S6', 'OrderStatus', '退货', '6', '6', '1');
INSERT INTO `sys_code` VALUES ('10006', 'S1', 'CustomerSex', '男', '1', '1', '1');
INSERT INTO `sys_code` VALUES ('10007', 'S2', 'CustomerSex', '女', '2', '2', '1');
INSERT INTO `sys_code` VALUES ('10008', 'S3', 'CustomerSex', '不明', '3', '3', '1');

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
INSERT INTO `sys_permission` VALUES ('100', 'demo', '示例', 'demo:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('101', 'demo', '示例', 'demo:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('102', 'demo', '示例', 'demo:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('103', 'demo', '示例', 'demo:delete', '删除', '2');
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户管理', 'user:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户管理', 'user:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户管理', 'user:update', '修改', '2');
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
INSERT INTO `sys_role` VALUES ('3', '程序员', '2017-11-22 16:28:47', '2018-12-11 09:51:22', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

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
INSERT INTO `sys_role_permission` VALUES ('42', '1', '100', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('43', '1', '101', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('44', '1', '102', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('45', '1', '103', '2018-12-07 11:52:43', '2018-12-07 11:52:43', '1');
INSERT INTO `sys_role_permission` VALUES ('50', '3', '601', '2018-12-11 09:51:22', '2018-12-11 09:51:22', '1');
INSERT INTO `sys_role_permission` VALUES ('51', '3', '603', '2018-12-11 09:51:22', '2018-12-11 09:51:22', '1');
INSERT INTO `sys_role_permission` VALUES ('52', '3', '701', '2018-12-11 09:51:22', '2018-12-11 09:51:22', '1');
INSERT INTO `sys_role_permission` VALUES ('53', '3', '702', '2018-12-11 09:51:22', '2018-12-11 09:51:22', '1');
INSERT INTO `sys_role_permission` VALUES ('54', '3', '704', '2018-12-11 09:51:22', '2018-12-11 09:51:22', '1');

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
INSERT INTO `sys_user` VALUES ('10004', 'user', '123456', '莎士比亚', '2', '2017-10-30 16:13:02', '2018-12-11 09:50:25', '1');
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
