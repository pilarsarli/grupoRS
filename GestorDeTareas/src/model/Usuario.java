package model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
            property = "@idProyecto")
	@ManyToMany (mappedBy="miembrosProyecto", fetch=FetchType.EAGER) 
	private Set<Proyecto> proyectos;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
            property = "@idTarea")
	@ManyToMany (mappedBy="miembrosTarea", fetch=FetchType.EAGER) 
	private Set<Tarea> tareas;

	public Usuario(String username, String clave, String nombre, String apellido, String mail ) {
		this.setNombreUsuario(username);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMail(mail);
	}

	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Usuario() {}
	
	public void setProyectos(Set<Proyecto> proyectos) {
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
