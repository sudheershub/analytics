package org.sudheershub.springrest.payroll.norest;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Employee {
	
	private @Id @GeneratedValue Long id;
	private String name;
	private String role;
	
	public Employee() {
		name = null;
		role = null;
	}
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object other) {
		
		if (this == other) {
			return true;
		}
		if (!(other instanceof Employee) ) {
			return false;
		}
		Employee employee = (Employee) other;
		return Objects.equals(this.id, employee.id) 
				&& Objects.equals(this.name, employee.name) 
				&& Objects.equals(this.role, employee.role);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}

}
