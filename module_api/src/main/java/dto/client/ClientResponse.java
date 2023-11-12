package dto.client;

import dto.address.AddressResponse;
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
public class ClientResponse {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;
    private ClientStatus clientStatus;
    private BigDecimal moneySpent;
    private String email;
    private AddressResponse address;
}
