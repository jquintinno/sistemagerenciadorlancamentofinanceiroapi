package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.configuration.ModelMapperConfiguration;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.ProdutoServicoDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.dto.ProdutoServicoResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	private static final ModelMapperConfiguration modelMapperConfiguration = new ModelMapperConfiguration();

	@Test
	void converterProdutoServicoDomainParaProdutoServicoResponseDTO() {
		ProdutoServicoDomain produtoServicoDomain = new ProdutoServicoDomain("Teste 001", "");
		ProdutoServicoResponseDTO produtoServicoResponseDTO = ProdutoServicoResponseDTO.convert(produtoServicoDomain);
		Assertions.assertEquals(produtoServicoDomain.getNome(), produtoServicoResponseDTO.getNome());

	}

}
