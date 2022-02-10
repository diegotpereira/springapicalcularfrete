package br.com.spring.springapicalcularfrete.model;

public class DadosCep {
	
	private String uf;
	private String ddd;

	public DadosCep() {}

	public DadosCep(String uf, String ddd) {
		this.uf = uf;
		this.ddd = ddd;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}	
}
