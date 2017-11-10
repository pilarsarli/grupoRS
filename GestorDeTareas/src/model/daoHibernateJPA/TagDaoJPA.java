package model.daoHibernateJPA;

import model.Tag;
import model.dao.TagDAO;

public class TagDaoJPA extends GenericDaoHibernateJPA<Tag> implements TagDAO {
	
	public TagDaoJPA() {
		super(Tag.class);
	}

}
