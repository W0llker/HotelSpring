package itAcadamy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(schema = "hotel", name = "administrative")
public class Administrative extends User {
    // TODO: 14.10.2023 SpringDate
    private Long idHotel;
    private String numberPhone;
}
