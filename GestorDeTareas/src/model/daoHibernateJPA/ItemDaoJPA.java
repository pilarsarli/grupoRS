package model.daoHibernateJPA;

import org.springframework.stereotype.Repository;

import model.Item;
import model.dao.ItemDAO;
@Repository
public class ItemDaoJPA extends GenericDaoHibernateJPA<Item> implements ItemDAO {

	public ItemDaoJPA() {
		super(Item.class);
	}

}
