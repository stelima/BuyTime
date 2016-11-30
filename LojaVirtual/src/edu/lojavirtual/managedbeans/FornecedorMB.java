package edu.lojavirtual.managedbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import edu.lojavirtual.dao.FornecedorDAO;
import edu.lojavirtual.dao.FornecedorDAOImpl;
import edu.lojavirtual.entidades.Fornecedor;


@SuppressWarnings("serial")
@ManagedBean(name = "MBFornecedor")
@SessionScoped
public class FornecedorMB implements Serializable{
	
	private ListDataModel<Fornecedor> tabela;

	private Fornecedor fornAtual;
	private FornecedorDAO fornDAO;
	private List<Fornecedor> fornecedores;
	
	public FornecedorMB(){
		fornAtual= new Fornecedor();
		setFornecedor(new ArrayList<Fornecedor>());
		fornDAO = new FornecedorDAOImpl();
	}

	public void inserir(){
		try {
			fornDAO.inserir(fornAtual);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listar();
	}
	
	public void alterar(){
		try {
			fornDAO.atualizar(fornAtual.getId(), fornAtual);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listar();
	}
	
	public void remover(Fornecedor f){
		try {
			fornDAO.remover(f.getId());
			pesquisar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listar();
	}
	
	public void pesquisar(){
		try {
			fornecedores = fornDAO.pesquisar(fornAtual.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listar(){
		try {
			tabela = new ListDataModel<Fornecedor>(fornDAO.listar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Fornecedor getFornAtual() {
		return fornAtual;
	}

	public void setFornAtual(Fornecedor fornAtual) {
		this.fornAtual = fornAtual;
	}

	public List<Fornecedor> getFornecedor() {
		return fornecedores;
	}

	public void setFornecedor(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public ListDataModel<Fornecedor> getTabela() {
		return tabela;
	}

	public void setTabela(ListDataModel<Fornecedor> tabela) {
		this.tabela = tabela;
	}
	
}
