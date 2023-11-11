package dto.hotel;

import dto.address.AddressRequest;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
    private Long id;
    private String name;
    private AddressRequest address;
}
