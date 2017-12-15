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
import model.daoHibernateJPA.ComentarioDaoJPA;

@RestController 
@RequestMapping("/comentarios")
public class ComentarioRestController {
	
	@Autowired
	ComentarioDaoJPA service; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Comentario> getComentario(@PathVariable("id") long id){
		Comentario comentario = service.recuperar(id);
		if (comentario == null) {
			 System.out.println("Comentario con id: " + id + " no encontrado");
			 return new ResponseEntity<Comentario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Comentario>(comentario, HttpStatus.OK); //funciona
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createComentario(@RequestBody Comentario comentario, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando el comentario");
		/*
		 * if (service.existe(item.get())) {
			System.out.println("Ya existe un Tag con nombre " + item.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 */
		 service.persistir(comentario);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(comentario.getIdComentario()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	// !??? se puede actualizar un comentario ??
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Comentario> updateComentario(@PathVariable("id") long id, @RequestBody Comentario comentario) {
		 System.out.println("Actualizando el Comentario " + id);
	
		 Comentario currentComentario = service.recuperar(id);
	
		 if (currentComentario==null) {
			 System.out.println("Coment with id " + id + " not found");
			 return new ResponseEntity<Comentario>(HttpStatus.NOT_FOUND);
		 }
		 currentComentario.setCuerpo(comentario.getCuerpo());
		 service.actualizar(currentComentario);
		 return new ResponseEntity<Comentario>(currentComentario, HttpStatus.OK); //funciona
	 }
}
