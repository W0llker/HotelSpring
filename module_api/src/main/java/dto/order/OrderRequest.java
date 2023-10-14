package dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long clientId;
    private Long hotelId;
    private LocalDate start;
    private LocalDate end;
}
