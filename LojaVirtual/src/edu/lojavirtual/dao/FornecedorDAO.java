package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.List;

import edu.lojavirtual.entidades.Fornecedor;

public interface FornecedorDAO {
	
	public void inserir(Fornecedor f) throws SQLException;
	public void remover(long id) throws SQLException;
	public void atualizar(long id, Fornecedor f) throws SQLException;
	public List<Fornecedor> pesquisar(String nome) throws SQLException;
	public List<Fornecedor> listar() throws SQLException;
	
}
