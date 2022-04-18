package org.sudheershub.springreact.payroll.security;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	@SuppressWarnings("unchecked")
	@Override @PreAuthorize("#employee?.manager == null  or #employee?.manager?.name == authentication?.name")
	Employee save(Employee employee);
	
	@Override @PreAuthorize("#employee?.manager == null  or #employee?.manager?.name == authentication?.name")
	void deleteById(Long id);
	
	@Override @PreAuthorize("#employee?.manager == null  or #employee?.manager?.name == authentication?.name")
	void delete(Employee employee);

}
