CREATE DATABASE  IF NOT EXISTS `songs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `songs`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: songs
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `song_id` varchar(400) DEFAULT NULL,
  `playlist_id` int NOT NULL AUTO_INCREMENT,
  `playlist_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`playlist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=219 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (NULL,1,'oldSongs'),('111,112,113',214,'dummy2'),(NULL,215,'anusha'),('112,119,118',218,'trial2');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `song_id` int NOT NULL,
  `song_name` varchar(50) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `artist` varchar(25) DEFAULT NULL,
  `song_duration` double DEFAULT NULL,
  `language` varchar(25) DEFAULT NULL,
  `album` varchar(25) DEFAULT NULL,
  `song_path` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (111,'Believer','rock','Dragons',3.24,'English','Evolve','src/main/resources/Songs.wav/Believer.wav'),(112,'Lovely','hip hop','Billie Eilish',3.2,'English','13 reasons why 2','src/main/resources/Songs.wav/Billie_Eilish_Lovely.wav'),(113,'Blood Sweat &Tears','pop','BTS',3.37,'Korean','wings','src/main/resources/Songs.wav/BTS - Blood Sweat & Tears.wav'),(114,'Idol','pop','BTS',3.42,'Korean','Love Yourself:Answer','src/main/resources/Songs.wav/BTS - IDOL.wav'),(115,'Spring day','pop','BTS',4.34,'Korean','You Never Walk Lone','src/main/resources/Songs.wav/BTS - Spring Day.wav'),(116,'Without Me','pop','Halsey',3.21,'English','Manic','src/main/resources/Songs.wav/Halsey_Without Me.wav'),(117,'What makes you beautiful','pop','One Direction',3.19,'English','Up all Night','src/main/resources/Songs.wav/one_direction_ what makes you beautiful.wav'),(118,'Unstoppable','pop','Sia',3.37,'English','This is Acting','src/main/resources/Songs.wav/sia_unstoppable.wav'),(119,'Waka Waka(This Time for Africa)','pop','Shika',3.22,'English','Freshly Ground','src/main/resources/Songs.wav/Waka Waka.wav');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'songs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05  9:29:13