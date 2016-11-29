package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.lojavirtual.entidades.Fornecedor;

public class FornecedorDAOImpl implements FornecedorDAO{

	@Override
	public void inserir(Fornecedor f) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Fornecedor f = em.getReference(Fornecedor.class, id);
		if (f != null) {
			em.getTransaction().begin();
			em.remove(f);
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public void atualizar(long id, Fornecedor f) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Fornecedor fornAntigo = em.getReference(Fornecedor.class, id);
		if (fornAntigo != null) {
			em.getTransaction().begin();
			fornAntigo.setNome(f.getNome());
			fornAntigo.setCnpj(f.getCnpj());
			fornAntigo.setEndereco(f.getEndereco());
			fornAntigo.setEmail(f.getEmail());
			fornAntigo.setTelefone(f.getTelefone());
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public List<Fornecedor> pesquisar(String nome) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Fornecedor> qry = em.createQuery("select f from Fornecedor f where nome like :n", Fornecedor.class);
		qry.setParameter("n", "%"+nome+"%");
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		fornecedores.addAll(qry.getResultList());
		em.close();
		return fornecedores;
	}

	@Override
	public List<Fornecedor> listar() throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Query qry = em.createQuery("select * from Fornecedor");
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		lista.addAll(qry.getResultList());
		return lista;
	}

}
