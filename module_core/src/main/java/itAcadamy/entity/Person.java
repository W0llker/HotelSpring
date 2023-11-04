package itAcadamy.entity;

import dto.person.Post;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @SequenceGenerator(name = "person_sq",sequenceName ="sq_person",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="person_sq")
    private Long id;
    private String name;
    private String surName;
    @Enumerated(EnumType.STRING)
    private Post post;
    private BigDecimal salary;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
}
