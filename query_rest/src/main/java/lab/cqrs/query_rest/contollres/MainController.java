package lab.cqrs.query_rest.contollres;

import lab.cqrs.query_rest.enteties.Order;
import lab.cqrs.query_rest.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private OrderService orderService;

    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public ResponseEntity getOrder(@RequestParam String owner, @RequestParam String date){
        LocalDateTime orderDate = LocalDateTime.parse(date);
        Order orders = orderService.getByOwnerAndDate(owner, orderDate);
        return ResponseEntity.ok(orders);
    }
}
