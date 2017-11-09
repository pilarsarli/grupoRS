package model;


import javax.persistence.*;

@Entity
@Table(name="TAG")
public class Tag implements java.io.Serializable {	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idTag;
	private String nombre;
	// CONSULTAR MANY TO MANY CON TAREAS
	
	public Tag(String nombre) {
		this.setNombre(nombre);
	}
	
	public long getId() {
		return idTag;
	}
	
	public void setId(long id) {
		this.idTag = id;
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
