package ru.kata.spring.boot_security.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String name;
    private String email;
    private int age;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_has_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Collection<Role> roles;

}
