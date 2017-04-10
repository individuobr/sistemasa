package br.com.satecnologia.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Dao<T> {
	
	private Class<T> classe;
	
	@Inject//Injeção de dependencia do CDI
	protected EntityManager manager;
	
	//Contrutor
	public Dao(Class<T> classe) {
		this.classe = classe;
	}
	
	//Métodos
	public void salvar(T t){
		System.out.println("Chegou no Dao método Salvar");
		manager.joinTransaction();
		manager.persist(t);		
	}
	
	public void remover(T t){
		manager.joinTransaction();
		T tmanager = this.manager.merge(t); //Passa o t para TRANSIENT
		manager.remove(tmanager);
		System.out.println("Removendo...");
	}
	
	public T buscaPorId(Integer id){
		return manager.find(classe, id);		
	}
	
	public void alterar(T t){
		manager.joinTransaction();
		manager.merge(t);
	}

	public List<T> listar() {		
		return this.manager.createQuery(
				"select c from " + classe.getSimpleName() + " c", classe)
				.getResultList();
	}
	
	public List<T> buscaPorNome(String texto){
		String jpql = "select c from " + classe.getSimpleName() + " c where "
				+ " lower(c.nome) like :pNome order by c.nome";
				
		List<T> lista = manager.createQuery(jpql, classe)
				.setParameter("pNome", texto + "%").getResultList();
		return lista;	
	}
	
	
	}
