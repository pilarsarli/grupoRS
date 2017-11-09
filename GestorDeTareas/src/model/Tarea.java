package model;
import java.util.Date;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name="TAREA")
public class Tarea implements java.io.Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idTarea;
	private String nombre;
	private String descripcion;
	private Date fecha_asignacion;
	private Date fecha_vencimiento;
	@ManyToMany (mappedBy="tags") 
	private ArrayList<Tag> tags;
	@OneToMany(mappedBy="comentarios",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private ArrayList<Comentario> comentarios;
	@OneToMany(mappedBy="checklist",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private ArrayList<Item> checkList;
	@ManyToMany (mappedBy="miembros_tarea")
	private ArrayList<Usuario> miembros;
	@ManyToOne(optional = false)
	@JoinColumn(name="columna_id")
	private Columna columna;
	
	public Tarea(long id, String nombre, String descripcion, Date fa, Date fv, String estado) {
		this.setIdTarea(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setFecha_asignacion(fa);
		this.setFecha_vencimiento(fv);
		this.setComentarios(new ArrayList<Comentario>());
		this.setCheckList(new ArrayList<Item>());
		this.setMiembros(new ArrayList<Usuario>());
	}
	
	

	public Tarea(String nombre, String descripcion, Date fa, Date fv,String tag) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setFecha_asignacion(fa);
		this.setFecha_vencimiento(fv);
		this.setComentarios(new ArrayList<Comentario>());
		this.setCheckList(new ArrayList<Item>());
		this.setMiembros(new ArrayList<Usuario>());
		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(new Tag(tag));
		this.setTags(tags);
	}
	
	public long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(long idTarea) {
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
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public ArrayList<Item> getCheckList() {
		return checkList;
	}
	public void setCheckList(ArrayList<Item> checkList) {
		this.checkList = checkList;
	}
	public ArrayList<Usuario> getMiembros() {
		return miembros;
	}
	public void setMiembros(ArrayList<Usuario> miembros) {
		this.miembros = miembros;
	}
	
	public boolean agregarComentario(Comentario unComentario) {
		return this.comentarios.add(unComentario);
	}
	
	public boolean eliminarComentario (Comentario unComentario) {
		return this.comentarios.remove(unComentario);
	}
	
	public boolean agregarItem(Item unItem) {
		return this.checkList.add(unItem);
	}
	public boolean elimiarItem(Item unItem) {
		return this.checkList.remove(unItem);
	}
	public boolean agregarMiembro(Usuario unMiembro) {
		return this.miembros.add(unMiembro);
	}
	public boolean eliminarMiembro(Usuario unMiembro) {
		return this.miembros.remove(unMiembro);
	}
	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	
	public boolean agregarTag(Tag unTag) {
		return tags.add(unTag);
	}
	public boolean eliminarTag(Tag unTag) {
		return tags.remove(unTag);
	}



	@Override
	public String toString() {
		return "Tarea [idTarea=" + idTarea + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fecha_asignacion=" + fecha_asignacion + ", fecha_vencimiento=" + fecha_vencimiento + "]";
	}
	
	

}
