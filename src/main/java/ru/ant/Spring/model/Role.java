package ru.ant.Spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Slf4j
public class Role implements GrantedAuthority {
    @Id
    private Integer id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> user;

    public Role(Integer i, String role_admin) {
    }


    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getNoPrefix() {
        String pr = "ROLE_";
        return name.substring(pr.length());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
