package ru.kata.spring.boot_security.demo.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private int id;
    @Enumerated(EnumType.STRING)
    private EnumRole role;


    public Role(int id, EnumRole role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return role.name();
    }
}
