package rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rabbitmq.producer.entity.Employee;
import rabbitmq.producer.producer.HumanResourcesProducer;

import java.time.LocalDate;

@SpringBootApplication
//@EnableScheduling
public class ProducerApplication implements CommandLineRunner {
    private final HumanResourcesProducer entityProducer;
    @Autowired
    public ProducerApplication(HumanResourcesProducer entityProducer) {
        this.entityProducer = entityProducer;

    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws JsonProcessingException {
        for(int i=0; i< 5 ; i++){
            var employee = new Employee("Emp"+i, LocalDate.now(), "Employee"+i);
            entityProducer.sendMessage(employee);
        }
    }
}
