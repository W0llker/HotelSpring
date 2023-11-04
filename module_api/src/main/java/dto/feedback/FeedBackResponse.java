package dto.feedback;

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
    private Long hotelId;
    private Long orderHotelId;
    private String comment;
    private Integer stars;
}
