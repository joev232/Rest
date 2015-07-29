package com.ejemplo.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejemplo.service.EmployeeService;
import com.ejemplo.service.EmployeeServiceServlet;
import com.ejemplo.tablasDTO.Empleadojson;
import com.ejemplo.tablasDTO.Employees;
import com.google.gson.Gson;

@Path("/empleado")
public class Empleado {

	
	
	private  Empleadojson convertirEmpleados(Employees emple)
	{
		Empleadojson emp=null;
		
		emp=new Empleadojson(emple.getFirstName(), emple.getLastName(), emple.getEmail());
		
		return emp;
		
	}
	
	private  List<Empleadojson> convertirListaEmpleados(List<Employees> emple)
	{
		List<Empleadojson> emp= new ArrayList<Empleadojson>();
		Empleadojson eaux = null;
		
		for (Employees empleado : emple) {
			eaux = convertirEmpleados(empleado);
			emp.add(eaux);
			
		}
		
		return emp;
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmpleado(@PathParam("id") String idempleado){
		

		EmployeeService empservice=new EmployeeService();
		
		//String departamentoid= req.getParameter("id");
		int deparid=Integer.parseInt(idempleado);

		
//		emp = (Employees) empservice.leerEmpleado(deparid);
		List<Employees> emple= (List<Employees>) empservice.obtenerEmpleadosPorDepartamento(deparid);
	
		List<Empleadojson> listajson =convertirListaEmpleados(emple);
		Gson gson = new Gson();
		String empleado_json = gson.toJson(listajson);
		return empleado_json;
		
		//System.out.println("Id empleado" +idempleado);
		//return "hola";
	}
	
}
