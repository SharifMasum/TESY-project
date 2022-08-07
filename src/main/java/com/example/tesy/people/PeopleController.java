package com.example.tesy.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleController(PeopleService peopleService,
                            PeopleRepository peopleRepository) {
        this.peopleService = peopleService;
        this.peopleRepository = peopleRepository;
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

}
