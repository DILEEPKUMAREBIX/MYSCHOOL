INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`)
VALUES
(
"CLASS",
"CLASSES AVAILABLE IN SCHOOL",
1);


INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`)
VALUES ( (select id from cmgroup where name="Class"),"1","Class 1",true ),
( (select id from cmgroup where name="Class"),"2","Class 2",true ),
( (select id from cmgroup where name="Class"),"3","Class 3",true ),
( (select id from cmgroup where name="Class"),"4","Class 4",true ),
( (select id from cmgroup where name="Class"),"5","Class 5",true ),
( (select id from cmgroup where name="Class"),"6","Class 6",true ),
( (select id from cmgroup where name="Class"),"7","Class 7",true ),
( (select id from cmgroup where name="Class"),"8","Class 8",true ),
( (select id from cmgroup where name="Class"),"9","Class 9",true ),
( (select id from cmgroup where name="Class"),"10","Class 10",true );


INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`)
VALUES
(
"SECTION",
"SECTIONS AVAILABLE IN SCHOOL",
1);

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`)
VALUES ( (select id from cmgroup where name="SECTION"),"A","Section A",true ),
( (select id from cmgroup where name="SECTION"),"B","Section B",true ),
( (select id from cmgroup where name="SECTION"),"C","Section C",true ),
( (select id from cmgroup where name="SECTION"),"D","Section D",true ),
( (select id from cmgroup where name="SECTION"),"E","Section E",true );

INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`)
VALUES
(
"SCHTYPE",
"School Type Public,Private,Chain",
1);

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`)
VALUES ( (select id from cmgroup where name="SCHTYPE"),"PUBLIC","Public/Government Schools",true ),
( (select id from cmgroup where name="SCHTYPE"),"PRIVATE","Private Schools",true ),
( (select id from cmgroup where name="SCHTYPE"),"CHAIN","Chain of schools",true );