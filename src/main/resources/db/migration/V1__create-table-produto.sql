CREATE TABLE produtos(
    id bigint PRIMARY KEY UNIQUE NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    preco_unitario NUMERIC(19, 2) NOT NULL,
    categoria VARCHAR(250) NOT NULL,
    status VARCHAR(1) NOT NULL,
	descricao VARCHAR(255),
	data_cadastro DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL
);