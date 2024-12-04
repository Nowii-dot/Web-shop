//package pl.air.nowak.webshop.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import pl.air.nowak.webshop.Model.MyAppUser;
//import pl.air.nowak.webshop.Repository.UserRepository;
//
//
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<MyAppUser> user = userRepository.findByUsername(username);
//        if (user.isPresent()) {
//            var userObj = user.get();
//            return User.builder()
//                    .username(userObj.getUsername())
//                    .password(userObj.getPassword())
//                    .roles(userObj.getRoles().toArray(new String[0])) // Dodanie ról do UserDetails
//                    .build();
//        } else {
//            throw new UsernameNotFoundException(username);
//        }
//    }
//}
