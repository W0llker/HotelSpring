package dto.feedback;

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
    private Long hotelId;
    private Long orderHotelId;
    private String comment;
    private Integer stars;
}
