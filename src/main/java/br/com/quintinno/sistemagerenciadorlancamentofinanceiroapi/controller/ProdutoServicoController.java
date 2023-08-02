package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.controller;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto-servico")
@CrossOrigin("*")
public class ProdutoServicoController {

    @Autowired
    private ProdutoServicoService produtoServicoService;

    @PostMapping
    public ProdutoServicoResponseDTO createOne(@RequestBody ProdutoServicoRequestDTO produtoServicoRequestDTO) {
        return this.produtoServicoService.createOne(produtoServicoRequestDTO);
    }

}
