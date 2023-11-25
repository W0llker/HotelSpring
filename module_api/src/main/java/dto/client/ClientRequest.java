package dto.client;

import dto.address.AddressRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    private String name;
    @NotBlank
    private String surName;
    @NotNull
    private LocalDate dateOfBirth;
    private ClientStatus clientStatus = ClientStatus.NORMAL;
    @Email
    private String email;
    private AddressRequest address;
}
