INSERT INTO `myschool`.`cmgroup`
(
`NAME`,
`DESCRIPTION`,
`ISACTIVE`,
`created_date`,
`last_updated_date`,`created_user`,`last_updated_user`)
VALUES
(
"Gender",
"Gender Type Male,Female,Transgender",
1,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep");

INSERT INTO `myschool`.`cmvalue`
(`GROUPID`,`NAME`,`DESCRIPTION`,`ISACTIVE`,`created_date`,`last_updated_date`,`created_user`,`last_updated_user`)
VALUES ( (select id from cmgroup where name="Gender"),"MALE","Male",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Gender"),"FEMALE","Female",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" ),
( (select id from cmgroup where name="Gender"),"TRANSGENDER","Transgender",true,"2020-04-02 14:58:15","2020-04-02 14:58:15","Dileep","Dileep" );
