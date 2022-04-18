package org.sudheershub.springreact.payroll.security;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String description;
	private @Version @JsonIgnore Long version;

	private @ManyToOne Manager manager;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String description, Manager manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.manager = manager;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof Employee)) {
			return false;
		}
		Employee emp = (Employee) o;

		return Objects.equals(id, emp.id) && Objects.equals(firstName, emp.firstName)
				&& Objects.equals(lastName, emp.lastName) && Objects.equals(description, emp.description)
				&& Objects.equals(manager, emp.manager);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, description, manager);
	}
	
	@Override
	public String toString() {
		return Objects.toString(version, " ");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	

}
