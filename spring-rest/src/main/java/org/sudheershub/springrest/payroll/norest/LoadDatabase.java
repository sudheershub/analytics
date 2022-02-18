package org.sudheershub.springrest.payroll.norest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sudheershub.springrest.payroll.norest.Order.Status;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(final EmployeeRepository repository, 
			final OrderRepository orderRepository) {
		return args -> {
			log.info("preloading " + repository.save(new Employee("Bilbo", "Pollce")));
			log.info("preloading " + repository.save(new Employee("Frodo", "Thief")));
			
			orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
			orderRepository.save(new Order("iPhone XR", Status.IN_PROGRESS));
			
			orderRepository.findAll().forEach(order -> {
				log.info("preloaded order : " + order);
			});
		};
	}

}
