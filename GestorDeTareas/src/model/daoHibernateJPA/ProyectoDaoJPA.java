package model.daoHibernateJPA;

import org.springframework.stereotype.Repository;

import model.Proyecto;
import model.dao.ProyectoDAO;

@Repository
public class ProyectoDaoJPA extends GenericDaoHibernateJPA<Proyecto> implements ProyectoDAO {

	public ProyectoDaoJPA() {
		super(Proyecto.class);
		
	}


}
