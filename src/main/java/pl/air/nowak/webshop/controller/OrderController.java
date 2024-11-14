package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.air.nowak.webshop.Cart;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;
import pl.air.nowak.webshop.service.Cartservice;

import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    private  final Cartservice cartservice;
    private final Cart cart;
    @Autowired
    public OrderController(Cartservice cartservice, Cart cart) {
        this.cartservice = cartservice;
        this.cart = cart;
    }

    @GetMapping("/cart")
    public String showSummary(Model model) {
        model.addAttribute("Itemss", cart.getCartItems());
        return "cartView";
    }
    @GetMapping("/increase/{idmovies2}")
    public String addItemToCart(@PathVariable("idmovies2") int idmovies2, Model model){
        cartservice.addItemToCart(idmovies2);
        return "cartView";
    }
    @GetMapping("/decrease/{idmovies2}")
    public String deleteItemToCart(@PathVariable("idmovies2") int idmovies2, Model model) {
        cartservice.deleteItemToCart(idmovies2);
        return "cartView";
    }

}
