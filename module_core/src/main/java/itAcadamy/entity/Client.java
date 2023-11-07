package itAcadamy.entity;

import dto.client.ClientStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "client")
public class Client extends User {
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus = ClientStatus.NORMAL;
    private BigDecimal moneySpent = new BigDecimal(0);
    private String email;
    @Embedded
    private Address address;
}
