package dto.person;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private Long id;
    private String name;
    private String surName;
    private Post post;
    private BigDecimal salary;
    private LocalDate dateStart;
    private LocalDate dateEnd;
}
