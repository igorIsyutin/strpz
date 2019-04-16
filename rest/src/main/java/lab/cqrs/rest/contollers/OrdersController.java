package lab.cqrs.rest.contollers;

import lab.cqrs.rest.enteties.Order;
import lab.cqrs.rest.services.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrdersController {
    private KafkaProducer kafkaProducer;

    public OrdersController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order){
        kafkaProducer.sendMessage("orders", order);
    }
}
