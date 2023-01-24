package io.tirzah.oldie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Role extends BaseEntity {
    private String name;

    public Role(String roleUser) {
        this.name = roleUser;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
