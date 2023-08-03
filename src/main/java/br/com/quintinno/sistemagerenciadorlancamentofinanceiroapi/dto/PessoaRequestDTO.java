package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PessoaRequestDTO {

    private Long codigo;

    @JsonAlias("tipoPessoa")
    private TipoPessoaResponseDTO tipoPessoaResponseDTO;

    private String nome;

    public PessoaRequestDTO() { }

    public PessoaRequestDTO(String nome) {
        this.nome = nome;
        this.tipoPessoaResponseDTO = TipoPessoaResponseDTO.converterEnumerationToDTO(1);
    }

    public PessoaRequestDTO(Long codigo, TipoPessoaResponseDTO tipoPessoaResponseDTO, String nome) {
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
