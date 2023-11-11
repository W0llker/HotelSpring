package dto.client;

import dto.address.AddressRequest;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;
    private ClientStatus clientStatus = ClientStatus.NORMAL;
    private String email;
    private AddressRequest address;
}
