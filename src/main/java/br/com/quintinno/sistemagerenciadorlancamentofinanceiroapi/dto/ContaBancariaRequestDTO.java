package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import java.math.BigDecimal;

public class ContaBancariaRequestDTO {

    private Long codigoPessoaContrada;

    private Long codigoCategoriaContaBancaria;

    private String numeroContaBancaria;

    private String numeroAgenciaContaBancaria;

    private BigDecimal saldoInicial;

    private String corContaBancaria;

    public ContaBancariaRequestDTO() { }

    public Long getCodigoPessoaContrada() {
        return codigoPessoaContrada;
    }

    public void setCodigoPessoaContrada(Long codigoPessoaContrada) {
        this.codigoPessoaContrada = codigoPessoaContrada;
    }

    public Long getCodigoCategoriaContaBancaria() {
        return codigoCategoriaContaBancaria;
    }

    public void setCodigoCategoriaContaBancaria(Long codigoCategoriaContaBancaria) {
        this.codigoCategoriaContaBancaria = codigoCategoriaContaBancaria;
    }

    public String getNumeroContaBancaria() {
        return numeroContaBancaria;
    }

    public void setNumeroContaBancaria(String numeroContaBancaria) {
        this.numeroContaBancaria = numeroContaBancaria;
    }

    public String getNumeroAgenciaContaBancaria() {
        return numeroAgenciaContaBancaria;
    }

    public void setNumeroAgenciaContaBancaria(String numeroAgenciaContaBancaria) {
        this.numeroAgenciaContaBancaria = numeroAgenciaContaBancaria;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getCorContaBancaria() {
        return corContaBancaria;
    }

    public void setCorContaBancaria(String corContaBancaria) {
        this.corContaBancaria = corContaBancaria;
    }

}
