package model.daoHibernateJPA;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import model.Usuario;
import model.dao.GenericDAO;
@Transactional
public class GenericDaoHibernateJPA<T> implements GenericDAO<T> {
	
	protected Class<T> persistentClass; 
	EntityManager entityManager = null ;
	
	public GenericDaoHibernateJPA(Class<T> clazz) {
		this.persistentClass = clazz;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager=em;
	}
	
	public EntityManager getEntityManager() {
		if (entityManager==null) {
			EntityManager em = EMF.getEMF().createEntityManager();
			this.setEntityManager(em);
		}
		return this.entityManager;
	}
	public T actualizar(T entity) {
		EntityManager em = this.getEntityManager();
		//EntityTransaction etx= em.getTransaction();
		//etx.begin();
		return em.merge(entity);
		//em.close();
	}

	@Override
	public void eliminar(T entity) {
		EntityManager em = this.getEntityManager();
		em.remove(em.contains(entity) ? entity : em.merge(entity));

	}
	
	/*@Override
	 * public T guardar(T entity) {
	
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			System.out.println("Hubo un problema para persistir los datos");
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
		return entity;
	}  */
	
	@Override
	public T recuperar(long id) {
		EntityManager em = this.getEntityManager();
		T entity = em.find((Class<T>) this.getPersistentClass(), id);
		return entity;
	}


	public T eliminar(Long id) {
		EntityManager em = this.getEntityManager();
		T entity = em.find(this.getPersistentClass(), id);
		if (entity != null) {
			this.eliminar(entity);
			}
			return entity;
	}
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	public T persistir(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
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
