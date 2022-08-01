/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1-mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:13306
 Source Schema         : db_imperial_court

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 01/08/2022 20:48:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emp_position` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_account` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_password` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE,
  UNIQUE INDEX `login_account`(`login_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES (1, '爱新觉罗·玄烨', 'emperor', 'xiaoxuanzi1654', '25325C896624D444B2E241807DCAC98B');
INSERT INTO `t_emp` VALUES (2, '纳兰明珠', 'minister', 'brightball1635', 'A580D0EF93C22036C859E194C14CB777');
INSERT INTO `t_emp` VALUES (3, '赫舍里·索额图', 'minister', 'tutu1636', 'E40FD7D49B8B7EF46F47407D583C3538');

-- ----------------------------
-- Table structure for t_memorials
-- ----------------------------
DROP TABLE IF EXISTS `t_memorials`;
CREATE TABLE `t_memorials`  (
  `memorials_id` int(11) NOT NULL AUTO_INCREMENT,
  `memorials_title` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `memorials_content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `memorials_emp` int(11) NOT NULL,
  `memorials_create_time` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `feedback_time` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `feedback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `memorials_status` int(11) NOT NULL,
  PRIMARY KEY (`memorials_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_memorials
-- ----------------------------
INSERT INTO `t_memorials` VALUES (1, '浙江巡抚奏钱塘堤决口疏', '皇上啊，不好啦！钱塘江发大水啦！堤坝冲毁啦！您看这咋弄啊！', 2, '1690-05-07', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (2, '左都御史参鳌拜圈地疏', '皇上啊，鳌拜这厮不是东西呀！占老百姓的地哇！还打人呀！您看咋弄啊！', 3, '1690-04-14', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (3, '都察院劾吴三桂不臣疏', '皇上啊，不得了啦！吴三桂那孙子想造反呀！', 2, '1693-11-18', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (4, '兵部奏准噶尔犯境疏', '皇上啊，不得了啦！葛尔丹要打过来了呀！', 3, '1693-11-18', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (5, '朝鲜使臣朝拜事宜呈皇上御览', '皇上啊！朝鲜国的人要来啦！咱们请他们吃猪肉炖粉条子吧！', 2, '1680-06-11', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (6, '英吉利炮舰购买事宜疏', '皇上啊！英国的小船船咱们买多少啊？', 3, '1680-06-12', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (7, '劾杭州织造贪墨疏', '皇上啊！杭州织造有问题啊！', 2, '1680-06-13', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (8, '禀畅春园落成疏', '皇上啊！畅春园修好了哇！您啥时候过来看看呀！', 3, '1680-06-14', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (9, '请旨木兰秋狝疏', '皇上啊！秋天到啦，又该打猎啦！', 2, '1680-06-15', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (10, '核准西北军饷银两疏', '皇上啊！您看看这钱数算的对不对呀！', 3, '1680-06-16', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (11, '请旨裁撤三藩疏', '皇上啊！咱们不裁撤三藩就芭比Q了哇！', 2, '1680-06-17', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (12, '蒙古王公进京朝拜疏', '皇上啊！蒙古王公要来啦！咱们请他们吃猪肉炖粉条子吧！', 3, '1680-06-18', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (13, '礼部请旨九阿哥赐名疏', '皇上啊！您看九阿哥该叫什么名字呀？', 2, '1680-06-19', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (14, '户部尚书请旨告老还乡疏', '皇上啊！臣想回家养老啦！您看看啥时候给臣把俸禄结一下啊！', 3, '1680-06-20', NULL, NULL, 0);
INSERT INTO `t_memorials` VALUES (15, '查江宁织造贪墨疏', '皇上啊！江宁织造有问题啊！', 2, '1680-06-21', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
