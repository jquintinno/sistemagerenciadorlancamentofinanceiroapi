select * 
from information_schema.tables 
where table_schema = 'public';

drop table if exists tb_categoria_lancamento_financeiro cascade;
drop table if exists tb_lancamento_financeiro cascade;
drop table if exists tb_produto_servico cascade;
drop table if exists tb_lancamento_financeiro_produto_servico cascade;
drop table if exists tb_parcelamento cascade;
drop table if exists tb_conta_bancaria cascade;
drop table if exists tb_forma_pagamento cascade;
drop table if exists tb_pagamento_parcelamento cascade;
drop table if exists tb_pessoa cascade;
drop table if exists tb_categoria_senha cascade;
drop table if exists tb_senha cascade;

create table if not exists tb_pessoa(
	codigo bigserial not null,
	tipo_pessoa varchar(45) not null check (tipo_pessoa in ('PESSOA_FISICA', 'PESSOA_JURIDICA')),
	nome varchar(100) not null unique,
	constraint pk_pessoa primary key (codigo)
);

insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_FISICA', 'José Quintinno');
insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_JURIDICA', 'Mirante Tecnologia da Informação');
insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_JURIDICA', 'Sinagoga Keter Torah');
insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_JURIDICA', 'TIM Telecomunicações');
insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_JURIDICA', 'VIVO Telecomunicações');

create table if not exists tb_categoria_lancamento_financeiro(
	codigo bigserial not null,
	nome varchar(100) not null unique,
	sigla varchar(10) not null unique,
	constraint pk_categoria_lancamento_financeiro primary key (codigo)
);

insert into tb_categoria_lancamento_financeiro (nome, sigla) values ('Concessão de Doação para Pessoa Física', 'CDPF');
insert into tb_categoria_lancamento_financeiro (nome, sigla) values ('Adquirição de Doação para Pessoa Jurídica', 'ADPJ');
insert into tb_categoria_lancamento_financeiro (nome, sigla) values ('Receita Fixa', 'REFI');
insert into tb_categoria_lancamento_financeiro (nome, sigla) values ('Receita Variável', 'REVA');
insert into tb_categoria_lancamento_financeiro (nome, sigla) values ('Despesa Fixa', 'DEFI');
insert into tb_categoria_lancamento_financeiro (nome, sigla) values ('Despesa Variável', 'DEVA');

create table tb_lancamento_financeiro (
	codigo bigserial not null,
	id_categoria_lancamento_financeiro serial not null,
  	id_pessoa_lancamento_financeiro serial not null,
  	id_pessoa_responsavel serial not null,
	data_lancamento_financeiro date not null,
	dia_vencimento_parcela integer null,
	quantidade_parcela integer null,
	constraint pk_lancamento_financeiro primary key (codigo),
	constraint fk_categoria_lancamento_financeiro foreign key (id_categoria_lancamento_financeiro) references tb_categoria_lancamento_financeiro (codigo)
);

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, data_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(3), (2), (1), now(), 10, 12
);

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, data_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(4), (3), (1), now(), null, 1
);

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, data_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(5), (3), (1), now(), 10, 12
);

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, data_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(5), (3), (1), now(), 10, 12
);

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, data_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(5), (4), (1), now(), 10, 12
);

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, data_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(5), (5), (1), now(), 10, 12
);

create table if not exists tb_produto_servico (
	codigo bigserial not null,
	nome varchar(100) not null unique,
	descricao varchar(255) null,
	constraint pk_produto_servico primary key (codigo)
);

insert into tb_produto_servico (nome, descricao) values ('Salário Mensalista CLT', null);
insert into tb_produto_servico (nome, descricao) values ('Consórcio Keter Torah', null);
insert into tb_produto_servico (nome, descricao) values ('Doação para Pessoa Jurídica', null);
insert into tb_produto_servico (nome, descricao) values ('Plano de Telefonia e Internet Móvel', null);

create table if not exists tb_lancamento_financeiro_produto_servico (
	codigo bigserial not null,
	id_lancamento_financeiro serial not null,
	id_produto_servico serial not null,
	valor decimal(10,2) not null,
	constraint pk_lancamento_financeiro_produto_servico primary key (codigo),
	constraint fk_lancamento_financeiro foreign key (id_lancamento_financeiro) references tb_lancamento_financeiro (codigo),
	constraint fk_produto_servico foreign key (id_produto_servico) references tb_produto_servico (codigo)
);

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(1), (1), 5300
);

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(2), (2), 1000
);

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(3), (3), 250
);

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(4), (2), 100
);

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(5), (4), 60
);

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(6), (4), 80
);

