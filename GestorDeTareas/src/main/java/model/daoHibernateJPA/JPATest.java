package model.daoHibernateJPA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Usuario;

public class JPATest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-ctx.xml");
		
		UsuarioDaoJPA usuarioDAO = ctx.getBean("usuarioDaoJPA", UsuarioDaoJPA.class);		
		
		// Se crean 2 usuarios de ejemplo
		Usuario user1 = new Usuario("usuario1","clave","nombre1","apellido1","mail1@ejemplo.com");
		Usuario user2 = new Usuario("usuario2","clave","nombre2","apellido2","mail2@ejemplo.com");
		user1 = usuarioDAO.persistir(user1);
		user2 = usuarioDAO.persistir(user2);
		
		// Probamos recuperarlo
		Usuario usuarioR = usuarioDAO.recuperar(user1.getIdUsuario());
		
		//Probamos Modificarlo
		user1.setNombreUsuario("usuario modificado");
		usuarioDAO.actualizar(user1);

		//Probamos Eliminarlo por id
		usuarioDAO.eliminar((long) 3);

		
	}

}
