package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoPessoaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaDomain create(@RequestBody PessoaDomain pessoaDomain) {
        return this.pessoaService.create(pessoaDomain);
    }

    @GetMapping
    public List<PessoaDomain> searchAll() {
        return this.pessoaService.searchAll();
    }

    @GetMapping("/{codigoPessoa}")
    public PessoaDomain searchOne(@PathVariable("codigoPessoa") Long codigoPessoa) {
        return this.pessoaService.searchOne(codigoPessoa);
    }

    @GetMapping("/tipo-pessoa")
    public List<TipoPessoaResponseDTO> searchTipoPessoaAll() {
        return this.pessoaService.searchTipoPessoaAll();
    }

}
