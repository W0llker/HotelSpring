package dto.person;

import dto.hotel.HotelRequest;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String surName;
    @NotNull
    private Post post;
    @Min(1)
    private BigDecimal salary;
    @Future
    private LocalDate dateStart;
    private LocalDate dateEnd;
    @NotNull
    private HotelRequest hotel;
}
