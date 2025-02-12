package pl.air.nowak.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YourController {

    // Zainicjalizuj logger
    private static final Logger logger = LoggerFactory.getLogger(YourController.class);

    @GetMapping("/user")
    public String userPage(HttpSession session, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Sprawdzamy, czy użytkownik jest uwierzytelniony
        if (auth != null && auth.isAuthenticated()) {
            logger.info("User is authenticated: {}", auth.isAuthenticated());
            logger.info("Current username: {}", auth.getName());
            logger.info("User authorities: {}", auth.getAuthorities());

            String username = auth.getName();
            // Przekazywanie ról jako lista
            model.addAttribute("username", username);
            model.addAttribute("authorities", auth.getAuthorities());
            session.setAttribute("username", username);
            session.setAttribute("authorities", auth.getAuthorities());
        } else {
            model.addAttribute("username", "Not logged in");
            model.addAttribute("authorities", "Not logged in");
        }

        return "error404"; // Zwrócenie widoku użytkownika
    }
}
