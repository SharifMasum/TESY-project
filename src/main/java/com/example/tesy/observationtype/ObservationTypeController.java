package com.example.tesy.observationtype;

import com.example.tesy.observation.ObservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/observationtype")
public class ObservationTypeController {

    private final ObservationTypeService observationTypeService;

    @Autowired
    public ObservationTypeController(ObservationTypeService observationTypeService) {
        this.observationTypeService = observationTypeService;
    }

    @GetMapping
    public List<ObservationEntity> getObservationTypeEntitys() {
        return observationTypeService.getObservationTypeEntitys();
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

    @PutMapping(path = "{typeId}")
    public void updateObservationTypeEntity(
            @PathVariable("typeId") Long typeId,
            @RequestParam(required = false) String obsType_name
    ) {
        observationTypeService.updateObservationTypeEntity(typeId,obsType_name);
    }

}
