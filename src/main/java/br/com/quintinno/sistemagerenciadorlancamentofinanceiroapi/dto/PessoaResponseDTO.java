package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaResponseDTO {

    private Long codigo;

    @JsonProperty("tipoPessoa")
    private String tipoPessoa;

    private String nome;

    public PessoaResponseDTO() { }

    public PessoaResponseDTO(Long codigo, String tipoPessoa, String nome) {
        this.codigo = codigo;
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
