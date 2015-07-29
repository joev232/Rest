package com.ejemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;


import com.ejemplo.connection.SessionManager;
import com.ejemplo.tablasDTO.Departments;


public class ListaDepartamento extends HttpServlet  {
	
	private final Logger log=LogManager.getRootLogger();
	private int nveces;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		nveces++;
		log.info(nveces);
		
		//esto hacerlo en el dao de lista departamento
		Session session=SessionManager.obtenerSesionNueva();
		List<Departments> ld=session.createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list();
		Departments d=null;
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		
		pw.println("<form action=\"EmpleadosPorDepartamento\" method=\"get\">");
		pw.println("<select name=\"departamentoid\">");
		Iterator it=ld.iterator();
		while(it.hasNext()){
			d=(Departments) it.next();
			pw.println("<option value="+d.getDepartmentId()+">"+d.getDepartmentName()+"</option>");
		}
		pw.println("</select>");
		pw.println("<br><br>");
		
		

		
		pw.println("<input type=\"submit\" value=\"Enviar\"/>");
		//desarrollo la vista para mostrar los empleados del departamento seleccionado
		//req.setAttribute("departamento", d.getDepartmentId());
		
		//log.info("codigo elegido es:"+d.getDepartmentId());
		pw.println("</form>");
		

		//comento el ejemplo de include
		//req.getRequestDispatcher("/ServletUsuariosActivos").include(req, resp);
		
		

		//req.getRequestDispatcher("/vistadepartamento.jsp").forward(req, resp);
		
		//super.doGet(req, resp);
	}

}
