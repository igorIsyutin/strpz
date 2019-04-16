package lab.cqrs.consumer.services;

import lab.cqrs.consumer.enteties.Order;

public interface OrderService {
    void processNewOrder(Order order);
}
