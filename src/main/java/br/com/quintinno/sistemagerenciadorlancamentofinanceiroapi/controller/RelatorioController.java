package br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.sistemagerenciadorlancamentofinanceiroapi.service.RelatorioService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/relatorio")
@CrossOrigin("*")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
	public ResponseEntity<byte[]> imprimirRelatorio(HttpServletResponse httpServletResponse) throws Exception {
    	httpServletResponse.setContentType("application/pdf");
         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
         String currentDateTime = dateFormatter.format(new Date());
         String headerKey = "Content-Disposition";
         String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
         httpServletResponse.setHeader(headerKey, headerValue);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(this.relatorioService.gerarRelatorio(httpServletResponse));
	}

}
