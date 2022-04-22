package rabbitmq.consumer.scheduler;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import rabbitmq.consumer.client.RabbitmqClient;


@Service
public class RabbitmqScheduler {

	private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);

	private final RabbitmqClient client;
	@Autowired
	public RabbitmqScheduler(final RabbitmqClient client) {this.client = client;}

	@Scheduled(fixedDelay = 90000)
	public void sweepDirtyQueues() {
		try {
			var dirtyQueues = client.getAllQueues().stream().filter(p -> p.isDirty()).collect(Collectors.toList());

			dirtyQueues.forEach(q -> LOG.info("Queue {} has {} unprocessed messages", q.getName(), q.getMessages()));
		} catch (Exception e) {
			LOG.warn("Cannot sweep queue : {}", e.getMessage());
		}
	}

}
