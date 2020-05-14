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