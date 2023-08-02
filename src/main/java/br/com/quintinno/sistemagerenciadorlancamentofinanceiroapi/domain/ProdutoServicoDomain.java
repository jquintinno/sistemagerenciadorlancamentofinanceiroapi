package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoRequestDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO_SERVICO")
public class ProdutoServicoDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static ModelMapperConfiguration modelMapperConfiguration;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    public ProdutoServicoDomain() {
        this.modelMapperConfiguration = new ModelMapperConfiguration();
    }

    public ProdutoServicoDomain(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public static ProdutoServicoDomain convert(ProdutoServicoRequestDTO produtoServicoRequestDTO) {
        return modelMapperConfiguration.modelMapper().map(produtoServicoRequestDTO, ProdutoServicoDomain.class);
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
