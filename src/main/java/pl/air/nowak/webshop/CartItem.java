package pl.air.nowak.webshop;

import lombok.Getter;
import pl.air.nowak.webshop.Model.Item;

import java.math.BigDecimal;

@Getter
public class CartItem {
    private Item item;
    private int counter;
    private BigDecimal price;

    public CartItem(Item item){
        this.item = item;
        this.counter = 1;
        this.price = item.getPrice();
    }

    //funkcja zwięszka sumę w koszyku
    public void increaseCounter() {
        counter++;
        realPrice();
    }

    // funkcja zmniejsza sumę w koszyku
    public void decreaseCounter() {
        if(counter > 0) {
            counter--;
            realPrice();
        }
    }

    //aktualna cena
    public void realPrice(){
        price = item.getPrice().multiply(new BigDecimal(counter));
    }
    public boolean ZeroItem(){
        return counter == 0;
    }

    public boolean idEquals(Item item){
        return this.item.getIdmovies2().equals(item.getIdmovies2());
    }
}
