package dto.order;

import dto.amenities.AmenitiesRequest;
import dto.client.ClientRequest;
import dto.hotel.HotelRequest;
import dto.room.RoomType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private ClientRequest client;
    @NotNull
    private HotelRequest hotel;
    @NotNull
    private RoomType roomType;
    private List<AmenitiesRequest> amenities;
    @Future
    private LocalDate dateStart;
    @Future
    private LocalDate dateEnd;
    @AssertTrue
    public boolean isData() {
        return dateEnd.isAfter(dateStart);
    }
}
