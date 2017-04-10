package br.com.satecnologia.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.satecnologia.dao.ClienteDao;
import br.com.satecnologia.modelo.Cliente;
import br.com.satecnologia.modelo.Telefone;
//import br.com.satecnologia.util.GeraRelatorio;


@Named
@ViewScoped
public class ClientesBean implements Serializable{	
		
	private static final long serialVersionUID = 1L;
	@Inject
	private ClienteDao clienteDao;
			
	private Cliente cliente = new Cliente();
	
	private Telefone telefone = new Telefone();
	
	private List<Cliente> clientes;
	
			
	//Getters and Setters
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	//Métodos
	public String adicionaTelefoneAoCliente(){
		this.telefone.setCliente(cliente);
		this.cliente.gravaTelefone(this.telefone);
		this.telefone = new Telefone();
		return null;
}
	
	public List<Telefone> listaTelefonesDoCliente(Cliente cliente){	
		this.cliente.setTelefones(clienteDao.listaTelefonesDoContato(cliente));	
		return this.cliente.getTelefones();
	}
		
	public String adicionar(){
		if (cliente.getId() == null){
			System.out.println("********Insert Novo Cliente**********");	
		clienteDao.salvar(this.cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Cadastrado com Sucesso!"));
		}else{
			System.out.println("********Update Atualiza Cliente**********");	
		clienteDao.alterar(cliente);
		}
		this.cliente = new Cliente();
		this.cliente.getTelefones().clear();
		return "cliente?faces-redirect=true";
	}
	
	public List<Cliente> getListaTodos(){
		if(clientes == null){
		clientes = clienteDao.listar();
		return this.clientes;		
	}
		return this.clientes;
	}

	public String remover(Cliente cliente){
		System.out.println("********Método Remover Passando pelo Bean");
		clienteDao.remover(cliente);	
		return "cliente?faces-redirect=true";
	}
	
	public void carregaCliente(Cliente cliente){
		this.cliente = cliente;
		System.out.println("*******Carregou o cliente : " + this.cliente.getNome());
		listaTelefonesDoCliente(cliente);
	}
	
	public List<Telefone> getTelefonesDoCliente(){
		return this.cliente.getTelefones();		
	}
	
	public void removeTelefoneDoCliente(Telefone telefone){
		this.cliente.removeTelefone(telefone);
					
	}
	
	public List<Cliente> listaPorNome(String nome){
		return clienteDao.buscaPorNome(nome);
	}
	
	/*public void gerarRelatorio(){
		GeraRelatorio geraRelatorio = new GeraRelatorio();
		geraRelatorio.getRelatorio(getListaTodos());
	}*/
	
	
	
	
	
}
