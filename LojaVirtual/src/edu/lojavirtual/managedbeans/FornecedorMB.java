package edu.lojavirtual.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.lojavirtual.entidades.Fornecedor;

@ManagedBean
@SessionScoped
public class FornecedorMB implements Serializable{
	
	private Fornecedor fornAtual;
	private FornecedorDAO fornDAO;
	private List<Fornecedor> fornecedores;
	
	public FornecedorMB(){
		fornAtual= new Fornecedor();
		setFornecedor(new ArrayList<Fornecedor>());
		fornDAO = new FornecedorDAOImpl();
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
	
}
