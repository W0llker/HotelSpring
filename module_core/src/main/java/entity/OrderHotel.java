package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.PrintWriter;
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
    @OneToOne
    private Room room;
    @ManyToOne
    private Client client;
//    ?привязать к ордеру отзыв, а не клиенту?
//    private FeedBack feedBack;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
