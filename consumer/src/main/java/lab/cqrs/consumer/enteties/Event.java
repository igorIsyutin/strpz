package lab.cqrs.consumer.enteties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Event {
    @Id
    private long eventId;

    private List<Integer> availableSeats;
}
