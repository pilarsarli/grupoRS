package model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COLUMNA")
public class Columna {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTarea;
	private String nombre;
	@OneToMany(mappedBy="tareas",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
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
		return idTarea;
	}
	
	public void setId(Long id) {
		this.idTarea = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
