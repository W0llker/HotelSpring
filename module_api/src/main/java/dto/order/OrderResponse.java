package dto.order;

import dto.room.RoomResponse;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private List<RoomResponse> room;
    private OrderType orderType;
    private BigDecimal totalPrice;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
