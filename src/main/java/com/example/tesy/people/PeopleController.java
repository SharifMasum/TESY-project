package com.example.tesy.people;

import com.example.tesy.inclasses.role.RoleEntity;
import com.example.tesy.inclasses.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final PeopleRepository peopleRepository;

    private final RoleRepository roleRepository;
    @Autowired
    public PeopleController(PeopleService peopleService,
                            PeopleRepository peopleRepository,
                            RoleRepository roleRepository) {
        this.peopleService = peopleService;
        this.peopleRepository = peopleRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public List<PeopleEntity> getPeople() {
        return peopleService.getPeople();
    }

    @GetMapping (path = "{peopleId}")
    public PeopleEntity getPeople(@PathVariable("peopleId") Long peopleId){
        PeopleEntity peopleEntity = getPeople().stream()
                .filter(people -> peopleId.equals(people.getPeopleId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Person with id" + peopleId + "does not exist !"));
        return peopleEntity;
    }

    @PostMapping
    public void registerNewPeople(@RequestBody PeopleEntity people) {
        peopleService.addNewPeople(people);
    }

    @DeleteMapping(path = "{peopleId}")
    public void deletePeople(@PathVariable("peopleId") Long peopleId) {
        peopleService.deletePeople(peopleId);
    }

    @PutMapping(path = "{peopleId}")
    public void editPeople(
            @PathVariable("peopleId") Long peopleId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String passwd,
            @RequestParam(required = false) String realName){
        peopleService.updatePeople(peopleId, username, passwd, realName);
    }

    @PutMapping(path = "/{peopleId}/role/{roleId}")
    PeopleEntity assignRoleTopeople(
            @PathVariable Long peopleId,
            @PathVariable Integer roleId
    ) {
        PeopleEntity people = peopleRepository.getReferenceById(peopleId);
        RoleEntity role = roleRepository.findRoleByRoleId(roleId);
        people.setAssignedRole(role);
        return  peopleRepository.save(people);
    }

    @DeleteMapping(path = "/{peopleId}/role/{roleId}")
    PeopleEntity deleteRoleFromPeople(
            @PathVariable Long peopleId,
            @PathVariable Integer roleId
    ) {
        PeopleEntity people = peopleRepository.getReferenceById(peopleId);
        RoleEntity role = roleRepository.getReferenceById(roleId);

        people.delAssignedRole(role);
        return peopleRepository.save(people);
    }

}
