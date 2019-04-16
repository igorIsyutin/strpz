package lab.cqrs.query_rest.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.cqrs.query_rest.enteties.Order;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Repository
public class OrderCache {
    private Jedis jedis = new Jedis();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init(){
        objectMapper.findAndRegisterModules();
    }


    public void put(Order order){
        try {
            jedis.set(order.getKey(), objectMapper.writeValueAsString(order));
            jedis.expire(order.getKey(), 60);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Order get(Order order){
        Order result = null;
        try {
            String orderJson = jedis.get(order.getKey());
            result = objectMapper.readValue(orderJson, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean existed(Order order) {
        return jedis.exists(order.getKey());
    }
}
