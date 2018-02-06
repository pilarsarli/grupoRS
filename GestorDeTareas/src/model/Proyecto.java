package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PROYECTO")
public class Proyecto implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProyecto;
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_estimada;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
            property = "@idUsuario")
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "PROYECTO_USUARIO", joinColumns = @JoinColumn(name = "PROYECTO_ID"), inverseJoinColumns = @JoinColumn(name = "USUARIO_ID"))
	private Set<Usuario> miembrosProyecto;
	
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
            property = "@idProyecto")
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch=FetchType.EAGER)
	@JoinColumn(name = "PROYECTO_ID")
	private Set<Columna> columnas;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
            property = "@idUsuario")
	@ManyToOne(optional = false)
	@JoinColumn(name = "lider_id")
	private Usuario lider; // lider es un usuario o el id del usuario

	public Proyecto(Usuario lider, String n, Date f_i, Date f_e) {
		this.setLider(lider);
		this.setNombre(n);
		this.setFecha_inicio(f_i);
		this.setFecha_estimada(f_e);

		this.setMiembrosProyecto(new HashSet<Usuario>());
		this.setColumnas(new HashSet<Columna>());
	}

	public Proyecto() {
	}

	public long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Set<Usuario> getMiembrosProyecto() {
		return miembrosProyecto;
	}

	public void setMiembrosProyecto(Set<Usuario> miembrosProyecto) {
		this.miembrosProyecto = miembrosProyecto;
	}

	public Set<Columna> getColumnas() {
		return columnas;
	}

	public void setColumnas(Set<Columna> Columnas) {
		this.columnas = Columnas;
	}

	public Usuario getLider() {
		return lider;
	}

	public void setLider(Usuario lider) {
		this.lider = lider;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_estimada() {
		return fecha_estimada;
	}

	public void setFecha_estimada(Date fecha_estimada) {
		this.fecha_estimada = fecha_estimada;
	}

	public void agregarColumna(Columna col) {
		this.columnas.add(col);
	}

	public void eliminarColumna(Columna c) {
		this.columnas.remove(c);
	}

	public void agregarMiembro(Usuario u) {
		this.miembrosProyecto.add(u);
	}

	public void eliminarMiembro(Usuario u) {
		this.miembrosProyecto.remove(u);
	}

	public long getId() {
		return idProyecto;
	}

	public void setId(long id) {
		this.idProyecto = id;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_estimada=" + fecha_estimada + ", lider=" + lider.getNombreUsuario() + "]";
	}

}
