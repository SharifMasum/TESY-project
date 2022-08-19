package com.example.tesy.role;


import com.example.tesy.right.RightEntity;
import com.example.tesy.right.RightRepository;
import com.example.tesy.right.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/role")
public class RoleController {

    public final RoleService roleService;
    public final RoleRepository roleRepository;
    public final RightRepository rightRepository;

    @Autowired
    public RoleController(RoleService roleService,
                          RoleRepository roleRepository,
                          RightRepository rightRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
        this.rightRepository = rightRepository;
    }

    @GetMapping
    public List<RoleEntity> getRole() {
        return roleService.getRole();
    }

    @GetMapping (path = "{roleId}")
    public RoleEntity getRole(@PathVariable("roleId") Integer roleId){
        RoleEntity roleEntity = getRole().stream()
                .filter(role -> roleId.equals(role.getRoleId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Role with id" + roleId + "does not exist !"));
        return roleEntity;
    }

    @PostMapping
    public void registerNewRole(@RequestBody RoleEntity role) {

        roleService.addNewRole(role);
    }

    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId") Integer roleId) {

        roleService.deleteRole(roleId);
    }

    @PutMapping(path = "{roleId}")
    public void editRole(
            @PathVariable("roleId") Integer roleId,
            @RequestParam(required = false) String roleName){
        roleService.updateRole(roleId, roleName);
    }

    @PutMapping(path = "/{roleId}/right/{rightId}")
    RoleEntity assignRightToRole(
            @PathVariable Integer roleId,
            @PathVariable Integer rightId
    ) {
        RoleEntity role = roleRepository.getReferenceById(roleId);
        RightEntity right = rightRepository.findRightByRightId(rightId);
        role.setAssignedRight(right);
        return  roleRepository.save(role);
    }

}
