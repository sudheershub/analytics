package org.sudheershub.springreact.payroll.security;

import static org.sudheershub.springreact.payroll.security.WebSocketConfiguration.MESSAGE_PREFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Employee.class)
public class EventHandler {

	private final SimpMessagingTemplate websocket;

	private final EntityLinks entityLinks;

	@Autowired
	public EventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
		this.websocket = websocket;
		this.entityLinks = entityLinks;
	}

	@HandleAfterCreate
	public void newEmployee(Employee employee) {
		convertAndSend("/newEmployee", employee);
	}

	@HandleAfterDelete
	public void deleteEmployee(Employee employee) {
		convertAndSend("/deleteEmployee", employee);
	}

	@HandleAfterSave
	public void updatemployee(Employee employee) {
		convertAndSend("/updateEmployee", employee);
	}
	
	private void convertAndSend(String path, Employee employee) {
		websocket.convertAndSend(MESSAGE_PREFIX + path,
				entityLinks.linkForItemResource(employee.getClass(), 
						employee.getId()).toUri().getPath());
	}

}

