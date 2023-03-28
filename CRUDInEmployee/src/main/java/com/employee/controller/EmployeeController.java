package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee){
		
		Employee emp = employeeService.saveEmployee(employee);
		
		return new ResponseEntity<Employee>(emp , HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer empId) {
		
		Employee emp = employeeService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	
	
	@PutMapping("/employee")   // for Update
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee){
		
		Employee emp = employeeService.updateEmployee(newEmployee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	
	
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer stuId){
		
		Employee emp = employeeService.deleteEmployeeById(stuId);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> employee = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.CREATED);
	}
	
	
	

}
