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