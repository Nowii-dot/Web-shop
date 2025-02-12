package pl.air.nowak.webshop.service;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.air.nowak.webshop.Model.MyAppUser;
import pl.air.nowak.webshop.Repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Trwa ładowanie użytkownika z ról: {}", username);

        return userRepository.findByUsernameWithRoles(username)
                .map(user -> {
                    Hibernate.initialize(user.getRoles());
                    logger.info("Znaleziono użytkownika: {}", user.getUsername());


                    // Zalogowanie nazw ról użytkownika po ich inicjalizacji
                    if (user.getRoles() != null && !user.getRoles().isEmpty()) {
                        user.getRoles().forEach(role -> logger.info("Rola użytkownika: {}", role.getName()));
                    } else {
                        logger.info("Brak ról dla użytkownika: {}", user.getUsername());
                    }

                    return user;
                })
                .orElseThrow(() -> {
                    logger.error("Nie znaleziono użytkownika: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });
    }

}
