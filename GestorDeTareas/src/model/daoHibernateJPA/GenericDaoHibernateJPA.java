package model.daoHibernateJPA;
import java.io.Serializable;

import javax.persistence.*;

import model.dao.GenericDAO;

public class GenericDaoHibernateJPA<T> implements GenericDAO<T> {
	private String Service = null;
	protected Class<T> persistentClass; 
	protected EntityManager getEMF() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Service);
		EntityManager em = emf.createEntityManager();
		return em;
	}
	public T actualizar(T entity) {
		EntityManager em = getEMF();
		EntityTransaction etx= em.getTransaction();
		etx.begin();
		T ent = em.merge(entity);
		etx.commit();
		em.close();
		return ent;
	}

	@Override
	public void eliminar(T entity) {
		EntityManager em = getEMF();
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestor");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
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
		EntityManager em = getEMF();
		T entity = em.find(this.getPersistentClass(), id);
		return entity;
	}


	public T eliminar(Serializable id) {
		EntityManager em = getEMF();
		T entity = em.find(this.getPersistentClass(), id);
		if (entity != null) {
			this.eliminar(entity);
			}
			return entity;
	}
	protected Class<T> getPersistentClass() {
		return this.persistentClass;
	}
		

}
