package model;

import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TAREA")
public class Tarea implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTarea;
	private String nombre;
	private String descripcion;
	private Date fecha_asignacion;
	private Date fecha_vencimiento;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TAREA_TAGS", joinColumns = @JoinColumn(name = "TAREA_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
	private Set<Tag> tags;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch=FetchType.EAGER)
	@JoinColumn(name = "TAREA_ID")
	private Set<Comentario> comentarios;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch=FetchType.EAGER)
	@JoinColumn(name = "TAREA_ID")
	private Set<Item> checkList;
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
            property = "@idUsuario")
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TAREA_USUARIO", joinColumns = @JoinColumn(name = "TAREA_ID"), inverseJoinColumns = @JoinColumn(name = "USUARIO_ID"))
	private Set<Usuario> miembrosTarea;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn private Columna columna;

	public Tarea() {
	}

	public Tarea(String nombre, String descripcion, Date fa, Date fv, String tag) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setFecha_asignacion(fa);
		this.setFecha_vencimiento(fv);
		tags.add(new Tag(tag));
		this.setTags(tags);
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_asignacion() {
		return fecha_asignacion;
	}

	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Item> getCheckList() {
		return checkList;
	}

	public void setCheckList(Set<Item> checkList) {
		this.checkList = checkList;
	}

	public Set<Usuario> getMiembros() {
		return miembrosTarea;
	}

	public void setMiembros(Set<Usuario> miembros) {

		this.miembrosTarea = miembros;

	}

	public boolean agregarComentario(Comentario unComentario) {
		return this.comentarios.add(unComentario);
	}

	public boolean eliminarComentario(Comentario unComentario) {
		return this.comentarios.remove(unComentario);
	}

	public boolean agregarItem(Item unItem) {
		return this.checkList.add(unItem);
	}

	public boolean elimiarItem(Item unItem) {
		return this.checkList.remove(unItem);
	}

	public boolean agregarMiembro(Usuario unMiembro) {
		return this.miembrosTarea.add(unMiembro);
	}

	public boolean eliminarMiembro(Usuario unMiembro) {
		return this.miembrosTarea.remove(unMiembro);
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public boolean agregarTag(Tag unTag) {
		return tags.add(unTag);
	}

	public boolean eliminarTag(Tag unTag) {
		return tags.remove(unTag);
	}
	

	public Set<Usuario> getMiembrosTarea() {
		return miembrosTarea;
	}

	public void setMiembrosTarea(Set<Usuario> miembrosTarea) {
		this.miembrosTarea = miembrosTarea;
	}

	public Columna getColumna() {
		return columna;
	}

	public void setColumna(Columna columna) {
		this.columna = columna;
	}

	@Override
	public String toString() {
		return "Tarea [idTarea=" + idTarea + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fecha_asignacion=" + fecha_asignacion + ", fecha_vencimiento=" + fecha_vencimiento + "]";
	}

}
