package ru.ant.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ant.Spring.model.Role;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findById(Long id);
}
