package com.ejemplo.tablasDTO;

public class Empleado {
	
	//atributos 
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private float salary;
	private float commission_pct;
	private int manager_id;
	private int departament_id;
	
	public Empleado(int employee_id, String first_name, String last_name,
			String email, String phone_number, String hire_date, String job_id,
			float salary, float commission_pct, int manager_id,
			int departament_id) {
		//super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.departament_id = departament_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(float commission_pct) {
		this.commission_pct = commission_pct;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getDepartament_id() {
		return departament_id;
	}

	public void setDepartament_id(int departament_id) {
		this.departament_id = departament_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(); //tipo de String más rápido en añadir! 
		sb.append("\nEmployeeID: "+employee_id );
		sb.append("\nFist Name: "+first_name );
		
		
		return sb.toString();
	}

}
