package com.ejemplo.DAO;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.connection.SessionManager;
import com.ejemplo.interfaz.InterfaceDAO;
import com.ejemplo.tablasDTO.Departments;


public class DepartmentsDAO extends SuperClaseDAO implements InterfaceDAO{

	public Object create(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object read(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Departments> listarDepartamentos(){
				
		SessionManager sesession;
		
		List<Departments> listar =  getSession().createSQLQuery("SELECT DEPARTMENT_ID FROM DEPARTMENTS").addEntity(Departments.class).list();
		return listar;
	}

}
