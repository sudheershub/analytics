package org.sudheershub.springrest.payroll.norest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(final EmployeeRepository repository) {
		return args -> {
			log.info("preloading " + repository.save(new Employee("Bilbo", "Pollce")));
			log.info("preloading " + repository.save(new Employee("Frodo", "Thief")));
		};
	}

}
