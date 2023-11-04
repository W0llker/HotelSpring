package itAcadamy.entity;

import dto.order.OrderType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "hotel", name = "orderhotel")
public class OrderHotel {
    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "seq_order", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @OneToMany
    private List<Room> room;
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Client client;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
    @OneToOne
    private FeedBack feedBack;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
