package br.com.satecnologia.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.satecnologia.dao.ClienteDao;
import br.com.satecnologia.dao.ProdutoDao;
import br.com.satecnologia.dao.VendaDao;
import br.com.satecnologia.modelo.Cliente;
import br.com.satecnologia.modelo.Item;
import br.com.satecnologia.modelo.Produto;
import br.com.satecnologia.modelo.Venda;

@Named
@ViewScoped
public class VendasBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private VendaDao vendaDao;
	
	@Inject
	private ProdutoDao produtoDao;
	@Inject
	private ClienteDao clienteDao;
	
	private Produto produto =  new Produto();
	
	private Cliente cliente = new Cliente();
	
	private Venda venda =  new Venda();
	
	
	private Item item = new Item();
	
	private Integer idProduto;
	private Integer idCliente;
	
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public void adicionaItem(){
		Produto produto = produtoDao.buscaPorId(idProduto);
		if (item.getQuantidade() < produto.getQtdeMinAtacado()){
			item.setProduto(produto);
			item.setValorUnitario(produto.getValorVarejo());
		}else{
			item.setProduto(produto);
			item.setValorUnitario(produto.getValorAtacado());
		}
		item.setVenda(venda);
		venda.getItens().add(item);
							
		item = new Item();
		idProduto =  null;		
	}	
	
	public void removeItem(Item item){
		this.venda.removeItem(item);
	}
	
	public BigDecimal getSomaTotal(){
		List<Item> itens = venda.getItens();
		valorTotal = BigDecimal.ZERO;	
		
		for (Item item : itens) {						
			valorTotal = valorTotal.add(item.getValorTotal());
			System.out.println(valorTotal);		
		}		
		
		return valorTotal;		
	}
	
	public String gravaVenda(){
				
		Cliente cliente = clienteDao.buscaPorId(idCliente);
		venda.setCliente(cliente);
		venda.setValor(valorTotal);
		vendaDao.salvar(venda);
		
		venda = new Venda();
		item = new Item();
				
		return "vendas?faces-redirect=true";
		
		
	}
}
