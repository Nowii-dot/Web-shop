//package pl.air.nowak.webshop.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true) // Zapewnienie unikalności roli
//    private String name; // np. "USER", "ADMIN"
//
//    @ManyToMany(mappedBy = "roles") // Ustalamy, że to MyAppUser ma klucz obcy w tabeli pośredniczącej
//    private Set<MyAppUser> users = new HashSet<>();
//}
//
