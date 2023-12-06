package pl.air.nowak.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.air.nowak.webshop.Cart;
import pl.air.nowak.webshop.Model.Item;
import pl.air.nowak.webshop.Repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class Cartservice {
    private final MovieRepository movieRepository;
    private final Cart cart;
    @Autowired
    public Cartservice(MovieRepository movieRepository, Cart cart) {
        this.movieRepository = movieRepository;
        this.cart = cart;
    }

    public List<Item> getAllItems() {
        return movieRepository.getAll();
    }

    public void addItemToCart(int idmovies2){

        Optional<Item> oitem = Optional.ofNullable(movieRepository.getById(idmovies2));
        if(oitem.isPresent())
        {
            Item item = oitem.get();
            cart.addItem(item);
        }
    }
    public void deleteItemToCart(int idmovies2) {

        Optional<Item> oitem = Optional.ofNullable(movieRepository.getById(idmovies2));
        if (oitem.isPresent()) {
            Item item = oitem.get();
            cart.removeItem(item);
        }
    }


}
