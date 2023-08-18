package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoServicoImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProdutoServicoDomain> searchOne(String nomeProdutoServico) {
        StringBuilder query = new StringBuilder("SELECT produtoServicoDomain ")
                .append("FROM ProdutoServicoDomain produtoServicoDomain ")
                .append("WHERE produtoServicoDomain.nome LIKE CONCAT('%', :nomeProdutoServicoParameter ,'%') ");
        TypedQuery<ProdutoServicoDomain> produtoServicoDomainTypedQuery = this.entityManager.createQuery(query.toString(), ProdutoServicoDomain.class);
            produtoServicoDomainTypedQuery.setParameter("nomeProdutoServicoParameter", nomeProdutoServico);
        return produtoServicoDomainTypedQuery.getResultList();
    }

}
