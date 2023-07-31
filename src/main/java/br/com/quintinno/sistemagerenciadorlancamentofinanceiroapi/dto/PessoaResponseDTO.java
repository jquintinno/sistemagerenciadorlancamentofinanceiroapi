package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaResponseDTO {

    private Long codigo;

    @JsonProperty("tipoPessoa")
    private TipoPessoaResponseDTO tipoPessoaResponseDTO;

    private String nome;

    public PessoaResponseDTO() { }

    public PessoaResponseDTO(Long codigo, TipoPessoaResponseDTO tipoPessoaResponseDTO, String nome) {
        this.codigo = codigo;
        this.tipoPessoaResponseDTO = tipoPessoaResponseDTO;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoPessoaResponseDTO getTipoPessoaResponseDTO() {
        return tipoPessoaResponseDTO;
    }

    public void setTipoPessoaResponseDTO(TipoPessoaResponseDTO tipoPessoaResponseDTO) {
        this.tipoPessoaResponseDTO = tipoPessoaResponseDTO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
