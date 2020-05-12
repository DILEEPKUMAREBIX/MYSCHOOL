


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


CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(45) NOT NULL,
  `LASTNAME` varchar(45) NOT NULL,
  `CATEGORYID` int NOT NULL,
  `SCHOOLID` int NOT NULL,
  `FATHERNAME` varchar(45) NOT NULL,
  `MOTHERNAME` varchar(45) NOT NULL,
  `ADDRESSID` int NOT NULL,
  `IMAGE` blob,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `PHONE` varchar(45) NOT NULL,
  `ROLES` varchar(100) NOT NULL,
  `PERMISSIONS` varchar(100) NOT NULL,
  `DOB` datetime NOT NULL,
  `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  `ISACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `ADDRESSID_idx` (`ADDRESSID`),
  KEY `SCHOOLID_idx` (`SCHOOLID`),
  KEY `CATEGORYID_idx` (`CATEGORYID`),
  CONSTRAINT `ADDRESSIDX` FOREIGN KEY (`ADDRESSID`) REFERENCES `address` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `CATEGORYIDX` FOREIGN KEY (`CATEGORYID`) REFERENCES `cmvalue` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `SCHOOLIDX` FOREIGN KEY (`SCHOOLID`) REFERENCES `school` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `userclass` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `academicyear` varchar(255) DEFAULT NULL,
  `classid` int DEFAULT NULL,
  `isactive` bit(1) DEFAULT NULL,
  `sectionid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbkw8gvfqltclm8kquj7cfxs03` (`classid`),
  KEY `FKc23o966yy1sqbmxvsp0lue5xm` (`sectionid`),
  KEY `FKp892caelskg4ug9krrqgx43qp` (`userid`),
  CONSTRAINT `FKbkw8gvfqltclm8kquj7cfxs03` FOREIGN KEY (`classid`) REFERENCES `cmvalue` (`ID`),
  CONSTRAINT `FKc23o966yy1sqbmxvsp0lue5xm` FOREIGN KEY (`sectionid`) REFERENCES `cmvalue` (`ID`),
  CONSTRAINT `FKp892caelskg4ug9krrqgx43qp` FOREIGN KEY (`userid`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
