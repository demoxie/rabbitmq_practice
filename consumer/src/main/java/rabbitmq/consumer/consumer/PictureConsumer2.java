//package rabbitmq.consumer.consumer;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import rabbitmq.consumer.entity.Picture;
//
//@Service
//public class PictureConsumer2 {
//    private final ObjectMapper objectMapper;
//    private static final Logger LOG = LoggerFactory.getLogger(PictureConsumer2.class);
//    @Autowired
//    public PictureConsumer2(final ObjectMapper objectMapper) {this.objectMapper = objectMapper;}
//
//    @RabbitListener(queues = {"q.picture.image","q.picture.vector","q.picture.log","q.picture.filter"})
//    public void listen(Message message) throws IOException {
//        var jsonString = new String(message.getBody());
//        var picture = objectMapper.readValue(jsonString, Picture.class);
//        LOG.info("Consuming picture : {} with routing key : {}",picture,message.getMessageProperties().getReceivedRoutingKey());
//    }
//}
