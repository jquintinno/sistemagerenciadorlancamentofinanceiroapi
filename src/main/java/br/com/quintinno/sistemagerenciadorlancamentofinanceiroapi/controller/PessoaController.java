package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.controller;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoPessoaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.PessoaService;
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
    public PessoaResponseDTO create(@RequestBody PessoaRequestDTO pessoaRequestDTO) {
        return this.pessoaService.create(pessoaRequestDTO);
    }

    @GetMapping
    public List<PessoaResponseDTO> searchAll() {
        return this.pessoaService.searchAll();
    }

    @GetMapping("/{codigoPessoa}")
    public PessoaResponseDTO searchOne(@PathVariable("codigoPessoa") Long codigoPessoa) {
        return this.pessoaService.searchOne(codigoPessoa);
    }

    @GetMapping("/tipo-pessoa")
    public List<TipoPessoaResponseDTO> searchTipoPessoaAll() {
        return this.pessoaService.searchTipoPessoaAll();
    }

    @PutMapping
    public PessoaResponseDTO searchOne(@RequestBody PessoaRequestDTO pessoaRequestDTO) {
        return this.pessoaService.updateOne(pessoaRequestDTO);
    }

}
