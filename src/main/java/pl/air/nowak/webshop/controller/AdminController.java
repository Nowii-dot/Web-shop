package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping
    private String adminPage(){
        return "adminview/addItem";
    }



    @PostMapping
    public String add(Item item){
       movieRepository.save(item);
       return("redirect:/");
    }
    @GetMapping("/delete")
    private String delete(){
        return ("adminview/DeleteItem");
    }

/*    @PostMapping
    private String addItem(Item item){
        MovieRepository.save(item);
        return "home";
    }*/

}
