package model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="COLUMNA")
public class Columna implements java.io.Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idColumna;
	private String nombre;
	@OneToMany(mappedBy="tareas",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Collection<Tarea> tareas;
	
	
	public Columna (String nombre) {
		this.setNombre(nombre);
	}
	public Long getIdColumna() {
		return idColumna;
	}
	public void setIdColumna(Long idColumna) {
		this.idColumna = idColumna;
	}
	public Columna() {}
	
	public boolean agregarTarea(Tarea unaTarea) {
		return tareas.add(unaTarea);
	}
	
	public boolean eliminarTarea(Tarea unaTarea) {
		return tareas.remove(unaTarea);
	}
	
	public Collection<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Collection<Tarea> collection) {
		this.tareas = collection;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
