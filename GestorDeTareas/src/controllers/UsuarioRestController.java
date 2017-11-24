package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Usuario;
import model.daoHibernateJPA.UsuarioDaoJPA;

@RestController
public class UsuarioRestController {
	
	@Autowired
	UsuarioDaoJPA service = new UsuarioDaoJPA();
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUsuario(long id){
		Usuario user = service.recuperar(id);
		if (user == null) {
			 System.out.println("Usuario con id " + id + " no encontrado");
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
}
