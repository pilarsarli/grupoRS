package model.daoHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Columna;
import model.Proyecto;
import model.dao.ProyectoDAO;

@Repository
public class ProyectoDaoJPA extends GenericDaoHibernateJPA<Proyecto> implements ProyectoDAO {

	public ProyectoDaoJPA() {
		super(Proyecto.class);
		
	}
	
	public boolean existe(String nombre) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT p FROM Proyecto p WHERE p.nombre = :proy");
		q.setParameter("proy", nombre); 
		List<Proyecto> resultado = (List<Proyecto>) q.getResultList();
		if(resultado.size()!=0){
			return true;
		}
		else{
			return false;
		}
	}

}
