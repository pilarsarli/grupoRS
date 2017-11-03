package model;

public class Comentario {
	
	private long idComentario;
	private String cuerpo;
	private Usuario miembro;
	
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
