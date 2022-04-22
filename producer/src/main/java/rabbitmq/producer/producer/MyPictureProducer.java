package rabbitmq.producer.producer;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;

import rabbitmq.producer.entity.Picture;

@Service
public class MyPictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void sendMessage(Picture picture) throws IOException {
		var json = objectMapper.writeValueAsString(picture);
		rabbitTemplate.convertAndSend("x.mypicture", picture.getType(), json);
	}
	
}
