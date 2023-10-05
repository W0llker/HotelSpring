package dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String login;
    private String password;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
