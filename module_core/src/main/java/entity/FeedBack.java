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
    @SequenceGenerator(name = "feedback_sq",sequenceName ="sq_feedback",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="feedback_sq")
    private Long id;
    @ManyToOne
    private Hotel hotel;
    @OneToOne
    private Client client;
    private String comment;
    private Integer stars;
}