package rabbitmq.producer.producer;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;

import rabbitmq.producer.entity.Employee;

@Service
public class RetryEmployeeProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void sendMessage(Employee data) throws IOException {
		var json = objectMapper.writeValueAsString(data);
		
		rabbitTemplate.convertAndSend("x.guideline2.work", "", json);
	}
	
}
