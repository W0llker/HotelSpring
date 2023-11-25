package dto.amenities;

import dto.hotel.HotelRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AmenitiesRequest {
    private Long id;
    @NotBlank
    private AmenitiesType type;
    @NotBlank
    private String name;
    @Min(1)
    private BigDecimal price;
    private HotelRequest hotel;
}
