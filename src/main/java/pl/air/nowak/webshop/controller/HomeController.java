
package pl.air.nowak.webshop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.air.nowak.webshop.Cart;

import pl.air.nowak.webshop.service.Cartservice;


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
    @GetMapping("/ranking/movies")
    public String ranking(Model model){
        model.addAttribute("items", cartservice.getTopTenItems() );
        return "rankingmovies";
        }

    @GetMapping("/shop-all/{idmovies2}")
    public String addItemToCart(@PathVariable("idmovies2") int idmovies2, Model model){
        cartservice.addItemToCart(idmovies2);
        model.addAttribute("items", cartservice.getAllItems());
        return "home";
    }




}
