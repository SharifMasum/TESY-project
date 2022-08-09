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

    @DeleteMapping(path = "{type_id}")
    public void deleteObservationTypeEntity(
            @PathVariable("type_id") Long type_id) {
        observationTypeService.deleteObservationTypeEntity(type_id);
    }

    @PutMapping(path = "{type_id")
    public void updateObservationTypeEntity(
            @PathVariable("type_id") Long type_id,
            @RequestParam(required = false) String obsType_name
    ) {
        observationTypeService.update(type_id,obsType_name);
    }

}
