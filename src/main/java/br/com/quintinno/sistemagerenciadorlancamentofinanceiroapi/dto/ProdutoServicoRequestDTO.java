package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;

import java.math.BigDecimal;

public class ProdutoServicoRequestDTO {

    private ProdutoServicoDomain produtoServicoDomain;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    public ProdutoServicoRequestDTO() { }

    public ProdutoServicoRequestDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public ProdutoServicoDomain getProdutoServicoDomain() {
        return produtoServicoDomain;
    }

    public void setProdutoServicoDomain(ProdutoServicoDomain produtoServicoDomain) {
        this.produtoServicoDomain = produtoServicoDomain;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
