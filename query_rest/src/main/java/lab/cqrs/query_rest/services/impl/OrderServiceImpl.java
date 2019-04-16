package lab.cqrs.query_rest.services.impl;

import lab.cqrs.query_rest.enteties.Order;
import lab.cqrs.query_rest.repository.OrderCache;
import lab.cqrs.query_rest.repository.OrderRepository;
import lab.cqrs.query_rest.services.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private OrderCache orderCache;

    public OrderServiceImpl(OrderRepository repository, OrderCache orderCache) {
        this.repository = repository;
        this.orderCache = orderCache;
    }

    @Override
    public Order getByOwnerAndDate(String owner, LocalDateTime date) {
        Order order = new Order();
        order.setDate(date);
        order.setOwner(owner);
        if (orderCache.existed(order)) {
            log.info("Order from cache");
            return orderCache.get(order);
        } else {
            order = repository.getAllByOwnerAndDate(owner, date);
            if (order != null)
                orderCache.put(order);
            log.info("Order from db");
            return order;
        }
    }
}