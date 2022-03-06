package org.sudheershub.springreact.payroll.versioning;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String description;

	private @Version @JsonIgnore Long version;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
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

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Employee employee = (Employee) other;
		return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName)
				&& Objects.equals(lastName, employee.lastName) && Objects.equals(description, employee.description)
				&& Objects.equals(version, employee.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, description, version);
	}
	
	@Override
	public String toString() {
		return "Employee {" + id + " " + firstName + " " + lastName + " " + description + " " + version + "}";
	}
}
