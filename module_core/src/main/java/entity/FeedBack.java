package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FeedBack {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Client client;
    private String comment;
    private Integer start;
}
