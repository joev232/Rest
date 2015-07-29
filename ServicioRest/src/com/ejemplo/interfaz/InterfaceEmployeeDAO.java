package com.ejemplo.interfaz;
import java.util.List;

import com.ejemplo.tablasDTO.Employees;


public interface InterfaceEmployeeDAO extends InterfaceDAO {

	
	public List<Employees> listadoPorDepartamento(Object dpto);
}
