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

import model.Columna;
import model.Tarea;
import model.daoHibernateJPA.ColumnaDaoJPA;
import model.daoHibernateJPA.TareaDaoJPA;

@RestController 
@RequestMapping("/columnas")
public class ColumnaRestController {
	
	@Autowired
	ColumnaDaoJPA service; 
	@Autowired
	TareaDaoJPA serviceTarea; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Columna> getColumna(@PathVariable("id") long id){
		Columna columna = service.recuperar(id);
		if (columna == null) {
			 System.out.println("Columna con id: " + id + " no encontrada");
			 return new ResponseEntity<Columna>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Columna>(columna, HttpStatus.OK); //error con las tareas de json
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createColumna(@RequestBody Columna columna, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando la columna " + columna.getNombre() );
		/*
		 * if (service.existe(columna.getNombre())) {
			System.out.println("Ya existe una columna con nombre " + columna.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
	
		 service.persistir(columna);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(columna.getIdColumna()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);  //funciona, id_proyecto = null
	}*/
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Columna> updateColumna(@PathVariable("id") long id, @RequestBody Columna columna) {
		 System.out.println("Actualizando el Comentario " + id);
	
		 Columna currentColumna = service.recuperar(id);
	
		 if (currentColumna==null) {
			 System.out.println("Columna with id " + id + " not found");
			 return new ResponseEntity<Columna>(HttpStatus.NOT_FOUND);
		 }
		 currentColumna.setNombre(columna.getNombre());
		 currentColumna.setTareas(columna.getTareas());
		 service.actualizar(currentColumna);
		 return new ResponseEntity<Columna>(currentColumna, HttpStatus.OK); //funciona
	 }
	 @RequestMapping(value = "/{id}/tarea", method = RequestMethod.POST)
		public ResponseEntity<Void> createTarea(@RequestBody Tarea tarea, UriComponentsBuilder ucBuilder,@PathVariable("id") long id) {
			Columna c = service.recuperar(id);
			tarea.setColumna(c);
		 	System.out.println("Creando la tarea " + tarea.getNombre());
			if (service.existe(tarea.getNombre())) {
				System.out.println("Ya existe una tarea con nombre " + tarea.getNombre());
				return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
			 }
			 serviceTarea.persistir(tarea);
			 HttpHeaders headers = new HttpHeaders();
			 headers.setLocation(ucBuilder.path("/tarea/{id}").buildAndExpand(tarea.getIdTarea()).toUri());
			 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
		}
}
