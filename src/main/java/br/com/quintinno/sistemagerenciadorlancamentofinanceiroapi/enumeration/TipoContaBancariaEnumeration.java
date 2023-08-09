package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoPessoaResponseDTO;

public enum TipoContaBancariaEnumeration {

    CONTA_ESPECIAL(1, "Conta Especial", "CONESP"),
    CONTA_SALARIO(2, "Conta Salário", "CONSAL"),
    CONTA_CORRENTE(3, "Conta Corrente", "CONCOR"),
    CONTA_POUPANCA(4, "Conta Poupança", "CONPOU"),
    CONTA_INVESTIMENTO(5, "Conta Investimento", "CONINV");

    private Integer codigo;

    private String descricao;

    private String sigla;

    TipoContaBancariaEnumeration(Integer codigo, String descricao, String sigla) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public static TipoContaBancariaEnumeration converter(TipoContaBancariaEnumeration tipoContaBancariaEnumeration) {
        switch (tipoContaBancariaEnumeration.getCodigo()) {
            case 1:
                return TipoContaBancariaEnumeration.CONTA_ESPECIAL;
            case 2:
                return TipoContaBancariaEnumeration.CONTA_SALARIO;
            case 3:
                return TipoContaBancariaEnumeration.CONTA_CORRENTE;
            case 4:
                return TipoContaBancariaEnumeration.CONTA_POUPANCA;
            default:
                return TipoContaBancariaEnumeration.CONTA_INVESTIMENTO;
        }
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
