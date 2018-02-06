package model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="COMENTARIO")
public class Comentario implements java.io.Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idComentario;
	private String cuerpo;
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private Usuario miembro;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name="tarea_id")
	private Tarea tarea;
	
	public Comentario(String cuerpo, Usuario mimebro) {
		this.setCuerpo(cuerpo);
		this.setMiembro(mimebro);
	}
	public Comentario() {}
	
	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(long idComentario) {
		this.idComentario = idComentario;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public Usuario getMiembro() {
		return miembro;
	}
	public void setMiembro(Usuario miembro) {
		this.miembro = miembro;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", cuerpo=" + cuerpo + ", miembro=" + miembro.getNombreUsuario() + ", tarea="
				+ tarea.getNombre() + "]";
	}
	
	

}
