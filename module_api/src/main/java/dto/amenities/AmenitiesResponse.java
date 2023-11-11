package dto.amenities;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AmenitiesResponse {
    private Long id;
    private AmenitiesType type;
    private String name;
    private BigDecimal price;
    private HotelResponse hotel;
}
