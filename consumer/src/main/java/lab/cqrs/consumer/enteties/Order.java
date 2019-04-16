package lab.cqrs.consumer.enteties;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Order {

    @Id
    private String id;

    private String owner;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;

    private List<PositionInOrder> positions;

    private Result result;

    public String getKey(){
        return owner+date.toString();
    }
}
