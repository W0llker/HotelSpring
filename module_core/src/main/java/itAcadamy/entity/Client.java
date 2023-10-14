package itAcadamy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@ToString(callSuper = true)
@NoArgsConstructor
@Table(schema = "hotel", name = "client")
public class Client extends User {
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus;
    private BigDecimal moneySpent;
    private Address address;
}
