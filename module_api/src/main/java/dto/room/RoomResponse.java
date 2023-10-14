package dto.room;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String Number;
    private RoomType roomType;
    private Integer floor;
    private BigDecimal price;
}
