package model.daoHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Tag;
import model.Usuario;
import model.dao.TagDAO;
@Repository
public class TagDaoJPA extends GenericDaoHibernateJPA<Tag> implements TagDAO {
	
	public TagDaoJPA() {
		super(Tag.class);
	}
	public boolean existe(String nombre) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT t FROM Tag t WHERE t.nombre = :tg"); 
		q.setParameter("tg", nombre); 
		List<Tag> resultado = (List<Tag>) q.getResultList();
		if(resultado.size()!=0){
			return true;
		}
		else{
			return false;
		}
	}
}
