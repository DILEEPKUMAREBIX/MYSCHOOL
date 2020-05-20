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