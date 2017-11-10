package model.daoHibernateJPA;

import model.Columna;
import model.dao.ColumnaDAO;

public class ColumnaDaoJPA extends GenericDaoHibernateJPA<Columna> implements ColumnaDAO {

	public ColumnaDaoJPA() {
		super(Columna.class);
	}

}
