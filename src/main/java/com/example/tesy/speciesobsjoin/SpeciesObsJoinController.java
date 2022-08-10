package com.example.tesy.speciesobsjoin;

import com.example.tesy.observation.ObservationEntity;
import com.example.tesy.observationtype.ObservationTypeEntity;
import com.example.tesy.observationtype.ObservationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/speciesobsjoin")
public class SpeciesObsJoinController {

    private final SpeciesObsJoinService speciesObsJoinService;

    @Autowired
    public SpeciesObsJoinController(SpeciesObsJoinService speciesObsJoinService) {
        this.speciesObsJoinService = speciesObsJoinService;
    }

    @GetMapping
    public List<SpeciesObsJoinEntity> getSpeciesObsJoinEntitys() {
        return speciesObsJoinService.getSpeciesObsJoinEntitys();
    }

    @PostMapping
    public void registerNewObservationTypeEntity(
            @RequestBody ObservationTypeEntity observationTypeEntity) {
        speciesObsJoinService.addNewSpeciesObsJoinEntity(observationTypeEntity);
    }

    @DeleteMapping(path = "{speciesObsJoinId}")
    public void deleteObservationTypeEntity(
            @PathVariable("speciesObsJoinId") Long typeId) {
        speciesObsJoinService.deleteSpeciesObsJoinEntity(typeId);
    }

    @PutMapping(path = "{speciesObsJoinId}")
    public void updateObservationTypeEntity(
            @PathVariable("speciesObsJoin") Long speciesObsJoinId
    ) {
        speciesObsJoinService.update(speciesObsJoinId);
    }
}
