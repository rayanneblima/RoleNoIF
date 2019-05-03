create table user (
    id integer not null auto_increment primary key,
    nome varchar(60) not null,
    email text not null,
    matricula varchar(80),
    telefone varchar(13),
    cidade varchar(30),
    senha LONGTEXT 
);