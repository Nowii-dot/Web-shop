package pl.air.nowak.webshop.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.air.nowak.webshop.Cart;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;
import pl.air.nowak.webshop.service.Cartservice;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {


    private  final Cartservice cartservice;
    private final Cart cart;
    @Autowired
    public HomeController(Cartservice cartservice, Cart cart) {
        this.cartservice = cartservice;
        this.cart = cart;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", cartservice.getAllItems());
        return "home";
    }

    @GetMapping("/shop-all/{idmovies2}")
    public String addItemToCart(@PathVariable("idmovies2") int idmovies2, Model model){
            cartservice.addItemToCart(idmovies2);
            model.addAttribute("items", cartservice.getAllItems());
            return "home";
    }

}
