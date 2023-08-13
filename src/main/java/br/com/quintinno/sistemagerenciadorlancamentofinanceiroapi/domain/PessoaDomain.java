package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoPessoaEnumeration;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @JsonAlias("tipoPessoa")
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PESSOA", nullable = false)
    private TipoPessoaEnumeration tipoPessoaEnumeration;

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome;

    public PessoaDomain() { }

    public PessoaDomain(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoaEnumeration getTipoPessoaEnumeration() {
        return tipoPessoaEnumeration;
    }

    public void setTipoPessoaEnumeration(TipoPessoaEnumeration tipoPessoaEnumeration) {
        this.tipoPessoaEnumeration = tipoPessoaEnumeration;
    }

}
