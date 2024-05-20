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

update user
set name = 'jacky1'
where name = 'jacky';

delete
from user
where name = 'jacky1';

select *
from user;

DROP TABLE IF EXISTS Customer;

CREATE TABLE IF NOT EXISTS Customer
(
    id          INT AUTO_INCREMENT PRIMARY KEY,                                  -- Unique identifier for each customer
    name        VARCHAR(100)   NOT NULL,                                         -- Customer's name, cannot be null
    age         SMALLINT       NOT NULL CHECK (age >= 0 AND age <= 120),         -- Customer's age with a constraint to be between 0 and 120
    gender      TINYINT        NOT NULL CHECK (gender IN (0, 1)),                -- Customer's gender with predefined options (0 for male, 1 for female, or customize as needed)
    phone       VARCHAR(20)    NOT NULL,                                         -- Customer's phone number, cannot be null
    username    VARBINARY(100) NOT NULL UNIQUE ,
    password    VARBINARY(100) NOT NULL,
    entry_date  DATE           NOT NULL,                                         -- Customer's entry date, cannot be null
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                             -- Automatically set to current timestamp upon creation
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Automatically updated to current timestamp on update
    CONSTRAINT chk_age CHECK (age >= 0 AND age <= 120)                           -- Ensures age is within a realistic range
);

-- Add an index on the phone column to improve search performance
CREATE INDEX idx_phone ON Customer (phone);
CREATE INDEX idx_username ON Customer (username);

INSERT INTO Customer (name, age, gender, phone, entry_date, username, password)
VALUES ('John Doe', 30, 0, '123-456-7890', '2024-01-01', 'Jane Smith', '12345'),
       ('Jane Smith', 25, 1, '098-765-4321', '2024-02-01', 'Jane Smith', '12345');

update customer
set name       = 'jacky',
    age=23,
    gender     = 0,
    phone      = '1234567890',
    entry_date = '2024-01-01'
where id = 1;

select *
from Customer
where name = '%J%'
  and gender = '1'
  and entry_date between '1900-01-01' and '2024-01-01'
order by update_time desc;