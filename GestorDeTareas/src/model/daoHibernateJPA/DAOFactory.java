package model.daoHibernateJPA;

import model.dao.*;

public class DAOFactory {

	
	
	public ProyectoDAO getProyectoDAO() {
		
		return new ProyectoDaoJPA();
	}
	public UsuarioDAO getUsuarioDAO() {
		
		return new UsuarioDaoJPA();
	}
	public TareaDAO getTareaDAO() {
		
		return new TareaDaoJPA();
	}
	public ColumnaDAO getColumnaDAO() {
		
		return new ColumnaDaoJPA();
	}
	public ItemDAO getItemDAO() {
		
		return new ItemDaoJPA();
	}
	public ComentarioDAO getComentarioDAO() {
		
		return new ComentarioDaoJPA();
	}
	public TagDAO getTagDAO() {
		
		return new TagDaoJPA();
	}

		
}
