//package rabbitmq.consumer.consumer;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import rabbitmq.consumer.entity.Picture;
//
//@Service
//public class PictureConsumer {
//    private final ObjectMapper objectMapper;
//    private static final Logger LOG = LoggerFactory.getLogger(PictureConsumer.class);
//    @Autowired
//    public PictureConsumer(final ObjectMapper objectMapper) {this.objectMapper = objectMapper;}
//
//    @RabbitListener(queues = "q.picture.vector")
//    public void listen(String message) throws JsonProcessingException {
//        var picture = objectMapper.readValue(message, Picture.class);
//        LOG.info("On image : {}",picture);
//    }
//}
