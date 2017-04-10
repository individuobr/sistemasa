package br.com.satecnologia.mb;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.satecnologia.dao.VendaDao;
import br.com.satecnologia.modelo.Venda;

@Named
@ViewScoped
public class VendasEfetivadasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VendaDao vendaDao;
	
	private List<Venda> vendas;
	
	private Integer idCliente;
	private Calendar dataInit = Calendar.getInstance();
	private Calendar dataEnd = Calendar.getInstance();

	public List<Venda> getVendas() {
		if(vendas == null){			
		vendas = vendaDao.listar();
		return vendas;
		}
		return vendas;
	}
	
	
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Calendar getDataInit() {
		return dataInit;
	}

	public void setDataInit(Calendar dataInit) {
		this.dataInit = dataInit;
	}

	public Calendar getDataEnd() {
		return dataEnd;
	}

	public void setDataEnd(Calendar dataEnd) {
		this.dataEnd = dataEnd;
	}
	
	public List<Venda> listaTodas() {
		vendas = vendaDao.listaPersonalizada(idCliente, dataInit, dataEnd);
		return vendas;
	}

}
