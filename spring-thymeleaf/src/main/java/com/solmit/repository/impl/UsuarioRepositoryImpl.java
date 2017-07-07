package com.solmit.repository.impl;

import java.util.List;

 
import com.solmit.entidad.Usuario;
import com.solmit.repository.UsuarioRepository;
import com.solmit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl  implements UsuarioRepository {

	
 
	Session session = null;

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
    public Usuario obtenerUsuario(String idUsuario) {
    	session = HibernateUtil.getSessionFactory().openSession();

        return session.get(Usuario.class, idUsuario);  
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
    	session = HibernateUtil.getSessionFactory().openSession();
    
		Query<Usuario> query = session.createQuery("from Usuario");
		return query.getResultList();
	}

	public void eliminar(Usuario usuario) {
    	session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = session.beginTransaction();

		try {
	
			Query q = session.createQuery("delete Usuario   where  idUsuario=:id");
			q.setString("id", usuario.getIdUsuario());	
			  System.out.println(q.executeUpdate());

			transaction.commit();
		} catch (Throwable t) {
			transaction.rollback();
			  throw t;
			}

	}

	public void persistir(Usuario usuario) {
 
		
		session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction(); 
    	session.persist(usuario);
	    session.getTransaction().commit();
	}

	public void actualizar(Usuario usuario) {
    	session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction(); 
		session.merge(usuario);
	    session.getTransaction().commit();
	}

}
