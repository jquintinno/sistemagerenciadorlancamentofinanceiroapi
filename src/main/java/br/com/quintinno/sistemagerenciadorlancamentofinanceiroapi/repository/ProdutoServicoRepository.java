package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServicoDomain, Long> { }
