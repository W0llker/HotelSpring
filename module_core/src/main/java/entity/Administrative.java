package entity;

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
    //еще думаю над полями
}
