package dto.hotel;

import dto.client.Address;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
    private Long id;
    private String name;
    @Embedded
    private Address address;
    private Integer floor;
}