create table if not exists tb_parcelamento (
	codigo bigserial not null,
	id_lancamento_financeiro serial not null,
	numero_parcela integer not null,
	data_vencimento date null,
	data_pagamento date null,
	valor_parcela numeric(10,2) null,
	valor_desconto numeric(10,2) null,
	valor_juros numeric(10,2) null,
	valor_total_parcela numeric(10,2) null,
	constraint pk_parcelamento primary key (codigo),
	constraint fk_lancamento_financeiro foreign key (id_lancamento_financeiro) references tb_lancamento_financeiro (codigo)
);

insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 1, '2023-01-10', '2023-01-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 2, '2023-02-10', '2023-02-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 3, '2023-03-10', '2023-03-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 4, '2023-04-10', '2023-04-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 5, '2023-05-10', '2023-05-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 6, '2023-06-10', '2023-06-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 7, '2023-07-10', '2023-07-10', 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 8, '2023-08-10', null, 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 9, '2023-09-10', null,  5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 10, '2023-10-10', null, 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 11, '2023-11-10', null, 5300, 0, 0, 5300);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((1), 12, '2023-12-10', null, 5300, 0, 0, 5300);

insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((2), 1, '2023-08-10', null, 1000, 0, 0, 1000);

insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 1, '2023-01-10', '2023-01-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 2, '2023-02-10', '2023-02-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 3, '2023-03-10', '2023-03-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 4, '2023-04-10', '2023-04-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 5, '2023-05-10', '2023-05-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 6, '2023-06-10', '2023-06-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 7, '2023-07-10', '2023-07-10', 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 8, '2023-08-10', null, 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 9, '2023-09-10', null, 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 10, '2023-10-10', null, 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 11, '2023-11-10', null, 250, 0, 0, 250);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((3), 12, '2023-12-10', null, 250, 0, 0, 250);

insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 1, '2023-01-10', '2023-01-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 2, '2023-02-10', '2023-02-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 3, '2023-03-10', '2023-03-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 4, '2023-04-10', '2023-04-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 5, '2023-05-10', '2023-05-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 6, '2023-06-10', '2023-06-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 7, '2023-07-10', '2023-07-10', 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 8, '2023-08-10', null, 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 9, '2023-09-10', null, 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 10, '2023-10-10', null, 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 11, '2023-11-10', null, 100, 0, 0, 100);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((4), 12, '2023-12-10', null, 100, 0, 0, 100);


insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 1, '2023-01-10', '2023-01-10', 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 2, '2023-02-10', '2023-02-10', 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 3, '2023-03-10', '2023-03-10', 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 4, '2023-04-10', '2023-04-10', 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 5, '2023-05-10', '2023-05-10', 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 6, '2023-06-10', '2023-06-10', 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 7, '2023-07-10', null, 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 8, '2023-08-10', null, 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 9, '2023-09-10', null, 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 10, '2023-10-10', null, 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 11, '2023-11-10', null, 60, 0, 0, 60);
insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento, data_pagamento, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values ((5), 12, '2023-12-10', null, 60, 0, 0, 60);

create table if not exists tb_categoria_senha (
	codigo bigserial not null, 
	descricao varchar(100) not null,
	constraint pk_categoria_senha primary key (codigo)
);

create table if not exists tb_senha (
	codigo bigserial not null,
	id_categoria_senha serial not null,
	id_pessoa serial not null,
	descricao varchar(100) not null,
	identificador varchar(100) null,
	senha varchar(50) not null,
	ativo boolean not null,
	constraint pk_senha primary key (codigo),
	constraint fk_categoria_senha foreign key (id_categoria_senha) references tb_categoria_senha (codigo),
	constraint fk_pessoa foreign key (id_pessoa) references tb_pessoa (codigo)
);

insert into tb_categoria_senha (descricao) values ('Aplicativo');
insert into tb_categoria_senha (descricao) values ('Cartão Bancário');
insert into tb_categoria_senha (descricao) values ('Cartão Benefício');
insert into tb_categoria_senha (descricao) values ('E-mail');

insert into tb_senha (id_categoria_senha, id_pessoa, descricao, identificador, senha, ativo) values (
	(2), (1), 'Cartão do Banco do Brasil', null, '770ac799-d7ff-4641-9815-d860ed521e16', true
);

insert into tb_senha (id_categoria_senha, id_pessoa, descricao, identificador, senha, ativo) values (
	(1), (1), 'Aplicativo do Banco do Brasil', null, '09f12c67-a236-49a4-bab7-3325755d3736', true
);

insert into tb_senha (id_categoria_senha, id_pessoa, descricao, identificador, senha, ativo) values (
	(4), (1), 'E-mail do GMAIL (jquintinno@gmail.com)', 'jquintinno@gmail.com', 'ead649be-29ad-43fd-8f98-d9ef5b314fbd', true
);

