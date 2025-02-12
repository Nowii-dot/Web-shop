package pl.air.nowak.webshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.air.nowak.webshop.Model.MyAppUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyAppUser, Long> {

    @Query("SELECT u FROM MyAppUser u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<MyAppUser> findByUsernameWithRoles(@Param("username") String username);


}




