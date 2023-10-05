package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
@Table(schema = "hotel", name = "hotel")
public class Hotel {
    @Id
    @SequenceGenerator(name = "hotel_sq",sequenceName ="sq_hotel",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="hotel_sq")
    private Long id;
    private String name;
    private Address address;
    // ?Лишнее?
    private Integer floor;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Room> roomList;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List <FeedBack> feedBacks = new ArrayList<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Amenities> amenitiesList = new ArrayList<>();
    @OneToMany(mappedBy = "hotel")
    @LazyCollection(LazyCollectionOption.TRUE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Person> personList = new ArrayList<>();
    @ElementCollection
    @JoinTable(name = "image")
    private List<ImageHotel> image = new ArrayList<>();
}
