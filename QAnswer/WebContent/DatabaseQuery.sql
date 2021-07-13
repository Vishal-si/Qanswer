create database Qanswer;

use Qanswer;

create table admin(adminid varchar(30) primary key,
password varchar(30) not null
);

insert into admin(adminid,password) values('admin123@gmail.com','admin123');

create table user(userid varchar(30) primary key,
name varchar(30) not null,
email varchar(30) unique key,
password varchar(30) not null
);

create table question(
quesid varchar(30) primary key,
topic varchar(30) not null,
subtopic varchar(60) not null,
question varchar(500) not null,
date date not null,
time time not null,
userid varchar(30)
);

alter table question add foreign key(userid) references user(userid);

create table answer(
ansid varchar(30) primary key,
answer varchar(500) not null,
quesid varchar(30),
cmpname varchar(30) not null
);

alter table answer add foreign key(quesid) references question(quesid);

create table approvecompany(
cmpid varchar(30) primary key,
cmpname varchar(60) not null,
email varchar(30) unique key not null,
password varchar(30) not null,
city varchar(30) not null,
country varchar(30) not null,
website varchar(60) not null
);

create table companysubmission(
cmpid varchar(30) primary key,
cmpname varchar(60) not null,
email varchar(30) unique key not null,
password varchar(30) not null,
city varchar(30) not null,
country varchar(30) not null,
website varchar(60) not null
);

create table like_table(
likeid varchar(30) primary key,
ansid varchar(30),
user varchar(30) not null,
likes tinyint(1) not null
);

alter table like_table add foreign key(ansid) references question(quesid);

create table dislike_table(
dislikeid varchar(30) primary key,
ansid varchar(30),
user varchar(30) not null,
dislikes tinyint(1) not null
);

alter table dislike_table add foreign key(ansid) references question(quesid);

create table comment(
cid varchar(30) primary key,
ansid varchar(30),
user varchar(30) not null,
comment varchar(500) not null
);

alter table comment add foreign key(ansid) references question(quesid);

create view question_answer AS
select q.quesid,q.topic,q.subtopic,q.question,q.userid,a.answer,a.cmpname
from question q,answer a
where q.quesid = a.quesid;