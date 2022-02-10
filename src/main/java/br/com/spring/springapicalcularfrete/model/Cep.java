package br.com.spring.springapicalcularfrete.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_cep")
public class Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Positive(message = "{peso.positive}")
	private double peso;

	@NotBlank(message = "{cepOrigem.not.blank}")
	private String cepOrigem;

	@NotBlank(message = "{cepDestino.not.blank}")
	private String cepDestino;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPrevistaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConsulta = new java.sql.Date(System.currentTimeMillis());

	private double vlTotalFrete;

	public Cep() {}

	public Cep(Long id,  double peso, String cepOrigem, String cepDestino, Date dataPrevistaEntrega,
			Date dataConsulta, double vlTotalFrete) {
		this.id = id;
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
		this.vlTotalFrete = vlTotalFrete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Date getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}
}
