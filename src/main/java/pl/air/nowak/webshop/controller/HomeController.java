package pl.air.nowak.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.air.nowak.webshop.Model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    protected static List<Item> items = new ArrayList<>();


    static{
            items.add(new Item("Halloween Ends 4K UHD + Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/product_thumb.php?img=images/products/halloween%20ends%204k%20uhd.jpg&w=278&h=400"));
            items.add( new Item("Puss in Boots: The Last Wish Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/images/products/pussinboots_thelastwish-P-BD-k.png"));
            items.add( new Item("Captain Marvel 3D + 2D Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/images/products/captain%20marvel%203d%20blu%20ray.jpg"));
            items.add( new Item("The Last of Us: The Complete First Season Blu Ray",new BigDecimal("80.10"),"https://www.futuremovieshop.fi/images/products/the%20last%20of%20us%20blu%20ray.jpg"));
            items.add( new Item("Rocky: The Knockout Collection 4K UHD",new BigDecimal("100"),"https://www.futuremovieshop.fi/images/products/rocky%20knockout%20collection%204k.jpg"));
    }



    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", items);
        return "home";
    }
}
