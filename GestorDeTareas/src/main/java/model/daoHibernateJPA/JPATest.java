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
<<<<<<< HEAD
		//Usuario user2 = new Usuario("usuario2","clave","nombre2","apellido2","mail2@ejemplo.com");
		user1 =  user.guardar(user1);
		//user2 =  user.guardar(user2);
		//Usuario u = user.recuperar(2);
		//u.setApellido("pilar");
;		//user.actualizar(u);
		//System.out.println(u);

		
/*		TagDAO tagDAO = f.getTagDAO();
		tagDAO.guardar(new Tag("Un nombre"));
		Tag tagEliminar = new Tag();
		tagEliminar.setId(1l);
		tagDAO.eliminar(tagEliminar);
		Tag t2  = tagDAO.recuperar(1);
		System.out.println(t2);
		tag.eliminar(t1);
		System.out.println(t1.getId());*/

=======
		Usuario user2 = new Usuario("usuario2","clave","nombre2","apellido2","mail2@ejemplo.com");
		user1 =  usuarioDAO.guardar(user1);
		user2 = usuarioDAO.guardar(user2);
		
		// Probamos recuperarlo
		Usuario usuarioR = usuarioDAO.recuperar(user1.getIdUsuario());
		
		//Probamos Modificarlo
		user1.setNombreUsuario("usuario modificado");
		usuarioDAO.actualizar(user1);
	
		//Probamos Eliminarlo por id
		usuarioDAO.eliminar(user1.getIdUsuario());
>>>>>>> 195aa8b3d5bf5dc09e60b1847c847462c4ee51d6
		
	}

}
