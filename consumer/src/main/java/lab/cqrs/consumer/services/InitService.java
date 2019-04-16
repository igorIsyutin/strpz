package lab.cqrs.consumer.services;

import lab.cqrs.consumer.enteties.Event;
import lab.cqrs.consumer.services.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class InitService {
    private EventService eventService;

    public InitService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostConstruct
    public void init() {
        Event event1 = Event.builder()
                .eventId(1)
                .availableSeats(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .build();

        Event event2 = Event.builder()
                .eventId(2)
                .availableSeats(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))
                .build();

        Event event3 = Event.builder()
                .eventId(3)
                .availableSeats(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
                .build();

        eventService.create(event1);
        eventService.create(event2);
        eventService.create(event3);
    }
}
