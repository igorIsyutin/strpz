package lab.cqrs.query_rest.enteties;

import lombok.Data;

import java.util.List;

@Data
public class PositionInOrder {
    private long concertId;
    private List<Integer> seatNumbers;
}