/*

	select * from tb_pessoa;
	select * from tb_categoria_lancamento_financeiro;
	select * from tb_lancamento_financeiro;
	select * from tb_produto_servico;
	select * from tb_lancamento_financeiro_produto_servico;
	select * from tb_parcelamento;
	select * from tb_categoria_senha;
	select * from tb_senha;
	
	-- Recuperar todos os lancamento Financeiros
	select 
		lancamento_financeiro.codigo as id_lancamento,
		pessoa_lancamento_financeiro.nome as favorecido,
		lancamento_financeiro.data_lancamento_financeiro as data_,
		categoria_lancamento_financeiro.nome as categoria
	-- select *
	from tb_lancamento_financeiro lancamento_financeiro
	join tb_categoria_lancamento_financeiro categoria_lancamento_financeiro on categoria_lancamento_financeiro.codigo = lancamento_financeiro.id_categoria_lancamento_financeiro 
	join tb_pessoa pessoa_lancamento_financeiro on pessoa_lancamento_financeiro.codigo = lancamento_financeiro.id_pessoa_lancamento_financeiro
	join tb_pessoa pessoa_responsavel on pessoa_responsavel.codigo = lancamento_financeiro.id_pessoa_responsavel;

	-- Recuperar todos os lancamento Financeiros com Produtos e Serviços
	select 
		lancamento_financeiro.codigo as id_lancamento,
		pessoa_lancamento_financeiro.nome as favorecido,
		to_char(lancamento_financeiro.data_lancamento_financeiro, 'dd/mm/yyyy') as data_,
		categoria_lancamento_financeiro.nome as categoria,
		produto_servico.nome as produto_servico,
		lancamento_financeiro_produto_servico.valor
	-- select *
	from tb_lancamento_financeiro lancamento_financeiro
	join tb_categoria_lancamento_financeiro categoria_lancamento_financeiro on categoria_lancamento_financeiro.codigo = lancamento_financeiro.id_categoria_lancamento_financeiro 
	join tb_pessoa pessoa_lancamento_financeiro on pessoa_lancamento_financeiro.codigo = lancamento_financeiro.id_pessoa_lancamento_financeiro
	join tb_pessoa pessoa_responsavel on pessoa_responsavel.codigo = lancamento_financeiro.id_pessoa_responsavel
	join tb_lancamento_financeiro_produto_servico lancamento_financeiro_produto_servico on lancamento_financeiro_produto_servico.id_lancamento_financeiro = lancamento_financeiro.codigo
	join tb_produto_servico produto_servico on produto_servico.codigo = lancamento_financeiro_produto_servico.id_produto_servico;

	-- Recuperar todos os lancamento Financeiros em aberto (por período)
	select 
		lancamento_financeiro.codigo as id_lancamento,
		pessoa_lancamento_financeiro.nome as favorecido,
		categoria_lancamento_financeiro.nome as categoria,
		produto_servico.nome as produto_servico,
		to_char(parcelamento.data_vencimento, 'dd/mm/yyyy') as data_prevista_pagamento,
		to_char(parcelamento.data_pagamento, 'dd/mm/yyyy') as data_pagamento,
		parcelamento.valor_total_parcela as valor
	-- select *
	from tb_lancamento_financeiro lancamento_financeiro
	join tb_categoria_lancamento_financeiro categoria_lancamento_financeiro on categoria_lancamento_financeiro.codigo = lancamento_financeiro.id_categoria_lancamento_financeiro 
	join tb_pessoa pessoa_lancamento_financeiro on pessoa_lancamento_financeiro.codigo = lancamento_financeiro.id_pessoa_lancamento_financeiro
	join tb_pessoa pessoa_responsavel on pessoa_responsavel.codigo = lancamento_financeiro.id_pessoa_responsavel
	join tb_lancamento_financeiro_produto_servico lancamento_financeiro_produto_servico on lancamento_financeiro_produto_servico.id_lancamento_financeiro = lancamento_financeiro.codigo
	join tb_produto_servico produto_servico on produto_servico.codigo = lancamento_financeiro_produto_servico.id_produto_servico
	join tb_parcelamento parcelamento on parcelamento.id_lancamento_financeiro = lancamento_financeiro.codigo
	where data_vencimento between date_trunc('month', now())::date and (date_trunc('month', now()) + interval '1 month' -interval '1 day')::date;
	
	-- Recuperar todos os lancamento Financeiros em aberto (por período - agregado)
	select 
		lancamento_financeiro.codigo as id_lancamento,
		pessoa_lancamento_financeiro.nome as favorecido,
		categoria_lancamento_financeiro.nome as categoria,
		produto_servico.nome as produto_servico,
		to_char(parcelamento.data_vencimento, 'dd/mm/yyyy') as data_prevista_pagamento,
		to_char(parcelamento.data_pagamento, 'dd/mm/yyyy') as data_pagamento,
		parcelamento.valor_total_parcela as valor,
		sum(parcelamento.valor_total_parcela) over (partition by categoria_lancamento_financeiro.nome) as totalizador
	-- select *
	from tb_lancamento_financeiro lancamento_financeiro
	join tb_categoria_lancamento_financeiro categoria_lancamento_financeiro on categoria_lancamento_financeiro.codigo = lancamento_financeiro.id_categoria_lancamento_financeiro 
	join tb_pessoa pessoa_lancamento_financeiro on pessoa_lancamento_financeiro.codigo = lancamento_financeiro.id_pessoa_lancamento_financeiro
	join tb_pessoa pessoa_responsavel on pessoa_responsavel.codigo = lancamento_financeiro.id_pessoa_responsavel
	join tb_lancamento_financeiro_produto_servico lancamento_financeiro_produto_servico on lancamento_financeiro_produto_servico.id_lancamento_financeiro = lancamento_financeiro.codigo
	join tb_produto_servico produto_servico on produto_servico.codigo = lancamento_financeiro_produto_servico.id_produto_servico
	join tb_parcelamento parcelamento on parcelamento.id_lancamento_financeiro = lancamento_financeiro.codigo
	where data_vencimento between date_trunc('month', now())::date and (date_trunc('month', now()) + interval '1 month' -interval '1 day')::date
	group by 
		lancamento_financeiro.codigo,
		pessoa_lancamento_financeiro.nome,
		categoria_lancamento_financeiro.nome,
		produto_servico.nome,
		parcelamento.data_vencimento,
		parcelamento.data_pagamento,
		parcelamento.valor_total_parcela;
		
	-- Recuperar Despesas Mensais vencidas
	select *
	from tb_parcelamento parcelamento
	where parcelamento.data_pagamento is null
	and parcelamento.data_vencimento <= (date_trunc('month', now())::date)
	order by parcelamento.data_vencimento asc;
	
	-- Recuperar Despesa Mensais com Valor Consolidado com Despesas Vencidas
	select 
		id_lancamento_financeiro,
		favorecido,
		categoria,
		-- produto_servico,
		(valor_parcela * quantidade_atraso) as valor
	from (
		select 
			count(parcelamento.id_lancamento_financeiro) quantidade_atraso,
			parcelamento.id_lancamento_financeiro,
			pessoa_lancamento_financeiro.nome as favorecido,
			categoria_lancamento_financeiro.nome as categoria,
			-- produto_servico.nome as produto_servico,
			-- to_char(parcelamento.data_vencimento, 'dd/mm/yyyy') as data_prevista_pagamento,
			-- to_char(parcelamento.data_pagamento, 'dd/mm/yyyy') as data_pagamento,
			parcelamento.valor_parcela
		from tb_parcelamento parcelamento
		join tb_lancamento_financeiro lancamento_financeiro on lancamento_financeiro.codigo = parcelamento.id_lancamento_financeiro
		join tb_pessoa pessoa_lancamento_financeiro on pessoa_lancamento_financeiro.codigo = lancamento_financeiro.id_pessoa_lancamento_financeiro
		join tb_categoria_lancamento_financeiro categoria_lancamento_financeiro on categoria_lancamento_financeiro.codigo = lancamento_financeiro.id_categoria_lancamento_financeiro
		-- join tb_lancamento_financeiro_produto_servico lancamento_financeiro_produto_servico on lancamento_financeiro_produto_servico.id_lancamento_financeiro = lancamento_financeiro.codigo
		-- join tb_produto_servico produto_servico on produto_servico.codigo = lancamento_financeiro_produto_servico.id_produto_servico
		where 1 = 1
		and parcelamento.data_pagamento is null
		and parcelamento.data_vencimento <= (date_trunc('month', now())::date)
		or parcelamento.data_vencimento between date_trunc('month', now())::date and (date_trunc('month', now()) + interval '1 month' -interval '1 day')::date
		group by 
			parcelamento.id_lancamento_financeiro,
			parcelamento.valor_parcela,
			categoria_lancamento_financeiro.nome,
			pessoa_lancamento_financeiro.nome
			-- parcelamento.data_vencimento,
			-- parcelamento.data_pagamento
			-- produto_servico.nome
		order by parcelamento.id_lancamento_financeiro
	) as parcelamento_atraso;
	
*/




