package model;

public class Item {
	
	private long idItem;
	private String descripcion;
	private boolean estado; // True-> finalizada, False-> sin terminar
	
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
