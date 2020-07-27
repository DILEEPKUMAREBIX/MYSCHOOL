

INSERT INTO `myschool`.`userclass` (
 `created_date`,
 `created_user`,
   `last_updated_date`,
  `last_updated_user`,
  `academicyear`,
  `classid`,
  `isactive`,
  `sectionid`,
  `userid`)
  VALUES
  ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020',(select id from cmvalue where NAME = '10' LIMIT 1),
  '1',(select id from cmvalue where NAME = 'A' LIMIT 1),(select id from user where FIRSTNAME= 'Manikanta' LIMIT 1)),
    ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020',(select id from cmvalue where NAME = '9' LIMIT 1),
  '1',(select id from cmvalue where NAME = 'B' LIMIT 1),(select id from user where FIRSTNAME= 'Dileep Kumar' LIMIT 1)),
    ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020',(select id from cmvalue where NAME = '8' LIMIT 1),
  '1',(select id from cmvalue where NAME = 'C' LIMIT 1),(select id from user where FIRSTNAME= 'Tejaswi' LIMIT 1)),
    ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020',(select id from cmvalue where NAME = '7' LIMIT 1),
  '1',(select id from cmvalue where NAME = 'D' LIMIT 1),(select id from user where FIRSTNAME= 'Ashok Kumar' LIMIT 1)),
    ('2020-01-01','DILEEP','2020-01-01','DILEEP','2020',(select id from cmvalue where NAME = '6' LIMIT 1),
  '1',(select id from cmvalue where NAME = 'E' LIMIT 1),(select id from user where FIRSTNAME= 'Anusha' LIMIT 1));

 INSERT INTO `myschool`.`events` (
  `FOLDER_NAME`,
  `EVENT_NAME`,
  `EVENT_DATE`,
  `IS_ACTIVE`,
  `SCHOOLID` ,
  `CLASSID` ,
   `SECTIONID`,
   `created_date` , `created_user`,
  `last_updated_date`,
  `last_updated_user`)
  VALUES
  ('4.27.12.farwellday','farwellday','2020-06-25','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '6' LIMIT 1),(select id from cmvalue where NAME = 'B' LIMIT 1),
  '2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('4.10.11.birthday','birthday','2020-07-01','1',(select id from school where NAME= 'Bhaskar High School' LIMIT 1),
  (select id from cmvalue where NAME = '10' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  '2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('1.2.11.mani','mani','2020-06-29','1',(select id from school where NAME= 'ZPH School' LIMIT 1),
  (select id from cmvalue where NAME = '2' LIMIT 1),(select id from cmvalue where NAME = 'A' LIMIT 1),
  '2020-01-01','DILEEP','2020-01-01','DILEEP'),
  ('2.3.12.manikanta','manikanta','2020-07-07','1',(select id from school where NAME= 'St. Teresa' LIMIT 1),
  (select id from cmvalue where NAME = '3' LIMIT 1),(select id from cmvalue where NAME = 'B' LIMIT 1),
  '2020-01-01','DILEEP','2020-01-01','DILEEP');


 