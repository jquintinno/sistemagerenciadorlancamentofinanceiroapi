package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;

import java.math.BigDecimal;

public class ContaBancariaResponseDTO {

    private Long codigo;

    private PessoaDomain pessoaContaBancaria;

    private PessoaDomain pessoaTitular;

    private String tipoContaBancaria;

    private String numeroContaBancaria;

    private String numeroAgenciaContaBancaria;

    private BigDecimal saldoInicial;

    private String corContaBancaria;

    private boolean bolContaBancariaPrincipal;

    public ContaBancariaResponseDTO() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public PessoaDomain getPessoaContaBancaria() {
        return pessoaContaBancaria;
    }

    public void setPessoaContaBancaria(PessoaDomain pessoaContaBancaria) {
        this.pessoaContaBancaria = pessoaContaBancaria;
    }

    public PessoaDomain getPessoaTitular() {
        return pessoaTitular;
    }

    public void setPessoaTitular(PessoaDomain pessoaTitular) {
        this.pessoaTitular = pessoaTitular;
    }

    public String getTipoContaBancaria() {
        return tipoContaBancaria;
    }

    public void setTipoContaBancaria(String tipoContaBancaria) {
        this.tipoContaBancaria = tipoContaBancaria;
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

    public boolean isBolContaBancariaPrincipal() {
        return bolContaBancariaPrincipal;
    }

    public void setBolContaBancariaPrincipal(boolean bolContaBancariaPrincipal) {
        this.bolContaBancariaPrincipal = bolContaBancariaPrincipal;
    }

}
