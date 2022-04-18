package org.sudheershub.springreact.payroll.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component @RepositoryEventHandler(Employee.class)
public class SpringDataRestEventHandler {
	
	private final ManagerRepository managerRepository;

	@Autowired
	public SpringDataRestEventHandler(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}
	
	@HandleBeforeSave 
	@HandleBeforeCreate
	public void applyUserInfoUsingSecurityContext(Employee employee) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Manager manager = managerRepository.findByName(name);
		if (manager == null) {
			Manager newManager = new Manager();
			newManager.setName(name);
			newManager.setRoles(new String[] {"ROLE_MANAGER"});
			manager = managerRepository.save(newManager);
		}
		employee.setManager(manager);
	}

}
