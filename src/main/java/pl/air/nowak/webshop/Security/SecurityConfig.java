package pl.air.nowak.webshop.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.spring6.SpringTemplateEngine;
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .formLogin(form -> form
                        .loginPage("/req/login")  // Strona logowania dostępna pod "/req/login"
                        .permitAll()  // Strona logowania dostępna dla wszystkich
                        .defaultSuccessUrl("/", true)  // Po zalogowaniu użytkownik zostaje przekierowany na stronę główną
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/")  // Po wylogowaniu użytkownik wraca na stronę główną
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .authorizeRequests(authz -> authz
                        .requestMatchers("/",  "/shop-all/**","/shop-all/{idmovies2}",     "/ranking/movies",   "/req/login", "/css/**", "/js/**", "/img/**").permitAll()  // Zezwala na dostęp do strony głównej i zasobów statycznych
                        .anyRequest().authenticated()  // Wszystkie inne żądania wymagają logowania
                )
                .build();
    }







}
