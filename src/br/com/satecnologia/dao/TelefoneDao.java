package br.com.satecnologia.dao;

import javax.ejb.Stateless;

import br.com.satecnologia.modelo.Telefone;
@Stateless
public class TelefoneDao extends Dao<Telefone>{

	public TelefoneDao() {
		super(Telefone.class);		
	}

}
