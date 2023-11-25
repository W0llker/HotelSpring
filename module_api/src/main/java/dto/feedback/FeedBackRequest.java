package dto.feedback;

import dto.hotel.HotelRequest;
import dto.order.OrderRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String comment;
    @Min(1)@Max(5)
    private Integer stars;
}
