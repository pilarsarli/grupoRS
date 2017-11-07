package model.dao;

import java.io.Serializable;

public interface GenericDAO<T> {
	
	public T actualizar(T entity);
	public void eliminar(T entity);
	public T eliminar(Serializable id);
	public T guardar(T entity);
	public T recuperar(long id);
}
