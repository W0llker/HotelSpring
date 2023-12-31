package itAcadamy.entity;

import dto.order.OrderType;
import lombok.*;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_hotel")
public class OrderHotel {
    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "seq_order", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Room room;
    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Amenities> amenities;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Client client;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private BigDecimal price;
}
