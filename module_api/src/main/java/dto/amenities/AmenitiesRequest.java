package dto.amenities;

import dto.hotel.HotelRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AmenitiesRequest {
    private Long id;
    @NotNull
    private AmenitiesType type;
    @NotBlank
    private String name;
    @Min(1)
    private BigDecimal price;
    @NotNull
    private HotelRequest hotel;
}
