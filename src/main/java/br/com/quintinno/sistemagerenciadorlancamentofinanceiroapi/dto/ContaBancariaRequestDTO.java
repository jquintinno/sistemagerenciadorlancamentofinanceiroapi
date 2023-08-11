package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaBancariaRequestDTO {

    private PessoaDomain pessoaContaBancaria;

    private PessoaDomain pessoaTitular;

    private String tipoContaBancaria;

    private String numero;

    private String numero_agencia;

    private LocalDate dataAbertura;

    private LocalDate dataEncerramento;

    private BigDecimal saldoInicial;

    private String corContaBancaria;

    private boolean bolContaBancariaPrincipal;

    public ContaBancariaRequestDTO() { }

    public ContaBancariaRequestDTO(PessoaDomain pessoaContaBancaria, PessoaDomain pessoaTitular, String tipoContaBancaria, String numero,
                                   String numero_agencia, boolean bolContaBancariaPrincipal) {
        this.pessoaContaBancaria = pessoaContaBancaria;
        this.pessoaTitular = pessoaTitular;
        this.tipoContaBancaria = tipoContaBancaria;
        this.numero = numero;
        this.numero_agencia = numero_agencia;
        this.bolContaBancariaPrincipal = true;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero_agencia() {
        return numero_agencia;
    }

    public void setNumero_agencia(String numero_agencia) {
        this.numero_agencia = numero_agencia;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public String getCorContaBancaria() {
        return corContaBancaria;
    }

    public void setCorContaBancaria(String corContaBancaria) {
        this.corContaBancaria = corContaBancaria;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public boolean isBolContaBancariaPrincipal() {
        return bolContaBancariaPrincipal;
    }

    public void setBolContaBancariaPrincipal(boolean bolContaBancariaPrincipal) {
        this.bolContaBancariaPrincipal = bolContaBancariaPrincipal;
    }

}
