package rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitProducer {
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    public HelloRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHello(String name){
        rabbitTemplate.convertAndSend("course.hello","Hello "+name);
    }
}
