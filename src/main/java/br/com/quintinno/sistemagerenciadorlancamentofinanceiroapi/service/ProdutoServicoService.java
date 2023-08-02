package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.ProdutoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServicoService {

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    public ProdutoServicoResponseDTO createOne(ProdutoServicoRequestDTO produtoServicoRequestDTO) {
        return ProdutoServicoResponseDTO.convert(this.produtoServicoRepository.save(ProdutoServicoDomain.convert(produtoServicoRequestDTO)));
    }

    public List<ProdutoServicoResponseDTO> searchAll() {
        return this.produtoServicoRepository.findAll().stream().map(ProdutoServicoResponseDTO::convert).collect(Collectors.toList());
    }

}
