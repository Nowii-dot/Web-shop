package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping
    private String adminPage(Model model){
        model.addAttribute("items", getAll());
        return "adminview/DeleteItem";
    }

    private @ResponseBody List<Item> getAll() {
        return movieRepository.getAll();
    }

    @PostMapping
    public String add(Item item){
       movieRepository.save(item);
       return("redirect:/");
    }

    @RequestMapping(value = "/delete/{idmovie2}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable int id){
        Optional<Item> oitem = Optional.ofNullable(movieRepository.getById(id));
        if(oitem.isPresent())
        {
            movieRepository.delete(id);
        }
        return("redirect:/");
    }
//    @PatchMapping(value = "/edit/{idmovie2}", method  = {RequestMethod.DELETE, RequestMethod.GET})
//    public int updateOne(@PathVariable("id")int id, @RequestBody Item updateMovie){
//        Item item = movieRepository.getById(id);
//        if(item!=null)
//        {
//            if(updateMovie.getName() !=null) item.setName(updateMovie.getName());
//            if(updateMovie.getPrice() !=null)  item.setPrice(updateMovie.getPrice());
//
//            movieRepository.update(item);
//            return 1;
//        }else {
//            return -1;
//        }
//    }
}
