package itAcadamy.entity;

import dto.amenities.AmenitiesType;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amenities {
    @Id
    @SequenceGenerator(name = "amenities_sq",sequenceName ="sq_amenities",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="amenities_sq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private AmenitiesType type;
    private String name;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
}
