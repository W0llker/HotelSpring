package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "hotel", name = "room")
public class Room {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    private String Number;
    private Integer size;
    private Integer floor;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
}
