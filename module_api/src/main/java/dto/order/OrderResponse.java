package dto.order;

import dto.room.RoomResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private RoomResponse room;
    private OrderType orderType;
    private BigDecimal price;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
