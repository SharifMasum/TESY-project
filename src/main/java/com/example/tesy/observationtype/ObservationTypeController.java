package com.example.tesy.observationtype;

import com.example.tesy.observation.ObservationEntity;
import com.example.tesy.speciesobsjoin.SpeciesObsJoinEntity;
import com.example.tesy.speciesobsjoin.SpeciesObsJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/observationtype")
public class ObservationTypeController {

    private final ObservationTypeService observationTypeService;

    private final ObservationTypeRepository observationTypeRepository;
    private final SpeciesObsJoinRepository speciesObsJoinRepository;

    @Autowired
    public ObservationTypeController(ObservationTypeService observationTypeService, ObservationTypeRepository observationTypeRepository, SpeciesObsJoinRepository speciesObsJoinRepository) {
        this.observationTypeService = observationTypeService;
        this.observationTypeRepository = observationTypeRepository;
        this.speciesObsJoinRepository = speciesObsJoinRepository;
    }

    // Get the list
    @GetMapping
    public List<ObservationEntity> getObservationTypeEntitys() {
        return observationTypeService.getObservationTypeEntitys();
    }

    // Get by Id
    @GetMapping(path = "{typeId}")
    public ObservationEntity findObservationTypeById(@PathVariable (value =
            "typeId") Long typeId) {
        return this.observationTypeRepository.findById(typeId).orElse(null);
    }

    @PostMapping
    public void registerNewObservationTypeEntity(
            @RequestBody ObservationTypeEntity observationTypeEntity) {
        observationTypeService.addNewObservationTypeEntity(observationTypeEntity);
    }

    @DeleteMapping(path = "{typeId}")
    public void deleteObservationTypeEntity(
            @PathVariable("typeId") Long typeId) {
        observationTypeService.deleteObservationTypeEntity(typeId);
    }

    //Update by Id
    @PutMapping(path = "{typeId}")
    public void updateObservationTypeEntity(
            @PathVariable("typeId") Long typeId,
            @RequestParam(required = false) String obsType_name
    ) {
        observationTypeService.updateObservationTypeEntity(typeId,obsType_name);
    }


    //Update by speciesObsJoin Id
    //Not working as I expected

    @PutMapping(path = "/{typeId}/speciesobsjoin/{speciesObsJoinId}")
    ObservationEntity assignSpeciesObsJoinToObservationType(
            @PathVariable Long typeId,
            @PathVariable Long speciesObsJoinId
    ) {
        ObservationEntity type = observationTypeRepository.findById(typeId).get();
        SpeciesObsJoinEntity speciesobsjoin = speciesObsJoinRepository.findById(speciesObsJoinId).get();
        speciesobsjoin.assignSpeciesObsJoin(speciesobsjoin);
        return observationTypeRepository.save(type);
    }

}
