package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
