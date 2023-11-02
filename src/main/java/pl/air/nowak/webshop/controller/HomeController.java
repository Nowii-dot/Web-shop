package pl.air.nowak.webshop.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable int id){
        Optional<Item> item = Optional.ofNullable(movieRepository.getById(id));
        if(item.isPresent())
        {
            movieRepository.delete(id);
            return("redirect:/");
        }

        return("redirect:/");
    }

    @GetMapping("/add/{idmovies2}")
    public String addItemToCart(@PathVariable int idmovies2, Model model){
            Optional<Item> oitem = Optional.ofNullable(movieRepository.getById(idmovies2));
            if(oitem.isPresent())
            {
                Item item = oitem.get();
                cart.addItem(item);


            }
            model.addAttribute("items", movieRepository.getAll());
        return "home";
    }
}
