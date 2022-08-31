package com.example.tesy.observation;

import com.example.tesy.animal.AnimalEntity;
import com.example.tesy.animal.AnimalRepository;
import com.example.tesy.observationtype.ObservationTypeEntity;
import com.example.tesy.observationtype.ObservationTypeRepository;
import com.example.tesy.people.PeopleEntity;
import com.example.tesy.people.PeopleRepository;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/observation")
public class ObservationController {

    private final ObservationService observationService;
    private final ObservationRepository observationRepository;
    private final AnimalRepository animalRepository;
    private final PeopleRepository peopleRepository;
    private final ObservationTypeRepository observationTypeRepository;

    public ObservationController(ObservationService observationService,
                                 ObservationRepository observationRepository,
                                 AnimalRepository animalRepository,
                                 PeopleRepository peopleRepository,
                                 ObservationTypeRepository observationTypeRepository) {
        this.observationService = observationService;
        this.observationRepository = observationRepository;
        this.animalRepository = animalRepository;
        this.peopleRepository = peopleRepository;
        this.observationTypeRepository = observationTypeRepository;
    }

    @PostMapping
    public void registerNewObservation(@RequestBody ObservationEntity observation) {
        observationService.addNewObservation(observation);
    }

    // Get all
    @GetMapping
    public List<ObservationEntity> getObservation() {
        return observationService.getObservations();
    }

    // Get by Id
    @GetMapping(path = "{observationId}")
    public ObservationEntity findObservationById(@PathVariable (value =
            "observationId") Long observationId) {
        return this.observationRepository.findById(observationId).orElse(null);
    }

    // Delete by Id
    @DeleteMapping(path = "{observationId}")
    public void deleteObservation(@PathVariable("observationId") Long observationId) {
        observationService.deleteObservation(observationId);
    }

    //Update by observation Id
    @PutMapping(path = "/{observationId}")
    public void updateObservation(
            @PathVariable Long observationId,
            @RequestParam(required = true)Date date,
            @RequestParam(required = false) String value)
             {
        observationService.updateObservation(observationId, date, value);
    }

    //Update by animal Id, relational data reference to animal class
    @PutMapping(path = "/{observationId}/animal/{animalId}")
    ObservationEntity assignObservationToAnimal(
            @PathVariable Long animalId,
            @PathVariable Long observationId
    ) {
        ObservationEntity observation = observationRepository.findById(observationId).get();
        AnimalEntity animal = animalRepository.findById(animalId).get();
        observation.assignAnimal(animal);
        return observationRepository.save(observation);
    }

    // Update by people Id, relational data reference to people class
    @PutMapping(path = "/{observationId}/people/{peopleId}")
    ObservationEntity assignObservationToPeople(
            @PathVariable Long peopleId,
            @PathVariable Long observationId
    ) {
        ObservationEntity observation = observationRepository.findById(observationId).get();
        PeopleEntity people = peopleRepository.findById(peopleId).get();
        observation.assignPeople(people);
        return observationRepository.save(observation);
    }

    /*
    //Update by observation type id, relational data, reference of observation type class
    //Does not work. "getOne()" is depreciated. Needs to find proper alternative.
    //ObservationTypeEntity is not legal here. But should be. Need to find alternate method.

    @PutMapping(path = "/{observationId}/type/{typeId}")
    ObservationEntity assignObservationToObservationType(
            @PathVariable Long typeId,
            @PathVariable Long observationId
    ) {
        ObservationEntity observation = observationRepository.getOne(observationId);
        ObservationTypeEntity type = observationTypeRepository.getOne(typeId);
        observation.assignType(type);
        return observationRepository.save(observation);
    }*/
}
