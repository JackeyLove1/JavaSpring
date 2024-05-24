use test;

drop table if exists mp;

create table tb_user(
    id bigint not null auto_increment,
    name varchar(255) not null ,
    username varchar(30) not null unique ,
    password varchar(30) not null,
    age int(11) default null,
    email varchar(255) default null,
    CONSTRAINT ck_age CHECK (age >= 0 and age <= 120),
    primary key (id)
);

create index idx_username on tb_user(username);
INSERT INTO `tb_user` (`id`, `username`, `password`, `name`, `age`, `email`) VALUES
    ('1', 'zhangsan', '123456', '张三', '18', 'test1@itcast.cn');
INSERT INTO `tb_user` (`id`, `username`, `password`, `name`, `age`, `email`) VALUES
    ('2', 'lisi', '123456', '李四', '20', 'test2@itcast.cn');
INSERT INTO `tb_user` (`id`, `username`, `password`, `name`, `age`, `email`) VALUES
    ('3', 'wangwu', '123456', '王五', '28', 'test3@itcast.cn');
INSERT INTO `tb_user` (`id`, `username`, `password`, `name`, `age`, `email`) VALUES
    ('4', 'zhaoliu', '123456', '赵六', '21', 'test4@itcast.cn');
INSERT INTO `tb_user` (`id`, `username`, `password`, `name`, `age`, `email`) VALUES
    ('5', 'sunqi', '123456', '孙七', '24', 'test5@itcast.cn');