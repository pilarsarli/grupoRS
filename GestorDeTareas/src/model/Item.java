package model;

import javax.persistence.*;

//@Entity
//@Table(name="ITEM")

public class Item implements java.io.Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idItem;
	private String descripcion;
	private boolean estado; // True-> finalizada, False-> sin terminar
	@ManyToOne(optional = false)
	@JoinColumn(name="tarea_id")
	private Tarea tarea;
	
	public Item(String descripcion, boolean estado) {
		this.setDescripcion(descripcion);
		this.setEstado(estado);
	}
	public Item() {}
	
	
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

	@Override
	public String toString() {
		String estado;
		if (this.estado) {
			estado = "Terminado";
		}else {estado="Sin terminar";}
		return "Item [idItem=" + idItem + ", descripcion=" + descripcion + ", estado=" + estado + ", tarea=" + tarea.getNombre()
				+ "]";
	}
	
	
		
}
