package dto.room;

import dto.hotel.HotelRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomRequest {
    private HotelRequest hotel;
    @NotBlank
    private String number;
    @NotNull
    private RoomType roomType;
    @Min(1)
    private BigDecimal price;
}
