package itAcadamy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class OrderHotel {
    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "seq_order", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    // TODO: 14.10.2023 клиент может заказать сразу несколько комнат
    @OneToOne
    private Room room;
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
    @OneToOne
    private FeedBack feedBack;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
