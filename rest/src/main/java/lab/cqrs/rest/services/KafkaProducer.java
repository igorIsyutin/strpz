package lab.cqrs.rest.services;

import lab.cqrs.rest.enteties.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Order order){
        kafkaTemplate.send(topic, order);
    }
}
