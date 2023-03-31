package pl.air.nowak.webshop.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.air.nowak.webshop.Cart;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;


import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepository;
    private final Cart cart;

    public HomeController(MovieRepository movieRepository, Cart cart) {
        this.movieRepository = movieRepository;
        this.cart = cart;
    }

    @GetMapping("/test")
    public int test(){
        return 1+1;
    }


    public Item getById(@PathVariable("idmovies2") int idmovies2) {
        return movieRepository.getById(idmovies2);
    }


    private @ResponseBody List<Item> getAll() {
        return movieRepository.getAll();
    }


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", getAll());
        return "home";
    }

    @GetMapping("/add/{idmovies2}")
    public String addItemToCart(@PathVariable("idmovies2") int id, Model model){




                cart.addItem(movieRepository.getById(id));
                cart.getSum();

        model.addAttribute("items", getAll());
        return "home";
    }
}
