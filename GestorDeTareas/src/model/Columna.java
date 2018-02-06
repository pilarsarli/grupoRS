package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="COLUMNA")
public class Columna implements java.io.Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idColumna;
	private String nombre;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(name="COLUMNA_ID")
	private Set<Tarea> tareas;
	@JsonIgnore
	@ManyToOne(optional = false)
	private Proyecto proyecto;
	
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
	
	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Set<Tarea> tareas) {
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
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
