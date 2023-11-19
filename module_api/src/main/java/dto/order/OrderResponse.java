package dto.order;

import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import dto.room.RoomResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private RoomResponse room;
    private List<AmenitiesResponse> amenities;
    private OrderType orderType;
    private BigDecimal price;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
