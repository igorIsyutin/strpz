package lab.cqrs.consumer.repositories;

import lab.cqrs.consumer.enteties.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
}
