package model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="PROYECTO")
public class Proyecto implements java.io.Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idProyecto;
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_estimada;
	@ManyToMany 
	@JoinTable( name="PROYECTO_USUARIO",
	joinColumns=@JoinColumn(name="PROYECTO_ID"),
	inverseJoinColumns=@JoinColumn(name="USUARIO_ID"))
	private Collection<Usuario> miembrosProyecto;
	@OneToMany(mappedBy="columnas",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Collection<Columna> columnas;
	@ManyToOne(optional = false)
	@JoinColumn(name="lider_id")
	private Usuario lider;
	
	public Proyecto (Usuario lider,String n, Date f_i, Date f_e) {
		this.setLider(lider);
		this.setNombre(n);
		this.setFecha_inicio(f_i);
		this.setFecha_estimada(f_e);
		
		this.setMiembrosProyecto(new ArrayList<Usuario>());
		this.setColumnas(new ArrayList<Columna>());
	}
	public Proyecto () {}
	
	
	public Collection<Usuario> getMiembrosProyecto() {
		return miembrosProyecto;
	}


	public void setMiembrosProyecto(ArrayList<Usuario> miembrosProyecto) {
		this.miembrosProyecto = miembrosProyecto;
	}


	public Collection<Columna> getColumnas() {
		return columnas;
	}


	public void setColumnas(ArrayList<Columna> Columnas) {
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

	public void agregarColumna (Columna col) {
		this.columnas.add(col);
	}
	public void eliminarColumna (Columna c) {
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
