package lab.cqrs.consumer.services.impl;

import lab.cqrs.consumer.enteties.Event;
import lab.cqrs.consumer.enteties.PositionInOrder;
import lab.cqrs.consumer.repositories.EventRepository;
import lab.cqrs.consumer.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public boolean tryBookSeats(List<PositionInOrder> positions) {
        boolean result = true;
        for (PositionInOrder position : positions) {
            Optional<Event> eventOptional = eventRepository.findById(position.getConcertId());
            if (eventOptional.isPresent()) {
                List<Integer> availableSeats = eventOptional.get().getAvailableSeats();
                if (availableSeats.containsAll(position.getSeatNumbers())) {
                    availableSeats.removeAll(position.getSeatNumbers());
                    eventRepository.save(eventOptional.get());
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public void create(Event event) {
        eventRepository.save(event);
    }
}