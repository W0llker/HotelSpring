package itAcadamy.entity;

import dto.person.Post;
import lombok.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends User {
    @Enumerated(EnumType.STRING)
    private Post post;
    private BigDecimal salary;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Hotel hotel;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(post.equals(Post.MANAGER)) {
            return List.of(new SimpleGrantedAuthority("ADMIN"));
        } else return List.of(new SimpleGrantedAuthority("PERSON"));
    }
}
