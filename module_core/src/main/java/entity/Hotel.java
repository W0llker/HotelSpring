package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@Data
@Table(schema = "hotel", name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private Integer countRoom;
    private Integer floor;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> roomList;
}
