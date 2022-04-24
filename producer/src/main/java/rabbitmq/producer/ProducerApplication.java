package rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import rabbitmq.producer.entity.DummyMessage;
import rabbitmq.producer.entity.Employee;
import rabbitmq.producer.entity.Furniture;
import rabbitmq.producer.entity.InvoiceCancelledMessage;
import rabbitmq.producer.entity.InvoiceCreatedMessage;
import rabbitmq.producer.entity.InvoicePaidMessage;
import rabbitmq.producer.entity.Picture;
import rabbitmq.producer.producer.AnotherDummyProducer;
import rabbitmq.producer.producer.DummyProducer;
import rabbitmq.producer.producer.FurnitureProducer;
import rabbitmq.producer.producer.HumanResourcesProducer;
import rabbitmq.producer.producer.InvoiceProducer;
import rabbitmq.producer.producer.MultiplePrefetchProducer;
import rabbitmq.producer.producer.MyPictureProducer;
import rabbitmq.producer.producer.PictureProducer;
import rabbitmq.producer.producer.PictureProducer2;
import rabbitmq.producer.producer.ReliableProducer;
import rabbitmq.producer.producer.RetryEmployeeProducer;
import rabbitmq.producer.producer.SingleActiveProducer;
import rabbitmq.producer.producer.SpringEmployeeProducer;
import rabbitmq.producer.producer.SpringPictureProducer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class ProducerApplication implements CommandLineRunner {
    private final AnotherDummyProducer producer;

    public ProducerApplication(final AnotherDummyProducer producer) {this.producer = producer;}

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    //    private final List<String> COLORS = List.of("white","red","green");
    private final List<String> TYPES = List.of("jpg", "png", "svg");
    //    private final List<String> MATERIALS = List.of("wood","plastic","steel");
    private final List<String> SOURCES = List.of("mobile", "web");

    @Override
    public void run(String... args) throws IOException {
        var dummyMessage = new DummyMessage("This is another dummy message",1);
        producer.sendDummy(dummyMessage);
//        for (int i=0; i<10; i++) {
//            var randomInvoiceNumber = "INV-"+i;
//            var invoiceCancelledMessage = new InvoiceCancelledMessage(LocalDate.now(), randomInvoiceNumber, "Just a test");
//            producer.sendInvoiceCancelled(invoiceCancelledMessage);
//        }

//        var randomInvoiceNumber = "INV-"+ThreadLocalRandom.current().nextInt(100, 200);
//        var invoiceCreatedMessage = new InvoiceCreatedMessage(3152.26, LocalDate.now().minusDays(2),"USD",randomInvoiceNumber);
//        producer.sendInvoiceCreated(invoiceCreatedMessage);
//
//        randomInvoiceNumber = "INV-"+ThreadLocalRandom.current().nextInt(200, 300);
//        var randomPaymentNumber = "PAY-"+ThreadLocalRandom.current().nextInt(800, 1000);
//        var invoicepAIDMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now().minusDays(2), randomPaymentNumber);
//        producer.sendInvoicePaid(invoicepAIDMessage);
//
//        randomInvoiceNumber = "INV-"+ThreadLocalRandom.current().nextInt(300,400);
//        var invoiceCancelledMessage = new InvoiceCancelledMessage(LocalDate.now(), randomInvoiceNumber, "Just a test");
//        producer.sendInvoiceCancelled(invoiceCancelledMessage);
//        for (int i=0; i<5 ; i++){
//        for (int i = 0; i < 500; i++) {
//            System.out.println("i am ok");
//            var dummyMessage = new DummyMessage("Now is" + LocalTime.now(), i);
//            producer.sendDummy(dummyMessage);
//        }
//        producer.simulateScheduler();
//        producer.simulateTransaction();
//        System.out.println("Done");
//            var picture = new Picture();
//            picture.setName("Test spring "+ LocalTime.now());
//            picture.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
//            picture.setSource(SOURCES.get(i % SOURCES.size()));
//            picture.setType(TYPES.get(i % TYPES.size()));
//            producer.sendMessage(picture);

//        }
    }
}
