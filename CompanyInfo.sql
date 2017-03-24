if not exists(select * from sysdatabases where name = ‘auditsys’)
create database auditsys

go

use auditsys;

go

if exists(select * from sysobjects where name = ‘1stcompany’ and type = 'U')
drop table 1stcompany;

go

if exists(select * from sysobjects where name = ‘2ndcompany’ and type = 'U')
drop table 2ndcompany;

go

if exists(select * from sysobjects where name = ‘acondition’ and type = 'U')
drop table acondition;


go

create table 1stcompany(
cname varchar(50) not null primary key,
corp char(10),
fin char(10),
tel int(11),
findata ,
funscope varchar(50)
)

go

insert into 1stcompany(cname,corp,fin,tel,findata,funscope) values()

go

create table 2ndcompany(
ccname varchar(50) primary key,
attachedti varchar(50) not null,
ccorp char(10),
ffin char(10),
ttel int(11),
ffindata ,
ffunscope varchar(50)
)

go

insert into course(cname) values('Database System Design')

go

create table acondition(
name varchar(50) primary key,
depart varchar(50),
auditime date,
auditype char(30),
mainaudit char(30),
auditdoc ,
foreign key(name) references 1stcompany(cname)
	on delete cascade,
foreign key(name) references 2ndcompany(ccname)
	on delete cascade
)

go

insert into attend(SSN,cid,year,semester) values(1,1,'2012','spring')
insert into attend(SSN,cid,year,semester) values(1,1,'2013','spring')
