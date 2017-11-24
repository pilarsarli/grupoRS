package model.daoHibernateJPA;

import org.springframework.stereotype.Repository;

import model.Columna;
import model.dao.ColumnaDAO;
@Repository
public class ColumnaDaoJPA extends GenericDaoHibernateJPA<Columna> implements ColumnaDAO {

	public ColumnaDaoJPA() {
		super(Columna.class);
	}

}
