create table anunciantes(

  id bigint auto_increment primary key,
  nome varchar(50) not null,
  email varchar(50) not null unique,
  cpf varchar(50) not null unique,
  telefone varchar(50) not null unique,
  rua varchar(50) not null,
  numero varchar(50) not null,
  bairro varchar(50) not null,
  funcao int
);