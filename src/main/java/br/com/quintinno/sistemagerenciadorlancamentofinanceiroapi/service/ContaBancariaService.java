package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ContaBancariaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ContaBancariaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ContaBancariaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoContaBancariaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoContaBancariaEnumeration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoPessoaEnumeration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    private final ModelMapperConfiguration modelMapperConfiguration;

    public ContaBancariaService() {
        modelMapperConfiguration = new ModelMapperConfiguration();
    }

    public ContaBancariaResponseDTO createOne(ContaBancariaRequestDTO contaBancariaRequestDTO) {
        ContaBancariaDomain contaBancariaDomain = modelMapperConfiguration.modelMapper().map(contaBancariaRequestDTO, ContaBancariaDomain.class);
        contaBancariaDomain = this.contaBancariaRepository.save(contaBancariaDomain);
        return modelMapperConfiguration.modelMapper().map(contaBancariaDomain, ContaBancariaResponseDTO.class);
    }

    public List<ContaBancariaResponseDTO> searchAll() {
        List<ContaBancariaResponseDTO> contaBancariaResponseDTOList = new ArrayList<>();
        List<ContaBancariaDomain> contaBancariaDomainList = this.contaBancariaRepository.findAll();
        contaBancariaDomainList.forEach( contaBancariaDomainResponse -> {
            ContaBancariaResponseDTO contaBancariaResponseDTO = modelMapperConfiguration.modelMapper().map(contaBancariaDomainResponse, ContaBancariaResponseDTO.class);
            contaBancariaResponseDTOList.add(contaBancariaResponseDTO);
        });
        return contaBancariaResponseDTOList;
    }

    public List<TipoContaBancariaResponseDTO> searchTipoContaBancaria() {
        List<TipoContaBancariaResponseDTO> tipoContaBancariaResponseDTOList = new ArrayList<>();
        for (TipoContaBancariaEnumeration tipoContaBancariaEnumeration : TipoContaBancariaEnumeration.values()) {
            TipoContaBancariaResponseDTO tipoContaBancariaResponseDTO = modelMapperConfiguration
                    .modelMapper().map(tipoContaBancariaEnumeration, TipoContaBancariaResponseDTO.class);
                tipoContaBancariaResponseDTOList.add(tipoContaBancariaResponseDTO);
        }
        return tipoContaBancariaResponseDTOList;
    }

}
