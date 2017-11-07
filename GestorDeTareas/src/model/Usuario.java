package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idUsuario;
	private String nombreUsuario;
	private String clave;
	private String nombre;
	private String apellido;
	private String mail;
	// CONSULTAR MANY TO MANY MIEMBROS-TAREAS MIEMBROS-PROYECTO
	@ManyToMany (mappedBy="miembros_proyecto") // ??????????!
	private ArrayList<Proyecto> proyectos;
	
	public Usuario(long id, String username, String clave, String nombre, String apellido, String mail ) {
		this.setIdUsuario(id);
		this.setNombreUsuario(username);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMail(mail);
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
