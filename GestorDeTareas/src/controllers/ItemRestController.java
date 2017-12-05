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

import model.Item;
import model.daoHibernateJPA.ItemDaoJPA;

@RestController 
@RequestMapping("/item")
public class ItemRestController {
	@Autowired
	ItemDaoJPA service; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Item> getItem(@PathVariable("id") long id){
		Item item = service.recuperar(id);
		if (item == null) {
			 System.out.println("Item con id: " + id + " no encontrado");
			 return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK); //funciona
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando el item " + item.getDescripcion());
		/*
		 * if (service.existe(item.get())) {
			System.out.println("Ya existe un Tag con nombre " + item.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 */
		 service.persistir(item);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(item.getIdItem()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item item) {
		 System.out.println("Actualizando el tag " + id);
	
		 Item currentItem = service.recuperar(id);
	
		 if (currentItem==null) {
			 System.out.println("Item with id " + id + " not found");
			 return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		 }
		 currentItem.setEstado(item.getEstado());
		 currentItem.setDescripcion(item.getDescripcion());
		
		 service.actualizar(currentItem);
		 return new ResponseEntity<Item>(currentItem, HttpStatus.OK); //funciona
	 }
	

}