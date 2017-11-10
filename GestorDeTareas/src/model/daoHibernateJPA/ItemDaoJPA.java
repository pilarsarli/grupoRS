package model.daoHibernateJPA;

import model.Item;
import model.dao.*;

public class ItemDaoJPA extends GenericDaoHibernateJPA<Item> implements ItemDAO {
	
	public ItemDaoJPA() {
		super(Item.class);
	}
}
