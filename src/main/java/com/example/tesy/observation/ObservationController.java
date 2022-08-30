package com.example.tesy.observation;

import com.example.tesy.animal.AnimalEntity;
import com.example.tesy.animal.AnimalRepository;
import com.example.tesy.observationtype.ObservationTypeEntity;
import com.example.tesy.observationtype.ObservationTypeRepository;
import com.example.tesy.people.PeopleEntity;
import com.example.tesy.people.PeopleRepository;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/{observationId}/animal/{animalID}")
    ObservationEntity assignObservationToAnimal(
            @PathVariable Long animalID,
            @PathVariable Long observationId
    ) {
        ObservationEntity observation = observationRepository.findById(observationId).get();
        AnimalEntity animal = animalRepository.findById(animalID).get();
        observation.assignAnimal(animal);
        return observationRepository.save(observation);
    }

    @PutMapping(path = "/{observationId}/people/{peopleID}")
    ObservationEntity assignObservationToPeople(
            @PathVariable Long peopleID,
            @PathVariable Long observationId
    ) {
        ObservationEntity observation = observationRepository.findById(observationId).get();
        PeopleEntity people = peopleRepository.findById(peopleID).get();
        observation.assignPeople(people);
        return observationRepository.save(observation);
    }
}
