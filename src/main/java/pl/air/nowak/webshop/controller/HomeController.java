package pl.air.nowak.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    protected static List<Item> items = new ArrayList<>();

    @Autowired
    MovieRepository movieRepository;

    public Item getById(@PathVariable("id") int id) {
        return movieRepository.getById(id);
    }


    public List<Item> getAll() {
        return movieRepository.getAll();
    }

/*
    static{
            items.add(new Item(1,"Halloween Ends 4K UHD + Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/product_thumb.php?img=images/products/halloween%20ends%204k%20uhd.jpg&w=278&h=400"));
            items.add( new Item(2,"Puss in Boots: The Last Wish Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/images/products/pussinboots_thelastwish-P-BD-k.png"));
            items.add( new Item(3,"Captain Marvel 3D + 2D Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/images/products/captain%20marvel%203d%20blu%20ray.jpg"));
            items.add( new Item(4,"The Last of Us: The Complete First Season Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/images/products/the%20last%20of%20us%20blu%20ray.jpg"));
            items.add( new Item(5,"Rocky: The Knockout Collection 4K UHD",new BigDecimal("100"),"https://www.futuremovieshop.fi/images/products/rocky%20knockout%20collection%204k.jpg"));
    }
*/



    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", getAll());
        return "home";
    }
}
