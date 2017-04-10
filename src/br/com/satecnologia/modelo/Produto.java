package br.com.satecnologia.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto implements Serializable{
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="O Nome do produto não pode ser vazio")
	private String nome;
	private String descricao;
	private BigDecimal valorAtacado;
	private BigDecimal valorVarejo;
	private Integer qtdeMinAtacado;
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValorAtacado() {
		return valorAtacado;
	}
	public void setValorAtacado(BigDecimal valorAtacado) {
		this.valorAtacado = valorAtacado;
	}
	public BigDecimal getValorVarejo() {
		return valorVarejo;
	}
	public void setValorVarejo(BigDecimal valorVarejo) {
		this.valorVarejo = valorVarejo;
	}
	public Integer getQtdeMinAtacado() {
		return qtdeMinAtacado;
	}
	public void setQtdeMinAtacado(Integer qtdeMinAtacado) {
		this.qtdeMinAtacado = qtdeMinAtacado;
	}
	
	
	
	
}
