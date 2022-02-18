package org.sudheershub.springrest.payroll.norest;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CUSTOMER_ORDER")
public class Order {
	
	enum Status { IN_PROGRESS, COMPLETED, CANCELLED };
	
	private @Id @GeneratedValue Long id; 
	private String description;
	private Status status;
	
	public Order() {
		this(null, null);
	}
	
	public Order(String description, Status status) {
		super();
		this.description = description;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Order)) {
			return false;
		}
		Order order = (Order) other;
		return Objects.equals(id, order.id) && Objects.equals(description, order.description) && Objects.equals(status, order.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, status);
	}

	@Override
	public String toString() {
		return "Order(" + id + " " + description + " " + status;
	}
}
