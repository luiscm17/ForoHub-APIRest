alter table users add active tinyint not null;
update users set active = 1;
