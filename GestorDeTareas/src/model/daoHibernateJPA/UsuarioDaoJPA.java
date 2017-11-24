package model.daoHibernateJPA;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Usuario;
import model.dao.UsuarioDAO;

@Repository("usuarioDaoJPA")
public class UsuarioDaoJPA extends GenericDaoHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDaoJPA() {
		super(Usuario.class);
		
	}
	public boolean existeUsuario(String username) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT * FROM USUARIO WHERE nombreUsuario = :usr");
		q.setParameter("usr", username);
		List<Usuario> resultado = (List<Usuario>) q.getResultList();
		if(resultado.size()!=0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public Usuario autentificacion(String usuario, String clave) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT * FROM USUARIO WHERE nombreUsuario = :usr AND clave = :clave");
		q.setParameter("usr", usuario);
		q.setParameter("clave", clave);
		List<Usuario> resultado = (List<Usuario>) q.getResultList();
		if(resultado.size()!=0){
			long id= resultado.get(0).getIdUsuario();
			return (this.recuperar(id)); //recupera el usuario y lo retorna
		}
		else{
			return null;
		}
	}

}
