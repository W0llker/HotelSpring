package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "hotel", name = "room")
public class Room {
    @Id
    @SequenceGenerator(name = "room_sq",sequenceName ="sq_room",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="room_sq")
    private Long id;
    private String Number;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private Integer floor;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
}
