/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-10-20 16:27:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `role_type` int DEFAULT NULL COMMENT '角色类型',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'admin', '1', '$2a$10$1.O77f/s0MGsTb5fVo/Y6eGMb3L65VOeVJDViOu/gjadO4j/WJce2', null);
INSERT INTO `user` VALUES ('4', 'user', '2', '$2a$10$uZH0mO3JTrlWApQO6bFBzOMD0EIBWVpltFaf65OzQVnKBAAZRbmOm', null);
