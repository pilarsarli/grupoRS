package model.daoHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Columna;
import model.Tarea;
import model.dao.TareaDAO;
@Repository
public class TareaDaoJPA extends GenericDaoHibernateJPA<Tarea> implements TareaDAO {

	
	public TareaDaoJPA() {
		super(Tarea.class);
	}
	
	public boolean existe(String nombre) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT t FROM Tarea t WHERE t.nombre = :tar");
		q.setParameter("tar", nombre); 
		List<Tarea> resultado = (List<Tarea>) q.getResultList();
		if(resultado.size()!=0){
			return true;
		}
		else{
			return false;
		}
	}

}
