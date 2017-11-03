package model.dao;

import java.util.ArrayList;

import model.*;

public interface TareaDAO {
	
//CRUD para Tareas
	public ArrayList<Tarea> getTareas(Columna c);
	public Tarea getTarea(long id);
	public boolean agregarTarea(Tarea t, Columna c);
	public boolean eliminarTarea(Tarea t);
	public boolean modifiarTarea(Tarea t);
	
// CRUD para Checklist
	public ArrayList<Item> getChecklist(Tarea t);
	public boolean setChecklist(ArrayList<Item> items, Tarea t);
	public boolean agregarItem(Item i, Tarea t);
	public boolean eliminarItem(Item i, Tarea t);
	public boolean modificarItem(Item i);
	
//CRUD para Comentarios
	public ArrayList<Comentario> getComentarios(Tarea t);
	public boolean setComentarios(ArrayList<Comentario> c, Tarea t);
	public boolean agregarComentario(Comentario c, Tarea t);
	public boolean eliminarComentario(Comentario c, Tarea t);
	
//CRUD para miembros de la tarea
	public ArrayList<Usuario> getMiembros(Tarea t);
	public boolean agregarMiembro(Usuario m, Tarea t);
	public boolean eliminarMiembro(Usuario m, Tarea t);
	
	

}
