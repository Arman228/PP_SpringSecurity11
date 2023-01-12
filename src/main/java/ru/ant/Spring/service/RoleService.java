package ru.ant.Spring.service;

import org.springframework.stereotype.Service;
import ru.ant.Spring.model.Role;

import java.util.List;

@Service
public interface RoleService {
    void findRoleById(int id);

    List<Role> getAllRoles();

    void addRole(Role role);
}
