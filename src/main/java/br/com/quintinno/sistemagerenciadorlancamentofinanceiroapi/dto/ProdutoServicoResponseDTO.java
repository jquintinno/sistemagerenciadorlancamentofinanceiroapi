package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;

public class ProdutoServicoResponseDTO {

    private Long codigo;

    private String nome;

    private String descricao;

    private static final ModelMapperConfiguration modelMapperConfiguration = new ModelMapperConfiguration();

    public ProdutoServicoResponseDTO() { }

    public static ProdutoServicoResponseDTO convert(ProdutoServicoDomain produtoServicoDomain) {
        return modelMapperConfiguration.modelMapper().map(produtoServicoDomain, ProdutoServicoResponseDTO.class);
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
