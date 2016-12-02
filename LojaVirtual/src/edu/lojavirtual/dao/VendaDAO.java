package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.List;

import edu.lojavirtual.entidades.Venda;

public interface VendaDAO {
	public void inserir(Venda v) throws SQLException;
	//public void remover(long id) throws SQLException;
	//public void atualizar(long id, Venda v) throws SQLException;
	//public List<Venda> pesquisar(String nome) throws SQLException;
	public List<Venda> listar() throws SQLException;
}
