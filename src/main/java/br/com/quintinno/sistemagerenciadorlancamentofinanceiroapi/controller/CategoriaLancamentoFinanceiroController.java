package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.controller;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.CategoriaLancamentoFinanceiroDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.CategoriaLancamentoFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria-lancamento-financeiro")
@CrossOrigin("*")
public class CategoriaLancamentoFinanceiroController {

    @Autowired
    private CategoriaLancamentoFinanceiroService categoriaLancamentoFinanceiroService;

    @GetMapping
    public List<CategoriaLancamentoFinanceiroDomain> searchAll() {
        return this.categoriaLancamentoFinanceiroService.searchAll();
    }

}
