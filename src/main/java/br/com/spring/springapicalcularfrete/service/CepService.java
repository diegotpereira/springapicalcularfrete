package br.com.spring.springapicalcularfrete.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import br.com.spring.springapicalcularfrete.model.Cep;
import br.com.spring.springapicalcularfrete.model.DadosCep;
import br.com.spring.springapicalcularfrete.utils.Util;

@Service
public class CepService {
	
	String webService = "http://viacep.com.br/ws/";

	public DadosCep consultar(String cep) throws IOException, InterruptedException {
		int codigoSucesso = 200;
		DadosCep objCep = new DadosCep();
		String urlApi = webService + cep + "/json";
		URL url;
		url = new URL(urlApi);
		HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

		if (conexao.getResponseCode() != codigoSucesso) 
			throw new RuntimeException("Verifique se os dados estão corretos, error code: " + conexao.getResponseCode());


		BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
		String jsonEmString = Util.converteJsonEmString(resposta);

		Gson gson = new Gson();
		objCep = gson.fromJson(jsonEmString, DadosCep.class);

		return objCep;
		
	}

	public Cep calcularFrete(DadosCep cepOrigem, DadosCep cepDestino, double peso) {
		double desconto = 0;
		double vlFrete = 0;
		int diasPrevistos = 0;

		vlFrete = peso * 1;

		if(cepOrigem.getDdd().equals(cepDestino.getDdd())) {
			desconto = 0.5;
			vlFrete = vlFrete * desconto;
			diasPrevistos = 1;
		} else if(cepOrigem.getUf().equals(cepDestino.getUf())) {
			desconto = 0.75;
			vlFrete = vlFrete * desconto;
			diasPrevistos = 3;
		} else {
			diasPrevistos = 10;
		}

		Cep cepModelo = new Cep();
		cepModelo.setVlTotalFrete(vlFrete);
		Date dataEntrega = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dataEntrega);
		calendario.add(Calendar.DATE, diasPrevistos);
		dataEntrega = calendario.getTime();

		cepModelo.setDataPrevistaEntrega(dataEntrega);

		return cepModelo;
	}
}
