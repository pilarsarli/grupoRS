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

import model.Proyecto;
import model.daoHibernateJPA.ProyectoDaoJPA;

@RestController 
@RequestMapping("/proyecto")
public class ProyectoRestController {

	@Autowired
	ProyectoDaoJPA service; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Proyecto> getProyecto(@PathVariable("id") long id){
		Proyecto proyecto = service.recuperar(id);
		if (proyecto == null) {
			 System.out.println("Proyecto con id: " + id + " no encontrado");
			 return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK); //funciona
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createProyecto(@RequestBody Proyecto proyecto, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando proyecto: " + proyecto.getNombre());
		if (service.existe(proyecto.getNombre())) {
			System.out.println("Ya existe un proyecto con nombre " + proyecto.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 service.persistir(proyecto);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(proyecto.getIdProyecto()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Proyecto> updateProyecto(@PathVariable("id") long id, @RequestBody Proyecto proyecto) {
		 System.out.println("Actualizando proyecto " + id);
	
		 Proyecto currentProyecto = service.recuperar(id);
	
		 if (currentProyecto==null) {
			 System.out.println("Proyecto with id " + id + " not found");
			 return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
		 }

		 currentProyecto.setNombre(proyecto.getNombre());
		 currentProyecto.setColumnas(proyecto.getColumnas());
		 currentProyecto.setFecha_inicio(proyecto.getFecha_inicio());
		 currentProyecto.setFecha_estimada(proyecto.getFecha_estimada());
		 currentProyecto.setMiembrosProyecto(proyecto.getMiembrosProyecto());
	
		 service.actualizar(currentProyecto);
		 return new ResponseEntity<Proyecto>(currentProyecto, HttpStatus.OK); //funciona
	 }
	

}
