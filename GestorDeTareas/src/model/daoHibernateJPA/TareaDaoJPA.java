package model.daoHibernateJPA;

import org.springframework.stereotype.Repository;

import model.Tarea;
import model.dao.TareaDAO;
@Repository
public class TareaDaoJPA extends GenericDaoHibernateJPA<Tarea> implements TareaDAO {

	
	public TareaDaoJPA() {
		super(Tarea.class);
	}

}
