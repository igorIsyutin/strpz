package lab.cqrs.rest.enteties;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {

    private String owner;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;

    private List<PositionInOrder> positions;
}
