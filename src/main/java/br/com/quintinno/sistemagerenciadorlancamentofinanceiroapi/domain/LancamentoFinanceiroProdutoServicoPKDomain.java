package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LancamentoFinanceiroProdutoServicoPKDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "ID_LANCAMENTO_FINANCEIRO")
    private LancamentoFinanceiroDomain lancamentoFinanceiroDomain;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO_SERVICO")
    private ProdutoServicoDomain produtoServicoDomain;

    public LancamentoFinanceiroProdutoServicoPKDomain() { }

    public LancamentoFinanceiroDomain getLancamentoFinanceiroDomain() {
        return lancamentoFinanceiroDomain;
    }

    public void setLancamentoFinanceiroDomain(LancamentoFinanceiroDomain lancamentoFinanceiroDomain) {
        this.lancamentoFinanceiroDomain = lancamentoFinanceiroDomain;
    }

    public ProdutoServicoDomain getProdutoServicoDomain() {
        return produtoServicoDomain;
    }

    public void setProdutoServicoDomain(ProdutoServicoDomain produtoServicoDomain) {
        this.produtoServicoDomain = produtoServicoDomain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LancamentoFinanceiroProdutoServicoPKDomain that = (LancamentoFinanceiroProdutoServicoPKDomain) o;
        return Objects.equals(lancamentoFinanceiroDomain, that.lancamentoFinanceiroDomain) && Objects.equals(produtoServicoDomain, that.produtoServicoDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lancamentoFinanceiroDomain, produtoServicoDomain);
    }

}
