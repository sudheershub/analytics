package org.sudheershub.springrest.tutorials.react;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String description;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee empl = (Employee) o;
		return Objects.equals(id, empl.id) && Objects.equals(firstName, empl.firstName)
				&& Objects.equals(lastName, empl.lastName) && Objects.equals(description, empl.description);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, description);
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
	
	@Override
	public String toString() {
		return "Employee { " + id + " " + firstName + " " + lastName + " " + description + " }"; 
	}
	
}
