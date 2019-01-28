
create user 'test'@'%' identified by '123456';
create database spring_db DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
grant all privileges on `spring_db`.* to 'test'@'%' identified by '123456';
flush privileges;

SET FOREIGN_KEY_CHECKS=0;

/*
Navicat MySQL Data Transfer

Source Server         : local_db
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : spring_jpa

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-01-28 11:50:16
*/


-- ----------------------------
-- Table structure for demo_customer
-- ----------------------------
DROP TABLE IF EXISTS `demo_customer`;
CREATE TABLE `demo_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_customer
-- ----------------------------
INSERT INTO `demo_customer` VALUES ('10085', '海川路46号-15-2', '2018-12-10 17:50:37', '包淞', '1', null);
INSERT INTO `demo_customer` VALUES ('10086', '吴兴大厦113号-7-5', '2018-12-10 17:50:37', '包乐', '2', null);
INSERT INTO `demo_customer` VALUES ('10087', '即墨路74号-6-6', '2018-12-10 17:50:37', '包陟', '1', null);
INSERT INTO `demo_customer` VALUES ('10088', '西江广场64号-13-1', '2018-12-10 17:50:37', '包倒', '2', null);
INSERT INTO `demo_customer` VALUES ('10089', '刘家峡路39号-8-9', '2018-12-10 17:50:37', '包抿', '1', null);
INSERT INTO `demo_customer` VALUES ('10090', '德盛街106号-7-7', '2018-12-10 17:50:37', '包荃', '1', null);
INSERT INTO `demo_customer` VALUES ('10091', '鱼山支街95号-7-2', '2018-12-10 17:50:37', '包疗', '1', null);
INSERT INTO `demo_customer` VALUES ('10092', '标山路49号-15-1', '2018-12-10 17:50:37', '奚芜帛', '2', null);
INSERT INTO `demo_customer` VALUES ('10093', '宁国一大厦108号-20-4', '2018-12-10 17:50:37', '奚堙柏', '1', null);
INSERT INTO `demo_customer` VALUES ('10094', '红岛支大厦74号-15-9', '2018-12-10 17:50:37', '奚淦凇', '1', null);
INSERT INTO `demo_customer` VALUES ('10095', '掖县路53号-11-4', '2018-12-10 17:50:37', '奚嘞迷', '2', null);
INSERT INTO `demo_customer` VALUES ('10096', '澳门七广场98号-15-7', '2018-12-10 17:50:37', '奚较殷', '1', null);
INSERT INTO `demo_customer` VALUES ('10097', '荷泽三大厦118号-14-1', '2018-12-10 17:50:38', '奚琢缇', '1', null);
INSERT INTO `demo_customer` VALUES ('10098', '春城街96号-6-7', '2018-12-10 17:50:38', '奚痊彭', '1', null);
INSERT INTO `demo_customer` VALUES ('10099', '观海二广场118号-12-5', '2018-12-10 17:50:38', '奚内喊', '2', null);
INSERT INTO `demo_customer` VALUES ('10100', '苏州街134号-1-10', '2018-12-10 17:50:38', '奚浪负', '2', null);
INSERT INTO `demo_customer` VALUES ('10101', '长兴街121号-14-4', '2018-12-10 17:50:38', '奚忄麸', '2', null);
INSERT INTO `demo_customer` VALUES ('10102', '漳浦广场96号-17-9', '2018-12-10 17:50:38', '奚卧臀', '1', null);
INSERT INTO `demo_customer` VALUES ('10103', '丰县广场132号-10-5', '2018-12-10 17:50:38', '胶叨沙', '1', null);
INSERT INTO `demo_customer` VALUES ('10104', '太平角五路45号-1-5', '2018-12-10 17:50:38', '胶堪虎', '2', null);
INSERT INTO `demo_customer` VALUES ('10105', '大学广场123号-18-3', '2018-12-10 17:50:38', '胶永襟', '1', null);
INSERT INTO `demo_customer` VALUES ('10106', '红岛支大厦125号-6-3', '2018-12-10 17:50:38', '胶催域', '1', null);
INSERT INTO `demo_customer` VALUES ('10107', '宁国一大厦138号-11-9', '2018-12-10 17:50:38', '胶闶舟', '2', null);
INSERT INTO `demo_customer` VALUES ('10108', '西陵峡三路58号-3-9', '2018-12-10 17:50:38', '胶襄墨', '2', null);
INSERT INTO `demo_customer` VALUES ('10109', '广西街146号-1-1', '2018-12-10 17:50:38', '胶跎俺', '1', null);
INSERT INTO `demo_customer` VALUES ('10110', '大名路136号-17-5', '2018-12-10 17:50:38', '胶嘏缗', '1', null);
INSERT INTO `demo_customer` VALUES ('10111', '古田路147号-9-2', '2018-12-10 17:50:38', '胶殳匀', '2', null);
INSERT INTO `demo_customer` VALUES ('10112', '巫峡大厦67号-7-1', '2018-12-10 17:50:38', '瞿邰', '1', null);
INSERT INTO `demo_customer` VALUES ('10113', '蒙阴大厦125号-9-10', '2018-12-10 17:50:38', '瞿里', '1', null);
INSERT INTO `demo_customer` VALUES ('10114', '仙山街12号-6-2', '2018-12-10 17:50:38', '瞿覃', '2', null);
INSERT INTO `demo_customer` VALUES ('10115', '济南街27号-6-9', '2018-12-10 17:50:38', '瞿闰', '2', null);
INSERT INTO `demo_customer` VALUES ('10116', '徐家麦岛函谷关广场105号-10-2', '2018-12-10 17:50:38', '瞿泪', '2', null);
INSERT INTO `demo_customer` VALUES ('10117', '福山大厦102号-11-8', '2018-12-10 17:50:38', '瞿跆', '1', null);
INSERT INTO `demo_customer` VALUES ('10118', '兴安支街70号-4-1', '2018-12-10 17:50:38', '瞿咎', '2', null);
INSERT INTO `demo_customer` VALUES ('10119', '台南路36号-6-9', '2018-12-10 17:50:38', '瞿塘', '1', null);
INSERT INTO `demo_customer` VALUES ('10120', '仰口街50号-2-2', '2018-12-10 17:50:39', '瞿敬', '1', null);
INSERT INTO `demo_customer` VALUES ('10121', '天台东二街113号-19-5', '2018-12-10 17:50:39', '瞿靡', '2', null);
INSERT INTO `demo_customer` VALUES ('10000', '北京市丰台区大红门街道123号', '2018-12-07 14:43:18', '刘先生', '1', null);
INSERT INTO `demo_customer` VALUES ('10001', '北京市海淀区羊坊店路10号', '2018-12-07 14:43:18', '张先生', '1', null);
INSERT INTO `demo_customer` VALUES ('10002', '十梅庵街45号-18-7', '2018-12-10 17:50:32', '阎忙图', '1', null);
INSERT INTO `demo_customer` VALUES ('10003', '滋阳街56号-18-1', '2018-12-10 17:50:32', '陈亭', '2', null);
INSERT INTO `demo_customer` VALUES ('10004', '青威高速76号-4-2', '2018-12-10 17:50:32', '胶藐', '1', null);
INSERT INTO `demo_customer` VALUES ('10005', '大港纬一路61号-1-3', '2018-12-10 17:50:32', '胶腋', '2', null);
INSERT INTO `demo_customer` VALUES ('10006', '常州街53号-16-1', '2018-12-10 17:50:32', '胶兰', '1', null);
INSERT INTO `demo_customer` VALUES ('10007', '巨野大厦141号-11-4', '2018-12-10 17:50:32', '殳茏郡', '1', null);
INSERT INTO `demo_customer` VALUES ('10008', '香港西大厦142号-5-7', '2018-12-10 17:50:32', '殳谵滗', '2', null);
INSERT INTO `demo_customer` VALUES ('10009', '博兴路71号-19-4', '2018-12-10 17:50:32', '殳朦扈', '2', null);
INSERT INTO `demo_customer` VALUES ('10010', '合江路108号-11-2', '2018-12-10 17:50:33', '殳铤睿', '1', null);
INSERT INTO `demo_customer` VALUES ('10011', '安邱街95号-7-4', '2018-12-10 17:50:33', '乌弃隈', '2', null);
INSERT INTO `demo_customer` VALUES ('10012', '泰兴广场68号-2-2', '2018-12-10 17:50:33', '乌逆剐', '1', null);
INSERT INTO `demo_customer` VALUES ('10013', '泰山广场130号-8-5', '2018-12-10 17:50:33', '乌棹震', '2', null);
INSERT INTO `demo_customer` VALUES ('10014', '天台二路64号-15-9', '2018-12-10 17:50:33', '乌野郜', '2', null);
INSERT INTO `demo_customer` VALUES ('10015', '临淄路53号-1-3', '2018-12-10 17:50:33', '乌陕兴', '1', null);
INSERT INTO `demo_customer` VALUES ('10016', '浙江路116号-17-2', '2018-12-10 17:50:33', '乌缆鹰', '2', null);
INSERT INTO `demo_customer` VALUES ('10017', '咸阳广场80号-13-1', '2018-12-10 17:50:33', '奚刘', '2', null);
INSERT INTO `demo_customer` VALUES ('10018', '青大街66号-20-2', '2018-12-10 17:50:33', '奚佃', '2', null);
INSERT INTO `demo_customer` VALUES ('10019', '徐州大厦22号-12-7', '2018-12-10 17:50:33', '奚澌', '1', null);
INSERT INTO `demo_customer` VALUES ('10020', '海门路113号-5-10', '2018-12-10 17:50:33', '奚侨', '1', null);
INSERT INTO `demo_customer` VALUES ('10021', '博兴路144号-19-8', '2018-12-10 17:50:34', '奚堋', '2', null);
INSERT INTO `demo_customer` VALUES ('10022', '港环路25号-15-10', '2018-12-10 17:50:34', '过饮', '1', null);
INSERT INTO `demo_customer` VALUES ('10023', '浦口广场85号-2-3', '2018-12-10 17:50:34', '过夷', '1', null);
INSERT INTO `demo_customer` VALUES ('10024', '华山路90号-6-3', '2018-12-10 17:50:34', '成偕', '2', null);
INSERT INTO `demo_customer` VALUES ('10025', '丹东街63号-8-5', '2018-12-10 17:50:34', '成墩', '1', null);
INSERT INTO `demo_customer` VALUES ('10026', '长兴街46号-20-5', '2018-12-10 17:50:34', '成癜', '2', null);
INSERT INTO `demo_customer` VALUES ('10027', '巢湖街27号-4-8', '2018-12-10 17:50:34', '成胭', '2', null);
INSERT INTO `demo_customer` VALUES ('10028', '南九水街100号-5-10', '2018-12-10 17:50:34', '成奂', '2', null);
INSERT INTO `demo_customer` VALUES ('10029', '台东三街81号-15-9', '2018-12-10 17:50:34', '成楼', '1', null);
INSERT INTO `demo_customer` VALUES ('10030', '泰城街67号-13-7', '2018-12-10 17:50:34', '成粢', '1', null);
INSERT INTO `demo_customer` VALUES ('10031', '晓望街15号-13-6', '2018-12-10 17:50:34', '成建', '1', null);
INSERT INTO `demo_customer` VALUES ('10032', '红岛路115号-9-6', '2018-12-10 17:50:34', '成罔', '2', null);
INSERT INTO `demo_customer` VALUES ('10033', '延安三路69号-12-2', '2018-12-10 17:50:34', '成系', '2', null);
INSERT INTO `demo_customer` VALUES ('10034', '屏东广场39号-16-4', '2018-12-10 17:50:34', '查玢盍', '1', null);
INSERT INTO `demo_customer` VALUES ('10035', '京山广场148号-16-10', '2018-12-10 17:50:34', '查囔囡', '2', null);
INSERT INTO `demo_customer` VALUES ('10036', '三明路84号-1-9', '2018-12-10 17:50:34', '查除觞', '2', null);
INSERT INTO `demo_customer` VALUES ('10037', '东海西路86号-4-9', '2018-12-10 17:50:34', '查渤筐', '2', null);
INSERT INTO `demo_customer` VALUES ('10038', '城武大厦13号-9-4', '2018-12-10 17:50:34', '查栳挞', '1', null);
INSERT INTO `demo_customer` VALUES ('10039', '新田路83号-12-1', '2018-12-10 17:50:34', '查鲡蒽', '1', null);
INSERT INTO `demo_customer` VALUES ('10040', '嫩江广场69号-1-3', '2018-12-10 17:50:34', '查刳诘', '2', null);
INSERT INTO `demo_customer` VALUES ('10041', '瑞云街57号-19-2', '2018-12-10 17:50:34', '查究橱', '2', null);
INSERT INTO `demo_customer` VALUES ('10042', '重庆大厦60号-7-2', '2018-12-10 17:50:34', '查坻篪', '1', null);
INSERT INTO `demo_customer` VALUES ('10043', '重庆大厦44号-17-6', '2018-12-10 17:50:35', '束礴规', '1', null);
INSERT INTO `demo_customer` VALUES ('10044', '黄海街113号-20-2', '2018-12-10 17:50:35', '束镍午', '1', null);
INSERT INTO `demo_customer` VALUES ('10045', '鱼山广场40号-11-10', '2018-12-10 17:50:35', '束芤叶', '1', null);
INSERT INTO `demo_customer` VALUES ('10046', '刘家峡路114号-6-10', '2018-12-10 17:50:35', '束客琛', '1', null);
INSERT INTO `demo_customer` VALUES ('10047', '兴阳路88号-6-5', '2018-12-10 17:50:35', '束涟破', '2', null);
INSERT INTO `demo_customer` VALUES ('10048', '莘县路57号-19-1', '2018-12-10 17:50:35', '束馇鹎', '2', null);
INSERT INTO `demo_customer` VALUES ('10049', '中川路45号-17-6', '2018-12-10 17:50:35', '束圉啡', '2', null);
INSERT INTO `demo_customer` VALUES ('10050', '团岛二路55号-10-2', '2018-12-10 17:50:35', '束迁纥', '2', null);
INSERT INTO `demo_customer` VALUES ('10051', '广西街63号-7-1', '2018-12-10 17:50:35', '束枪辰', '1', null);
INSERT INTO `demo_customer` VALUES ('10052', '屏东支路68号-6-8', '2018-12-10 17:50:35', '束停艳', '1', null);
INSERT INTO `demo_customer` VALUES ('10053', '仙山街148号-19-2', '2018-12-10 17:50:35', '徐熘', '1', null);
INSERT INTO `demo_customer` VALUES ('10054', '珠海一广场137号-4-3', '2018-12-10 17:50:35', '徐砻', '1', null);
INSERT INTO `demo_customer` VALUES ('10055', '崇阳街51号-17-4', '2018-12-10 17:50:35', '徐痛', '2', null);
INSERT INTO `demo_customer` VALUES ('10056', '青海支路130号-14-5', '2018-12-10 17:50:35', '徐葶', '2', null);
INSERT INTO `demo_customer` VALUES ('10057', '王家麦岛22号-13-10', '2018-12-10 17:50:35', '徐崾', '2', null);
INSERT INTO `demo_customer` VALUES ('10058', '洮南大厦126号-14-5', '2018-12-10 17:50:35', '徐灯', '2', null);
INSERT INTO `demo_customer` VALUES ('10059', '仙游路111号-19-1', '2018-12-10 17:50:35', '徐恨', '2', null);
INSERT INTO `demo_customer` VALUES ('10060', '风岗街111号-15-4', '2018-12-10 17:50:35', '徐笺', '1', null);
INSERT INTO `demo_customer` VALUES ('10061', '雒口大厦26号-12-4', '2018-12-10 17:50:36', '徐坯', '1', null);
INSERT INTO `demo_customer` VALUES ('10062', '掖县路28号-11-7', '2018-12-10 17:50:36', '冯资崾', '1', null);
INSERT INTO `demo_customer` VALUES ('10063', '大港沿82号-6-8', '2018-12-10 17:50:36', '冯崭莆', '2', null);
INSERT INTO `demo_customer` VALUES ('10064', '章丘路51号-3-3', '2018-12-10 17:50:36', '冯儆倔', '2', null);
INSERT INTO `demo_customer` VALUES ('10065', '泗水大厦24号-19-10', '2018-12-10 17:50:36', '冯缸辙', '1', null);
INSERT INTO `demo_customer` VALUES ('10066', '云霄大厦96号-18-7', '2018-12-10 17:50:36', '冯耷膻', '1', null);
INSERT INTO `demo_customer` VALUES ('10067', '天台路90号-12-9', '2018-12-10 17:50:36', '冯伊鹱', '1', null);
INSERT INTO `demo_customer` VALUES ('10068', '广饶支街44号-8-5', '2018-12-10 17:50:36', '冯蓑咦', '1', null);
INSERT INTO `demo_customer` VALUES ('10069', '西陵峡三路54号-1-3', '2018-12-10 17:50:36', '冯皑症', '2', null);
INSERT INTO `demo_customer` VALUES ('10070', '宁国一支广场48号-4-4', '2018-12-10 17:50:36', '冯藕泼', '2', null);
INSERT INTO `demo_customer` VALUES ('10071', '大港一广场133号-17-2', '2018-12-10 17:50:36', '佘锆岢', '2', null);
INSERT INTO `demo_customer` VALUES ('10072', '绣城路69号-14-2', '2018-12-10 17:50:36', '佘乙洇', '2', null);
INSERT INTO `demo_customer` VALUES ('10073', '宁国四街113号-2-4', '2018-12-10 17:50:36', '佘氍芍', '2', null);
INSERT INTO `demo_customer` VALUES ('10074', '寿张街79号-7-5', '2018-12-10 17:50:36', '佘椽毹', '1', null);
INSERT INTO `demo_customer` VALUES ('10075', '重庆大厦91号-13-8', '2018-12-10 17:50:36', '佘诀袂', '2', null);
INSERT INTO `demo_customer` VALUES ('10076', '黄海街105号-18-6', '2018-12-10 17:50:36', '莘绊', '2', null);
INSERT INTO `demo_customer` VALUES ('10077', '淄川广场117号-3-1', '2018-12-10 17:50:36', '莘戍', '1', null);
INSERT INTO `demo_customer` VALUES ('10078', '宁国四街107号-13-5', '2018-12-10 17:50:36', '莘苍', '1', null);
INSERT INTO `demo_customer` VALUES ('10079', '乐清广场73号-20-10', '2018-12-10 17:50:36', '莘发', '1', null);
INSERT INTO `demo_customer` VALUES ('10080', '曲阜街56号-8-7', '2018-12-10 17:50:36', '莘河', '1', null);
INSERT INTO `demo_customer` VALUES ('10081', '观城路104号-1-6', '2018-12-10 17:50:37', '莘速', '2', null);
INSERT INTO `demo_customer` VALUES ('10082', '孟庄广场113号-6-3', '2018-12-10 17:50:37', '莘喵', '2', null);
INSERT INTO `demo_customer` VALUES ('10083', '港环路67号-7-7', '2018-12-10 17:50:37', '包铝', '1', null);
INSERT INTO `demo_customer` VALUES ('10084', '滋阳街111号-19-7', '2018-12-10 17:50:37', '包松', '1', null);

-- ----------------------------
-- Table structure for demo_goods
-- ----------------------------
DROP TABLE IF EXISTS `demo_goods`;
CREATE TABLE `demo_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_goods
-- ----------------------------
INSERT INTO `demo_goods` VALUES ('10000', '2018-12-01 14:43:18', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', '小米8', 'https://imgservice.suning.cn/uimg1/b2c/image/vZXxfEEZ1yYg2Cw2p9Yk0w.jpg_800w_800h_4e', '3799', null);
INSERT INTO `demo_goods` VALUES ('10001', '2018-12-07 14:43:18', 'HUAWEI/华为Mate 20 极光色 6GB+128GB 麒麟980芯片全面屏徕卡三摄移动联通电信4G手机', '华为Mate20 pro', 'https://imgservice.suning.cn/uimg1/b2c/image/FGsGbl26_-wt2dcYaweaPA.jpg_800w_800h_4e', '5999', null);
INSERT INTO `demo_goods` VALUES ('10002', '2018-12-10 09:45:21', '骁龙845 AI加速 屏幕下指纹 AI双摄光学防抖', '魅族 16th', 'https://openfile.meizu.com/group1/M00/05/E1/Cgbj0FtqgmuAHzQbAAflWG0_wvs749.png680x680.jpg', '2698', null);

-- ----------------------------
-- Table structure for demo_order
-- ----------------------------
DROP TABLE IF EXISTS `demo_order`;
CREATE TABLE `demo_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  `order_sn` varchar(255) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `is_enabled` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKms5b3xpnxmublhhepnduc5d7` (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_order
-- ----------------------------
INSERT INTO `demo_order` VALUES ('10000', '2018-12-07 14:48:17', '黑色 64G', '3799', 'OSN1111111', '1', '2018-12-07 14:48:17', null, '10000', '1');
INSERT INTO `demo_order` VALUES ('10001', '2018-12-07 14:48:17', '官方标配 星空蓝', '5999', 'OSN2222222', '2', '2018-12-06 14:48:17', null, '10001', '1');
INSERT INTO `demo_order` VALUES ('10002', '2018-12-10 18:13:40', '黑色 64G', '3799', 'OSN80510312', '4', '2018-12-10 18:13:40', null, '10004', '1');
INSERT INTO `demo_order` VALUES ('10003', '2018-12-10 18:13:40', '黑色 64G', '3799', 'OSN93633374', '4', '2018-12-10 18:13:40', null, '10017', '1');
INSERT INTO `demo_order` VALUES ('10004', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN27653729', '3', '2018-12-10 18:13:41', null, '10024', '1');
INSERT INTO `demo_order` VALUES ('10005', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN47728401', '3', '2018-12-10 18:13:41', null, '10061', '1');
INSERT INTO `demo_order` VALUES ('10006', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN92402286', '2', '2018-12-10 18:13:41', null, '10059', '1');
INSERT INTO `demo_order` VALUES ('10007', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN34195869', '3', '2018-12-10 18:13:41', null, '10113', '1');
INSERT INTO `demo_order` VALUES ('10008', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN04429246', '4', '2018-12-10 18:13:41', null, '10039', '1');
INSERT INTO `demo_order` VALUES ('10009', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN11928400', '2', '2018-12-10 18:13:41', null, '10080', '1');
INSERT INTO `demo_order` VALUES ('10010', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN16000741', '2', '2018-12-10 18:13:41', null, '10101', '1');
INSERT INTO `demo_order` VALUES ('10011', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN49661065', '1', '2018-12-10 18:13:41', null, '10091', '1');
INSERT INTO `demo_order` VALUES ('10012', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN08237282', '1', '2018-12-10 18:13:41', null, '10038', '1');
INSERT INTO `demo_order` VALUES ('10013', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN34181899', '1', '2018-12-10 18:13:41', null, '10024', '1');
INSERT INTO `demo_order` VALUES ('10014', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN07883860', '1', '2018-12-10 18:13:41', null, '10098', '1');
INSERT INTO `demo_order` VALUES ('10015', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN42685896', '1', '2018-12-10 18:13:41', null, '10042', '1');
INSERT INTO `demo_order` VALUES ('10016', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN21001570', '4', '2018-12-10 18:13:41', null, '10037', '1');
INSERT INTO `demo_order` VALUES ('10017', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN26407456', '2', '2018-12-10 18:13:41', null, '10066', '1');
INSERT INTO `demo_order` VALUES ('10018', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN32759571', '3', '2018-12-10 18:13:41', null, '10088', '1');
INSERT INTO `demo_order` VALUES ('10019', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN04137251', '1', '2018-12-10 18:13:41', null, '10078', '1');
INSERT INTO `demo_order` VALUES ('10020', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN97092584', '4', '2018-12-10 18:13:41', null, '10006', '1');
INSERT INTO `demo_order` VALUES ('10021', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN58239265', '2', '2018-12-10 18:13:41', null, '10064', '1');
INSERT INTO `demo_order` VALUES ('10022', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN90287547', '3', '2018-12-10 18:13:41', null, '10006', '1');
INSERT INTO `demo_order` VALUES ('10023', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN01933580', '4', '2018-12-10 18:13:41', null, '10094', '1');
INSERT INTO `demo_order` VALUES ('10024', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN08735679', '3', '2018-12-10 18:13:41', null, '10101', '1');
INSERT INTO `demo_order` VALUES ('10025', '2018-12-10 18:13:41', '黑色 64G', '3799', 'OSN19145770', '4', '2018-12-10 18:13:41', null, '10010', '1');
INSERT INTO `demo_order` VALUES ('10026', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN67849827', '2', '2018-12-10 18:13:42', null, '10079', '1');
INSERT INTO `demo_order` VALUES ('10027', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN91840949', '1', '2018-12-10 18:13:42', null, '10037', '1');
INSERT INTO `demo_order` VALUES ('10028', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN43712435', '1', '2018-12-10 18:13:42', null, '10014', '1');
INSERT INTO `demo_order` VALUES ('10029', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN47514024', '2', '2018-12-10 18:13:42', null, '10087', '1');
INSERT INTO `demo_order` VALUES ('10030', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN41755729', '1', '2018-12-10 18:13:42', null, '10100', '1');
INSERT INTO `demo_order` VALUES ('10031', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN70178658', '1', '2018-12-10 18:13:42', null, '10038', '1');
INSERT INTO `demo_order` VALUES ('10032', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN96374397', '2', '2018-12-10 18:13:42', null, '10109', '1');
INSERT INTO `demo_order` VALUES ('10033', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN33832915', '3', '2018-12-10 18:13:42', null, '10107', '1');
INSERT INTO `demo_order` VALUES ('10034', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN57231147', '1', '2018-12-10 18:13:42', null, '10050', '1');
INSERT INTO `demo_order` VALUES ('10035', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN41621112', '1', '2018-12-10 18:13:42', null, '10030', '1');
INSERT INTO `demo_order` VALUES ('10036', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN94666884', '1', '2018-12-10 18:13:42', null, '10087', '1');
INSERT INTO `demo_order` VALUES ('10037', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN06969429', '1', '2018-12-10 18:13:42', null, '10037', '1');
INSERT INTO `demo_order` VALUES ('10038', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN17959200', '2', '2018-12-10 18:13:42', null, '10026', '1');
INSERT INTO `demo_order` VALUES ('10039', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN15796843', '2', '2018-12-10 18:13:42', null, '10028', '1');
INSERT INTO `demo_order` VALUES ('10040', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN53289620', '1', '2018-12-10 18:13:42', null, '10006', '1');
INSERT INTO `demo_order` VALUES ('10041', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN43064911', '3', '2018-12-10 18:13:42', null, '10028', '1');
INSERT INTO `demo_order` VALUES ('10042', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN78460900', '1', '2018-12-10 18:13:42', null, '10087', '1');
INSERT INTO `demo_order` VALUES ('10043', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN74566189', '1', '2018-12-10 18:13:42', null, '10031', '1');
INSERT INTO `demo_order` VALUES ('10044', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN00253407', '2', '2018-12-10 18:13:42', null, '10066', '1');
INSERT INTO `demo_order` VALUES ('10045', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN54699711', '1', '2018-12-10 18:13:42', null, '10030', '1');
INSERT INTO `demo_order` VALUES ('10046', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN07949408', '4', '2018-12-10 18:13:42', null, '10105', '1');
INSERT INTO `demo_order` VALUES ('10047', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN79874981', '1', '2018-12-10 18:13:42', null, '10037', '1');
INSERT INTO `demo_order` VALUES ('10048', '2018-12-10 18:13:42', '黑色 64G', '3799', 'OSN14370894', '3', '2018-12-10 18:13:42', null, '10099', '1');
INSERT INTO `demo_order` VALUES ('10049', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN64922542', '3', '2018-12-10 18:13:43', null, '10094', '1');
INSERT INTO `demo_order` VALUES ('10053', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN49609706', '3', '2018-12-10 18:13:43', null, '10065', '1');
INSERT INTO `demo_order` VALUES ('10054', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN56832515', '3', '2018-12-10 18:13:43', null, '10060', '1');
INSERT INTO `demo_order` VALUES ('10055', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN31253021', '2', '2018-12-10 18:13:43', null, '10119', '1');
INSERT INTO `demo_order` VALUES ('10056', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN57095288', '3', '2018-12-10 18:13:43', null, '10091', '1');
INSERT INTO `demo_order` VALUES ('10057', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN92614265', '2', '2018-12-10 18:13:43', null, '10029', '1');
INSERT INTO `demo_order` VALUES ('10058', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN00202906', '2', '2018-12-10 18:13:43', null, '10065', '1');
INSERT INTO `demo_order` VALUES ('10059', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN21334261', '3', '2018-12-10 18:13:43', null, '10119', '1');
INSERT INTO `demo_order` VALUES ('10060', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN83283978', '1', '2018-12-10 18:13:43', null, '10012', '1');
INSERT INTO `demo_order` VALUES ('10061', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN36656961', '1', '2018-12-10 18:13:43', null, '10086', '1');
INSERT INTO `demo_order` VALUES ('10062', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN45929462', '1', '2018-12-10 18:13:43', null, '10055', '1');
INSERT INTO `demo_order` VALUES ('10063', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN68941207', '4', '2018-12-10 18:13:43', null, '10091', '1');
INSERT INTO `demo_order` VALUES ('10064', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN09113662', '1', '2018-12-10 18:13:43', null, '10059', '1');
INSERT INTO `demo_order` VALUES ('10065', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN04513909', '3', '2018-12-10 18:13:43', null, '10117', '1');
INSERT INTO `demo_order` VALUES ('10066', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN21040669', '2', '2018-12-10 18:13:43', null, '10023', '1');
INSERT INTO `demo_order` VALUES ('10067', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN76171779', '4', '2018-12-10 18:13:43', null, '10069', '1');
INSERT INTO `demo_order` VALUES ('10068', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN84774767', '2', '2018-12-10 18:13:43', null, '10017', '1');
INSERT INTO `demo_order` VALUES ('10069', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN42741676', '2', '2018-12-10 18:13:43', null, '10054', '1');
INSERT INTO `demo_order` VALUES ('10070', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN70641881', '3', '2018-12-10 18:13:43', null, '10098', '1');
INSERT INTO `demo_order` VALUES ('10071', '2018-12-10 18:13:43', '黑色 64G', '3799', 'OSN11636750', '1', '2018-12-10 18:13:43', null, '10011', '1');
INSERT INTO `demo_order` VALUES ('10073', '2018-12-10 18:13:44', '黑色 64G', '3799', 'OSN00415777', '1', '2018-12-10 18:13:44', null, '10013', '1');
INSERT INTO `demo_order` VALUES ('10074', '2018-12-10 18:13:44', '黑色 64G', '3799', 'OSN58408076', '1', '2018-12-10 18:13:44', null, '10051', '1');
INSERT INTO `demo_order` VALUES ('10143', '2019-01-11 17:13:56', null, null, null, null, null, '2019-01-11 17:13:56', null, '0');
INSERT INTO `demo_order` VALUES ('10142', '2019-01-11 17:00:27', '我的小米不贴膜', '6764', 'ORD232', '3', '2019-01-11 00:00:00', '2019-01-11 17:44:20', '10000', '1');
INSERT INTO `demo_order` VALUES ('10144', '2019-01-14 09:52:57', null, null, null, null, null, '2019-01-14 09:52:57', null, '0');
INSERT INTO `demo_order` VALUES ('10145', '2019-01-14 10:04:03', null, null, null, null, null, '2019-01-14 10:04:03', null, '0');
INSERT INTO `demo_order` VALUES ('10146', '2019-01-14 10:04:11', null, null, null, null, null, '2019-01-14 10:04:11', null, '0');
INSERT INTO `demo_order` VALUES ('10147', '2019-01-14 10:06:45', null, null, null, null, null, '2019-01-14 10:06:45', null, '0');
INSERT INTO `demo_order` VALUES ('10148', '2019-01-14 10:06:51', null, null, null, null, null, '2019-01-14 10:06:51', null, '0');
INSERT INTO `demo_order` VALUES ('10149', '2019-01-14 10:10:12', null, null, null, null, null, '2019-01-14 10:10:12', null, '0');
INSERT INTO `demo_order` VALUES ('10150', '2019-01-14 10:13:14', null, null, null, null, null, '2019-01-14 10:13:14', null, '0');
INSERT INTO `demo_order` VALUES ('10151', '2019-01-14 10:13:19', null, null, null, null, null, '2019-01-14 10:13:19', null, '0');
INSERT INTO `demo_order` VALUES ('10152', '2019-01-14 10:13:25', null, null, null, null, null, '2019-01-14 10:13:25', null, '0');
INSERT INTO `demo_order` VALUES ('10153', '2019-01-14 10:15:42', null, null, null, null, null, '2019-01-14 10:15:42', null, '0');
INSERT INTO `demo_order` VALUES ('10154', '2019-01-14 14:26:27', null, null, null, null, null, '2019-01-14 14:26:27', null, '0');
INSERT INTO `demo_order` VALUES ('10155', '2019-01-14 14:27:54', null, null, null, null, null, '2019-01-14 14:27:54', null, '0');
INSERT INTO `demo_order` VALUES ('10156', '2019-01-14 14:28:02', null, null, null, null, null, '2019-01-14 14:28:02', null, '0');
INSERT INTO `demo_order` VALUES ('10157', '2019-01-14 14:32:24', null, null, null, null, null, '2019-01-14 14:32:24', null, '0');
INSERT INTO `demo_order` VALUES ('10158', '2019-01-14 14:32:28', null, null, null, null, null, '2019-01-14 14:32:28', null, '0');
INSERT INTO `demo_order` VALUES ('10159', '2019-01-14 14:32:34', null, null, null, null, null, '2019-01-14 14:32:34', null, '0');
INSERT INTO `demo_order` VALUES ('10160', '2019-01-14 14:34:23', null, null, null, null, null, '2019-01-14 14:34:23', null, '0');
INSERT INTO `demo_order` VALUES ('10161', '2019-01-14 14:35:50', null, null, null, null, null, '2019-01-14 14:35:50', null, '0');
INSERT INTO `demo_order` VALUES ('10162', '2019-01-14 14:41:40', null, null, null, null, null, '2019-01-14 14:41:40', null, '0');
INSERT INTO `demo_order` VALUES ('10163', '2019-01-14 14:58:59', null, null, null, null, null, '2019-01-14 14:58:59', null, '0');
INSERT INTO `demo_order` VALUES ('10164', '2019-01-14 15:00:19', null, null, null, null, null, '2019-01-14 15:00:19', null, '0');
INSERT INTO `demo_order` VALUES ('10165', '2019-01-14 15:00:27', null, null, null, null, null, '2019-01-14 15:00:27', null, '0');
INSERT INTO `demo_order` VALUES ('10166', '2019-01-14 15:03:11', null, null, null, null, null, '2019-01-14 15:03:11', null, '0');
INSERT INTO `demo_order` VALUES ('10167', '2019-01-14 15:04:05', null, null, null, null, null, '2019-01-14 15:04:05', null, '0');
INSERT INTO `demo_order` VALUES ('10168', '2019-01-14 15:04:31', null, null, null, null, null, '2019-01-14 15:04:31', null, '0');
INSERT INTO `demo_order` VALUES ('10169', '2019-01-14 15:07:09', null, null, null, null, null, '2019-01-14 15:07:09', null, '0');
INSERT INTO `demo_order` VALUES ('10170', '2019-01-14 15:12:10', null, null, null, null, null, '2019-01-14 15:12:10', null, '0');
INSERT INTO `demo_order` VALUES ('10171', '2019-01-14 15:15:11', null, null, null, null, null, '2019-01-14 15:15:11', null, '0');
INSERT INTO `demo_order` VALUES ('10172', '2019-01-14 15:15:23', null, null, null, null, null, '2019-01-14 15:15:23', null, '0');
INSERT INTO `demo_order` VALUES ('10173', '2019-01-14 15:16:21', null, null, null, null, null, '2019-01-14 15:16:21', null, '0');
INSERT INTO `demo_order` VALUES ('10174', '2019-01-14 15:17:24', null, null, null, null, null, '2019-01-14 15:17:24', null, '0');
INSERT INTO `demo_order` VALUES ('10175', '2019-01-14 15:24:35', null, null, null, null, null, '2019-01-14 15:24:35', null, '0');
INSERT INTO `demo_order` VALUES ('10176', '2019-01-15 15:52:12', null, null, null, null, null, '2019-01-15 15:52:12', null, '0');

-- ----------------------------
-- Table structure for demo_order_item
-- ----------------------------
DROP TABLE IF EXISTS `demo_order_item`;
CREATE TABLE `demo_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `retail_price` double DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjre4nw5n1kjjctkxu590660i` (`goods_id`),
  KEY `FKhnnor68du3ty9u3x2hjskcmvo` (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_order_item
-- ----------------------------
INSERT INTO `demo_order_item` VALUES ('1', '2019-01-07 15:49:24', '2019-01-07 15:49:24', '1', '3788', '3788', '10000', '10120');
INSERT INTO `demo_order_item` VALUES ('2', '2019-01-07 15:50:50', '2019-01-07 15:50:50', '2', '5888', '11776', '10001', '10123');
INSERT INTO `demo_order_item` VALUES ('3', '2019-01-11 11:10:26', '2019-01-11 11:10:26', '2', '3333', '6666', '10000', '10125');
INSERT INTO `demo_order_item` VALUES ('4', '2019-01-11 11:12:51', '2019-01-11 11:12:51', '1', '3444', '3444', '10000', '10125');
INSERT INTO `demo_order_item` VALUES ('5', '2019-01-11 11:19:07', '2019-01-11 11:19:07', '1', '3555', '3555', '10000', '10126');
INSERT INTO `demo_order_item` VALUES ('6', '2019-01-11 11:46:44', '2019-01-11 11:46:44', '1', '3888', '3888', '10000', '10127');
INSERT INTO `demo_order_item` VALUES ('7', '2019-01-11 11:47:32', '2019-01-11 11:47:32', '1', '5888', '5888', '10001', '10127');
INSERT INTO `demo_order_item` VALUES ('8', null, '2019-01-11 14:51:17', '1', '3891', '3891', '10000', '10130');
INSERT INTO `demo_order_item` VALUES ('9', '2019-01-11 15:33:14', '2019-01-11 15:33:14', '1', '12333', '12333', '10000', '10131');
INSERT INTO `demo_order_item` VALUES ('10', '2019-01-11 15:34:14', '2019-01-11 15:34:14', '2', '1233', '2466', '10000', '10132');
INSERT INTO `demo_order_item` VALUES ('12', '2019-01-11 15:38:55', '2019-01-11 15:38:55', '1', '12321', '12321', '10000', '10133');
INSERT INTO `demo_order_item` VALUES ('13', '2019-01-11 15:47:23', '2019-01-11 15:47:23', '1', '1232', '1232', '10000', null);
INSERT INTO `demo_order_item` VALUES ('14', '2019-01-11 15:47:25', '2019-01-11 15:47:25', '1', '1232', '1232', '10000', null);
INSERT INTO `demo_order_item` VALUES ('15', '2019-01-11 15:49:24', '2019-01-11 15:49:24', '1', '3799', '3799', '10000', null);
INSERT INTO `demo_order_item` VALUES ('16', '2019-01-11 15:57:39', '2019-01-11 15:57:39', '1', '3555', '3555', '10000', '10134');
INSERT INTO `demo_order_item` VALUES ('17', '2019-01-11 16:30:30', '2019-01-11 16:30:30', '1', '1222', '1222', '10000', '10135');
INSERT INTO `demo_order_item` VALUES ('18', '2019-01-11 16:36:31', '2019-01-11 16:36:31', '1', '3333', '3333', '10000', '10136');
INSERT INTO `demo_order_item` VALUES ('19', '2019-01-11 16:58:25', '2019-01-11 16:58:25', '1', '3666', '3666', '10000', '10139');
INSERT INTO `demo_order_item` VALUES ('21', '2019-01-11 17:12:52', '2019-01-11 17:12:52', '2', '3382', '6764', '10000', '10142');
INSERT INTO `demo_order_item` VALUES ('23', '2019-01-14 15:19:00', '2019-01-14 15:19:00', '1', '5666', '5666', '10001', '10071');
INSERT INTO `demo_order_item` VALUES ('25', '2019-01-14 15:25:02', '2019-01-14 15:25:02', '1', '222', '222', '10000', '10073');
INSERT INTO `demo_order_item` VALUES ('26', '2019-01-14 15:25:53', '2019-01-14 15:25:53', '1', '5444', '5444', '10001', '10073');

-- ----------------------------
-- Table structure for demo_pivot
-- ----------------------------
DROP TABLE IF EXISTS `demo_pivot`;
CREATE TABLE `demo_pivot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `rate` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_pivot
-- ----------------------------
INSERT INTO `demo_pivot` VALUES ('1', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('2', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('3', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('4', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('5', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('6', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('7', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('8', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('9', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('10', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('11', '东北', '1', '1月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('12', '东北', '2', '1月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('13', '东北', '1', '2月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('14', '东北', '2', '2月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('15', '东北', '1', '2月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('16', '东北', '2', '2月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('17', '东北', '1', '2月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('18', '东北', '2', '2月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('19', '东北', '1', '2月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('20', '东北', '2', '2月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('21', '东北', '1', '2月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('22', '东北', '2', '2月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('23', '东北', '1', '2月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('24', '东北', '2', '2月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('25', '东北', '1', '3月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('26', '东北', '2', '3月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('27', '东北', '1', '3月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('28', '东北', '2', '3月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('29', '东北', '1', '3月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('30', '东北', '2', '3月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('31', '东北', '1', '3月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('32', '东北', '2', '3月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('33', '东北', '1', '3月', '黑龙江', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('34', '东北', '2', '3月', '黑龙江', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('35', '东北', '1', '3月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('36', '东北', '2', '3月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('37', '东北', '1', '4月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('38', '东北', '2', '4月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('39', '东北', '1', '4月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('40', '东北', '2', '4月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('41', '东北', '1', '4月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('42', '东北', '2', '4月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('43', '东北', '1', '4月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('44', '东北', '2', '4月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('45', '东北', '1', '4月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('46', '东北', '2', '4月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('47', '东北', '1', '4月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('48', '东北', '2', '4月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('49', '东北', '1', '5月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('50', '东北', '2', '5月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('51', '东北', '1', '5月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('52', '东北', '2', '5月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('53', '东北', '1', '5月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('54', '东北', '2', '5月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('55', '东北', '1', '5月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('56', '东北', '2', '5月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('57', '东北', '1', '5月', '吉林', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('58', '东北', '2', '5月', '吉林', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('59', '东北', '1', '5月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('60', '东北', '2', '5月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('61', '东北', '1', '6月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('62', '东北', '2', '6月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('63', '东北', '1', '6月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('64', '东北', '2', '6月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('65', '东北', '1', '6月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('66', '东北', '2', '6月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('67', '东北', '1', '6月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('68', '东北', '2', '6月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('69', '东北', '1', '6月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('70', '东北', '2', '6月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('71', '东北', '1', '6月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('72', '东北', '2', '6月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('73', '东北', '1', '7月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('74', '东北', '2', '7月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.75');
INSERT INTO `demo_pivot` VALUES ('75', '东北', '1', '7月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', null);
INSERT INTO `demo_pivot` VALUES ('76', '东北', '2', '7月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('77', '东北', '1', '7月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('78', '东北', '2', '7月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('79', '东北', '1', '7月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('80', '东北', '2', '7月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('81', '东北', '1', '7月', '辽宁', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('82', '东北', '2', '7月', '辽宁', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('83', '华北', '1', '7月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('84', '华北', '2', '7月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('85', '华北', '1', '8月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('86', '华北', '2', '8月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('87', '华北', '1', '8月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('88', '华北', '2', '8月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('89', '华北', '1', '8月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('90', '华北', '2', '8月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('91', '华北', '1', '8月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('92', '华北', '2', '8月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('93', '华北', '1', '8月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('94', '华北', '2', '8月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('95', '华北', '1', '8月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('96', '华北', '2', '8月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('97', '华北', '1', '9月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('98', '华北', '2', '9月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('99', '华北', '1', '9月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('100', '华北', '2', '9月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('101', '华北', '1', '9月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('102', '华北', '2', '9月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('103', '华北', '1', '9月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('104', '华北', '2', '9月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('105', '华北', '1', '9月', '北京', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('106', '华北', '2', '9月', '北京', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('107', '华北', '1', '9月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('108', '华北', '2', '9月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('109', '华北', '1', '10月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('110', '华北', '2', '10月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('111', '华北', '1', '10月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('112', '华北', '2', '10月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('113', '华北', '1', '10月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('114', '华北', '2', '10月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('115', '华北', '1', '10月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('116', '华北', '2', '10月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('117', '华北', '1', '10月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('118', '华北', '2', '10月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('119', '华北', '1', '10月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('120', '华北', '2', '10月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('121', '华北', '1', '11月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('122', '华北', '2', '11月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('123', '华北', '1', '11月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('124', '华北', '2', '11月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('125', '华北', '1', '11月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('126', '华北', '2', '11月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('127', '华北', '1', '11月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('128', '华北', '2', '11月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('129', '华北', '1', '11月', '天津', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('130', '华北', '2', '11月', '天津', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('131', '华北', '1', '11月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('132', '华北', '2', '11月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('133', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('134', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('135', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('136', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('137', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('138', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('139', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('140', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('141', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('142', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('143', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('144', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('145', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('146', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('147', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('148', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('149', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('150', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('151', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('152', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('153', '华北', '1', '12月', '河北', '人工费', '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');
INSERT INTO `demo_pivot` VALUES ('154', '华北', '2', '12月', '河北', null, '110', '2018-12-01 00:00:00', '2019-01-17 14:11:14', '1.25');

-- ----------------------------
-- Table structure for demo_pivot_collection
-- ----------------------------
DROP TABLE IF EXISTS `demo_pivot_collection`;
CREATE TABLE `demo_pivot_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `collection_json` text,
  `user_id` int(11) DEFAULT NULL,
  `collection_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrotwm3ruqdjmcsto5a2styqh1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_pivot_collection
-- ----------------------------
INSERT INTO `demo_pivot_collection` VALUES ('4', '2019-01-17 17:25:06', '2019-01-17 17:25:06', '{\"rowKeys\":[\"区域\",\"省份\"],\"colKeys\":[\"月份\",\"大类\",\"小类\"],\"fieldFilter\":[{\"label\":\"月份 包含 1月; 或月份 包含 2月; \",\"relation\":\"or\",\"query\":[[\"month\",\"like\",\"1月\"],[\"month\",\"like\",\"2月\"]],\"structure\":[[\"STRING\",[{\"label\":\"包含\",\"value\":\"like\"},{\"label\":\"不包含\",\"value\":\"not like\"},{\"label\":\"等于\",\"value\":\"=\"},{\"label\":\"不等于\",\"value\":\"!=\"},{\"label\":\"找开头是\",\"value\":\"startwith\"},{\"label\":\"找结尾是\",\"value\":\"endwith\"},{\"label\":\"已设置\",\"value\":\"not null\"},{\"label\":\"未设置\",\"value\":\"null\"}]],[\"STRING\",[{\"label\":\"包含\",\"value\":\"like\"},{\"label\":\"不包含\",\"value\":\"not like\"},{\"label\":\"等于\",\"value\":\"=\"},{\"label\":\"不等于\",\"value\":\"!=\"},{\"label\":\"找开头是\",\"value\":\"startwith\"},{\"label\":\"找结尾是\",\"value\":\"endwith\"},{\"label\":\"已设置\",\"value\":\"not null\"},{\"label\":\"未设置\",\"value\":\"null\"}]]]},{\"label\":\"更新时间 早于 2019-01-31 00:00:00; \",\"relation\":\"and\",\"query\":[[\"update_time\",\"<\",\"2019-01-31 00:00:00\"]],\"structure\":[[\"DATE\",[{\"label\":\"等于\",\"value\":\"=\"},{\"label\":\"不等于\",\"value\":\"!=\"},{\"label\":\"晚于\",\"value\":\">\"},{\"label\":\"早于\",\"value\":\"<\"},{\"label\":\"不早于\",\"value\":\">=\"},{\"label\":\"不晚于\",\"value\":\"<=\"},{\"label\":\"已设置\",\"value\":\"not null\"},{\"label\":\"未设置\",\"value\":\"null\"}]]]},{\"label\":\"大类 是 成本; \",\"relation\":\"and\",\"query\":[[\"major\",\"=\",\"1\"]],\"structure\":[[\"SELECTION\",[{\"label\":\"是\",\"value\":\"=\"},{\"label\":\"不是\",\"value\":\"!=\"},{\"label\":\"已设置\",\"value\":\"not null\"},{\"label\":\"未设置\",\"value\":\"null\"}],{\"DemoMajor\":[{\"label\":\"成本\",\"value\":\"1\"},{\"label\":\"收入\",\"value\":\"2\"}]},\"DemoMajor\"]]}]}', '10003', '测试3');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for sys_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_key` varchar(255) DEFAULT NULL,
  `code_name` varchar(255) DEFAULT NULL,
  `code_type` varchar(255) DEFAULT NULL,
  `code_value` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code
-- ----------------------------
INSERT INTO `sys_code` VALUES ('10000', 'S1', '待付款', 'OrderStatus', '1', '1', '1', null, null);
INSERT INTO `sys_code` VALUES ('10001', 'S2', '待发货', 'OrderStatus', '2', '1', '2', null, null);
INSERT INTO `sys_code` VALUES ('10002', 'S3', '待收货', 'OrderStatus', '3', '1', '3', null, null);
INSERT INTO `sys_code` VALUES ('10003', 'S4', '已收货', 'OrderStatus', '4', '1', '4', null, null);
INSERT INTO `sys_code` VALUES ('10004', 'S5', '退款', 'OrderStatus', '5', '1', '5', null, null);
INSERT INTO `sys_code` VALUES ('10005', 'S6', '退货', 'OrderStatus', '6', '1', '6', null, null);
INSERT INTO `sys_code` VALUES ('10006', 'S1', '男', 'CustomerSex', '1', '1', '1', null, null);
INSERT INTO `sys_code` VALUES ('10007', 'S2', '女', 'CustomerSex', '2', '1', '2', null, null);
INSERT INTO `sys_code` VALUES ('10008', 'S3', '不明', 'CustomerSex', '3', '1', '3', null, null);
INSERT INTO `sys_code` VALUES ('10009', 'S1', '是', 'DirectlyUnder', '1', '1', '1', null, null);
INSERT INTO `sys_code` VALUES ('10010', 'S2', '否', 'DirectlyUnder', '0', '1', '1', null, null);
INSERT INTO `sys_code` VALUES ('10011', 'S1', '成本', 'DemoMajor', '1', '1', '1', null, null);
INSERT INTO `sys_code` VALUES ('10012', 'S2', '收入', 'DemoMajor', '2', '1', '1', null, null);

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_directly_under` int(11) DEFAULT NULL,
  `org_code` varchar(255) DEFAULT NULL,
  `org_name` varchar(255) DEFAULT NULL,
  `parent_org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7w94wvw8l6qbkmqcf5l87vw9u` (`parent_org_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('1', '2018-12-29 16:13:32', '2018-12-29 16:13:35', '1', 'ORG11111', '十五所', null);
INSERT INTO `sys_organization` VALUES ('3', '2018-12-29 17:32:51', '2018-12-29 17:32:51', '1', 'ORG11333', '运维部', '1');
INSERT INTO `sys_organization` VALUES ('4', '2018-12-29 17:35:03', '2018-12-29 17:35:03', '1', 'ORG11444', '测试部', '1');
INSERT INTO `sys_organization` VALUES ('7', '2018-12-29 17:55:28', '2018-12-29 17:55:28', '1', 'ORG00016', '十六所', null);
INSERT INTO `sys_organization` VALUES ('12', '2018-12-29 18:01:37', '2019-01-03 09:34:20', '1', 'ORG000161', '系统一部', '7');
INSERT INTO `sys_organization` VALUES ('11', '2018-12-29 18:01:11', '2018-12-29 18:01:11', '0', 'ORG000017', '十七所', null);
INSERT INTO `sys_organization` VALUES ('13', '2019-01-03 09:33:05', '2019-01-03 09:33:05', '0', 'ORG000018', '十八所', null);
INSERT INTO `sys_organization` VALUES ('14', '2019-01-03 09:33:36', '2019-01-03 09:33:47', '1', 'ORG0000171', '系统一部', '11');
INSERT INTO `sys_organization` VALUES ('15', '2019-01-04 10:24:06', '2019-01-04 10:24:16', '1', 'ORG001235', '行政部', '1');
INSERT INTO `sys_organization` VALUES ('16', '2019-01-07 10:01:40', '2019-01-07 10:01:40', '1', 'ORG129000', '十九所', null);
INSERT INTO `sys_organization` VALUES ('17', '2019-01-17 11:27:41', '2019-01-17 11:27:41', '0', 'ORD1213', '运维部', '12');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `permission_code` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `required_permission` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=805 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('100', 'demo', '示例', 'demo:list', '列表', '1', null, null);
INSERT INTO `sys_permission` VALUES ('101', 'demo', '示例', 'demo:add', '新增', '2', null, null);
INSERT INTO `sys_permission` VALUES ('102', 'demo', '示例', 'demo:update', '修改', '2', null, null);
INSERT INTO `sys_permission` VALUES ('103', 'demo', '示例', 'demo:delete', '删除', '2', null, null);
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户管理', 'user:list', '列表', '1', null, null);
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户管理', 'user:add', '新增', '2', null, null);
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户管理', 'user:update', '修改', '2', null, null);
INSERT INTO `sys_permission` VALUES ('701', 'role', '角色权限', 'role:list', '列表', '1', null, null);
INSERT INTO `sys_permission` VALUES ('702', 'role', '角色权限', 'role:add', '新增', '2', null, null);
INSERT INTO `sys_permission` VALUES ('703', 'role', '角色权限', 'role:update', '修改', '2', null, null);
INSERT INTO `sys_permission` VALUES ('704', 'role', '角色权限', 'role:delete', '删除', '2', null, null);
INSERT INTO `sys_permission` VALUES ('801', 'organization', '机构管理', 'organization:list', '列表', '1', null, null);
INSERT INTO `sys_permission` VALUES ('802', 'organization', '机构管理', 'organization:add', '新增', '2', null, null);
INSERT INTO `sys_permission` VALUES ('803', 'organization', '机构管理', 'organization:update', '修改', '2', null, null);
INSERT INTO `sys_permission` VALUES ('804', 'organization', '机构管理', 'organization:delete', '删除', '2', null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '2017-11-22 16:24:34', '1', '管理员', '2017-11-22 16:24:52');
INSERT INTO `sys_role` VALUES ('2', '2017-11-22 16:24:34', '1', '作家', '2018-12-25 11:11:57');
INSERT INTO `sys_role` VALUES ('3', '2017-11-22 16:28:47', '1', '程序员', '2018-12-25 14:39:02');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('89', '2018-12-25 11:11:05', '1', '2018-12-25 11:11:02', '701', '2');
INSERT INTO `sys_role_permission` VALUES ('93', '2018-12-25 11:11:57', '1', '2018-12-25 11:11:57', '601', '2');
INSERT INTO `sys_role_permission` VALUES ('42', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '100', '1');
INSERT INTO `sys_role_permission` VALUES ('43', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '101', '1');
INSERT INTO `sys_role_permission` VALUES ('44', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '102', '1');
INSERT INTO `sys_role_permission` VALUES ('45', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '103', '1');
INSERT INTO `sys_role_permission` VALUES ('112', '2018-12-25 14:39:02', '1', '2018-12-25 14:39:02', '603', '3');
INSERT INTO `sys_role_permission` VALUES ('111', '2018-12-25 14:39:02', '1', '2018-12-25 14:39:02', '701', '3');
INSERT INTO `sys_role_permission` VALUES ('110', '2018-12-25 14:39:02', '1', '2018-12-25 14:39:02', '704', '3');
INSERT INTO `sys_role_permission` VALUES ('55', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '601', '1');
INSERT INTO `sys_role_permission` VALUES ('56', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '602', '1');
INSERT INTO `sys_role_permission` VALUES ('57', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '603', '1');
INSERT INTO `sys_role_permission` VALUES ('58', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '701', '1');
INSERT INTO `sys_role_permission` VALUES ('59', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '702', '1');
INSERT INTO `sys_role_permission` VALUES ('60', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '703', '1');
INSERT INTO `sys_role_permission` VALUES ('61', '2018-12-07 11:52:43', '1', '2018-12-07 11:52:43', '704', '1');
INSERT INTO `sys_role_permission` VALUES ('109', '2018-12-25 14:39:02', '1', '2018-12-25 14:39:02', '601', '3');
INSERT INTO `sys_role_permission` VALUES ('108', '2018-12-25 14:39:02', '1', '2018-12-25 14:39:02', '702', '3');
INSERT INTO `sys_role_permission` VALUES ('101', '2018-12-29 15:39:38', '1', '2018-12-29 15:39:43', '801', '1');
INSERT INTO `sys_role_permission` VALUES ('102', '2018-12-29 15:39:56', '1', '2018-12-29 15:40:00', '802', '1');
INSERT INTO `sys_role_permission` VALUES ('103', '2018-12-29 15:40:09', '1', '2018-12-29 15:40:12', '803', '1');
INSERT INTO `sys_role_permission` VALUES ('104', '2018-12-29 15:40:21', '1', '2018-12-29 15:40:23', '804', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `delete_status` int(1) DEFAULT '1',
  `nickname` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh83e18gbpcirmt45cl82s05xh` (`org_id`),
  KEY `FK4dm5kxn3potpfgdigehw7pdyu` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10003', '2017-10-30 11:52:38', '1', '超级用户', '123456', '2018-12-05 16:52:19', 'admin', '1', '1');
INSERT INTO `sys_user` VALUES ('10004', '2017-10-30 16:13:02', '1', '莎士比亚', '123456', '2019-01-02 14:47:51', 'user', '2', '7');
INSERT INTO `sys_user` VALUES ('10005', '2017-11-15 14:02:56', '1', 'abba', '123456', '2019-01-02 15:42:48', 'aaa', '1', '12');
INSERT INTO `sys_user` VALUES ('10007', '2017-11-22 16:29:41', '1', '就看看列表', '123456', '2019-01-02 15:42:56', 'test', '3', '1');
INSERT INTO `sys_user` VALUES ('10009', '2018-12-05 16:17:13', '2', '李xx', '123123', '2018-12-05 16:50:12', 'lij', '1', null);
INSERT INTO `sys_user` VALUES ('10010', '2018-12-05 16:08:17', '1', '李倞', '321321', '2019-01-02 15:43:04', 'lijing', '1', '3');
INSERT INTO `sys_user` VALUES ('10011', '2018-12-05 16:50:54', '1', 'test1', '123', '2019-01-02 15:43:30', 'test1', '1', '3');
INSERT INTO `sys_user` VALUES ('10012', '2018-12-05 16:51:06', '1', 'test2', '123', '2019-01-02 15:43:47', 'test2', '1', '3');
INSERT INTO `sys_user` VALUES ('10013', '2018-12-05 16:51:22', '1', 'test3', '123', '2019-01-02 15:43:35', 'test3', '1', '12');
INSERT INTO `sys_user` VALUES ('10014', '2018-12-05 16:51:42', '1', 'test4', '123', '2019-01-02 15:43:40', 'test4', '1', '4');
INSERT INTO `sys_user` VALUES ('10015', '2018-12-05 16:51:52', '1', 'test5', '123', '2019-01-02 15:43:54', 'test5', '1', '11');
INSERT INTO `sys_user` VALUES ('10016', '2018-12-05 16:52:01', '1', 'test6', '123', '2019-01-02 15:59:49', 'test6', '1', '4');
INSERT INTO `sys_user` VALUES ('10018', '2018-12-21 16:16:37', '2', 'lijing22', '123123', '2018-12-21 16:18:07', 'lijing22', '1', null);
INSERT INTO `sys_user` VALUES ('10019', '2018-12-25 10:23:02', '1', 'lkk', '123123', '2019-01-02 16:00:09', 'lkk', '2', '7');
INSERT INTO `sys_user` VALUES ('10020', '2018-12-25 10:24:54', '1', 'lkk2', '123', '2019-01-02 16:00:15', 'lkk2', '2', '7');
INSERT INTO `sys_user` VALUES ('10021', '2019-01-02 14:42:09', '1', '新人', '123123', '2019-01-02 14:42:09', '新人', '1', '12');
INSERT INTO `sys_user` VALUES ('10022', '2019-01-02 17:16:53', '1', '测试', '123123', '2019-01-02 17:16:53', '测试', null, null);
