package lab.cqrs.consumer.services;

import lab.cqrs.consumer.enteties.Event;
import lab.cqrs.consumer.enteties.PositionInOrder;

import java.util.List;

public interface EventService {
    boolean tryBookSeats(List<PositionInOrder> positions);

    void create(Event event);
}
