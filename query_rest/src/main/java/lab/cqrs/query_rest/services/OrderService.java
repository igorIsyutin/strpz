package lab.cqrs.query_rest.services;

import lab.cqrs.query_rest.enteties.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order getByOwnerAndDate(String owner, LocalDateTime date);
}
