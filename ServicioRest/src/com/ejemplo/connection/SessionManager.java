package com.ejemplo.connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {
	//es publica y estatica y se llama sin necesidad de instanciar
	
	static {
		
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	sesion_factory = configuration.buildSessionFactory(builder.build());
		
	}
	
	private static SessionFactory sesion_factory;
	//solo un session factory y este me generara varias sesiones	
	private SessionManager (){}
	
	public static SessionFactory getSessionFactory ()
	{
		return sesion_factory;
	}
	
	public static Session obtenerSesionNueva ()
	{
		return sesion_factory.openSession();
	}
	
	
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
	}
	
	

}