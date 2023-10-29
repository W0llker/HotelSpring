package dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surName;
    private Address address;
}
