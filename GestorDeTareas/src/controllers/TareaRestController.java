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

import model.Tarea;
import model.daoHibernateJPA.TareaDaoJPA;

@RestController 
@RequestMapping("/tarea")
public class TareaRestController {
	
	@Autowired
	TareaDaoJPA service; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Tarea> getTarea(@PathVariable("id") long id){
		Tarea tarea = service.recuperar(id);
		if (tarea == null) {
			 System.out.println("Tarea con id: " + id + " no encontrada");
			 return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tarea>(tarea, HttpStatus.OK); //funciona
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTarea(@RequestBody Tarea tarea, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando la tarea " + tarea.getNombre());
		if (service.existe(tarea.getNombre())) {
			System.out.println("Ya existe una tarea con nombre " + tarea.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 service.persistir(tarea);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(tarea.getIdTarea()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
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
		 return new ResponseEntity<Tarea>(currentTarea, HttpStatus.OK); //funciona
	 }
	

}
