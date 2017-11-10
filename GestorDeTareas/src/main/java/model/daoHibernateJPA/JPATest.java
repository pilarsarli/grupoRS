package model.daoHibernateJPA;
import model.*;
import model.dao.*;

public class JPATest {

	public static void main(String[] args) {
		DAOFactory f = new DAOFactory();
		
		UsuarioDAO user = f.getUsuarioDAO();
		// Se crean 2 usuarios de ejemplo
		Usuario user1 = new Usuario("usuario1","clave","nombre1","apellido1","mail1@ejemplo.com");
		Usuario user2 = new Usuario("usuario2","clave","nombre2","apellido2","mail2@ejemplo.com");
		user1 =  user.guardar(user1);
		user2 =  user.guardar(user2);
		
		
	}

}
