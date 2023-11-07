package dto.hotel;

import dto.address.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {
    private Long id;
    private String name;
    private AddressResponse address;
}
