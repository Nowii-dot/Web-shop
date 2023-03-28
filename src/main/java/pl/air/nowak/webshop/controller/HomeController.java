package pl.air.nowak.webshop.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepository;

    public Item getById(@PathVariable("id") int id) {
        return movieRepository.getById(id);
    }


    private List<Item> getAll() {
        return movieRepository.getAll();
    }


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", getAll());
        return "home";
    }

    @GetMapping("/add/{idmovies2}")
    public String addItemToCart(@PathVariable("idmovies2") int idmovies2, Model model, HttpSession session){
        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<>();
        }
        Item oItem = movieRepository.getById(idmovies2);
            cart.add(oItem);
            session.setAttribute("cart", cart);

        model.addAttribute("items", getAll());
        return "home";
    }
}
