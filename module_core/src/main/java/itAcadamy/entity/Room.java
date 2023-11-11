package itAcadamy.entity;

import dto.room.RoomType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "room")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "room")
public class Room {
    @Id
    @SequenceGenerator(name = "room_sq", sequenceName = "sq_room", allocationSize = 1, schema = "hotel")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_sq")
    private Long id;
    private String Number;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
}
