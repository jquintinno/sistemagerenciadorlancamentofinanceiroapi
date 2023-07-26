package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.enumeration.TipoPessoaEnumeration;

import java.util.ArrayList;
import java.util.List;

public class TipoPessoaResponseDTO {

    private Integer codigo;

    private String descricao;

    private String sigla;

    public TipoPessoaResponseDTO() { }

    public static TipoPessoaResponseDTO converterEnumerationToDTO(Integer codigoTipoPessoa) {
        TipoPessoaResponseDTO tipoPessoaResponseDTO = new TipoPessoaResponseDTO();
        for (TipoPessoaResponseDTO item : searchTipoDTOPessoaAll()) {
            if (codigoTipoPessoa == item.getCodigo()) {
                tipoPessoaResponseDTO.setCodigo(item.getCodigo());
                tipoPessoaResponseDTO.setDescricao(item.getDescricao());
                tipoPessoaResponseDTO.setSigla(item.getSigla());
            }
        }
        return tipoPessoaResponseDTO;
    }

    private static List<TipoPessoaResponseDTO> searchTipoDTOPessoaAll() {
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
