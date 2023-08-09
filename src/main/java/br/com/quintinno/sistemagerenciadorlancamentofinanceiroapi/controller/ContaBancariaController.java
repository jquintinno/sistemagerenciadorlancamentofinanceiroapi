package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.controller;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ContaBancariaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ContaBancariaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoContaBancariaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta-bancaria")
@CrossOrigin("*")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping
    public ContaBancariaResponseDTO createOne(@RequestBody ContaBancariaRequestDTO contaBancariaRequestDTO) {
        return this.contaBancariaService.createOne(contaBancariaRequestDTO);
    }

    @GetMapping
    public List<ContaBancariaResponseDTO> searchAll() {
        return this.contaBancariaService.searchAll();
    }

    @GetMapping("/tipo")
    public List<TipoContaBancariaResponseDTO> searchTipoContaBancaria() {
        return this.contaBancariaService.searchTipoContaBancaria();
    }

}
