create table topicos (
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null unique,
    autor_id bigint not null,
    curso varchar(100) not null,
    fecha_creacion datetime not null,
    estado varchar(100) not null,

    primary key (id)
);