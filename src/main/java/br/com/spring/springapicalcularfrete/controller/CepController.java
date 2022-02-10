package br.com.spring.springapicalcularfrete.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.springapicalcularfrete.model.Cep;
import br.com.spring.springapicalcularfrete.model.DadosCep;
import br.com.spring.springapicalcularfrete.repository.CepRepositorio;
import br.com.spring.springapicalcularfrete.service.CepService;

@RestController
@RequestMapping("/cep")
@CrossOrigin("*")
public class CepController {

	@Autowired
	private CepRepositorio repositorio;

	@Autowired
	private CepService service;

	@PostMapping("/calcularFrete")
	public ResponseEntity<Cep> consultar(@RequestBody @Valid Cep cep) throws InterruptedException {
		
		Cep cepResultado = null;

		try{
			DadosCep cepOrigem = service.consultar(cep.getCepOrigem());
			DadosCep cepDestino = service.consultar(cep.getCepDestino());
			cepResultado = service.calcularFrete(cepOrigem, cepDestino, cep.getPeso());
			cepResultado.setCepOrigem(cep.getCepOrigem());
			cepResultado.setCepDestino(cep.getCepDestino());
			cepResultado.setNomeDestinatario(cep.getNomeDestinatario());
			cepResultado.setPeso(cep.getPeso());
			cep.setDataPrevistaEntrega(cepResultado.getDataPrevistaEntrega());
			cep.setVlTotalFrete(cepResultado.getVlTotalFrete());

			repositorio.save(cep);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(cepResultado);
	}
	
}
