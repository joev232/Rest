package com.ejemplo.service;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



//import org.apache.logging.log4j.*;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.DAO.DepartmentsDAO;
import com.ejemplo.DAO.EmployeesDAO;
import com.ejemplo.connection.Pool;
import com.ejemplo.connection.SessionManager;
import com.ejemplo.tablasDTO.Departments;
import com.ejemplo.tablasDTO.Empleado;
import com.ejemplo.tablasDTO.Employees;


import com.ejemplo.interfaz.*;

public class EmployeeService  {
	
	//private static Logger log = Logger.getLogger("mylog");
	private  final Logger log = LogManager.getRootLogger();
	
	
	 IRecuperable recuperable;
	
	EmployeesDAO employeesDAO=new EmployeesDAO();
	DepartmentsDAO departmentsDAO=new DepartmentsDAO();
	
	public EmployeeService() {
	// TODO Auto-generated constructor stub
	this.employeesDAO=new EmployeesDAO();
	this.departmentsDAO=new DepartmentsDAO();
	
}
	
	/**
	 * 
	 * @return incrementa salario de todos los empleados
	 */
	public boolean incrementarSalario(){
		//session.obtenerSesionNueva();
		
		boolean incremento = false;
		Session session=null;
		Transaction transaction=null;
		List<Employees> listaempleados=null;
		
	try {
		//SessionManager session = null;
		session =  SessionManager.obtenerSesionNueva();
		//empiezo mi transaccion(si algo sale mal hago un rollback en el try)
		transaction=session.beginTransaction();
		//voy empezar a trabajar con bd asigno una session a employeDAO //lee de superclase
		employeesDAO.setSession(session);
		//listaempleados de la base de datos
		listaempleados=employeesDAO.listarempleados();
		//Iterator<E> mejor hacerlo en un nuevo metodo
		
		//llamarlo 
		actualizarSalario(listaempleados);
		transaction.commit();
		incremento=true;
		//System.out.println();
	} catch (Exception e) {
		// TODO: handle exception
		//falta usar el log
		log.error("Error al recuperar la base de datos"+e);
		transaction.rollback();
		e.printStackTrace();
	}	finally{
		SessionManager.cerrarSession(session);
	}
		return incremento;
	}
	/**
	 * 
	 * @param lista_e
	 * return aumenta salario
	 */
	private void actualizarSalario(List<Employees> lista_e){
		//recorrer la lista para poder actualizar con iterator o for
		// estado seria persistent 
		for (Employees emp : lista_e) {
			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.20) ));
		}
	}
	/**
	 * 
	 * @return empleado con mayor salario de cada departamento
	 */
		public List<Employees> mejorPagadoxDepartamento(){
		
			Transaction transaction = null;	 
	 		Session session = null; 
	 		List<Employees> listamaspagado = new ArrayList<Employees>();
	 		List<Departments> listadepartamento = new ArrayList<Departments>();  
	 		try 
	 		{ 
	 			session= SessionManager.obtenerSesionNueva();
	 			employeesDAO.setSession(session);
	 			transaction=employeesDAO.getSession().beginTransaction();
	 			
	 			List<Departments> lista=new ArrayList<Departments>();
	 			lista=leerDepartamento();
	 			
	 			//listadepartamento=leerDepartamento();
	 			
	 			for(Departments departamento:listadepartamento){
	 				listamaspagado.add(obtenerMasGana(departamento));
	 			}
	 			System.out.println(listamaspagado);
	 		} 
	 		catch (Exception e) 
			{ 
	 			log.error("Error al recuperar mejorpagado"+e);
	 			e.printStackTrace(); 
	 			transaction.rollback(); 
	 		} 
	 		finally 
	 		{ 
	 			SessionManager.cerrarSession(session);
	 			 
	 		} 
	 		 return listamaspagado; 
	 	} 
		private Employees obtenerMasGana(Departments dpto){
			Employees empleadomasgana = null;
			BigDecimal mayor = new BigDecimal (0);
			List<Employees> listaremp = new ArrayList<Employees>();
			listaremp = employeesDAO.listadoPorDepartamento(dpto); 
			for (Employees emp : listaremp) 
			{
				//salario mayor por departamento
				if (emp.getSalary().intValue() >  mayor.intValue())
				{
					mayor = emp.getSalary();
					empleadomasgana = emp;
				}
			}
			return empleadomasgana;
			
		}
		/**
		 * 
		 * @return recupero la lista de departamentos
		 */
		private List<Departments> leerDepartamento(){
			List<Departments> departa=departmentsDAO.listarDepartamentos();
			return departa;
		}
		/**
		 * 
		 * @param dpto
		 * @return empleados por departamentos
		 */
		public List<Employees> obtenerEmpleadosPorDepartamento(Object dpto)
		{
			List <Employees> listempdepartamento = new ArrayList<Employees>();
			Transaction transaction = null;	
			Session session = null;
			try
			{
				session = SessionManager.obtenerSesionNueva();
				employeesDAO.setSession(session);
				transaction = employeesDAO.getSession().beginTransaction();
				listempdepartamento = employeesDAO.listadoPorDepartamento(dpto);
			}
			catch (Exception e)
			{
				log.error("Error al recuperar object dpto"+e);
				e.printStackTrace();
				transaction.rollback();
			}
			finally
			{
				session.close();
			}
			return listempdepartamento;
		}
		
		
		
		
}

