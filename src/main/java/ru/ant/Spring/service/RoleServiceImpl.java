package ru.ant.Spring.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ant.Spring.model.Role;
import ru.ant.Spring.repository.RoleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleRepository roleRepository;


    @Override
    public void findRoleById(int id) {
        roleRepository.findById(id);

    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();

    }

    @Transactional
    @Override
    public void addRole(Role role) {
     roleRepository.save(role);
    }
}
