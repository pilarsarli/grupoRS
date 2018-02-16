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
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :usr"); //se pone usuario xq es x la clase no x la tabla
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
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :usr AND u.clave = :clave");
		q.setParameter("usr", usuario);
		q.setParameter("clave", clave);
		Usuario resultado = (Usuario) q.getSingleResult();
		return resultado; 
}
}
