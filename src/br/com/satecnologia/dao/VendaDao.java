package br.com.satecnologia.dao;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.satecnologia.modelo.Venda;

@Stateless
public class VendaDao  extends Dao<Venda>{

	public VendaDao() {
		super(Venda.class);
		
	}
	
	
	/*public List<Venda> listaPersonalizada(){
	CriteriaBuilder builder = manager.getCriteriaBuilder();
	CriteriaQuery<Venda> criteria = builder.createQuery(Venda.class);
	criteria.from(Venda.class);
	return  manager.createQuery(criteria).getResultList();		
	}*/
	
	public List<Venda> listaPersonalizada(Integer clienteId, Calendar init, Calendar end){
		if (clienteId != null){
			String jpql = "from Venda v where v.cliente.id = :pClienteId and (v.data between :pInicio and :pFim)";
			TypedQuery<Venda> query = manager.createQuery(jpql, Venda.class);	
			query.setParameter("pClienteId", clienteId);
			query.setParameter("pInicio", init);
			query.setParameter("pFim", end);
			return query.getResultList();
		}
			String jpql = "from Venda v where v.data between :pInicio and :pFim";
			TypedQuery<Venda> query = manager.createQuery(jpql, Venda.class);	
			query.setParameter("pInicio", init);
			query.setParameter("pFim", end);
			return query.getResultList();		
		
	}
	

	
}
