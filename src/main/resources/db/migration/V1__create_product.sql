create table product (
                         ativo boolean,
                         estoque integer,
                         id serial not null,
                         preco numeric(38,2),
                         validade timestamp(6),
                         descricao varchar(255),
                         fornecedor varchar(255),
                         nome varchar(255),
                         primary key (id)
)