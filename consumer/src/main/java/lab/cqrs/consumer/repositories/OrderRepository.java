package lab.cqrs.consumer.repositories;

import lab.cqrs.consumer.enteties.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
}
