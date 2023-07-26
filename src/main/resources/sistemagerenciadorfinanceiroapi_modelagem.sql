drop table if exists tb_pessoa cascade;
drop table if exists tb_categoria_lancamento_financeiro cascade;
drop table if exists tb_conta_bancaria cascade;
drop table if exists tb_forma_pagamento cascade;
drop table if exists  tb_lancamento_financeiro cascade;
drop table if exists tb_produto_servico cascade;
drop table if exists tb_lancamento_financeiro_produto_servico cascade;
drop table if exists tb_pagamento_parcela cascade;
drop table if exists tb_parcelamento cascade;
drop table if exists tb_pagamento_parcelamento cascade;

create table if not exists tb_pessoa (
	codigo bigserial not null,
	tipo_pessoa varchar(30) not null check ( tipo_pessoa in ('PESSOA_FISICA', 'PESSOA_JURIDICA')),
	nome varchar(100) not null unique,
	constraint pk_pessoa primary key (codigo)
);

create table if not exists tb_categoria_lancamento_financeiro (
	codigo bigserial not null,
	nome varchar(50) not null unique,
	constraint pk_categoria_lancamento_financeiro primary key (codigo)
);

create table if not exists tb_lancamento_financeiro (
	codigo bigserial not null,
	id_categoria_lancamento_financeiro serial not null,
	id_pessoa_lancamento_financeiro serial not null,
	id_pessoa_responsavel serial not null,
	data_lancamento_financeiro timestamp not null, 
	valor_total_lancamento_financeiro numeric(10,2) not null,
	dia_vencimento_parcela integer null,
	quantidade_parcela integer not null default 1,
	constraint pk_lancamento_financeiro primary key (codigo),
	constraint fk_categoria_lancamento_financeiro foreign key (id_categoria_lancamento_financeiro) references tb_categoria_lancamento_financeiro (codigo),
	constraint fk_pessoa_lancamento_financeiro foreign key (id_pessoa_lancamento_financeiro) references tb_pessoa (codigo),
	constraint fk_pessoa_responsavel foreign key (id_pessoa_responsavel) references tb_pessoa (codigo)
);

comment on column tb_lancamento_financeiro.codigo is 'Identificador Único da Tabela';
comment on column tb_lancamento_financeiro.id_pessoa_lancamento_financeiro is 'Indica a pessoa que Recebe de um determinado Lançamento Financeiro.';
comment on column tb_lancamento_financeiro.id_pessoa_responsavel is 'Indica a pessoa responsável por um determinado Lançamento Financeiro.';
comment on column tb_lancamento_financeiro.id_categoria_lancamento_financeiro is 'Indica a Categoria de um determinado Lançamento Financeiro.';
comment on column tb_lancamento_financeiro.data_lancamento_financeiro is 'Indica a Data de Cadastro de um determinado Lançamento Financeiro.';
comment on column tb_lancamento_financeiro.valor_total_lancamento_financeiro is 'Indica o Valor Total de um determinado Lançamento Financeiro.';
comment on column tb_lancamento_financeiro.dia_vencimento_parcela is 'Indica o Dia de Vencimento de um determinado Lançamento Financeiro. Usado apenas quando a Categoria do Lançamento Financeiro for do tipo FIXO.';
comment on column tb_lancamento_financeiro.quantidade_parcela is 'Indica a quantidade de parcelas de um determinado Lançamento Financeiro. Por padrão, todo Lançamento Financeiro deve ser 1 (para Lançamento Financeiro do tipo FIXO) e mais de um (para Lançamentos Financeiros do tipo VARIÁVEL)';

create table if not exists tb_produto_servico (
	codigo bigserial not null,
	nome varchar not null unique,
	descricao varchar not null unique,
	constraint pk_produto_servico primary key (codigo)
);

