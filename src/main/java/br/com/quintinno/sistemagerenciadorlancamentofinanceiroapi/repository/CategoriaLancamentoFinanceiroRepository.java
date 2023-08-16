package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.CategoriaLancamentoFinanceiroDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaLancamentoFinanceiroRepository extends JpaRepository<CategoriaLancamentoFinanceiroDomain, Long> { }
