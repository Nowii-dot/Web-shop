package pl.air.nowak.webshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.air.nowak.webshop.Model.MyAppUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyAppUser, Long> {

    Optional<MyAppUser> findByUsername(String username);

}

