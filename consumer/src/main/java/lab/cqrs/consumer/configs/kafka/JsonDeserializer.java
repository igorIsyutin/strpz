package lab.cqrs.consumer.configs.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.cqrs.consumer.enteties.Order;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

@Log4j2
public class JsonDeserializer implements Deserializer {

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public Order deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Order obj = null;
        try {
            obj = mapper.readValue(bytes, Order.class);
        } catch (Exception e) {

            log.error(e.getMessage());
        }
        return obj;
    }

    @Override
    public void close() {

    }
}
