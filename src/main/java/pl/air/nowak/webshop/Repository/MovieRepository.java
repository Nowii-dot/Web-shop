package pl.air.nowak.webshop.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.air.nowak.webshop.Model.Item;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Item getById(int id){
        return jdbcTemplate.queryForObject("SELECT  idmovies2, name, price, imgUrl FROM movies2 WHERE idmovies2 = ?", BeanPropertyRowMapper.newInstance(Item.class), id);
    }

    public List<Item> getAll(){
        return jdbcTemplate.query("SELECT * FROM movies2", BeanPropertyRowMapper.newInstance(Item.class));
    }

    public int save(Item item) {
         return jdbcTemplate.update("INSERT INTO movies2(name, price, imgUrl,rating) VALUES (? , ? , ?,0)",
                item.getName(), item.getPrice(), item.getImgUrl()
        );
    }
    public int delete(int  idmovies2){
        return jdbcTemplate.update("Delete FROM movies2 where idmovies2=?", idmovies2);
    }
    public int update(Item item){
        return  jdbcTemplate.update("UPDATE movies2 set name=?, price=?, imgUrl=? where idmovies2=?",
                item.getName(), item.getPrice(), item.getImgUrl(), item.getIdmovies2());
    }
    public List<Item> getTopTenMovies(){
        return jdbcTemplate.query("SELECT * FROM movies2 ORDER BY rating DESC LIMIT 10", BeanPropertyRowMapper.newInstance(Item.class));
    }



}
