package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.air.nowak.webshop.Model.MyAppUser;
import pl.air.nowak.webshop.Model.Role;
import pl.air.nowak.webshop.Repository.RoleRepository;
import pl.air.nowak.webshop.Repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value = "/req/signup", consumes = "application/json")
    public MyAppUser createUser(@RequestBody MyAppUser user) {
        if (userRepository.findByUsernameWithRoles(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Użytkownik o tej nazwie już istnieje");
        }

        // Szyfruj hasło
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Pobierz istniejącą rolę "USER"
        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            throw new IllegalArgumentException("Rola 'USER' nie istnieje w bazie");
        }

        // Przypisz rolę do użytkownika
        user.getRoles().add(userRole);

        // Zapisz użytkownika w bazie
        return userRepository.save(user);
    }

}

