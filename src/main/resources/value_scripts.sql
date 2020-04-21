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
"Sukesh",
"Sukesh");


INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`, `created_date`,`last_updated_date`,`created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="Class"),"1","Class 1",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"2","Class 2",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"3","Class 3",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"4","Class 4",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"5","Class 5",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"6","Class 6",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"7","Class 7",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"8","Class 8",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"9","Class 9",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="Class"),"10","Class 10",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" );


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
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`, `created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="SECTION"),"A","Section A",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="SECTION"),"B","Section B",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="SECTION"),"C","Section C",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="SECTION"),"D","Section D",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="SECTION"),"E","Section E",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" );

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
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`,`created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="SCHTYPE"),"PUBLIC","Public/Government Schools",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="SCHTYPE"),"PRIVATE","Private Schools",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="SCHTYPE"),"CHAIN","Chain of schools",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" );


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
VALUES ( (select id from cmgroup where name="UserCategory"),"STUDENT","STUDENT",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Sukesh","Sukesh" ),
( (select id from cmgroup where name="UserCategory"),"TEACHER","TEACHER",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"PARENT","PARENT",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"ADMIN","ADMIN",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="UserCategory"),"HEADMASTER","HEADMASTER",true ,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );