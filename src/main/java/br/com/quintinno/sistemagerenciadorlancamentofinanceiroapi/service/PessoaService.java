package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoPessoaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoPessoaEnumeration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDomain create(PessoaDomain pessoaDomain) {
        return this.pessoaRepository.save(pessoaDomain);
    }

    public List<PessoaDomain> searchAll() {
        return this.pessoaRepository.findAll();
    }

    public PessoaDomain searchOne(Long codigoPessoa) {
        return this.pessoaRepository.findById(codigoPessoa).orElseThrow();
    }

    public List<TipoPessoaResponseDTO> searchTipoPessoaAll() {
        List<TipoPessoaResponseDTO> tipoPessoaResponseDTOList = new ArrayList<>();
        for (TipoPessoaEnumeration tipoPessoaEnumeration : TipoPessoaEnumeration.values()) {
            TipoPessoaResponseDTO tipoPessoaResponseDTO = new TipoPessoaResponseDTO();
                tipoPessoaResponseDTO.setCodigo(tipoPessoaEnumeration.getCodigo());
                tipoPessoaResponseDTO.setDescricao(tipoPessoaEnumeration.getDescricao());
                tipoPessoaResponseDTO.setSigla(tipoPessoaEnumeration.getSigla());
                tipoPessoaResponseDTOList.add(tipoPessoaResponseDTO);
        }
        return tipoPessoaResponseDTOList;
    }

}
