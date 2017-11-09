package model.daoHibernateJPA;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import model.dao.GenericDAO;

public class GenericDaoHibernateJPA<T> implements GenericDAO<T> {
	private String Service = null;
	protected Class<T> persistentClass; 

	public T actualizar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx= em.getTransaction();
		etx.begin();
		T ent = em.merge(entity);
		etx.commit();
		em.close();
		return ent;
	}

	@Override
	public void eliminar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
		if ( tx != null && tx.isActive() ) tx.rollback();
		throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
		em.close();
		}
	}

	@Override
	public T guardar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			System.out.println("la cagaste");
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
		return entity;
	}
	@Override
	public T recuperar(long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		T entity = em.find((Class<T>) this.getPersistentClass(), id);
		return entity;
	}


	public T eliminar(Serializable id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		T entity = em.find(this.getPersistentClass(), id);
		if (entity != null) {
			this.eliminar(entity);
			}
			return entity;
	}
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
		
	/*
	 * public List<T> listar(){
		List<T> listado = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		T entity = em.
		return listado;
	}
	*/
}
