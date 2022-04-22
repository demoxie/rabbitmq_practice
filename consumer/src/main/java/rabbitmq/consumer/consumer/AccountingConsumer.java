//package rabbitmq.consumer.consumer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import rabbitmq.consumer.entity.Employee;
//
//import java.io.IOException;
//
//
//@Service
//public class AccountingConsumer {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    private final ObjectMapper objectMapper;
//    private static final Logger LOG = LoggerFactory.getLogger(FixedRateConsumer.class);
//    @Autowired
//    public AccountingConsumer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.objectMapper = objectMapper;
//    }
//    @RabbitListener(queues="q.hr.accounting")
//    public void listen(String message) throws IOException {
//        var employee = objectMapper.readValue(message, Employee.class);
//        LOG.info("The employe on accounting {}",employee);
//    }
//
//}
