package pl.air.nowak.webshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.air.nowak.webshop.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
