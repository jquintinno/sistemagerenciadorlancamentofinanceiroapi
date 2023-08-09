package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

public class TipoContaBancariaResponseDTO {

    private Integer codigo;

    private String descricao;

    private String sigla;

    public TipoContaBancariaResponseDTO() { }

    public TipoContaBancariaResponseDTO(Integer codigo, String descricao, String sigla) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
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
