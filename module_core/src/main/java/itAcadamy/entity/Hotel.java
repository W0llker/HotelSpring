package itAcadamy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "hotel")
public class Hotel {
    @Id
    @SequenceGenerator(name = "hotel_sq",sequenceName ="sq_hotel",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="hotel_sq")
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Room> roomList;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List <FeedBack> feedBacks = new ArrayList<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<OrderHotel> orderHotels = new ArrayList<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Amenities> amenitiesList = new ArrayList<>();
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Person> personList = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "image")
    private List<ImageHotel> image = new ArrayList<>();
}
