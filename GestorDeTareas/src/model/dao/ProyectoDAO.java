package model.dao;

import java.util.*;

import model.*;

public interface ProyectoDAO {

	public boolean agregarProyecto(long id, String nombre, Date fecha_inicio, Date fecha_estimada);
	public boolean eliminarProyecto(long id);
	public boolean editarProyecto(long id, String nombre, Date fecha_inicio, Date fecha_estimada);
	
	public boolean agregarMiembro(Usuario user);
	public boolean eliminarMiembro(Usuario u);
	
	public boolean agregarColumna(Columna c);
	public boolean eliminarColumna(Columna c);
	public ArrayList<Columna> getColumnas();
	
	
	
	
	
	
}
