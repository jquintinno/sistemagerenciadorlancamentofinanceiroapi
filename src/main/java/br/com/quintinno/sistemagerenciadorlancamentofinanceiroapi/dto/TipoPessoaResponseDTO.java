package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

public class TipoPessoaResponseDTO {

    private Integer codigo;

    private String descricao;

    private String sigla;

    public TipoPessoaResponseDTO() { }

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
