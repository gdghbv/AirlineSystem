/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : airline_ticket_system

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 22/12/2024 01:22:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for airport_aircraft
-- ----------------------------
DROP TABLE IF EXISTS `airport_aircraft`;
CREATE TABLE `airport_aircraft`  (
  `aircraftID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '飞机编号',
  `airportID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '停留机场',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of airport_aircraft
-- ----------------------------
INSERT INTO `airport_aircraft` VALUES ('A123', 'PEK', '在飞');
INSERT INTO `airport_aircraft` VALUES ('A124', 'SHA', '停机');
INSERT INTO `airport_aircraft` VALUES ('A125', 'CAN', '在飞');
INSERT INTO `airport_aircraft` VALUES ('A126', 'SZX', '停机');
INSERT INTO `airport_aircraft` VALUES ('A127', 'CTU', '在飞');

-- ----------------------------
-- Table structure for airport_flight_info
-- ----------------------------
DROP TABLE IF EXISTS `airport_flight_info`;
CREATE TABLE `airport_flight_info`  (
  `routeID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '航线',
  `flightID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '航班编号',
  `departureTime` datetime(6) NULL DEFAULT NULL COMMENT ' /* 起飞时间 */',
  `boardingGate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `airportID` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `delay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `seatCount` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of airport_flight_info
-- ----------------------------
INSERT INTO `airport_flight_info` VALUES ('R001', 'FL123', '2024-12-20 08:00:00.000000', 'A1', 500.00, 'PEK', '是', 149);
INSERT INTO `airport_flight_info` VALUES ('R002', 'FL124', '2024-12-20 09:00:00.000000', 'B1', 600.00, 'PEK', '无', 120);
INSERT INTO `airport_flight_info` VALUES ('R003', 'FL125', '2024-12-20 10:00:00.000000', 'C1', 550.00, 'PEK', '无', 130);
INSERT INTO `airport_flight_info` VALUES ('R004', 'FL126', '2024-12-20 11:00:00.000000', 'D1', 700.00, 'PEK', '无', 140);
INSERT INTO `airport_flight_info` VALUES ('R005', 'FL127', '2024-12-20 12:00:00.000000', 'E1', 650.00, 'PEK', '无', 160);

-- ----------------------------
-- Table structure for airport_info
-- ----------------------------
DROP TABLE IF EXISTS `airport_info`;
CREATE TABLE `airport_info`  (
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '注册邮箱',
  `airportAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机场地址',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `airportPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机场电话',
  `airportID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `airportName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of airport_info
-- ----------------------------
INSERT INTO `airport_info` VALUES ('pekin@airport.com', '翻斗花园机场2号楼1001室', '482c811da5d5b4bc6d497ffa98491e38', '010-12345678', 'PEK', '翻斗花园机场');
INSERT INTO `airport_info` VALUES ('shanghai@airport.com', '上海市浦东新区机场路', '482c811da5d5b4bc6d497ffa98491e38', '021-87654321', 'P', '上海浦东国际机场');
INSERT INTO `airport_info` VALUES ('guangzhou@airport.com', '广州市白云区机场路', '482c811da5d5b4bc6d497ffa98491e38', '020-12343210', 'i', '广州白云国际机场');
INSERT INTO `airport_info` VALUES ('shenzhen@airport.com', '深圳市宝安区机场路', '482c811da5d5b4bc6d497ffa98491e38', '0755-11223344', 'PE', '深圳宝安国际机场');
INSERT INTO `airport_info` VALUES ('chengdu@airport.com', '成都市双流区机场路', 'password123', '028-44556677', 'CTU', '成都双流国际机场');

-- ----------------------------
-- Table structure for company_aircraft_info
-- ----------------------------
DROP TABLE IF EXISTS `company_aircraft_info`;
CREATE TABLE `company_aircraft_info`  (
  `aircraftType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '飞机型号',
  `aircraftID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '飞机编号',
  `seatCount` int NULL DEFAULT NULL COMMENT '座位数 ',
  `companyID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属公司代码'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_aircraft_info
-- ----------------------------
INSERT INTO `company_aircraft_info` VALUES ('波音737', 'A123', 180, 'C001');
INSERT INTO `company_aircraft_info` VALUES ('空客A320', 'A124', 160, 'C002');
INSERT INTO `company_aircraft_info` VALUES ('波音787', 'A125', 250, 'C003');
INSERT INTO `company_aircraft_info` VALUES ('空客A330', 'A126', 220, 'C004');
INSERT INTO `company_aircraft_info` VALUES ('波音777', 'A127', 240, 'C005');

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info`  (
  `companyID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '社会统一信用代码',
  `companyName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司名称',
  `companyAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '企业地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注册邮箱号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_info
-- ----------------------------
INSERT INTO `company_info` VALUES ('C001', '大中华航空', '北京市海淀区航空大厦', '010-87654321', 'info@dch.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `company_info` VALUES ('C002', '东方航空', '上海市浦东新区东方大厦', '021-65432109', 'contact@dme.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `company_info` VALUES ('C003', '南方航空', '广州市天汇大厦', '020-12345678', 'service@csa.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `company_info` VALUES ('C004', '海南航空', '海南省海口市航空大厦', '0898-11122333', 'support@hna.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `company_info` VALUES ('C005', '厦门航空', '厦门市湖里区航空路', '0592-33445566', 'help@xma.com', '482c811da5d5b4bc6d497ffa98491e38');

-- ----------------------------
-- Table structure for company_routes_info
-- ----------------------------
DROP TABLE IF EXISTS `company_routes_info`;
CREATE TABLE `company_routes_info`  (
  `routeID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '航线编号',
  `origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '起始地点',
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '终点地点',
  `originAirport` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '起点机场',
  `destinationAirport` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '终点机场',
  `companyID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属公司ID',
  `aircraftID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '飞机编号'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_routes_info
-- ----------------------------
INSERT INTO `company_routes_info` VALUES ('R001', '翻斗花园', '上海', 'PEK', 'SHA', 'C001', 'A123');
INSERT INTO `company_routes_info` VALUES ('R002', '上海', '广州', 'SHA', 'CAN', 'C002', 'A124');
INSERT INTO `company_routes_info` VALUES ('R003', '翻斗花园', '成都', 'CAN', 'CTU', 'C003', 'A125');
INSERT INTO `company_routes_info` VALUES ('R004', '深圳', '北京', 'SZX', 'PEK', 'C004', 'A126');
INSERT INTO `company_routes_info` VALUES ('R005', '成都', '上海', 'CTU', 'SHA', 'C005', 'A127');

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info`  (
  `citizenID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公民身份证号码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顾客姓名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `points` int NULL DEFAULT 0 COMMENT '积分',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('110101199001011234', '佐巴扬', '123514313', '男', 500, 'zhangsan@xyz.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `customer_info` VALUES ('110101199002022345', 'kobe', '13823456789', '武装直升机', 24, 'lisi@xyz.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `customer_info` VALUES ('110101199003033456', '奶龙', '13734567890', '奶龙', 200, 'wangwu@xyz.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `customer_info` VALUES ('110101199004044567', '赵六', '13645678901', '女', 300, 'zhaoliu@xyz.com', '482c811da5d5b4bc6d497ffa98491e38');
INSERT INTO `customer_info` VALUES ('110101199005055678', '孙七', '13556789012', '男', 150, 'sunqi@xyz.com', '482c811da5d5b4bc6d497ffa98491e38');

-- ----------------------------
-- Table structure for customer_ticket_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_ticket_info`;
CREATE TABLE `customer_ticket_info`  (
  `dateTime` datetime(6) NULL DEFAULT NULL COMMENT '购票日期',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '票务状态',
  `flightID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '航班编号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顾客邮箱',
  `seatID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '座位ID',
  `ticketID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '票号'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer_ticket_info
-- ----------------------------
INSERT INTO `customer_ticket_info` VALUES ('2024-12-19 12:00:00.000000', '已出票', 'FL123', 'zhangsan@xyz.com', 'A1', 'TICKET001');
INSERT INTO `customer_ticket_info` VALUES ('2024-12-19 12:30:00.000000', '已出票', 'FL124', 'lisi@xyz.com', 'B1', 'TICKET002');
INSERT INTO `customer_ticket_info` VALUES ('2024-12-19 13:00:00.000000', '已出票', 'FL125', 'wangwu@xyz.com', 'C1', 'TICKET003');
INSERT INTO `customer_ticket_info` VALUES ('2024-12-19 13:30:00.000000', '已出票', 'FL126', 'zhaoliu@xyz.com', 'D1', 'TICKET004');
INSERT INTO `customer_ticket_info` VALUES ('2024-12-19 14:00:00.000000', '已出票', 'FL127', 'sunqi@xyz.com', 'E1', 'TICKET005');
INSERT INTO `customer_ticket_info` VALUES ('2024-12-18 17:02:20.150000', '未出行', 'FL123', 'zhangsan@xyz.com', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
