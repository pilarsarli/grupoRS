package model.daoHibernateJPA;

import model.Comentario;
import model.dao.ComentarioDAO;

public class ComentarioDaoJPA extends GenericDaoHibernateJPA<Comentario> implements ComentarioDAO {
	
	public ComentarioDaoJPA() {
		super(Comentario.class);
	}
}
