create table users (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(60) not null,
    profile varchar(30) not null,

    primary key (id)
);
