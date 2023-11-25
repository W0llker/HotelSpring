package dto.hotel;

import dto.address.AddressRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
    private Long id;
    @NotBlank
    private String name;
    private AddressRequest address;
}
