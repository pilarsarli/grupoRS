package model.dao;

public interface GenericDAO<T> {
	
	public T actualizar(T entity);
	public void eliminar(T entity);
	public T eliminar(Long id);
	public T persistir(T entity);
	public T recuperar(long id);
}
