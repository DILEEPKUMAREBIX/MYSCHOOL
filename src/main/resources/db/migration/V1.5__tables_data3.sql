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
  ('2020-01-02','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'TELUGU' LIMIT 1),(select id from classperiod where ID = '1' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-02','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'ENGLISH' LIMIT 1),(select id from classperiod where ID = '2' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-02','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'MATHS' LIMIT 1),(select id from classperiod where ID = '3' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
   ('2020-01-02','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SOCIAL' LIMIT 1),(select id from classperiod where ID = '4' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-02','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SCIENCE' LIMIT 1),(select id from classperiod where ID = '5' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),

    ('2020-01-03','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'ENGLISH' LIMIT 1),(select id from classperiod where ID = '1' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-03','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SOCIAL' LIMIT 1),(select id from classperiod where ID = '2' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-03','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'TELUGU' LIMIT 1),(select id from classperiod where ID = '3' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
   ('2020-01-03','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SCIENCE' LIMIT 1),(select id from classperiod where ID = '4' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-02','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'MATHS' LIMIT 1),(select id from classperiod where ID = '5' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),

  
    ('2020-01-04','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SCIENCE' LIMIT 1),(select id from classperiod where ID = '1' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-04','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SOCIAL' LIMIT 1),(select id from classperiod where ID = '2' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-04','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'ENGLISH' LIMIT 1),(select id from classperiod where ID = '3' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
   ('2020-01-04','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'TELUGU' LIMIT 1),(select id from classperiod where ID = '4' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-04','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'MATHS' LIMIT 1),(select id from classperiod where ID = '5' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  
    ('2020-01-05','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SOCIAL' LIMIT 1),(select id from classperiod where ID = '1' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-05','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SCIENCE' LIMIT 1),(select id from classperiod where ID = '2' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-05','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'ENGLISH' LIMIT 1),(select id from classperiod where ID = '3' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
   ('2020-01-05','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'MATHS' LIMIT 1),(select id from classperiod where ID = '4' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-05','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'TELUGU' LIMIT 1),(select id from classperiod where ID = '5' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  
    ('2020-01-06','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SOCIAL' LIMIT 1),(select id from classperiod where ID = '1' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-06','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'MATHS' LIMIT 1),(select id from classperiod where ID = '2' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-06','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'TELUGU' LIMIT 1),(select id from classperiod where ID = '3' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
   ('2020-01-06','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'SCIENCE' LIMIT 1),(select id from classperiod where ID = '4' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2020-01-06','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  (select id from cmvalue where NAME = 'ENGLISH' LIMIT 1),(select id from classperiod where ID = '5' LIMIT 1),
  (select id from classteachersubject where id = '1' LIMIT 1),'2020-01-01','DILEEP','2020-01-01','DILEEP');