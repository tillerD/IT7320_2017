-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alumnischema
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `idStudents` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStudents`),
  UNIQUE KEY `idUsersLogin_UNIQUE` (`idStudents`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'dylan.tiller','testing123','hamish','ralfe',2141388,'h.ralfe@gmail.com',0),(2,'1','1','1','1',1,'1',0),(3,'2','2','a','a',1234567,'123@456.789',0);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studies`
--

DROP TABLE IF EXISTS `studies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studies` (
  `idStudies` int(11) NOT NULL,
  `PaperID` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Major` varchar(45) DEFAULT NULL,
  `Description` longtext,
  PRIMARY KEY (`idStudies`),
  UNIQUE KEY `idStudies_UNIQUE` (`idStudies`),
  UNIQUE KEY `PaperID_UNIQUE` (`PaperID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studies`
--

LOCK TABLES `studies` WRITE;
/*!40000 ALTER TABLE `studies` DISABLE KEYS */;
INSERT INTO `studies` VALUES (1,'BIT','Bachelor of IT','Programming','This papaer is harder then it looks.'),(2,'BITmN','Bachelor of IT','Networking','This papaer is easier then it looks.'),(3,'BITnSE','Bachelor of IT','Software Engineering','Wait what? This ain\'t correct.');
/*!40000 ALTER TABLE `studies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stustu`
--

DROP TABLE IF EXISTS `stustu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stustu` (
  `idStuStu` int(11) NOT NULL AUTO_INCREMENT,
  `idStudents` int(11) NOT NULL,
  `idStudies` int(11) NOT NULL,
  PRIMARY KEY (`idStuStu`),
  UNIQUE KEY `idStuStu_UNIQUE` (`idStuStu`),
  KEY `idStudies_idx` (`idStudies`),
  KEY `idStudents_idx` (`idStudents`),
  CONSTRAINT `idStudents` FOREIGN KEY (`idStudents`) REFERENCES `students` (`idStudents`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idStudies` FOREIGN KEY (`idStudies`) REFERENCES `studies` (`idStudies`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stustu`
--

LOCK TABLES `stustu` WRITE;
/*!40000 ALTER TABLE `stustu` DISABLE KEYS */;
INSERT INTO `stustu` VALUES (1,1,1),(2,1,3),(3,2,2),(4,2,3);
/*!40000 ALTER TABLE `stustu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-16 20:24:04
