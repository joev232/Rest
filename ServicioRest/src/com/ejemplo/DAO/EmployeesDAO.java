package com.ejemplo.DAO;
import java.util.List;

import com.ejemplo.interfaz.InterfaceEmployeeDAO;
import com.ejemplo.tablasDTO.Employees;


public class EmployeesDAO extends SuperClaseDAO  implements InterfaceEmployeeDAO{

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
	
	public List<Employees> listarempleados(){
		List<Employees> listar=null;
		listar=getSession().createSQLQuery("select * from EMPLOYEES").addEntity(Employees.class).list();
		return listar;
	}

	public List<Employees> listadoPorDepartamento(Object dpto) {
		// TODO Auto-generated method stub
			
			List<Employees> lista = getSession().createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID ="+dpto).addEntity(Employees.class).list();
			//List<Employees> lis=getSession().createSQLQuery(queryString)
			return lista;
	}
}
