package dto.image;

import dto.hotel.HotelRequest;
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
    private String name;
    private String url;
}
