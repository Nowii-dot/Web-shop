package pl.air.nowak.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    private String adminPage(Model model) {
        model.addAttribute("items", getAll());
        return "adminview/Allmovies";
    }


    private @ResponseBody List<Item> getAll() {
        return movieRepository.getAll();
    }

    //Section add item
    @GetMapping("/add")
    private String addPage(Model model) {

        model.addAttribute("item", movieRepository.getAll());
        return "adminview/addItem";
    }
    @PostMapping("/admin/save")
    public String saveMovie(@RequestParam String name,
                            @RequestParam BigDecimal price,
                            @RequestParam String imgUrl) {
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setPrice(price);
        newItem.setImgUrl(imgUrl);

        movieRepository.save(newItem);  // Zapisanie filmu w bazie danych

        return "redirect:/admin";  // Po zapisaniu przekierowanie na stronę admina
    }

    @PostMapping("/save")
    public String add(Item item) {
        movieRepository.save(item);
        return ("redirect:/");
    }

    // Section delete item
    @RequestMapping(value = "/delete/{idmovie2}", method = {RequestMethod.DELETE})
    public String delete(@PathVariable("idmovie2") int idmovie2) {
        Optional<Item> oitem = Optional.ofNullable(movieRepository.getById(idmovie2));
        if (oitem.isPresent()) {
            movieRepository.delete(idmovie2);
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{idmovies2}")
    private String EditItem(@PathVariable("idmovies2") int idmovies2, Model model) {
        Item item = movieRepository.getById(idmovies2);
        model.addAttribute("items", item);
            return "adminview/EditItem";
    }


    @PostMapping("/edit/{idmovies2}")
    public String update(@PathVariable("idmovies2") int idmovies2, Item item){
        // get item from database by id
        Item updatedItem = movieRepository.getById(idmovies2);
        updatedItem.setName(item.getName());
        updatedItem.setPrice(item.getPrice());
        updatedItem.setImgUrl(item.getImgUrl());

        // save updated item object
        movieRepository.update(updatedItem);

            return ("redirect:/");
    }


}
