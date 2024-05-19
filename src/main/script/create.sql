show databases;

create database if not exists db1;

use db1;

drop table if exists user;

create table if not exists user
(
    id          bigint unsigned         not null auto_increment,
    name        varchar(55) unique,
    age         tinyint unsigned        not null check ( age >= 0 and age <= 120 ),
    gender      enum ('male', 'female') not null,
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp on update current_timestamp,
    delete_time timestamp default null,
    PRIMARY KEY (id),
    CONSTRAINT ck_age CHECK (age >= 0 and age <= 120),
    CONSTRAINT ck_name CHECK ( LENGTH(name) >= 3 AND LENGTH(name) < 50 ),
    UNIQUE KEY unique_name (name)
) comment 'UserTable';

create index idx_name on user (name);

insert into user(name, age, gender)
VALUES ('jacky', 18, 'male');

update user set name = 'jacky1' where name = 'jacky';

delete from user where name = 'jacky1';

select * from user;

