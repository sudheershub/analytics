package org.sudheershub.springrest.payroll.norest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sudheershub.springrest.payroll.norest.Order.Status;

@RestController
public class OrderController {
	
	private OrderRepository orderRepository;
	private OrderModelAssembler orderModelAssembler;
	
	public OrderController(OrderRepository orderRepository, OrderModelAssembler orderModelAssembler) {
		super();
		this.orderRepository = orderRepository;
		this.orderModelAssembler = orderModelAssembler;
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	CollectionModel<EntityModel<Order>> all() {
		
		List<EntityModel<Order>> orders = orderRepository.findAll().stream().map(orderModelAssembler::toModel).collect(Collectors.toList());
		
		return CollectionModel.of(orders, linkTo(methodOn(OrderController.class).all()).withSelfRel());
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	EntityModel<Order> one(@PathVariable Long id) {
		
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " not found"));
		return orderModelAssembler.toModel(order);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order) {
		order.setStatus(Status.IN_PROGRESS);
		Order savedOrder = orderRepository.save(order);
		return ResponseEntity.created(linkTo(methodOn(OrderController.class)
				.one(savedOrder.getId())).toUri()).body(orderModelAssembler.toModel(savedOrder));
	}
	
	@RequestMapping(value = "orders/{id}/cancel", method = RequestMethod.DELETE)
	ResponseEntity<?> cancel(@PathVariable Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " not found"));
		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.CANCELLED);
			return ResponseEntity.ok(orderModelAssembler.toModel(orderRepository.save(order)));
		}
		//not valid as order is not in progress
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
				.body(Problem.create().withTitle("Method not allowed").withDetail("cannot cancel order with status " + order.getStatus()));
	}
	
	@RequestMapping(value = "/orders/{id}/complete")
	ResponseEntity<?> complete(@PathVariable Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " not found"));
		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.COMPLETED);
			return ResponseEntity.ok(orderModelAssembler.toModel(orderRepository.save(order)));
		}
		//not valid as order is not in progress
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
				.body(Problem.create().withTitle("Method not allowed").withDetail("cannot complete order with status " + order.getStatus()));
	}
}
