package com.JuanPereira.employerManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanPereira.employerManager.exception.UserNotFoundException;
import com.JuanPereira.employerManager.model.Employee;
import com.JuanPereira.employerManager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	// list all employers of repo
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	// update employee
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	//find employee by id
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
	}

	// delete employee
	public void deleteEmployee(Long id) {
		employeeRepository.deleteEmployeeById(id);;
	}
}
