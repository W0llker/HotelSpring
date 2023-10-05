package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "hotel",name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    private String country;
    private String city;
    private String street;
    private String postalCode;

    @Override
    public String toString() {
        return  "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
