package model.dao;

import java.util.*;

import model.Usuario;

public interface UsuarioDAO {
	
	public ArrayList<Usuario> getUsuarios();
	public Usuario getUsuario(long id);
	public void agregarUsuario(long id, String nombre, String apellido, String email, String clave, String nombreUsuario);
	public void editarUsuario(long id, String nombre, String apellido, String email, String clave, String nombreUsuario);
	public void eliminarUsuario(long id);
	
	
	
	
	
	
}
