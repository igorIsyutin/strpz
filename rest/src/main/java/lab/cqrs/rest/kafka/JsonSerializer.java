package lab.cqrs.rest.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Log4j2
public class JsonSerializer implements Serializer {
    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Object o) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            retVal = objectMapper.writeValueAsBytes(o);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return retVal;
    }

    @Override
    public void close() {

    }
}
