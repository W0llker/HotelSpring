package dto.room;

import dto.hotel.HotelRequest;
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
    private String number;
    private RoomType roomType;
    private BigDecimal price;
}
