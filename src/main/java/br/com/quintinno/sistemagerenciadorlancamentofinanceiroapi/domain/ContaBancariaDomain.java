package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_CONTA_BANCARIA")
public class ContaBancariaDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_CONTA_BANCARIA", nullable = false)
    private PessoaDomain pessoaContaBancaria;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_TITULAR", nullable = false)
    private PessoaDomain pessoaTitular;

    @Column(name = "TIPO_CONTA_BANCARIA", nullable = false)
    private String tipoContaBancaria;

    @Column(name = "NUMERO_CONTA_BANCARIA", unique = true, length = 10, nullable = false)
    private String numeroContaBancaria;

    @Column(name = "NUMERO_AGENCIA_CONTA_BANCARIA", unique = true, length = 10, nullable = false)
    private String numeroAgenciaContaBancaria;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ABERTURA")
    private LocalDate dataAbertura;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ENCERRAMENTO")
    private LocalDate dataEncerramento;

    @Column(name = "SALDO_INICIAL")
    private BigDecimal saldoInicial;

    @Column(name = "BOL_CONTA_BANCARIA_PRINCIPAL", nullable = false)
    private boolean bolContaBancariaPrincipal;

    public ContaBancariaDomain() {
        this.bolContaBancariaPrincipal = true;
    }

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
