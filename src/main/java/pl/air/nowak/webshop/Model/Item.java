package pl.air.nowak.webshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "movies2")
@NoArgsConstructor @Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    private int idmovies2;

    private  String name;
    private BigDecimal price;
    private String imgUrl;
}
