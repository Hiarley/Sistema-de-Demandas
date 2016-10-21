package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.ProdutoDAO;
import dominio.Produto;

@ManagedBean
@RequestScoped
public class ProdutoMB {
	
	
	private Produto produto;
	
	@Inject
	private ProdutoDAO produtoDAO;
	private List<Produto> listaProdutos;
	
	
	public  ProdutoMB() {
		produto = new Produto();
		listaProdutos = new ArrayList<Produto>(); 
	}
	
	public String inserir(){
		produto.setPrazo(new Date());
		produtoDAO.salvar(produto);
		return "/interna/cadastro_sucesso.jsf";
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Produto getProduto(String nome) {
		return produtoDAO.buscarProdutoNome(nome);
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListaProdutos() {
		setListaProdutos(produtoDAO.listar());
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
