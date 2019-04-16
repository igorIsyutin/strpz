package lab.cqrs.query_rest.repository;

import lab.cqrs.query_rest.enteties.Order;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {
    Order getAllByOwnerAndDate(String owner, LocalDateTime date);
}
