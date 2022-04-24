package rabbitmq.consumer.scheduler;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import rabbitmq.consumer.client.RabbitmqClient;


@Service
@EnableScheduling
public class RabbitmqScheduler {

	private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);

//	private final RabbitmqClient client;
//	@Autowired
//	public RabbitmqScheduler(final RabbitmqClient client) {this.client = client;}
//
//	@Scheduled(fixedDelay = 90000)
//	public void sweepDirtyQueues() {
//		try {
//			var dirtyQueues = client.getAllQueues().stream().filter(p -> p.isDirty()).collect(Collectors.toList());
//
//			dirtyQueues.forEach(q -> LOG.info("Queue {} has {} unprocessed messages", q.getName(), q.getMessages()));
//		} catch (Exception e) {
//			LOG.warn("Cannot sweep queue : {}", e.getMessage());
//		}
//	}

    private RabbitListenerEndpointRegistry registry;
    @Autowired
    public RabbitmqScheduler(final RabbitListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    @Scheduled(cron = "1 0 0 * * *")
    public void stopAll(){
        registry.getListenerContainers().forEach(c->{
            LOG.info("Stopping listener container {}",c);
            c.stop();
        });
    }

    @Scheduled(cron = "1 0 0 * * *")
    public void startAll(){
        registry.getListenerContainers().forEach(c->{
            LOG.info("Starting listener container {}",c);
            c.start();
        });
    }

}
