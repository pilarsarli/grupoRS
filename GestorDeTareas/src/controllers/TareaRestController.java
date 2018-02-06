package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import model.Comentario;
import model.Item;
import model.Tarea;
import model.daoHibernateJPA.ComentarioDaoJPA;
import model.daoHibernateJPA.ItemDaoJPA;
import model.daoHibernateJPA.TareaDaoJPA;

@RestController 
@RequestMapping("/tareas")
public class TareaRestController {
	
	@Autowired
	TareaDaoJPA service; 
	@Autowired
	ItemDaoJPA serviceItem;
	@Autowired
	ComentarioDaoJPA serviceComentario;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Tarea> getTarea(@PathVariable("id") long id){
		Tarea tarea = service.recuperar(id);
		if (tarea == null) {
			 System.out.println("Tarea con id: " + id + " no encontrada");
			 return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tarea>(tarea, HttpStatus.OK); //
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTarea(@RequestBody Tarea tarea, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando la tarea " + tarea.getNombre());
		if (service.existe(tarea.getNombre())) {
			System.out.println("Ya existe una tarea con nombre " + tarea.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 service.persistir(tarea);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/tarea/{id}").buildAndExpand(tarea.getIdTarea()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}*/
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Tarea> updateTarea(@PathVariable("id") long id, @RequestBody Tarea tarea) {
		 System.out.println("Actualizando la tarea " + id);
	
		 Tarea currentTarea = service.recuperar(id);
	
		 if (currentTarea==null) {
			 System.out.println("Tarea with id " + id + " not found");
			 return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
		 }

		 currentTarea.setCheckList(tarea.getCheckList());
		 currentTarea.setComentarios(tarea.getComentarios());
		 currentTarea.setDescripcion(tarea.getDescripcion());
		 currentTarea.setNombre(tarea.getNombre());
		 currentTarea.setFecha_vencimiento(tarea.getFecha_vencimiento());
		 currentTarea.setMiembros(tarea.getMiembros());
		 currentTarea.setTags(tarea.getTags());
	
		 service.actualizar(currentTarea);
		 return new ResponseEntity<Tarea>(currentTarea, HttpStatus.OK); //
	 }
	 
	 @RequestMapping(value = "/{id}/item", method = RequestMethod.POST)
		public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder, @PathVariable("id") long id) {
			Tarea t = service.recuperar(id);
			item.setTarea(t);
			System.out.println("Creando el item " + item.getDescripcion());
			/*
			 * if (service.existe(item.get())) {
				System.out.println("Ya existe un Tag con nombre " + item.getNombre());
				return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
			 }
			 */
			serviceItem.persistir(item);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(item.getIdItem()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);  //funciona con tarea_id = NULL
		}
	 
	 @RequestMapping(value = "/{id}/comentario", method = RequestMethod.POST)
	 public ResponseEntity<Void> createColumna(@RequestBody Comentario comentario, UriComponentsBuilder ucBuilder,@PathVariable("id") long id) {
			Tarea t = service.recuperar(id);
			comentario.setTarea(t);
		 	System.out.println("Creando su comentario " );
			/*
			 * if (service.existe(columna.getNombre())) {
				System.out.println("Ya existe una columna con nombre " + columna.getNombre());
				return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
			 }
			 **/
			 serviceComentario.persistir(comentario);
			 HttpHeaders headers = new HttpHeaders();
			 headers.setLocation(ucBuilder.path("/comentario/{id}").buildAndExpand(comentario.getIdComentario()).toUri());
			 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);  //funciona, id_proyecto = null
		}

}