create table if not exists tb_lancamento_financeiro_produto_servico (
	codigo bigserial not null,
	id_lancamento_financeiro serial not null,
	id_produto_servico serial not null,
	valor numeric(10,2) not null,
	constraint pk_lancamento_financeiro_produto_servico primary key (codigo),
	constraint fk_lancamento_financeiro foreign key (id_lancamento_financeiro) references tb_lancamento_financeiro (codigo),
	constraint fk_produto_servico foreign key (id_produto_servico) references tb_produto_servico (codigo)
);

create table if not exists tb_parcelamento (
	codigo bigserial not null,
	id_lancamento_financeiro serial not null,
	numero_parcela integer not null,
	data_vencimento_parcela date null,
	valor_parcela numeric(10,2) null,
	valor_desconto numeric(10,2) null,
	valor_juros numeric(10,2) null,
	valor_total_parcela numeric(10,2) null,
	constraint pk_parcelamento primary key (codigo),
	constraint fk_lancamento_financeiro foreign key (id_lancamento_financeiro) references tb_lancamento_financeiro (codigo)
);

create table if not exists tb_conta_bancaria (
	codigo bigserial not null, 
	id_pessoa_conta_bancaria serial not null, 
	id_pessoa_titular serial not null, 
	tipo_conta_bancaria varchar(50) not null check ( tipo_conta_bancaria in ('CONTA_ESPECIAL', 'CONTA_SALARIO', 'CONTA_CORRENTE', 'CONTA_POUPANCA', 'CONTA_INVESTIMENTO')),
	identificador varchar(100) null,
	numero varchar(50) not null unique,
	numero_agencia varchar(20) not null unique,
	data_abertura date null,
	data_enceramento date null,
	e_conta_bancaria_principal boolean not null, 
	constraint pk_conta_bancaria primary key (codigo),
	constraint fk_pessoa_conta_bancaria foreign key (id_pessoa_conta_bancaria) references tb_pessoa (codigo),
	constraint fk_pessoa_titular foreign key (id_pessoa_titular) references tb_pessoa (codigo)
);

create table if not exists tb_forma_pagamento (
	codigo bigserial not null,
	id_conta_bancaria serial not null,
	nome varchar(100) not null unique,
	constraint pk_forma_pagamento primary key (codigo),
	constraint fk_conta_bancaria foreign key (id_conta_bancaria) references tb_conta_bancaria (codigo)
);

create table if not exists tb_pagamento_parcelamento (
	codigo bigserial not null,
	id_parcelamento serial not null,
	id_forma_pagamento serial not null,
	data_pagamento date not null,
	valor_pagamento numeric(10,2) not null,
	constraint pk_pagamento_parcelamento primary key (codigo),
	constraint fk_parcelamento foreign key (id_parcelamento) references tb_parcelamento (codigo),
	constraint fk_forma_pagamento foreign key (id_forma_pagamento) references tb_forma_pagamento (codigo)
);

insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_FISICA', 'José Quintinno');
insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_JURIDICA', 'Banco do Brasil');
insert into tb_pessoa (tipo_pessoa, nome) values ('PESSOA_JURIDICA', 'Amazon Brasil');

insert into tb_categoria_lancamento_financeiro (nome) values ('Receita Fixa');
insert into tb_categoria_lancamento_financeiro (nome) values ('Receita Variável');
insert into tb_categoria_lancamento_financeiro (nome) values ('Despesa Fixa');
insert into tb_categoria_lancamento_financeiro (nome) values ('Despesa Variável');
insert into tb_categoria_lancamento_financeiro (nome) values ('Adquirição de Empréstimo (Pessoa Física)');
insert into tb_categoria_lancamento_financeiro (nome) values ('Adquirição de Empréstimo (Pessoa Jurídica)');
insert into tb_categoria_lancamento_financeiro (nome) values ('Concessão de Empréstimo (Pessoa Física)');
insert into tb_categoria_lancamento_financeiro (nome) values ('Concessão de Empréstimo (Pessoa Jurídica)');

