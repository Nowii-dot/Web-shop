package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.movieRepository;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    movieRepository MovieRepository;

    @GetMapping
    private String adminPage(){
        return "adminview/addItem";
    }

    @PostMapping
    public String add(Item item){
       MovieRepository.save(item);
       return("redirect:/");
    }

/*    @PostMapping
    private String addItem(Item item){
        MovieRepository.save(item);
        return "home";
    }*/

}
