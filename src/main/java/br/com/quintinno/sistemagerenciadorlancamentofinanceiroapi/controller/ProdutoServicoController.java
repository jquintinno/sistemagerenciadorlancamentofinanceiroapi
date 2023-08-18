package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.controller;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ProdutoServicoResponseDTO> searchAll() {
        return this.produtoServicoService.searchAll();
    }

    @GetMapping("/filtro/{nomeProdutoServico}")
    public List<ProdutoServicoResponseDTO> searchOne(@PathVariable("nomeProdutoServico") String nomeProdutoServico) {
        return this.produtoServicoService.searchOne(nomeProdutoServico);
    }

}
