package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration;

public enum TipoPessoaEnumeration {
    PESSOA_FISICA(1, "Pessoa Física", "PF"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica", "PJ");

    TipoPessoaEnumeration(Integer codigo, String descricao, String sigla) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    private Integer codigo;

    private String descricao;

    private String sigla;

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
