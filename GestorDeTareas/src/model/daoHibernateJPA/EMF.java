package model.daoHibernateJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("GestorDeTareas");

	public static EntityManagerFactory getEMF() {
		return em;
	}
}
