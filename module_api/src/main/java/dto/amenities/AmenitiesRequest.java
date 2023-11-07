package dto.amenities;

import dto.hotel.HotelRequest;
import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AmenitiesRequest {
    private Long id;
    private AmenitiesType type;
    private String name;
    private BigDecimal price;
    private HotelRequest hotel;
}
