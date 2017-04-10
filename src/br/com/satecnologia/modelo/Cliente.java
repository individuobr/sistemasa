package br.com.satecnologia.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos  
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "O Campo nome não pode ser vazio.")
	private String nome;
	private String endereco;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cliente", orphanRemoval=true)
	private List<Telefone> telefones = new ArrayList<Telefone>();	
		
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}		
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	//Métodos
	public void gravaTelefone(Telefone telefone){
		System.out.println("**********************Método gravaTelefone da Classse CLIENTE***********************");
		this.telefones.add(telefone);
	}
	
	public void removeTelefone(Telefone telefone){
		this.telefones.remove(telefone);
		
	}
	
}
