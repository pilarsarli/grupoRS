package model.daoHibernateJPA;

import org.springframework.stereotype.Repository;

import model.Tag;
import model.dao.TagDAO;
@Repository
public class TagDaoJPA extends GenericDaoHibernateJPA<Tag> implements TagDAO {
	
	public TagDaoJPA() {
		super(Tag.class);
	}

}
