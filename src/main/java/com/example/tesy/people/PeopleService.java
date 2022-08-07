package com.example.tesy.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleEntity> getPeople(){
        return peopleRepository.findAll();
    }


    public void addNewPeople(PeopleEntity people) {
        System.out.println(people);

        Optional<PeopleEntity> peopleOptional = peopleRepository.findPeopleByUsername(people.getUsername());
        if (peopleOptional.isPresent()) {
            throw new IllegalStateException("This Username is registered before !");
        }
        peopleRepository.save(people);
    }

    public void deletePeople(Long peopleId) {
        boolean exists = peopleRepository.existsById(peopleId);
        if (!exists) {
            throw new IllegalStateException("This Person whit id "+ peopleId+" do not exists!");
        }
        peopleRepository.deleteById(peopleId);
    }

    @Transactional
    public void updatePeople(Long peopleId,
                             String username,
                             String passwd,
                             String realName) {
        PeopleEntity people = peopleRepository.findById(peopleId)
                .orElseThrow(() -> new IllegalStateException("person with ID " + peopleId + " do not exists!"));

        if ( username != null &&
                username.length() > 0 &&
                !Objects.equals(people.getUsername(), username)) {
                Optional <PeopleEntity> peopleEntityOptional = peopleRepository.findPeopleByUsername(username);
            if (peopleEntityOptional.isPresent()) {
                throw new IllegalStateException("This username is registered before !");
            }
            people.setUsername(username);
        }

        if ( passwd != null &&
                passwd.length() > 0 &&
                !Objects.equals(people.getPasswd(), passwd)) {
            people.setPasswd(passwd);
        }

        if ( realName != null &&
                realName.length() > 0 &&
                !Objects.equals(people.getRealName(), realName)) {
            people.setRealName(realName);
        }
        System.out.println(people);
    }
}
