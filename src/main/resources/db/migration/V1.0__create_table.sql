


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(45) NOT NULL,
  `LASTNAME` varchar(45) NOT NULL,
  `GENDERID` int NOT NULL,
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
  `RELIGIONID` int NOT NULL,
  `CASTEID` int NOT NULL,
  `IDPROOF` varchar(45) NOT NULL,
   `ROLES` varchar(100) NOT NULL,
  `PERMISSIONS` varchar(100) NOT NULL,
  `DOB` datetime NOT NULL,
  `joiningDate` datetime NOT NULL,
  `endingDate` datetime NULL,
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
   KEY `GENDERID_idx` (`GENDERID`),
   KEY `FK6e8gba1c3emdsjaigmr7amv8s` (`RELIGIONID`),
  KEY `FKanj3mw9kwj2bbg95orjh3tphk` (`CASTEID`),
  CONSTRAINT `ADDRESSIDX` FOREIGN KEY (`ADDRESSID`) REFERENCES `address` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `CATEGORYIDX` FOREIGN KEY (`CATEGORYID`) REFERENCES `cmvalue` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `SCHOOLIDX` FOREIGN KEY (`SCHOOLID`) REFERENCES `school` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
   CONSTRAINT `GENDERIDX` FOREIGN KEY (`GENDERID`) REFERENCES `cmvalue` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
   CONSTRAINT `FK6e8gba1c3emdsjaigmr7amv8s` FOREIGN KEY (`RELIGIONID`) REFERENCES `cmvalue` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT,
   CONSTRAINT `FKanj3mw9kwj2bbg95orjh3tphk` FOREIGN KEY (`CASTEID`) REFERENCES `cmvalue` (`ID`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



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


CREATE TABLE `classteachersubject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `isactive` bit(1) DEFAULT NULL,
  `classid` int DEFAULT NULL,
  `teacheruserid` int DEFAULT NULL,
  `subjectid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhw349jnhku1o6hlc9ex3mniol` (`subjectid`),
  KEY `FKm5fks0mpv7tuymkuifbt5yb7g` (`teacheruserid`),
  KEY `FK8mffa7fub0b9uw6swmv88l97q` (`classid`),
  CONSTRAINT `FKhw349jnhku1o6hlc9ex3mniol` FOREIGN KEY (`subjectid`) REFERENCES `cmvalue` (`ID`),
  CONSTRAINT `FKm5fks0mpv7tuymkuifbt5yb7g` FOREIGN KEY (`teacheruserid`) REFERENCES `user` (`ID`),
  CONSTRAINT `FK8mffa7fub0b9uw6swmv88l97q` FOREIGN KEY (`classid`) REFERENCES `cmvalue` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `isactive` bit(1) DEFAULT NULL,
`ispresent` bit(1) DEFAULT NULL,
`periodno` int DEFAULT NULL,
  `userclassid` int DEFAULT NULL,
  `classteachersubjectid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
   KEY `FK4v00uryomv5kg76fohfgaqb77` (`userclassid`),
  KEY `FK6gxd2aewy5ivrnn2v8qv66ocy` (`classteachersubjectid`),
   CONSTRAINT `FK4v00uryomv5kg76fohfgaqb77` FOREIGN KEY (`userclassid`) REFERENCES `userclass` (`ID`),
  CONSTRAINT `FK6gxd2aewy5ivrnn2v8qv66ocy` FOREIGN KEY (`classteachersubjectid`) REFERENCES `classteachersubject` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `timetable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
    `isactive` bit(1) DEFAULT NULL,
`periodno` int DEFAULT NULL,
  `classteachersubjectid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKekkjipn6jgr5w56a832aspu0g` (`classteachersubjectid`),
  CONSTRAINT `FKekkjipn6jgr5w56a832aspu0g` FOREIGN KEY (`classteachersubjectid`) REFERENCES `classteachersubject` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `schoolclassperiods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `count` int DEFAULT NULL,
  `isactive` bit(1) DEFAULT NULL,
  `schoolid` int DEFAULT NULL,
  `classid` int DEFAULT NULL,
  `sectionid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `SCHOOL_ID` (`schoolid`),
  KEY `CLASS_ID` (`classid`),
  KEY `SECTION_ID` (`sectionid`),
  CONSTRAINT `SCHOOL_ID` FOREIGN KEY (`schoolid`) REFERENCES `school` (`ID`),
  CONSTRAINT `CLASS_ID` FOREIGN KEY (`classid`) REFERENCES `cmvalue` (`ID`),
  CONSTRAINT `SECTION_ID` FOREIGN KEY (`sectionid`) REFERENCES `cmvalue` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `homework` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(1000) DEFAULT NULL,
  `HOMEWORK_DATE` DATETIME DEFAULT NULL,
  `ISACTIVE` bit(1) DEFAULT NULL,
  `SCHOOLID` INT DEFAULT NULL,
  `CLASSID` INT DEFAULT NULL,
  `SECTIONID` INT DEFAULT NULL,
  `SUBJECTID` INT DEFAULT NULL,
   `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SCHOOLID_idx` (`SCHOOLID`),
  KEY `CLASSID_idx` (`CLASSID`),
  KEY `SECTIONID_idx` (`SECTIONID`),
  KEY `SUBJECTID_idx` (`SUBJECTID`),
  CONSTRAINT `SCHOOLID` FOREIGN KEY (`SCHOOLID`) REFERENCES `school` (`ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `CLASSID` FOREIGN KEY (`CLASSID`) REFERENCES `cmvalue` (`ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `SECTIONID` FOREIGN KEY (`SECTIONID`) REFERENCES `cmvalue` (`ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `SUBJECTID`FOREIGN KEY (`SUBJECTID`) REFERENCES `cmvalue` (`ID`) ON DELETE RESTRICT ON UPDATE CASCADE
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
  
  
  CREATE TABLE `events` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FOLDER_NAME` VARCHAR(45) DEFAULT NULL,
  `EVENT_NAME` VARCHAR(45) DEFAULT NULL,
  `EVENT_DATE` DATETIME DEFAULT NULL,
  `IS_ACTIVE` BIT(1) DEFAULT NULL,
  `SCHOOLID` INT DEFAULT NULL,
  `CLASSID` INT DEFAULT NULL,
   `created_user` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_user` varchar(255) DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKlw56q4gi1oxuvvpx7k7ef5ojk` (`SCHOOLID`),
  KEY `CLASSID_idx` (`CLASSID`),
  CONSTRAINT `FKlw56q4gi1oxuvvpx7k7ef5ojk` FOREIGN KEY (`SCHOOLID`) REFERENCES `school` (`ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `CLASSIDidx` FOREIGN KEY (`CLASSID`) REFERENCES `cmvalue` (`ID`) ON DELETE RESTRICT ON UPDATE CASCADE
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
  
  CREATE TABLE `holidays` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `HOLIDAY_DATE` DATETIME NULL,
  `DESCRIPTION` VARCHAR(45) NULL,
  `IS_ACTIVE` BIT(1) NULL,
  `SCHOOLID` INT NOT NULL,
   `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SCHOOLID_idx` (`SCHOOLID`),
  CONSTRAINT `SCHOOLID_idx`
    FOREIGN KEY (`SCHOOLID`)
    REFERENCES `school` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `leaves` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `LEAVE_DATE` DATETIME NULL,
  `DESCRIPTION` VARCHAR(1000) NULL,
  `IS_ACTIVE` BIT(1) NULL,
  `SCHOOLID` INT NOT NULL,
  `USERID` INT NOT NULL,
   `created_date` datetime NOT NULL,
  `created_user` varchar(45) NOT NULL,
  `last_updated_date` datetime NOT NULL,
  `last_updated_user` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USERID_idx` (`USERID`),
  KEY `SCHOOLID_idx` (`SCHOOLID`),
  CONSTRAINT `USERID`
    FOREIGN KEY (`USERID`)
    REFERENCES `user` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `SCHOOLID_idx1`
    FOREIGN KEY (`SCHOOLID`)
    REFERENCES `school` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;