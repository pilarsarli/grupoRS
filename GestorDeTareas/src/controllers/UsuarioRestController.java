package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import model.Comentario;
import model.Proyecto;
import model.Tarea;
import model.Usuario;
import model.daoHibernateJPA.ProyectoDaoJPA;
import model.daoHibernateJPA.UsuarioDaoJPA;

@RestController 
@RequestMapping("/usuarios")
public class UsuarioRestController {
	
	@Autowired
	UsuarioDaoJPA service; //spring deberia levantarlo con el autowired, no hace falta el new
	@Autowired
	ProyectoDaoJPA serviceProyecto;
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = "application/json") //tiraba error de la otra forma de json
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id){
		Usuario user = service.recuperar(id);
		if (user == null) {
			 System.out.println("Usuario con id: " + id + " no encontrado");
			 
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		String str = "{"+user.getIdUsuario()+"}+123456";
		HttpHeaders headers = new HttpHeaders();
        headers.set("token", str);
        return new ResponseEntity<Usuario>(headers, HttpStatus.OK);
		//return new ResponseEntity<Usuario>(user, HttpStatus.OK); //funciona
	}
	
	@RequestMapping(value = "/usuario/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Usuario user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando el usuario " + user.getNombreUsuario());
		if (service.existeUsuario(user.getNombreUsuario())) {
			System.out.println("Ya existe un usuario con nombre " + user.getNombreUsuario());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		 }
		 service.persistir(user);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(user.getIdUsuario()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED); //funciona
	}
	
	 @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario user) {
		 System.out.println("Actualizando el usuario " + id);
	
		 Usuario currentUser = service.recuperar(id);
	
		 if (currentUser==null) {
			 System.out.println("User with id " + id + " not found");
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 currentUser.setNombreUsuario(user.getNombreUsuario());
		 currentUser.setNombre(user.getNombre());
		 currentUser.setApellido(user.getApellido());
		 currentUser.setClave(user.getClave());
		 currentUser.setMail(user.getMail()); 
	
		 service.actualizar(currentUser);
		 /*String str = "{"+user.getIdUsuario()+"}+123456";
			HttpHeaders headers = new HttpHeaders();
	        headers.set("token", str);
	        return new ResponseEntity<Usuario>(headers, HttpStatus.OK);*/
		 return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK); //funciona
	 }
	
	 @RequestMapping(value="/autenticacion/", method=RequestMethod.POST)
	 public ResponseEntity<Void> autenticar(@RequestHeader String username, @RequestHeader String clave,UriComponentsBuilder ucBuilder){
		 System.out.println("Autenticando el usuario: " + username );
		 Usuario user = service.autentificacion(username, clave);
		 HttpHeaders headers = new HttpHeaders();
		 if (user == null) {
			 return new ResponseEntity<Void>(headers, HttpStatus.FORBIDDEN);
		 }else {
			 headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(user.getIdUsuario()).toUri());
			 String str = "{"+user.getIdUsuario()+"}+123456";
		     headers.set("token", str);  
			 return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
		 } //funciona
	 }
	 @RequestMapping(value = "/{id}/proyecto", method = RequestMethod.POST)
	 public ResponseEntity<Void> createColumna(@RequestBody Proyecto proyecto, UriComponentsBuilder ucBuilder,@PathVariable("id") long id) {
			Usuario u = service.recuperar(id);
			proyecto.setLider(u);
		 	System.out.println("Creando nuevo proyecto " );
			/*
			 * if (service.existe(columna.getNombre())) {
				System.out.println("Ya existe una columna con nombre " + columna.getNombre());
				return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
			 }
			 **/
			 serviceProyecto.persistir(proyecto);
			 HttpHeaders headers = new HttpHeaders();
			 headers.setLocation(ucBuilder.path("/proyecto/{id}").buildAndExpand(proyecto.getIdProyecto()).toUri());
			 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);  //funciona, id_proyecto = null
		}
}
