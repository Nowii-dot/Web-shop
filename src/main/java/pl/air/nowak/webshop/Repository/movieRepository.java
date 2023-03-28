package pl.air.nowak.webshop.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.air.nowak.webshop.Model.Item;

import java.util.List;

@Repository
public class movieRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Item getById(int id){
        return jdbcTemplate.queryForObject("SELECT  idmovies2,name, price, imgUrl FROM movies2 WHERE idmovies2 = ?", BeanPropertyRowMapper.newInstance(Item.class), id);
    }


    public List<Item> getAll(){
        return jdbcTemplate.query("SELECT * FROM idmovies2", BeanPropertyRowMapper.newInstance(Item.class));
    }

    public int save(Item item) {
      return   jdbcTemplate.update("INSERT INTO movies2(name, price, imgUrl) VALUES (? , ? , ?)",
                    item.getName(), item.getPrice(), item.getImgUrl()
                );
    }


}
