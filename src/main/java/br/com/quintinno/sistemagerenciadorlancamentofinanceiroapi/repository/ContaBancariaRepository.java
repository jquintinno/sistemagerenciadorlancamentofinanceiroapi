package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ContaBancariaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaDomain, Long> { }
