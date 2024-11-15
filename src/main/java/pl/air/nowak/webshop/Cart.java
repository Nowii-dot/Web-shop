package pl.air.nowak.webshop;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.air.nowak.webshop.Model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public  void addItem(Item item){
        boolean notFound = true;

        for (CartItem ci: cartItems) {
            if(ci.getItem().getIdmovies2().equals(item.getIdmovies2())){
                notFound = false;
                ci.increaseCounter();
                SumOfPrice();
                break;
            }
        }
        if(notFound) {
            cartItems.add(new CartItem(item));
            SumOfPrice();
        }
    }
    public void removeItem(Item item) {

        for (CartItem ci : cartItems) {
            if (ci.getItem().getIdmovies2().equals(item.getIdmovies2())) {
                ci.decreaseCounter();
                if(ci.ZeroItem())
                {
                    cartItems.remove(ci);
                }
                SumOfPrice();
                break;
            }
        }
    }

    private void SumOfPrice(){
        int tempCounter = 0;
        BigDecimal tempPrice = BigDecimal.ZERO;

        for (CartItem ci: cartItems) {
            tempCounter += ci.getCounter();
            tempPrice = tempPrice.add(ci.getPrice());
        }
        this.counter = tempCounter;
        this.sum = tempPrice;

    }


}
