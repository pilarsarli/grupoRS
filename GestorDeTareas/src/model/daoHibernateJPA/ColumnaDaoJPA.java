package model.daoHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Columna;
import model.dao.ColumnaDAO;
@Repository
public class ColumnaDaoJPA extends GenericDaoHibernateJPA<Columna> implements ColumnaDAO {

	public ColumnaDaoJPA() {
		super(Columna.class);
	}

	public boolean existe(String nombre) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Columna c WHERE c.nombre = :col");
		q.setParameter("col", nombre); 
		List<Columna> resultado = (List<Columna>) q.getResultList();
		if(resultado.size()!=0){
			return true;
		}
		else{
			return false;
		}
	}
}
