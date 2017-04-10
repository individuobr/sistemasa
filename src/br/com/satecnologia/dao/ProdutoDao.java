package br.com.satecnologia.dao;

import javax.ejb.Stateless;

import br.com.satecnologia.modelo.Produto;
@Stateless
public class ProdutoDao extends Dao<Produto>{

	public ProdutoDao() {
		super(Produto.class);
		
	}

}
