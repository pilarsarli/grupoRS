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

import model.Tag;
import model.daoHibernateJPA.TagDaoJPA;

@RestController 
@RequestMapping("/tag")
public class TagRestController {
	@Autowired
	TagDaoJPA service; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Tag> getTag(@PathVariable("id") long id){
		Tag tag = service.recuperar(id);
		if (tag == null) {
			 System.out.println("Tag con id: " + id + " no encontrado");
			 return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tag>(tag, HttpStatus.OK); //funciona
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTag(@RequestBody Tag tag, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando el usuario " + tag.getNombre());
		if (service.existe(tag.getNombre())) {
			System.out.println("Ya existe un Tag con nombre " + tag.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 service.persistir(tag);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(tag.getIdTag()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Tag> updateTag(@PathVariable("id") long id, @RequestBody Tag tag) {
		 System.out.println("Actualizando el tag " + id);
	
		 Tag currentTag = service.recuperar(id);
	
		 if (currentTag==null) {
			 System.out.println("Tag with id " + id + " not found");
			 return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
		 }
		 currentTag.setNombre(tag.getNombre());
	
		 service.actualizar(currentTag);
		 return new ResponseEntity<Tag>(currentTag, HttpStatus.OK); //funciona
	 }
	

}
