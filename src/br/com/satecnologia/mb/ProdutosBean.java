package br.com.satecnologia.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.satecnologia.dao.ProdutoDao;
import br.com.satecnologia.modelo.Produto;

@Named // Gerenciado pelo CDI
@ViewScoped
public class ProdutosBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDao produtoDao;
	
	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	//Getters And Setters
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	//Métodos
	
	public String adiciona(){
		if (produto.getId() == null){
			produtoDao.salvar(this.produto);
			return "produto?faces-redirect=true";
		}else{
			produtoDao.alterar(this.produto);
		}
		produto =  new Produto();
		return "produto?faces-redirect=true";
	}
	
	public List<Produto> getListarProdutos(){
		if (produtos == null){
			produtos = produtoDao.listar();
			return produtos;
		}
		return produtos;
	}
	
	public String remover(Produto produto){
		produtoDao.remover(produto);
		return "produto?faces-redirect=true";
	}
	
	public void alterar(Produto produto){
		this.produto = produto;
	}
	
	public List<Produto> listaPorNome(String nome){
		return produtoDao.buscaPorNome(nome);
	}
	
	
}
