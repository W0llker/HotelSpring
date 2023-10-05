package dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private String login;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;
    private String address;
}
