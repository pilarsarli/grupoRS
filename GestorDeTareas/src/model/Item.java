package model;

import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idItem;
	private String descripcion;
	private boolean estado; // True-> finalizada, False-> sin terminar
	@ManyToOne(optional = false)
	@JoinColumn(name="tarea_id")
	private Tarea tarea;
	
	public Item(long id, String descripcion, boolean estado) {
		this.setIdItem(id);
		this.setDescripcion(descripcion);
		this.setEstado(estado);
	}
	
	public Item(long id, String descripcion) {
		this.setIdItem(id);
		this.setDescripcion(descripcion);
		this.setEstado(false);
	}
	
	public long getIdItem() {
		return idItem;
	}
	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
		
}
