package model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="USUARIO")
public class Usuario implements java.io.Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idUsuario;
	private String nombreUsuario;
	private String clave;
	private String nombre;
	private String apellido;
	private String mail;
	@ManyToMany (mappedBy="miembrosProyecto", fetch=FetchType.EAGER) 
	private Collection<Proyecto> proyectos;
	@ManyToMany (mappedBy="miembrosTarea") 
	private Collection<Tarea> tareas;

	public Usuario(String username, String clave, String nombre, String apellido, String mail ) {
		this.setNombreUsuario(username);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMail(mail);
	}

	public Usuario() {}
	
	public void setProyectos(Collection<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	public Collection<Proyecto> getProyectos(){
		return this.proyectos;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", mail=" + mail + "]";
	}
	
	
	
}
