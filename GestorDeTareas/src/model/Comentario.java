package model;

import javax.persistence.*;
@Entity
@Table(name="COMENTARIO")
public class Comentario implements java.io.Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idComentario;
	private String cuerpo;
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private Usuario miembro;
	@ManyToOne(optional = false)
	@JoinColumn(name="tarea_id")
	private Tarea tarea;
	
	private Comentario(long id, String cuerpo, Usuario mimebro) {
		this.setIdComentario(id);
		this.setCuerpo(cuerpo);
		this.setMiembro(mimebro);
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
	
	

}
