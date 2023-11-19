package dto.feedback;

import dto.hotel.HotelResponse;
import dto.order.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackResponse {
    private Long id;
    private HotelResponse hotel;
    private OrderResponse orderHotel;
    private String comment;
    private Integer stars;
}
