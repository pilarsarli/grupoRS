package model.daoHibernateJPA;

import org.springframework.stereotype.Repository;

import model.Comentario;
import model.dao.ComentarioDAO;
@Repository
public class ComentarioDaoJPA extends GenericDaoHibernateJPA<Comentario> implements ComentarioDAO {

	
	public ComentarioDaoJPA() {
		super(Comentario.class);
	}

}
