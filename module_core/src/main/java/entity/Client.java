package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "hotel", name = "client")
public class Client extends User {
    private LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Override
    public String toString() {

        return super.toString() + "Client{" +
                "dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}
