package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ContaBancariaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ContaBancariaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ContaBancariaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.TipoContaBancariaResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoContaBancariaEnumeration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.ContaBancariaImplementacaoRepository;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.ContaBancariaRepository;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaImplementacaoRepository;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaBancariaImplementacaoRepository contaBancariaImplementacaoRepository;

    @Autowired
    private PessoaImplementacaoRepository pessoaImplementacaoRepository;

    private final ModelMapperConfiguration modelMapperConfiguration;

    public ContaBancariaService() {
        modelMapperConfiguration = new ModelMapperConfiguration();
    }

    public ContaBancariaResponseDTO createOne(ContaBancariaRequestDTO contaBancariaRequestDTO) {
        PessoaDomain pessoaContaBancaria = this.pessoaRepository.findById(contaBancariaRequestDTO.getCodigoPessoaContrada()).get();
        TipoContaBancariaEnumeration tipoContaBancariaEnumeration = TipoContaBancariaEnumeration.converter(contaBancariaRequestDTO.getCodigoCategoriaContaBancaria());
        ContaBancariaDomain contaBancariaDomain = new ContaBancariaDomain();
            contaBancariaDomain.setPessoaContaBancaria(pessoaContaBancaria);
            contaBancariaDomain.setPessoaTitular(this.recuperarUsuarioLogado());
            contaBancariaDomain.setTipoContaBancaria(tipoContaBancariaEnumeration.name());
            contaBancariaDomain.setNumeroContaBancaria(contaBancariaRequestDTO.getNumeroContaBancaria());
            contaBancariaDomain.setNumeroAgenciaContaBancaria(contaBancariaRequestDTO.getNumeroAgenciaContaBancaria());
            contaBancariaDomain.setSaldoInicial(contaBancariaRequestDTO.getSaldoInicial());
            contaBancariaDomain = this.contaBancariaRepository.save(contaBancariaDomain);
            this.verificarTitularContaBancariaPrincipal(contaBancariaDomain);
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

    private PessoaDomain recuperarUsuarioLogado() {
        return new PessoaDomain(358L);
    }

    private void verificarTitularContaBancariaPrincipal(ContaBancariaDomain contaBancariaDomain) {
        if (this.contaBancariaImplementacaoRepository.bolVerificarTitularContaBancariaPrincipal(contaBancariaDomain.getPessoaTitular().getCodigo())) {
            this.contaBancariaImplementacaoRepository.recuperarContaBancariaPessoaTitular(contaBancariaDomain.getCodigo(), contaBancariaDomain.getPessoaTitular().getCodigo()).forEach( result -> {
                this.contaBancariaImplementacaoRepository.alterarContaBancariaPrincipal(result.getCodigo());
            });
        }
    }

}
