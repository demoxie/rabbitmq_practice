package rabbitmq.producer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitmq.producer.entity.Employee;

@Service
public class HumanResourcesProducer {

    private final RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper;
    @Autowired
    public HumanResourcesProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Employee data) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(data);
        rabbitTemplate.convertAndSend("x.hr","",json);
    }

}
