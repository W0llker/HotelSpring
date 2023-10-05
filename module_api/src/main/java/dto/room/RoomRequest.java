package dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private String Number;
    private Integer size;
    private Integer floor;
    private BigDecimal price;
}
