package model;


import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="TAG")
public class Tag implements java.io.Serializable {	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idTag;
	private String nombre;
	@ManyToMany (mappedBy="tags") 
	private Collection<Tarea> tareas;
	// CONSULTAR MANY TO MANY CON TAREAS
	
	public Tag() {}
	public Tag(String nombre) {
		this.setNombre(nombre);
	}
	
	public long getIdTag() {
		return idTag;
	}
	public void setIdTag(long idTag) {
		this.idTag = idTag;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tag [idTag=" + idTag + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
	
}
