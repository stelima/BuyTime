package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.lojavirtual.entidades.Venda;

public class VendaDAOImpl implements VendaDAO{
	@Override
	public void inserir(Venda v) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist( v );
		em.getTransaction().commit();
		em.close();
	}
	
	
	@Override
	public List<Venda> listar() throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Venda> qry = em.createQuery("select v from Venda v", Venda.class);
		List<Venda> vendas = new ArrayList<Venda>();
		vendas.addAll(qry.getResultList());
		em.close();
		return vendas;
	}
}
