-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: universitymanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fee` (
  `course` varchar(40) NOT NULL,
  `semester1` varchar(20) DEFAULT NULL,
  `semester2` varchar(20) DEFAULT NULL,
  `semester3` varchar(20) DEFAULT NULL,
  `semester4` varchar(20) DEFAULT NULL,
  `semester5` varchar(20) DEFAULT NULL,
  `semester6` varchar(20) DEFAULT NULL,
  `semester7` varchar(20) DEFAULT NULL,
  `semester8` varchar(20) DEFAULT NULL,
  `semester9` varchar(20) DEFAULT NULL,
  `semester10` varchar(20) DEFAULT NULL,
  `semester11` varchar(20) DEFAULT NULL,
  `semester12` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`course`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
INSERT INTO `fee` VALUES ('CIVIL','55000','62000','71500','67000','60500','81000','52000','45000','20000','40000','66000','75000'),('CSE','55000','60000','70000','65000','85000','85000','50000','44000','50000','30000','56000','60000'),('GEB','55000','66000','70500','65000','80500','85000','54000','40500','50000','30000','56000','60000'),('PHARMACY','50000','66000','80500','66000','80500','89000','68000','44000','60000','40000','86000','90000');
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','12345');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marks` (
  `studentID` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `marks1` varchar(50) DEFAULT NULL,
  `marks2` varchar(50) DEFAULT NULL,
  `marks3` varchar(50) DEFAULT NULL,
  `marks4` varchar(50) DEFAULT NULL,
  `marks5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`studentID`,`semester`),
  CONSTRAINT `fk_marks_student` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES ('2023-2-80-525','1st Semester','A-','A+','B+','A',''),('2024-1-60-236','2nd Semester','B+','A','A-','B','');
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `name` varchar(40) DEFAULT NULL,
  `fname` varchar(40) DEFAULT NULL,
  `UniqueID` varchar(40) DEFAULT NULL,
  `DateOfBirth` varchar(40) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `StudentID` varchar(40) NOT NULL,
  `Semester` varchar(10) DEFAULT NULL,
  `Course` varchar(40) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Department` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('Sultana Akter','Md.Shah Alam','0092158049727935','Jun 7, 2003','mirpur-10,Dhaka','015568******','2023-1-20-256','9th','Msc','2023-1-20-256@std.ewubd.edu','GEB'),('Mohammad Fairuz','Md.Nazrul Islam','009357567130077','Jul 13, 2002','Boalia,Rajshahi','016999*****','2023-2-80-525','8th','M.Pharm','2023-2-80-525@std.ewubd.edu','PHARMACY'),('Md.Karim Uddin','Md.Abdullah Munem','0095336034109101','Dec 14,2001','hajiganj,Bangladesh','0136968******','2024-1-60-236','6th','Bsc','2024-1-60-236@std.ewubd.edu','CSE');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentleave`
--

DROP TABLE IF EXISTS `studentleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentleave` (
  `studentID` varchar(40) NOT NULL,
  `date` varchar(40) NOT NULL,
  `duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`studentID`,`date`),
  CONSTRAINT `fk_studentleave_student` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentleave`
--

LOCK TABLES `studentleave` WRITE;
/*!40000 ALTER TABLE `studentleave` DISABLE KEYS */;
INSERT INTO `studentleave` VALUES ('2023-1-20-256','Dec 18, 2025','Half Day'),('2024-1-60-236','Dec 12, 2025','Full Day');
/*!40000 ALTER TABLE `studentleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `studentID` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `subject1` varchar(50) DEFAULT NULL,
  `subject2` varchar(50) DEFAULT NULL,
  `subject3` varchar(50) DEFAULT NULL,
  `subject4` varchar(50) DEFAULT NULL,
  `subject5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`studentID`,`semester`),
  CONSTRAINT `fk_subject_student` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('2023-2-80-525','1st Semester','PHARM 101','PHARM 102','ENG 101','MAT 100','');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `name` varchar(40) DEFAULT NULL,
  `fname` varchar(40) DEFAULT NULL,
  `uniqueID` varchar(20) DEFAULT NULL,
  `dob` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `teacherID` varchar(20) NOT NULL,
  `Qualification` varchar(40) DEFAULT NULL,
  `department` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('Farzana Rahman','Obaidul Islam','0114988825066314','Jun 20,1985','barishal,Bangladesh','01780*****','2018-1-60-855','Bsc','CSE','2018-1-60-855@std.ewubd.edu'),('Rakib','Farhad','0111417589411732','Nov 16, 2002','Rampura,Dhaka','01668*****','2019-1-80-255','Msc','EEE','2019-1-80-255@std.ewubd.edu');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherleave`
--

DROP TABLE IF EXISTS `teacherleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherleave` (
  `teacherID` varchar(20) NOT NULL,
  `date` varchar(40) NOT NULL,
  `duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`teacherID`,`date`),
  CONSTRAINT `fk_tleave_teacher` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherleave`
--

LOCK TABLES `teacherleave` WRITE;
/*!40000 ALTER TABLE `teacherleave` DISABLE KEYS */;
INSERT INTO `teacherleave` VALUES ('2018-1-60-855','Dec 4, 2025','Full Day'),('2019-1-80-255','Dec 11, 2025','Half Day');
/*!40000 ALTER TABLE `teacherleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `varsityfee`
--

DROP TABLE IF EXISTS `varsityfee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `varsityfee` (
  `studentID` varchar(20) NOT NULL,
  `course` varchar(20) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `semester` varchar(40) NOT NULL,
  `total` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`studentID`,`semester`),
  KEY `fk_varsityfee_fee` (`department`),
  CONSTRAINT `fk_varsityfee_fee` FOREIGN KEY (`department`) REFERENCES `fee` (`course`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_varsityfee_student` FOREIGN KEY (`studentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `varsityfee`
--

LOCK TABLES `varsityfee` WRITE;
/*!40000 ALTER TABLE `varsityfee` DISABLE KEYS */;
INSERT INTO `varsityfee` VALUES ('2024-1-60-236','Bsc','CSE','Semester3','70000');
/*!40000 ALTER TABLE `varsityfee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-18 14:09:10
