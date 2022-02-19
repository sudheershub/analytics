package org.sudheershub.springrest.tutorials.react;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

}
