package pl.air.nowak.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/req/login")
    public String loginPage() {
        return "login"; // Zwróć nazwę widoku logowania (np. "login.html")
    }
    @GetMapping("/req/signup")
    public String signup(Model model){
        return "signup";
    }
}
