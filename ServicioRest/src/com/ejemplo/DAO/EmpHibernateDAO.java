package com.ejemplo.DAO;




import org.hibernate.Session;

import com.ejemplo.connection.SessionManager;
import com.ejemplo.interfaz.IRecuperable;
import com.ejemplo.tablasDTO.Employees;

public class EmpHibernateDAO implements IRecuperable{
	
	
	IRecuperable recuperable;
	Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	public void setRecuperable(IRecuperable recuperable) {
		this.recuperable = recuperable;
	}

//Session session;
public Object leerEmpleado(int n) {
		// TODO Auto-generated method stub
		//sessionmanager  obtener session
	Object empleado=null;
		try {
			
			session=SessionManager.obtenerSesionNueva();
			empleado=session.get(Employees.class, n);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
		return empleado;
	}

}
