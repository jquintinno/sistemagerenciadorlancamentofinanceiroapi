package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_LANCAMENTO_FINANCEIRO")
public class LancamentoFinanceiroDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_LANCAMENTO_FINANCEIRO", nullable = false)
    private CategoriaLancamentoFinanceiroDomain categoriaLancamentoFinanceiroDomain;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_LANCAMENTO_FINANCEIRO", nullable = false)
    private PessoaDomain pessoaLancamentoFinanceiro;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_RESPONSAVEL")
    private PessoaDomain pessoaResponsavel;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO_FINANCEIRO", nullable = false)
    private LocalDate dataLancamentoFinanceiro;

    @Column(name = "VALOR_TOTAL_LANCAMENTO_FINANCEIRO", nullable = false)
    private BigDecimal valorTotalLancamentoFinanceiro;

    @Column(name = "DIA_VENCIMENTO_PARCELA")
    private Integer diaVencimentoParcela;

    @Column(name = "QUANTIDADE_PARCELA")
    private Integer quantidadeParcela;

    public LancamentoFinanceiroDomain() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public CategoriaLancamentoFinanceiroDomain getCategoriaLancamentoFinanceiroDomain() {
        return categoriaLancamentoFinanceiroDomain;
    }

    public void setCategoriaLancamentoFinanceiroDomain(CategoriaLancamentoFinanceiroDomain categoriaLancamentoFinanceiroDomain) {
        this.categoriaLancamentoFinanceiroDomain = categoriaLancamentoFinanceiroDomain;
    }

    public PessoaDomain getPessoaLancamentoFinanceiro() {
        return pessoaLancamentoFinanceiro;
    }

    public void setPessoaLancamentoFinanceiro(PessoaDomain pessoaLancamentoFinanceiro) {
        this.pessoaLancamentoFinanceiro = pessoaLancamentoFinanceiro;
    }

    public PessoaDomain getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(PessoaDomain pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public LocalDate getDataLancamentoFinanceiro() {
        return dataLancamentoFinanceiro;
    }

    public void setDataLancamentoFinanceiro(LocalDate dataLancamentoFinanceiro) {
        this.dataLancamentoFinanceiro = dataLancamentoFinanceiro;
    }

    public BigDecimal getValorTotalLancamentoFinanceiro() {
        return valorTotalLancamentoFinanceiro;
    }

    public void setValorTotalLancamentoFinanceiro(BigDecimal valorTotalLancamentoFinanceiro) {
        this.valorTotalLancamentoFinanceiro = valorTotalLancamentoFinanceiro;
    }

    public Integer getDiaVencimentoParcela() {
        return diaVencimentoParcela;
    }

    public void setDiaVencimentoParcela(Integer diaVencimentoParcela) {
        this.diaVencimentoParcela = diaVencimentoParcela;
    }

    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }

}
