package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoPessoaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoPessoaEnumeration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaImplementacaoRepository;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaImplementacaoRepository pessoaImplementacaoRepository;

    private final ModelMapperConfiguration modelMapperConfiguration;

    public PessoaService() {
        modelMapperConfiguration = new ModelMapperConfiguration();
    }

    public PessoaResponseDTO createOne(PessoaRequestDTO pessoaRequestDTO) {
        PessoaDomain pessoaDomain = this.convertPessoaDomain(pessoaRequestDTO);
            pessoaDomain = this.pessoaRepository.save(pessoaDomain);
        return this.convertPessoaResponseDTO(pessoaDomain);
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

    public List<PessoaResponseDTO> searchOne(String nomePessoa) {
        List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
        List<PessoaDomain> pessoaDomainList = this.pessoaImplementacaoRepository.recuperarPessoaNome(nomePessoa);
        if (pessoaDomainList.isEmpty()) {
            return pessoaResponseDTOList;
        }
        pessoaDomainList.forEach( pessoaDomain -> {
            PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
                pessoaResponseDTO.setCodigo(pessoaDomain.getCodigo());
                pessoaResponseDTO.setNome(pessoaDomain.getNome());
                this.searchTipoPessoaAll().forEach( tipoPessoaResponseDTO -> {
                    if (tipoPessoaResponseDTO.getCodigo() == pessoaDomain.getTipoPessoaEnumeration().getCodigo()) {
                        pessoaResponseDTO.setTipoPessoaResponseDTO(tipoPessoaResponseDTO);
                    }
                });
            pessoaResponseDTOList.add(pessoaResponseDTO);
        });
        return pessoaResponseDTOList;
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

    private PessoaDomain convertPessoaDomain(PessoaRequestDTO pessoaRequestDTO) {
        PessoaDomain pessoaDomain = modelMapperConfiguration.modelMapper().map(pessoaRequestDTO, PessoaDomain.class);
            pessoaDomain.setTipoPessoaEnumeration(TipoPessoaEnumeration.converter(pessoaRequestDTO.getTipoPessoaResponseDTO()));
        return pessoaDomain;
    }

    private PessoaResponseDTO convertPessoaResponseDTO(PessoaDomain pessoaDomain) {
        PessoaResponseDTO pessoaResponseDTO = this.modelMapperConfiguration.modelMapper().map(pessoaDomain, PessoaResponseDTO.class);
            pessoaResponseDTO.setTipoPessoaResponseDTO(TipoPessoaResponseDTO.converterEnumerationToDTO(pessoaDomain.getTipoPessoaEnumeration().getCodigo()));
        return pessoaResponseDTO;
    }

}
