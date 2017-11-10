package model.daoHibernateJPA;

import model.Tarea;
import model.dao.TareaDAO;

public class TareaDaoJPA extends GenericDaoHibernateJPA<Tarea> implements TareaDAO {
	
	public TareaDaoJPA() {
		super(Tarea.class);
	}
}
