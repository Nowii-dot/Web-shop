package pl.air.nowak.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/summary")
public class OrderController {

    @GetMapping("/summary")
    public String showSummary() {
        return "summary";
    }

}
