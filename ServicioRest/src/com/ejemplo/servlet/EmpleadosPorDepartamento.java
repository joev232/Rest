package com.ejemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.service.EmployeeService;
import com.ejemplo.tablasDTO.Employees;

public class EmpleadosPorDepartamento extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeService empservice=new EmployeeService();
//		req.getAttribute("departamentoid");
//		List<Employees> emple= empservice.obtenerEmpleadosPorDepartamento("departamentoid");
		
		String departamentoid= req.getParameter("departamentoid");
		int deparid=Integer.parseInt(departamentoid);
		List<Employees> emple= empservice.obtenerEmpleadosPorDepartamento(deparid);
//		
//		
//		resp.setContentType("text/html");
//		PrintWriter out=resp.getWriter();
//		
//		for (Employees employees : emple) {
//			employees.getFirstName();
//			out.println("Nombre:"+employees.getFirstName()+"<br>");
//			out.println("Apellidos:"+employees.getLastName()+"<br>");
//		}
		
		
		req.setAttribute("listaempleados", emple);
		req.getRequestDispatcher("vistadepartamento.jsp").forward(req, resp);
		//super.doGet(req, resp);
	}

}
