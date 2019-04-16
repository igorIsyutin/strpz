package lab.cqrs.consumer.services;

import lab.cqrs.consumer.enteties.Order;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {
    private OrderService orderService;

    public KafkaConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = "orders", groupId = "main")
    public void receiveOrders(ConsumerRecord<String, Order> record){
       log.info(record);
       orderService.processNewOrder(record.value());
    }
}
