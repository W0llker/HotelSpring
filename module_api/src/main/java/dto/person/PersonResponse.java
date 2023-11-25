package dto.person;

import dto.hotel.HotelResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private Long id;
    private String login;
    private String name;
    private String surName;
    private Post post;
    private BigDecimal salary;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private HotelResponse hotel;
}
