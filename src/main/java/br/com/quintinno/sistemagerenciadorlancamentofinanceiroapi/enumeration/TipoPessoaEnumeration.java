package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoPessoaResponseDTO;

public enum TipoPessoaEnumeration {
    PESSOA_FISICA(1, "Pessoa Física", "PF"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica", "PJ");

    private Integer codigo;

    private String descricao;

    private String sigla;

    TipoPessoaEnumeration(Integer codigo, String descricao, String sigla) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public static TipoPessoaEnumeration converter(TipoPessoaResponseDTO tipoPessoaResponseDTO) {
        if (tipoPessoaResponseDTO.getCodigo() == 1) {
            return TipoPessoaEnumeration.PESSOA_FISICA;
        }
        return TipoPessoaEnumeration.PESSOA_JURIDICA;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
