package com.example.tesy.role;

import com.example.tesy.right.RightEntity;
import com.example.tesy.right.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleEntity> getRole(){
        return roleRepository.findAll();
    }

    public void addNewRole(RoleEntity role) {
        System.out.println(role);

        Optional<RoleEntity> roleOptional = roleRepository.findRoleByRoleName(role.getRoleName());
        if (roleOptional.isPresent()) {
            throw new IllegalStateException("This role is registered before !");
        }
        roleRepository.save(role);
    }

    public void deleteRole(Integer roleId) {
        boolean exists = roleRepository.existsById(roleId);
        if (!exists) {
            throw new IllegalStateException("This Person whit id "+ roleId+" do not exists!");
        }
        roleRepository.deleteById(roleId);
    }

    @Transactional
    public void updateRole(Integer roleId,
                            String roleName) {
        RoleEntity role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalStateException("person with ID " + roleId + " do not exists!"));

        if ( roleName != null &&
                roleName.length() > 0 &&
                !Objects.equals(role.getRoleName(), role)) {
            Optional <RoleEntity> roleEntityOptional = roleRepository.findRoleByRoleName(roleName);
            if (roleEntityOptional.isPresent()) {
                throw new IllegalStateException("This role is registered before !");
            }
            role.setRoleName(roleName);
        }

        System.out.println(role);
    }
}
