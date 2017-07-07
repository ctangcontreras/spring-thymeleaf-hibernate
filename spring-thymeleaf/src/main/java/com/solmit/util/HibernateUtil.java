package com.solmit.util;

import java.util.Objects;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.solmit.entidad.Categoria;
import com.solmit.entidad.DetallePedido;
import com.solmit.entidad.Pedido;
import com.solmit.entidad.Producto;
import com.solmit.entidad.Rol;
import com.solmit.entidad.Usuario;
import com.solmit.entidad.UsuarioRol;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory() {
    	
    	if (Objects.isNull(sessionFactory)){
    		Configuration configuration = new Configuration();
    		configuration.configure();
    		
    		configuration.addAnnotatedClass(Usuario.class);
    		configuration.addAnnotatedClass(Rol.class);
    		configuration.addAnnotatedClass(UsuarioRol.class);
    		configuration.addAnnotatedClass(Pedido.class);
    		configuration.addAnnotatedClass(DetallePedido.class);
    		configuration.addAnnotatedClass(Categoria.class);
    		configuration.addAnnotatedClass(Producto.class);
    		
    		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	}
        return sessionFactory;
    }
}
