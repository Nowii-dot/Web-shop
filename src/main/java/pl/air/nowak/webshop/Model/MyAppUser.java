//package pl.air.nowak.webshop.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//public class MyAppUser implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String username;
//    private String email;
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER) // Ładowanie ról użytkownika
//    @JoinTable(
//            name = "user_roles", // Nazwa tabeli pośredniczącej
//            joinColumns = @JoinColumn(name = "user_id"), // Klucz obcy do tabeli użytkowników
//            inverseJoinColumns = @JoinColumn(name = "role_id") // Klucz obcy do tabeli ról
//    )
//    private Set<Role> roles = new HashSet<>();
//
//    @Override
//    public Set<? extends GrantedAuthority> getAuthorities() {
//        // Zwracamy role jako autorytety
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        for (Role role : roles) {
//            authorities.add(() -> "ROLE_" + role.getName()); // Przedrostek "ROLE_" jest wymagany przez Spring Security
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
