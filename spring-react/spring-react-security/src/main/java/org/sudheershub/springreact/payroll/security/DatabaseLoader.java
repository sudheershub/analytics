package org.sudheershub.springreact.payroll.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	private final EmployeeRepository employeeRepository;
	private final ManagerRepository managerRepository;
	
	public DatabaseLoader(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.managerRepository = managerRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Manager greg = managerRepository.save(new Manager("greg", "greg", "ROLE_MANAGER"));
		Manager olivia = managerRepository.save(new Manager("olivia", "olivia", "ROLE_MANAGER"));
		
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("greg", "password", 
				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

		employeeRepository.save(new Employee("Tom", "Hanks", "DBA", greg));
		employeeRepository.save(new Employee("Steven", "Spelbeg", "Architect", greg));
		employeeRepository.save(new Employee("Matt", "Damon", "Developer", greg));

		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("olivia", "password", 
				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

		employeeRepository.save(new Employee("Morgan", "Freeman", "BA", olivia));
		employeeRepository.save(new Employee("Shah Rukh", "Khan", "Offshore Developer", olivia));
		employeeRepository.save(new Employee("Aamir", "Khan", "Offshore BA", olivia));
		
		SecurityContextHolder.clearContext();
	
	}

}
