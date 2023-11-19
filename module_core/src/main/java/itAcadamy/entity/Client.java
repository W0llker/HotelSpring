package itAcadamy.entity;

import dto.client.ClientStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "client")
public class Client extends User {
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus;
    private BigDecimal moneySpent = new BigDecimal(0);
    private String email;
    @Embedded
    private Address address;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }
}
