INSERT INTO `myschool`.`schoolclassperiods` (
  `created_date`,`created_user`,
  `last_updated_date`,
  `last_updated_user`,
  `count` ,
  `isactive`,
  `schoolid`,
  `classid`,
  `sectionid`)
  VALUES
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','6','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'B' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','8','1',(select id from school where NAME= 'Maharshi' LIMIT 1),
  (select id from cmvalue where NAME = '7' LIMIT 1),(select id from cmvalue where NAME = 'C' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','9','1',(select id from school where NAME= 'St. Teresa' LIMIT 1),
  (select id from cmvalue where NAME = '8' LIMIT 1),(select id from cmvalue where NAME = 'D' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','7','1',(select id from school where NAME= 'RCM High School' LIMIT 1),
  (select id from cmvalue where NAME = '9' LIMIT 1),(select id from cmvalue where NAME = 'E' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','8','1',(select id from school where NAME= 'ZPH School' LIMIT 1),
  (select id from cmvalue where NAME = '10' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1));
  
  
  INSERT INTO `myschool`.`classteachersubject` (
 `created_date`, `created_user`,
  `last_updated_date`,
  `last_updated_user`,
  `year`, 
  `isactive` ,
  `classid` ,
  `teacheruserid`,
  `subjectid`)
  VALUES
 ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020','1',(select id from cmvalue where NAME = '10' LIMIT 1),
  (select id from user where FIRSTNAME= 'Manikanta' LIMIT 1),(select id from cmvalue where NAME = 'TELUGU' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020','1',(select id from cmvalue where NAME = '9' LIMIT 1),
  (select id from user where FIRSTNAME= 'Dileep Kumar' LIMIT 1),(select id from cmvalue where NAME = 'ENGLISH' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020','1',(select id from cmvalue where NAME = '8' LIMIT 1),
  (select id from user where FIRSTNAME= 'Tejaswi' LIMIT 1),(select id from cmvalue where NAME = 'HINDI' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020','1',(select id from cmvalue where NAME = '7' LIMIT 1),
  (select id from user where FIRSTNAME= 'Ashok Kumar' LIMIT 1),(select id from cmvalue where NAME = 'MATHS' LIMIT 1)),
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020','1',(select id from cmvalue where NAME = '6' LIMIT 1),
  (select id from user where FIRSTNAME= 'Anusha' LIMIT 1),(select id from cmvalue where NAME = 'SOCIAL' LIMIT 1));
  
  
  
  INSERT INTO `myschool`.`attendance` (
 `created_date`, `created_user`,
   `last_updated_date` ,
  `last_updated_user`,
  `date`,
  `isactive`,
`ispresent`,
`periodno`,
  `userclassid`,
  `classteachersubjectid`)
  VALUES
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020-07-01','1','1',(select id from cmvalue where NAME = 'P2' LIMIT 1),
   (select id from userclass where id= '1' LIMIT 1),(select id from classteachersubject where id= '1' LIMIT 1)),
   ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020-07-01','1','1',(select id from cmvalue where NAME = 'P3' LIMIT 1),
   (select id from userclass where id= '2' LIMIT 1),(select id from classteachersubject where id= '2' LIMIT 1)),
   ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020-07-01','1','1',(select id from cmvalue where NAME = 'P4' LIMIT 1),
   (select id from userclass where id= '3' LIMIT 1),(select id from classteachersubject where id= '3' LIMIT 1)),
   ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020-07-01','1','1',(select id from cmvalue where NAME = 'P5' LIMIT 1),
   (select id from userclass where id= '4' LIMIT 1),(select id from classteachersubject where id= '4' LIMIT 1)),
   ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020-07-01','1','1',(select id from cmvalue where NAME = 'P7' LIMIT 1),
   (select id from userclass where id= '5' LIMIT 1),(select id from classteachersubject where id= '5' LIMIT 1));
   
   
   INSERT INTO `myschool`.`timetable` (
  `TIMETABLEDATE`,
  `ISACTIVE`,
  `SCHOOLID`,
  `CLASSID` ,
  `SECTIONID`,
  `SUBJECTID`,
  `CLASSPERIODID`,
  `CLASSTTEACHERSUBJECTID`,
   `created_date`,
  `created_user`,
  `last_updated_date`,
  `last_updated_user`)
  VALUES
  ('2020-01-01','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'TELUGU' LIMIT 1),(select id from classperiod where ID = '1' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-01','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'MATHS' LIMIT 1),(select id from classperiod where ID = '2' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-01','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'ENGLISH' LIMIT 1),(select id from classperiod where ID = '3' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
   ('2020-01-01','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SCIENCE' LIMIT 1),(select id from classperiod where ID = '4' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-01','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SOCIAL' LIMIT 1),(select id from classperiod where ID = '5' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP');

