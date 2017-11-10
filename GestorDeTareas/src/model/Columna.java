package model;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
