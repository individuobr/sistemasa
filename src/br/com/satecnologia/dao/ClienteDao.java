package br.com.satecnologia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.satecnologia.modelo.Cliente;
import br.com.satecnologia.modelo.Telefone;
@Stateless
public class ClienteDao extends Dao<Cliente>{

	public ClienteDao() {
		super(Cliente.class);
	}
	public List<Telefone> listaTelefonesDoContato(Cliente cliente){
		TypedQuery<Telefone> query = manager.createQuery("select t from Telefone t where t.cliente = :pCliente", Telefone.class);
		query.setParameter("pCliente", cliente);
		
		List<Telefone> telefones = query.getResultList();		
		for (Telefone telefone : telefones) {
			System.out.println("Nome: " + cliente.getNome() + " Telefone Relacionado: " +telefone.getNumero());
		}
		
		return query.getResultList();		
	}
}
