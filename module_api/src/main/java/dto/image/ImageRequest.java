package dto.image;

import dto.hotel.HotelRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
    private HotelRequest hotelRequest;
    @NotBlank
    private String name;
    @NotBlank
    private String url;
}
