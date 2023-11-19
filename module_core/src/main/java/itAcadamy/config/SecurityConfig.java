package itAcadamy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        //Amenities
                        .requestMatchers(HttpMethod.POST, "/amenities/getAll", "/amenities/findType",
                                "/amenities/findByName").authenticated()
                        .requestMatchers(HttpMethod.GET, "/amenities/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/amenities/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/amenities/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/amenities/**").hasAuthority("ADMIN")
                        //Client
                        .requestMatchers(HttpMethod.DELETE, "/client/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/client/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/client/**").authenticated()
                        //FeedBack
                        .requestMatchers(HttpMethod.POST, "/feedback/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/feedback/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/feedback/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/feedback/**").authenticated()
                        //Hotel
                        .requestMatchers(HttpMethod.POST, "/hotel/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/hotel/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/hotel/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/hotel/**").authenticated()
                        //Order
                        .requestMatchers(HttpMethod.GET, "/order/getAllOrderClient").authenticated()
                        .requestMatchers(HttpMethod.POST, "/order/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/order/paymentOrder").authenticated()
                        .requestMatchers(HttpMethod.GET, "/order/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/order/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/order/**").hasAuthority("ADMIN")
                        //Person
                        .requestMatchers(HttpMethod.POST, "/person/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/person/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/person/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/person/**").hasAuthority("ADMIN")
                        //Room
                        .requestMatchers(HttpMethod.POST, "/room/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/room/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/room/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/room/**").hasAuthority("ADMIN")
                        //User
                        .requestMatchers(HttpMethod.GET, "/user/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/logout").authenticated()
                        .requestMatchers(HttpMethod.POST, "/client/save").permitAll()
                ).build();
    }
}
