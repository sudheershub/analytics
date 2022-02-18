package org.sudheershub.springrest.payroll.norest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	Employee add(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	Employee get(@PathVariable Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " not found"));
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable Long id) {
		 employeeRepository.deleteById(id);
	}
	
}
