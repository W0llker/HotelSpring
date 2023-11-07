package dto.order;

import dto.amenities.AmenitiesRequest;
import dto.client.ClientRequest;
import dto.hotel.HotelRequest;
import dto.room.RoomRequest;
import dto.room.RoomType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long id;
    private ClientRequest client;
    private HotelRequest hotel;
    private RoomType roomType;
    private List<AmenitiesRequest> amenitiesRequestList;
    private LocalDate dateStart;
    @Future
    private LocalDate dateEnd;
}
