package pl.air.nowak.webshop.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.air.nowak.webshop.service.UserService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {


    private final UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable() // Wyłączenie CSRF dla prostoty
                .formLogin(httpForm -> {
                    httpForm.loginPage("/req/login").permitAll(); // Strona logowania dostępna dla wszystkich
                    httpForm.defaultSuccessUrl("/home");
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/req/signup", "/css/**", "/js/**", "/img/**").permitAll(); // Pozwól na dostęp do zasobów statycznych
                    registry.anyRequest().authenticated(); // Wszystko inne wymaga autoryzacji
                })
                .build();
    }
}