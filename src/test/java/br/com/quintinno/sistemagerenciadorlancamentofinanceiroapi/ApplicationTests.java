package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.PessoaRequestDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoResponseDTO;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.PessoaService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class ApplicationTests {

	private static final ModelMapperConfiguration modelMapperConfiguration = new ModelMapperConfiguration();

	private static final String ARQUIVO_PESSOAS = "pessoas.json";

	private static final String ARQUIVO_BANCOS = "bancos.json";

	@Autowired
	private PessoaService pessoaService;

	@Test
	void converterProdutoServicoDomainParaProdutoServicoResponseDTO() {
		ProdutoServicoDomain produtoServicoDomain = new ProdutoServicoDomain("Teste 001", "");
		ProdutoServicoResponseDTO produtoServicoResponseDTO = ProdutoServicoResponseDTO.convert(produtoServicoDomain);
		Assertions.assertEquals(produtoServicoDomain.getNome(), produtoServicoResponseDTO.getNome());
	}

	@Test
	public void deveLerArquivoJSONPessoasGravarDadosBanco() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(ARQUIVO_PESSOAS);
		JsonNode jsonNodeRoot = objectMapper.readTree(file.getAbsoluteFile());
		for (JsonNode jsonNode : jsonNodeRoot) {
			PessoaRequestDTO pessoaRequestDTOFilho = new PessoaRequestDTO(jsonNode.get("nome").asText(), 1);
			PessoaRequestDTO pessoaRequestDTOMae = new PessoaRequestDTO(jsonNode.get("mae").asText(), 1);
			PessoaRequestDTO pessoaRequestDTOPai = new PessoaRequestDTO(jsonNode.get("pai").asText(), 1);
				this.pessoaService.createOne(pessoaRequestDTOFilho);
				this.pessoaService.createOne(pessoaRequestDTOMae);
				this.pessoaService.createOne(pessoaRequestDTOPai);
		}
		Assertions.assertEquals(jsonNodeRoot != null, true);
	}

	@Test
	public void deveLerArquivoJSONBancosGravarDadosBanco() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(ARQUIVO_BANCOS);
		JsonNode jsonNodeRoot = objectMapper.readTree(file.getAbsoluteFile());
		for (JsonNode jsonNode : jsonNodeRoot) {
			PessoaRequestDTO pessoaRequestDTO = new PessoaRequestDTO(jsonNode.get("LongName").asText(), 2);
			this.pessoaService.createOne(pessoaRequestDTO);
		}
		Assertions.assertEquals(jsonNodeRoot != null, true);
	}

}
