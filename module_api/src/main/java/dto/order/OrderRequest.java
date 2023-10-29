package dto.order;

import dto.client.ClientRequest;
import dto.hotel.HotelRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long id;
    private ClientRequest client;
    private HotelRequest hotel;
    private LocalDate start;
    private LocalDate end;
}
