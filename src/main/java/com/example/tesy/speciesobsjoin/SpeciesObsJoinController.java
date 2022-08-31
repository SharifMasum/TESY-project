package com.example.tesy.speciesobsjoin;

import com.example.tesy.observation.ObservationEntity;
import com.example.tesy.observation.ObservationRepository;
import com.example.tesy.species.SpeciesEntity;
import com.example.tesy.species.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/speciesobsjoin")
public class SpeciesObsJoinController {

    private final SpeciesObsJoinService speciesObsJoinService;

    private final SpeciesObsJoinRepository speciesObsJoinRepository;
    private final SpeciesRepository speciesRepository;
    private final ObservationRepository observationRepository;
    @Autowired
    public SpeciesObsJoinController(SpeciesObsJoinService speciesObsJoinService, SpeciesObsJoinRepository speciesObsJoinRepository, SpeciesRepository speciesRepository, ObservationRepository observationRepository) {
        this.speciesObsJoinService = speciesObsJoinService;
        this.speciesObsJoinRepository = speciesObsJoinRepository;
        this.speciesRepository = speciesRepository;
        this.observationRepository = observationRepository;
    }

    @GetMapping
    public List<SpeciesObsJoinEntity> getSpeciesObsJoinEntitys() {
        return speciesObsJoinService.getSpeciesObsJoinEntitys();
    }

    // Get by Id
    @GetMapping(path = "{speciesObsJoinId}")
    public SpeciesObsJoinEntity findSpeciesObsJoinById(@PathVariable (value =
            "speciesObsJoinId") Long speciesObsJoinId) {
        return this.speciesObsJoinRepository.findById(speciesObsJoinId).orElse(null);
    }

    @PostMapping
    public void registerNewSpeciesObsJoinEntity(
            @RequestBody SpeciesObsJoinEntity speciesObsJoinEntity) {
        speciesObsJoinService.addNewSpeciesObsJoinEntity(speciesObsJoinEntity);
    }

    @DeleteMapping(path = "{speciesObsJoinId}")
    public void deleteNewSpeciesObsJoinEntity(
            @PathVariable("speciesObsJoinId") Long speciesObsJoinId) {
        speciesObsJoinService.deleteSpeciesObsJoinEntity(speciesObsJoinId);
    }

    @PutMapping(path = "{speciesObsJoinId}")
    public void updateSpeciesObsJoinEntity(
            @PathVariable("speciesObsJoinId") Long speciesObsJoinId
    ) {
        speciesObsJoinService.updateSpeciesObsJoinEntity(speciesObsJoinId);
    }

    //Update by species Id
    @PutMapping(path = "/{speciesObsJoinId}/species/{speciesId}")
    SpeciesObsJoinEntity assignSpeciesToSpeciesObsJoin(
            @PathVariable Long speciesId,
            @PathVariable Long speciesObsJoinId
    ) {
        SpeciesObsJoinEntity speciesobsjoin  = speciesObsJoinRepository.findById(speciesObsJoinId).get();
        SpeciesEntity species = speciesRepository.findById(speciesId).get();
        speciesobsjoin.assignSpecies(species);
        return speciesObsJoinRepository.save(speciesobsjoin);
    }

    //Update by observation Id
    @PutMapping(path = "/{speciesObsJoinId}/observation/{observationId}")
    SpeciesObsJoinEntity assignObservationTypeToSpeciesObsJoin(
            @PathVariable Long observationId,
            @PathVariable Long speciesObsJoinId
    ) {
        SpeciesObsJoinEntity speciesobsjoin  = speciesObsJoinRepository.findById(speciesObsJoinId).get();
        ObservationEntity observation = observationRepository.findById(observationId).get();
        speciesobsjoin.assignObservation(observation);
        return speciesObsJoinRepository.save(speciesobsjoin);
    }
}
