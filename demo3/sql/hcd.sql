/*
 Navicat Premium Dump SQL

 Source Server         : cmj
 Source Server Type    : MySQL
 Source Server Version : 50540 (5.5.40)
 Source Host           : localhost:3306
 Source Schema         : hcd

 Target Server Type    : MySQL
 Target Server Version : 50540 (5.5.40)
 File Encoding         : 65001

 Date: 28/11/2024 16:47:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hcd_cart
-- ----------------------------
DROP TABLE IF EXISTS `hcd_cart`;
CREATE TABLE `hcd_cart`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hcd_cart
-- ----------------------------
INSERT INTO `hcd_cart` VALUES (1, 1, 1, 3);
INSERT INTO `hcd_cart` VALUES (2, 1, 3, 2);
INSERT INTO `hcd_cart` VALUES (3, 1, 2, 18);
INSERT INTO `hcd_cart` VALUES (6, 3, 1, 6);
INSERT INTO `hcd_cart` VALUES (7, 3, 8, 2);
INSERT INTO `hcd_cart` VALUES (8, 3, 0, 1);
INSERT INTO `hcd_cart` VALUES (9, 3, 2, 4);
INSERT INTO `hcd_cart` VALUES (10, 1, 15, 11);
INSERT INTO `hcd_cart` VALUES (11, 2, 9, 1);
INSERT INTO `hcd_cart` VALUES (12, 2, 23, 1);
INSERT INTO `hcd_cart` VALUES (13, 2, 24, 1);

-- ----------------------------
-- Table structure for hcd_cate
-- ----------------------------
DROP TABLE IF EXISTS `hcd_cate`;
CREATE TABLE `hcd_cate`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hcd_cate
-- ----------------------------
INSERT INTO `hcd_cate` VALUES (1, '人气甜品', 'Popular dessert', '2024-11-25 18:59:07');
INSERT INTO `hcd_cate` VALUES (2, '常温小食', 'Normal temperature snack', '2024-11-25 19:00:12');
INSERT INTO `hcd_cate` VALUES (3, '家的味道', 'enjoy long life and good forture', '2024-11-25 19:01:59');

-- ----------------------------
-- Table structure for hcd_menu
-- ----------------------------
DROP TABLE IF EXISTS `hcd_menu`;
CREATE TABLE `hcd_menu`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `sales` int(11) NULL DEFAULT NULL,
  `mcreatetime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hcd_menu
-- ----------------------------
INSERT INTO `hcd_menu` VALUES (1, '焦糖榛子', 268.00, 10, 'cake1.png', 1, 500, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (2, '手绘小羊', 310.00, 26, 'cake2.png', 1, 4, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (3, '新中式清欢', 366.00, 38, 'cake3.png', 1, 2, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (4, '提拉米苏', 38.00, 5, 'sweet1.png', 2, 677, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (5, '黑莓奶酪糕', 38.00, 12, 'sweet2.png', 2, 40, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (6, '童年娃娃头', 15.00, 14, 'sweet3.png', 2, 120, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (7, '巴斯克', 28.00, 58, 'sweet4.png', 2, 251, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (8, '草莓奶糕', 46.00, 1, 'sweet5.png', 2, 7, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (9, '黑金泡芙', 24.00, 2, 'sweet6.png', 2, 14, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (10, '桃子奶糕', 42.00, 4, 'sweet7.png', 2, 15, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (11, '蜜瓜姜饼人', 46.00, 1, 'sweet8.png', 2, 10, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (12, '法棍泡芙', 18.00, 5, 'sweet9.png', 2, 876, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (13, '大泡芙', 17.00, 10, 'sweet10.png', 2, 222, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (14, '草莓百香果', 22.00, 63, 'drink1.png', 3, 21, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (15, '拿铁咖啡', 25.00, 67, 'drink2.png', 3, 37, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (16, '气泡水', 22.00, 6, 'drink3.png', 3, 41, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (17, '磅蛋糕', 9.00, 6, 'food1.png', 4, 170, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (18, '芒果条', 6.00, 5, 'food2.png', 4, 309, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (19, '巧克力布朗尼', 14.00, 7, 'food3.png', 4, 170, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (20, '小狗凤梨酥', 23.00, 6, 'food4.png', 4, 48, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (21, '软曲奇', 12.00, 3, 'food5.png', 4, 108, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (22, '谷物脆脆', 38.00, 6, 'food6.png', 4, 58, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (23, '泰式打抛猪肉饭', 36.00, 32, 'cook1.png', 5, 20, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (24, '韩式辣鸡爪', 78.00, 10, 'cook2.png', 5, 41, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (25, '日式炸猪排', 22.00, 10, 'cook3.png', 5, 140, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (26, '傣式无骨鸡爪', 36.00, 10, 'cook4.png', 5, 108, '2024-11-25 20:17:04');
INSERT INTO `hcd_menu` VALUES (27, '冬阴功炒饭', 38.00, 8, 'cook5.png', 5, 26, '2024-11-25 20:17:04');

-- ----------------------------
-- Table structure for newsinfo
-- ----------------------------
DROP TABLE IF EXISTS `newsinfo`;
CREATE TABLE `newsinfo`  (
  `id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `newstype` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ndate` datetime NULL DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of newsinfo
-- ----------------------------
INSERT INTO `newsinfo` VALUES (1, '新闻1', 'agcc', '娱乐', '2024-11-19 08:59:43', '王小明');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL,
  `loginname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pass` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'user1', '王小明', '123', '男', 'icon1.jpg');
INSERT INTO `userinfo` VALUES (2, 'user2', '陈小明', '123', '女', 'icon2.jpg');
INSERT INTO `userinfo` VALUES (3, 'user3', '李小明', '123', '男', 'icon3.jpg');

SET FOREIGN_KEY_CHECKS = 1;
