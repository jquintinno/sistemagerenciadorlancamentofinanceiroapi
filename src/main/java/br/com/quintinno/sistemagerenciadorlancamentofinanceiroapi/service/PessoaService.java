package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaResponseDTO;
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

    public PessoaResponseDTO create(PessoaRequestDTO pessoaRequestDTO) {
        PessoaDomain pessoaDomain = new PessoaDomain();
            pessoaDomain.setNome(pessoaRequestDTO.getNome());
            pessoaDomain.setTipoPessoaEnumeration(TipoPessoaEnumeration.converter(pessoaRequestDTO.getTipoPessoaResponseDTO()));
            pessoaDomain = this.pessoaRepository.save(pessoaDomain);
        PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
            pessoaResponseDTO.setCodigo(pessoaDomain.getCodigo());
            pessoaResponseDTO.setNome(pessoaDomain.getNome());
            pessoaResponseDTO.setTipoPessoaResponseDTO(pessoaRequestDTO.getTipoPessoaResponseDTO());
        return pessoaResponseDTO;
    }

    public List<PessoaResponseDTO> searchAll() {
        List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
        this.pessoaRepository.findAll().forEach( pessoaDomain -> {
            pessoaResponseDTOList.add(new PessoaResponseDTO(pessoaDomain.getCodigo(),
                    TipoPessoaResponseDTO.converterEnumerationToDTO(pessoaDomain.getTipoPessoaEnumeration().getCodigo()),
                    pessoaDomain.getNome()));
        });
        return pessoaResponseDTOList;
    }

    public PessoaResponseDTO searchOne(Long codigoPessoa) {
        PessoaDomain pessoaDomain = this.pessoaRepository.findById(codigoPessoa).orElseThrow(() -> {
        throw new RuntimeException("Pessoa Não Encontrada!");
        });
        PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
            pessoaResponseDTO.setCodigo(pessoaDomain.getCodigo());
            pessoaResponseDTO.setNome(pessoaDomain.getNome());
            this.searchTipoPessoaAll().forEach( tipoPessoaResponseDTO -> {
                if (tipoPessoaResponseDTO.getCodigo() == pessoaDomain.getTipoPessoaEnumeration().getCodigo()) {
                    pessoaResponseDTO.setTipoPessoaResponseDTO(tipoPessoaResponseDTO);
                }
            });
        return pessoaResponseDTO;
    }

    public PessoaResponseDTO updateOne(PessoaRequestDTO pessoaRequestDTO) {
        PessoaDomain pessoaDomain = new PessoaDomain();
            pessoaDomain.setCodigo(pessoaRequestDTO.getCodigo());
            pessoaDomain.setTipoPessoaEnumeration(TipoPessoaEnumeration.converter(pessoaRequestDTO.getTipoPessoaResponseDTO()));
            pessoaDomain.setNome(pessoaRequestDTO.getNome());
            pessoaDomain = this.pessoaRepository.save(pessoaDomain);
        PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
            pessoaResponseDTO.setCodigo(pessoaDomain.getCodigo());
            pessoaResponseDTO.setTipoPessoaResponseDTO(pessoaRequestDTO.getTipoPessoaResponseDTO());
            pessoaDomain.setNome(pessoaDomain.getNome());
        return pessoaResponseDTO;
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
