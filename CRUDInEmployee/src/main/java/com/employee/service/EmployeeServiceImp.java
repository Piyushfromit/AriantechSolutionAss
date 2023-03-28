package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;



@Service
public class EmployeeServiceImp  implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		
		if( employee == null) {
			throw new EmployeeException("Enployee data Is missing");
		}else {
			employeeRepository.save(employee);
		}
		return employee;
	}


	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.orElseThrow(() -> new EmployeeException("Employee not found"));
	}
	


	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		Optional<Employee> opt = employeeRepository.findById(employee.getEmpId());
		if (opt.isPresent()) {
			employeeRepository.save(employee);
			
		} else {
			throw new EmployeeException("Customer not found");
		}
		return employee;
	}
	
    @Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
    	Optional<Employee> opt =  employeeRepository.findById(empId);
		if (opt.isPresent()) {
			employeeRepository.delete(opt.get());
		} else {
			throw new EmployeeException("Customer not found");
		}
		return opt.get();
	}


	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		   // TODO Auto-generated method stub
			List<Employee> list = employeeRepository.findAll();
			if (list.size() == 0) {
				throw new EmployeeException("No any Student Found");
			}
			return list;
	}
	
	
	

}
