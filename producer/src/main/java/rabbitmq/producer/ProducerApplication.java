package rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import rabbitmq.producer.entity.Employee;
import rabbitmq.producer.entity.Furniture;
import rabbitmq.producer.entity.Picture;
import rabbitmq.producer.producer.FurnitureProducer;
import rabbitmq.producer.producer.HumanResourcesProducer;
import rabbitmq.producer.producer.MyPictureProducer;
import rabbitmq.producer.producer.PictureProducer;
import rabbitmq.producer.producer.PictureProducer2;
import rabbitmq.producer.producer.RetryEmployeeProducer;
import rabbitmq.producer.producer.SpringPictureProducer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication implements CommandLineRunner {
    private final SpringPictureProducer producer;

    public ProducerApplication(final SpringPictureProducer producer) {this.producer = producer;}

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

//    private final List<String> COLORS = List.of("white","red","green");
private final List<String> TYPES = List.of("jpg","png","svg");
//    private final List<String> MATERIALS = List.of("wood","plastic","steel");
private final List<String> SOURCES = List.of("mobile","web");
    @Override
    public void run(String... args) throws IOException {
        for (int i=0; i<10 ; i++){
            var picture = new Picture();
            picture.setName("Test spring "+ LocalTime.now());
            picture.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
            picture.setSource(SOURCES.get(i % SOURCES.size()));
            picture.setType(TYPES.get(i % TYPES.size()));
            producer.sendMessage(picture);

        }
    }
}
