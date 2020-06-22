INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`,
`created_date`,
`last_updated_date`,
`created_user`,
`last_updated_user`)
VALUES
(
"CLASS",
"CLASSES AVAILABLE IN SCHOOL",
1,
"2020-04-02 14:58:15",
"2020-04-02 14:58:15",
"Dileep",
"Dileep");


INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`, `created_date`,`last_updated_date`,`created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="Class"),"1","Class 1",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"2","Class 2",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"3","Class 3",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"4","Class 4",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"5","Class 5",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"6","Class 6",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"7","Class 7",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"8","Class 8",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"9","Class 9",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Class"),"10","Class 10",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );


INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`,
`created_date`,
`last_updated_date`,`created_user`,`last_updated_user`)
VALUES
(
"SECTION",
"SECTIONS AVAILABLE IN SCHOOL",
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`, `created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="SECTION"),"A","Section A",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SECTION"),"B","Section B",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SECTION"),"C","Section C",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SECTION"),"D","Section D",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SECTION"),"E","Section E",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );

INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`,
`created_date`,
`last_updated_date`,`created_user`,`last_updated_user`)
VALUES
(
"SCHTYPE",
"School Type Public,Private,Chain",
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`,`created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="SCHTYPE"),"PUBLIC","Public/Government Schools",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SCHTYPE"),"PRIVATE","Private Schools",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SCHTYPE"),"CHAIN","Chain of schools",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );


INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`,
`created_date`,
`last_updated_date`,`created_user`,`last_updated_user`)
VALUES
(
"UserCategory",
"User type like student teacher parent etc.,",
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`, `created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="UserCategory"),"STUDENT","STUDENT",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"TEACHER","TEACHER",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"PARENT","PARENT",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"ADMIN","ADMIN",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"HEADMASTER","HEADMASTER",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );


INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`,
`created_date`,
`last_updated_date`,`created_user`,`last_updated_user`)
VALUES
(
"SubjectCatagory",
"subject type like Telugu English etc.,",
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`, `created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="SubjectCatagory"),"TELUGU","TELUGU",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SubjectCatagory"),"HINDI","HINDI",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SubjectCatagory"),"ENGLISH","ENGISH",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SubjectCatagory"),"MATHS","MATHS",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SubjectCatagory"),"SCIENCE","SCIENCE",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="SubjectCatagory"),"SOCIAL","SOCIAL",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );




-- ADDRESS STARTING
INSERT INTO `myschool`.`address`
(`HOUSENO`,`STREET`,`VILLAGE`,`LANDMARK`,`MANDAL`,`DISTRICT`,`STATE`,`PINCODE`,`ISACTIVE`,`created_date`,`created_user`,`last_updated_date`,`last_updated_user`)
VALUES
('1-393','Ramalayam','Veeraghattam','Temple','Veeraghattam','Srikakulam','Andhra Pradesh','532460','1','2020-01-01','Dileep','2020-01-01','Dileep'),
('1-393','Ramalayam','Kattula Kavity','Temple','Veeraghattam','Srikakulam','Andhra Pradesh','532460','1','2020-01-01','Dileep','2020-01-01','Dileep'),
('100','Ramalayam','Parvathipuram','Temple','Veeraghattam','Srikakulam','Andhra Pradesh','532460','1','2020-01-01','Dileep','2020-01-01','Dileep');
-- ADDRESS ENDING


-- SCHOOL STARTING
INSERT INTO `myschool`.`school`
(`NAME`,`TYPE`,`ADDRESSID`,`ISACTIVE`,`anniversary`,`created_date`,`created_user`,`last_updated_date`,`last_updated_user`)
VALUES
('ZPH School', (select id from cmvalue where NAME = 'PUBLIC' LIMIT 1),(select id from address where VILLAGE = 'Kattula Kavity' LIMIT 1),'1','2020-01-01','2020-01-01','Dileep','2020-01-01','Dileep'),
('Maharshi', (select id from cmvalue where NAME = 'PRIVATE' LIMIT 1),(select id from address where VILLAGE = 'Veeraghattam' LIMIT 1),'1','2020-01-01','2020-01-01','Dileep','2020-01-01','Dileep'),
('St. Teresa', (select id from cmvalue where NAME = 'PRIVATE' LIMIT 1),(select id from address where VILLAGE = 'Parvathipuram' LIMIT 1),'1','2020-01-01','2020-01-01','Dileep','2020-01-01','Dileep'),
('St. Teresa', (select id from cmvalue where NAME = 'CHAIN' LIMIT 1),(select id from address where VILLAGE = 'Parvathipuram' LIMIT 1),'1','2020-01-01','2020-01-01','Dileep','2020-01-01','Dileep'),
('St. Teresa', (select id from cmvalue where NAME = 'CHAIN' LIMIT 1),(select id from address where VILLAGE = 'Parvathipuram' LIMIT 1),'1','2020-01-01','2020-01-01','Dileep','2020-01-01','Dileep'),
('St. Teresa', (select id from cmvalue where NAME = 'CHAIN' LIMIT 1),(select id from address where VILLAGE = 'Parvathipuram' LIMIT 1),'1','2020-01-01','2020-01-01','Dileep','2020-01-01','Dileep');

-- SCHOOL ENDING


-- USER STARTING
INSERT INTO `myschool`.`user`
(`FIRSTNAME`,`LASTNAME`,`GENDERID`,`CATEGORYID`,`SCHOOLID`,`FATHERNAME`,`MOTHERNAME`,`ADDRESSID`,`USERNAME`,
`PASSWORD`,`EMAIL`,`PHONE`,`ROLES`,`PERMISSIONS`,`DOB`,`joiningDate`,`endingDate`,`created_date`,`created_user`,`last_updated_date`,
`last_updated_user`,`ISACTIVE`)
VALUES
('Dileep Kumar','Kottakota',(select id from cmvalue where NAME = 'MALE' LIMIT 1),(select id from cmvalue where NAME = 'STUDENT' LIMIT 1),
(select id from school where NAME= 'ZPH School' LIMIT 1),'Koteswara Rao Kottakota','Padmavathi',(select id from address where VILLAGE = 'Kattula Kavity' LIMIT 1),
'kottakotadileepkumar@gmail.com','test','kottakotadileepkumar@gmail.com','9493702550','','','2020-01-01','2020-01-01',null,
'2020-01-01','DILEEP','2020-01-01','DILEEP','1'),
('Ashok Kumar','Kottakota',(select id from cmvalue where NAME = 'MALE' LIMIT 1),(select id from cmvalue where NAME = 'STUDENT' LIMIT 1),
(select id from school where NAME= 'ZPH School' LIMIT 1),'Koteswara Rao Kottakota','Padmavathi',(select id from address where VILLAGE = 'Kattula Kavity' LIMIT 1),
'kottakotadileepkumar@gmail.com','test','kottakotaashokkumar@gmail.com','9440452010','','','2020-01-01','2020-01-01',null,
'2020-01-01','DILEEP','2020-01-01','DILEEP','1'),
('Anusha','Kottakota',(select id from cmvalue where NAME = 'FEMALE' LIMIT 1),(select id from cmvalue where NAME = 'STUDENT' LIMIT 1),
(select id from school where NAME= 'ZPH School' LIMIT 1),'Koteswara Rao Kottakota','Padmavathi',(select id from address where VILLAGE = 'Kattula Kavity' LIMIT 1),
'kottakotaanusha@gmail.com','test','kottakotaanusha@gmail.com','9440452010','','','2020-01-01','2020-01-01',null,
'2020-01-01','DILEEP','2020-01-01','DILEEP','1'),
('KPNaidu','Kottakota',(select id from cmvalue where NAME = 'MALE' LIMIT 1),(select id from cmvalue where NAME = 'TEACHER' LIMIT 1),
(select id from school where NAME= 'Maharshi' LIMIT 1),'QWERT','QWERT',(select id from address where VILLAGE = 'Parvathipuram' LIMIT 1),
'qwerrt@gmail.com','test','qerwer@gmail.com','9440452010','','','2020-01-01','2020-01-01',null,
'2020-01-01','DILEEP','2020-01-01','DILEEP','1'),
('abcd','abcd',(select id from cmvalue where NAME = 'MALE' LIMIT 1),(select id from cmvalue where NAME = 'STUDENT' LIMIT 1),
(select id from school where NAME= 'Maharshi' LIMIT 1),'abcd','QWERT',(select id from address where VILLAGE = 'Parvathipuram' LIMIT 1),
'qwerrt@gmail.com','test','abcd@gmail.com','94404599010','','','2020-01-01','2020-01-01',null,
'2020-01-01','DILEEP','2020-01-01','DILEEP','1');

-- USER ENDING