package rabbitmq.consumer.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;


import com.fasterxml.jackson.databind.ObjectMapper;

import rabbitmq.consumer.entity.Employee;

//@Service
public class EmployeeJsonConsumer {

	@Autowired
	private ObjectMapper objectMapper;
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
	
	@RabbitListener(queues = "course.employee")
	public void listen(String message) throws IOException {
		var employee = objectMapper.readValue(message, Employee.class);
		
		LOG.info("Employee is {}", employee);
	}
	
}
