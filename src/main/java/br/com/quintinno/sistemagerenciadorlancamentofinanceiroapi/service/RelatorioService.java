package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.repository.PessoaRepository;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;

@Service
public class RelatorioService implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private static final String SEPARADOR = File.separator;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public byte[] gerarRelatorio(HttpServletResponse response) throws JRException, IOException {
        java.util.List<PessoaDomain> address = pessoaRepository.findAll();
        File file = ResourceUtils.getFile(this.configurarCaminhoRelatorio("relatorio_pessoas_sistema.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRSaver.saveObject(jasperReport, this.configurarCaminhoRelatorio("relatorio_pessoas_sistema.jasper"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(address);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
	
	private String configurarCaminhoRelatorio(String nomeArquivo) {
		return new StringBuilder()
				.append("src")
				.append(SEPARADOR)
				.append("main")
				.append(SEPARADOR)
				.append("resources")
				.append(SEPARADOR)
				.append("relatorio")
				.append(SEPARADOR)
				.append(nomeArquivo)
				.toString();
	}

}
