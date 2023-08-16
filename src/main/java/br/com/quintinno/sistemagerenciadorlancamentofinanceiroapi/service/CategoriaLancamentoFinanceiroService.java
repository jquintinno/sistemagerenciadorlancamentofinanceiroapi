package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.CategoriaLancamentoFinanceiroDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.CategoriaLancamentoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaLancamentoFinanceiroService {

    @Autowired
    private CategoriaLancamentoFinanceiroRepository categoriaLancamentoFinanceiroRepository;

    public List<CategoriaLancamentoFinanceiroDomain> searchAll() {
        return this.categoriaLancamentoFinanceiroRepository.findAll();
    }

}
