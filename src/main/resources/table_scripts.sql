
create database myschool;
use myschool;

SET SQL_SAFE_UPDATES = 0;

CREATE TABLE `address` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `HOUSENO` varchar(45) NOT NULL,
  `STREET` varchar(45) NOT NULL,
  `VILLAGE` varchar(45) DEFAULT NULL,
  `LANDMARK` varchar(45) DEFAULT NULL,
  `MANDAL` varchar(45) DEFAULT NULL,
  `DISTRICT` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `PINCODE` varchar(45) DEFAULT NULL,
  `ISACTIVE` tinyint(1) DEFAULT '1',
  `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `cmgroup` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(45) NOT NULL,
  `ISACTIVE` tinyint(1) unsigned zerofill DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `cmvalue` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `GROUPID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `ISACTIVE` tinyint(1) unsigned zerofill DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `ID_idx` (`GROUPID`),
  CONSTRAINT `GROUPID` FOREIGN KEY (`GROUPID`) REFERENCES `cmgroup` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `school` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `TYPE` int NOT NULL,
  `ADDRESSID` int NOT NULL,
  `ISACTIVE` tinyint(1) DEFAULT '1',
  `anniversary` datetime DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `ID_idx` (`ADDRESSID`),
  CONSTRAINT `ID` FOREIGN KEY (`ADDRESSID`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `person` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `CATEGORYID` int NOT NULL,
  `SCHOOLID` int NOT NULL,
  `FATHERNAME` varchar(45) NOT NULL,
  `MOTHERNAME` varchar(45) NOT NULL,
  `USERNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(240) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `MOBILE` int NOT NULL,
  `ADDRESSID` int NOT NULL,
  `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`,`ADDRESSID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `CATEGORYID_idx` (`CATEGORYID`),
  KEY `ADDRESSID_idx` (`ADDRESSID`),
  KEY `SCHOOLID_idx` (`SCHOOLID`),
  CONSTRAINT `ADDRESSID` FOREIGN KEY (`ADDRESSID`) REFERENCES `address` (`ID`),
  CONSTRAINT `CATEGORYID` FOREIGN KEY (`CATEGORYID`) REFERENCES `cmvalue` (`ID`),
  CONSTRAINT `SCHOOLID` FOREIGN KEY (`SCHOOLID`) REFERENCES `school` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
