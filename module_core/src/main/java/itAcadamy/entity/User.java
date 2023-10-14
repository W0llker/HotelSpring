package itAcadamy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NoArgsConstructor
@Table(schema = "hotel",name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "user_sq",sequenceName ="sq_user",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="user_sq")
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
