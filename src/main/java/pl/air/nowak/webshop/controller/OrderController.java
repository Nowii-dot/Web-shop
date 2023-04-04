package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/summary")
    public String showSummary(Model model) {
        model.addAttribute("items", getAll());
        return "summary";
    }

    private @ResponseBody List<Item> getAll() {
        return movieRepository.getAll();
    }

}
