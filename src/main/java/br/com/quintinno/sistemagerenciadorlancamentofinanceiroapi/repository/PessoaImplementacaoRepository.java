package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PessoaDomain> recuperarPessoaNome(String nome) {
        StringBuilder query = new StringBuilder("SELECT pessoaDomain_ ")
                .append("FROM PessoaDomain pessoaDomain_ ")
                .append("WHERE pessoaDomain_.nome LIKE CONCAT('%', :nomeParameter ,'%') ");
        TypedQuery<PessoaDomain> pessoaDomainTypedQuery = this.entityManager.createQuery(query.toString(), PessoaDomain.class);
            pessoaDomainTypedQuery.setParameter("nomeParameter", nome);
        return pessoaDomainTypedQuery.getResultList();
    }

}
