package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
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

    @Column(name = "TIPO_CONTA_BANCARIA", unique = true, nullable = false)
    private String tipoContaBancaria;

    @Column(name = "NUMERO", unique = true, length = 5, nullable = false)
    private String numero;

    @Column(name = "NUMERO_AGENCIA", unique = true, length = 7, nullable = false)
    private String numero_agencia;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ABERTURA")
    private LocalDate dataAbertura;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ENCERRAMENTO")
    private LocalDate dataEncerramento;

    @Column(name = "E_CONTA_BANCARIA_PRINCIPAL", nullable = false)
    private boolean eContaBancariaPrincipal;

    public ContaBancariaDomain() { }

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

    public boolean iseContaBancariaPrincipal() {
        return eContaBancariaPrincipal;
    }

    public void seteContaBancariaPrincipal(boolean eContaBancariaPrincipal) {
        this.eContaBancariaPrincipal = eContaBancariaPrincipal;
    }

}
