package rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rabbitmq.producer.entity.DummyMessage;


@Service
public class AnotherDummyProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendDummy(DummyMessage message) {
		rabbitTemplate.convertAndSend("x.another-dummy", "", message);
	}
	
}
