package model.daoHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usuario;
import model.dao.UsuarioDAO;

public class UsuarioDaoJPA extends GenericDaoHibernateJPA<Usuario> implements UsuarioDAO {

	@Override
	public Usuario autentificacion(String usuario, String clave) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT p FROM USUARIO p WHERE p.nombreUsuario = :usr AND p.clave = :clave");
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
