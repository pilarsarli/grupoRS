package model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="COLUMNA")
public class Columna implements java.io.Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idColumna;
	private String nombre;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="COLUMNA_ID")
	private Collection<Tarea> tareas;
	
	
	public Columna() {
		
	}
	public Columna (String nombre) {
		this.setNombre(nombre);
	}
	public Long getIdColumna() {
		return idColumna;
	}
	public void setIdColumna(Long idColumna) {
		this.idColumna = idColumna;
	}
	public boolean agregarTarea(Tarea unaTarea) {
		return tareas.add(unaTarea);
	}
	
	public boolean eliminarTarea(Tarea unaTarea) {
		return tareas.remove(unaTarea);
	}
	
	public Collection<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Collection<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Long getId() {
		return idColumna;
	}
	
	public void setId(Long id) {
		this.idColumna = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
