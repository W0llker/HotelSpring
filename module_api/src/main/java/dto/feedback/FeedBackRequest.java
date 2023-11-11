package dto.feedback;

import dto.hotel.HotelRequest;
import dto.order.OrderRequest;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackRequest {
    private Long id;
    private HotelRequest hotel;
    private OrderRequest order;
    private String comment;
    private Integer stars;
}
