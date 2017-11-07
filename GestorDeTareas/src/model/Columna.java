package model;
import java.util.ArrayList;

public class Columna implements java.io.Serializable {
	private Long id;
	private String nombre;
	private ArrayList<Tarea> tareas;
	
	
	public Columna (String nombre) {
		this.setNombre(nombre);
		this.setTareas(new ArrayList<Tarea>());
	}
	
	public boolean agregarTarea(Tarea unaTarea) {
		return tareas.add(unaTarea);
	}
	
	public boolean eliminarTarea(Tarea unaTarea) {
		return tareas.remove(unaTarea);
	}
	
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
