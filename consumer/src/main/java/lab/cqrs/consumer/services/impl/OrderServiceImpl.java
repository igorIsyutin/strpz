package lab.cqrs.consumer.services.impl;

import lab.cqrs.consumer.enteties.Order;
import lab.cqrs.consumer.enteties.Result;
import lab.cqrs.consumer.enteties.ResultType;
import lab.cqrs.consumer.repositories.OrderCache;
import lab.cqrs.consumer.repositories.OrderRepository;
import lab.cqrs.consumer.services.EventService;
import lab.cqrs.consumer.services.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    private OrderCache orderCache;
    private OrderRepository orderRepository;
    private EventService eventService;
    private Executor executor = Executors.newSingleThreadExecutor();

    public OrderServiceImpl(OrderCache orderCache, OrderRepository orderRepository, EventService eventService) {
        this.orderCache = orderCache;
        this.orderRepository = orderRepository;
        this.eventService = eventService;
    }

    @Override
    public void processNewOrder(Order order) {
        if(orderCache.existed(order)){
            order.setResult(Result.builder().type(ResultType.Error).message("Duplicated order").build());
            log.error("Order already existed");
            return;
        } else {
            if(eventService.tryBookSeats(order.getPositions())){
                order.setResult(Result.builder().type(ResultType.Success).message("Everything ok").build());
            } else {
                order.setResult(Result.builder().type(ResultType.Declined).message("Seats are not available").build());
            }
            orderCache.put(order);
        }
        saveInDB(order);
    }

    private void saveInDB(Order order) {
        executor.execute(() -> orderRepository.save(order));
    }
}
