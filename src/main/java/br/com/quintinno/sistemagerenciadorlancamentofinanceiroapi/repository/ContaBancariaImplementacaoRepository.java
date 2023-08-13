package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ContaBancariaDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContaBancariaImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Boolean bolVerificarTitularContaBancariaPrincipal(Long codigoPessoaTitular) {
        StringBuilder query = new StringBuilder("SELECT COUNT(*) > 1 ")
                .append("FROM ContaBancariaDomain contaBancariaDomain_ ")
                .append("JOIN PessoaDomain pessoaTitular_ ON pessoaTitular_.codigo = contaBancariaDomain_.pessoaTitular.codigo ")
                .append("WHERE pessoaTitular_.codigo = :codigoParameter ");
        TypedQuery<Boolean> typedQueryBoolean = this.entityManager.createQuery(query.toString(), Boolean.class);
        typedQueryBoolean.setParameter("codigoParameter", codigoPessoaTitular);
        return typedQueryBoolean.getSingleResult();
    }

    public List<ContaBancariaDomain> recuperarContaBancariaPessoaTitular(Long codigoContaBancaria, Long codigoPessoaTitular) {
        StringBuilder query = new StringBuilder("SELECT contaBancariaDomain_ ")
                .append("FROM ContaBancariaDomain contaBancariaDomain_ ")
                .append("JOIN PessoaDomain pessoaTitular_ ON pessoaTitular_.codigo = contaBancariaDomain_.pessoaTitular.codigo ")
                .append("WHERE pessoaTitular_.codigo = :codigoPessoaTitularParameter ")
                .append("AND contaBancariaDomain_.codigo < :codigoContaBancariaParameter ");
        TypedQuery<ContaBancariaDomain> typedQueryBoolean = this.entityManager.createQuery(query.toString(), ContaBancariaDomain.class);
            typedQueryBoolean.setParameter("codigoPessoaTitularParameter", codigoPessoaTitular);
            typedQueryBoolean.setParameter("codigoContaBancariaParameter", codigoContaBancaria);
        return typedQueryBoolean.getResultList();
    }

    @Transactional
    public void alterarContaBancariaPrincipal(Long codigoContaBancaria) {
        StringBuilder sql = new StringBuilder("UPDATE ContaBancariaDomain contaBancariaDomain ")
                .append("SET contaBancariaDomain.bolContaBancariaPrincipal = FALSE ")
                .append("WHERE contaBancariaDomain.codigo = :codigoContaBancariaParameter ");
        Query query = this.entityManager.createQuery(sql.toString());
            query.setParameter("codigoContaBancariaParameter", codigoContaBancaria);
            query.executeUpdate();
    }

}
