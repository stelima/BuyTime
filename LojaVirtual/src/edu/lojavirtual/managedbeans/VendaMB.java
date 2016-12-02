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

import edu.lojavirtual.dao.VendaDAO;
import edu.lojavirtual.dao.VendaDAOImpl;
import edu.lojavirtual.entidades.Venda;
import edu.lojavirtual.entidades.Produto;

@ManagedBean(name = "VendaMB")
@SessionScoped
public class VendaMB implements Serializable {

	private static final long serialVersionUID = -3304202810037758438L;
	
	private Venda vendaAtual;
	private VendaDAO vendaDAO;
	private List<Venda> vendas;
	List<Produto> produtos;
	
	public VendaMB() { 
		
		vendaAtual = new Venda();
		setVendas(new ArrayList<Venda>());
		vendaDAO = new VendaDAOImpl();
		
	}
	
	public void inserir(List<Produto> produtos) { 
		try {
			vendaDAO.inserir( vendaAtual );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listar();
	}
	
	public void carregar(Venda v) { 
		vendaAtual = v;		
	}
	/*
	public void atualizar() {
		try {
			vendaDAO.atualizar( vendaAtual.getId(), vendaAtual );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Venda v) { 
		try {
			vendaDAO.remover( v.getId() );
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void pesquisar() { 
		try {
			vendas = vendasDAO.pesquisar( vendaAtual.getNome() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	public void listar() { 
		try {
			vendas = vendaDAO.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public Venda getVendaAtual() {
		return vendaAtual;
	}

	public void setVendaAtual(Venda vendaAtual) {
		this.vendaAtual = vendaAtual;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

}
