package com.employee.service;

import java.util.List;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;



public interface EmployeeService {
	
    public Employee saveEmployee(Employee  employee)throws EmployeeException;
	
	public Employee  getEmployeeById(Integer id)throws EmployeeException;
	
	public Employee  updateEmployee(Employee  employee)throws EmployeeException;

	public Employee  deleteEmployeeById(Integer empId)throws EmployeeException;
	
	public List<Employee> getAllEmployee()throws EmployeeException;

}