insert into tb_lancamento_financeiro (id_categoria_lancamento_financeiro, id_pessoa_lancamento_financeiro, id_pessoa_responsavel, 
data_lancamento_financeiro, valor_total_lancamento_financeiro, dia_vencimento_parcela, quantidade_parcela) values (
	(select codigo from tb_categoria_lancamento_financeiro where nome = 'Despesa Variável'),
	(select codigo from tb_pessoa where nome = 'Amazon Brasil'),
	(select codigo from tb_pessoa where nome = 'José Quintinno'),
	now(),
	3689.11,
	null,
	1
);

insert into tb_produto_servico (nome, descricao) values ('Notebook Lenovo', 'Lenovo 82MG0009BR - Notebook ideapad Gaming 3i, i5-11300H, 8GB, 512GB SSD Dedicada GTX 1650 4GB 15.6" FHD WVA W11, Preto');

insert into tb_lancamento_financeiro_produto_servico (id_lancamento_financeiro, id_produto_servico, valor) values (
	(1),
	(1),
	3689.11
);

insert into tb_parcelamento (id_lancamento_financeiro, numero_parcela, data_vencimento_parcela, valor_parcela, valor_desconto, valor_juros, valor_total_parcela) values (
	(1),
	1, null, 3689.11, 0, 0, 3689.11
);

insert into tb_conta_bancaria (id_pessoa_conta_bancaria, id_pessoa_titular, tipo_conta_bancaria, identificador, numero, numero_agencia, data_abertura, data_enceramento, e_conta_bancaria_principal) values (
	(1),
	(1),
	'CONTA_ESPECIAL', 'Conta Especial', '00000-X', '0000', null, null, true
);

insert into tb_conta_bancaria (id_pessoa_conta_bancaria, id_pessoa_titular, tipo_conta_bancaria, identificador, numero, numero_agencia, data_abertura, data_enceramento, e_conta_bancaria_principal) values (
	(2),
	(1),
	'CONTA_CORRENTE', null, '5689568-X', '5689', null, null, false
);

insert into tb_forma_pagamento (id_conta_bancaria, nome) values (
	(1),
	'Dinheiro'
);

insert into tb_pagamento_parcelamento (id_parcelamento, id_forma_pagamento, data_pagamento, valor_pagamento) values (
	(1),
	1,
	now(),
	3689.11
);

/*

-- Recuperar lancamento financeiro

	select 	
		to_char(lancamento_financeiro.data_lancamento_financeiro, 'dd/mm/yyyy') as data_compra,
		pessoa.nome as loja,
		produto_servico.nome as produto,
		lancamento_financeiro_produto_servico.valor,
		to_char(pagamento_parcelamento.data_pagamento , 'dd/mm/yyyy') as data_pagamento,
		forma_pagamento.nome as forma_pagamento,
		conta_bancaria.tipo_conta_bancaria as origem_recurso
	-- select *
	from tb_lancamento_financeiro lancamento_financeiro
	join tb_pessoa pessoa on pessoa.codigo = lancamento_financeiro.id_pessoa_lancamento_financeiro
	join tb_lancamento_financeiro_produto_servico lancamento_financeiro_produto_servico on lancamento_financeiro_produto_servico.id_lancamento_financeiro = lancamento_financeiro.codigo 
	join tb_produto_servico produto_servico on produto_servico.codigo = lancamento_financeiro_produto_servico.id_produto_servico
	join tb_parcelamento parcelamento on parcelamento.id_lancamento_financeiro = lancamento_financeiro.codigo
	join tb_pagamento_parcelamento pagamento_parcelamento on pagamento_parcelamento.id_parcelamento = parcelamento.codigo
	join tb_forma_pagamento forma_pagamento on forma_pagamento.codigo = pagamento_parcelamento.id_forma_pagamento
	join tb_conta_bancaria conta_bancaria on conta_bancaria.codigo = forma_pagamento.id_conta_bancaria
	join tb_pessoa pessoa_conta_bancaria on pessoa_conta_bancaria.codigo = conta_bancaria.id_pessoa_conta_bancaria;

*/
