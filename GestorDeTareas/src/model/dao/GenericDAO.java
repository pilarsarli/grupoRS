package model.dao;

public interface GenericDAO<T> {
	
	public boolean actualizar(T entity);
	public boolean eliminar(T entity);
	public boolean guardar(T entity);
	public T recuperar(long id);
	public boolean existe(T entity);
}
