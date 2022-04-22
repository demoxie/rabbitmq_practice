package rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rabbitmq.producer.entity.Picture;

@Service
public class PictureProducer2 {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    @Autowired
    public PictureProducer2(final RabbitTemplate rabbitTemplate, final ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Picture picture) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(picture);
        var sb = new StringBuilder();
        sb.append(picture.getSource());
        sb.append(".");
        if(picture.getSize()>4000){
            sb.append("large");
        }else {
            sb.append("small");
        }
        sb.append(".");
        sb.append(picture.getType());

        rabbitTemplate.convertAndSend("x.picture2",sb.toString(),json);

    }

}
