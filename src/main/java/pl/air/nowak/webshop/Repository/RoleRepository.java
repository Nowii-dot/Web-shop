package pl.air.nowak.webshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.air.nowak.webshop.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);  // Metoda do znajdowania roli po nazwie
}
