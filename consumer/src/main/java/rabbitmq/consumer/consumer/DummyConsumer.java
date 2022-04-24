//package rabbitmq.consumer.consumer;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//
//import rabbitmq.consumer.entity.DummyMessage;
//
//
////@Service
//public class DummyConsumer {
//
//	private static final Logger LOG = LoggerFactory.getLogger(DummyConsumer.class);
//
//	@RabbitListener(queues = "q.dummy")
//	public void listenDummy(DummyMessage message) {
//		LOG.info("Message is {}", message);
//	}
//
//}
