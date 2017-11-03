package model.dao;

import java.util.*;

import model.*;

public interface ProyectoDAO {

	public boolean crearProyecto(long id, String nombre, Date fecha_inicio, Date fecha_estimada);
	public boolean eliminarProyecto(long id);
	public boolean editarProyecto(long id, String nombre, Date fecha_inicio, Date fecha_estimada);
	public boolean recuperarProyecto(Proyecto proyecto);
	
	
	
	
	
}
