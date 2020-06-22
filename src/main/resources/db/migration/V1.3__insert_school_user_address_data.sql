


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