package model.daoHibernateJPA;

import model.Proyecto;
import model.dao.*;


public class ProyectoDaoJPA extends GenericDaoHibernateJPA<Proyecto> implements ProyectoDAO {

	public ProyectoDaoJPA() {
		super(Proyecto.class);
		
	}

}
