package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/*
'create table if not exists tb_lancamento_financeiro_produto_servico (
	codigo bigserial not null,
	id_lancamento_financeiro serial not null,
	id_produto_servico serial not null,
	valor numeric(10,2) not null,
	constraint pk_lancamento_financeiro_produto_servico primary key (codigo),
	constraint fk_lancamento_financeiro foreign key (id_lancamento_financeiro) references tb_lancamento_financeiro (codigo),
	constraint fk_produto_servico foreign key (id_produto_servico) references tb_produto_servico (codigo)
);
*/
@Entity
@Table(name = "TB_LANCAMENTO_FINANCEIRO_PRODUTO_SERVICO")
public class LancamentoFinanceiroProdutoServicoDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LancamentoFinanceiroProdutoServicoPKDomain lancamentoFinanceiroProdutoServicoPKDomain = new LancamentoFinanceiroProdutoServicoPKDomain();

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    public LancamentoFinanceiroProdutoServicoDomain() { }

}
