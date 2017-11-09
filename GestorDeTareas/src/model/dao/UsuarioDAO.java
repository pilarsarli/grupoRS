package model.dao;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public Usuario autentificacion(String usuario, String clave);
	
	
}
