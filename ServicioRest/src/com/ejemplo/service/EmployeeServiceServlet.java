package com.ejemplo.service;

import com.ejemplo.interfaz.IRecuperable;

public class EmployeeServiceServlet {
	
	IRecuperable recuperable;
	
	//set recuperable para servlet get
		public void setRecuperable(IRecuperable recuperable) {
			this.recuperable = recuperable;
		}
	//
		public Object leerEmpleado(int i){
			Object o=null;
			o=recuperable.leerEmpleado(i);
			return o;
		}
		
}
