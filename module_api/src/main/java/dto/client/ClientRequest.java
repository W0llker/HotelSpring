package dto.client;

import dto.address.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;
    private ClientStatus clientStatus;
    private String email;
    private AddressRequest address;
}
