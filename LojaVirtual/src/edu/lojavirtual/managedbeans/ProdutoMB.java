package edu.lojavirtual.managedbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import edu.lojavirtual.dao.ProdutoDAO;
import edu.lojavirtual.dao.ProdutoDAOImpl;
import edu.lojavirtual.entidades.Produto;

@ManagedBean(name = "ProdutoMB")
@SessionScoped
public class ProdutoMB implements Serializable {

	private static final long serialVersionUID = -3304202810037758438L;
	
	private Produto prodAtual;
	private ProdutoDAO prodDAO;
	private List<Produto> produtos;
	
	public ProdutoMB() { 
		
		prodAtual = new Produto();
		setProdutos(new ArrayList<Produto>());
		prodDAO = new ProdutoDAOImpl();
		
	}
	
	public void inserir() { 
		try {
			prodDAO.inserir( prodAtual );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listar();
	}
	
	public void carregar(Produto p) { 
		prodAtual = p;		
	}
	
	public void atualizar() {
		try {
			prodDAO.atualizar( prodAtual.getId(), prodAtual );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Produto p) { 
		try {
			prodDAO.remover( p.getId() );
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void pesquisar() { 
		try {
			produtos = prodDAO.pesquisar( prodAtual.getNome() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listar() { 
		try {
			produtos = prodDAO.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public Produto getProdAtual() {
		return prodAtual;
	}

	public void setProdAtual(Produto prodAtual) {
		this.prodAtual = prodAtual;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
