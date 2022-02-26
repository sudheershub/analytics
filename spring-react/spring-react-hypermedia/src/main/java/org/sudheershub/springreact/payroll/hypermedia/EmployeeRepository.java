package org.sudheershub.springreact.payroll.hypermedia;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository  extends PagingAndSortingRepository<Employee, Long> {

}
