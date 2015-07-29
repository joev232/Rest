package com.ejemplo.DAO;
import org.hibernate.Session;


public class SuperClaseDAO {
//sesion
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
