package com.example.tesy.species;

import com.example.tesy.observation.ObservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/species")
public class SpeciesController {

    private final SpeciesService speciesService;
    private final SpeciesRepository speciesRepository;

    @Autowired
    public SpeciesController(SpeciesService speciesService, SpeciesRepository speciesRepository) {
        this.speciesService = speciesService;
        this.speciesRepository = speciesRepository;
    }

    @GetMapping
    public List<SpeciesEntity> getSpeciesEntitys() {
        return speciesService.getSpeciesEntitys();
    }

    // Get by Id
    @GetMapping(path = "{speciesId}")
    public SpeciesEntity findSpeciesById(@PathVariable (value =
            "speciesId") Long speciesId) {
        return this.speciesRepository.findById(speciesId).orElse(null);
    }
    @PostMapping
    public void registerNewSpeciesEntity(
            @RequestBody SpeciesEntity speciesEntity) {
        speciesService.addNewSpeciesEntity(speciesEntity);
    }

    @DeleteMapping(path = "{speciesId}")
    public void deleteSpeciesEntity(
            @PathVariable("speciesId") Long speciesId) {
        speciesService.deleteSpeciesEntity(speciesId);
    }

    @PutMapping(path = "{speciesId}")
    public void updateSpeciesEntity(
            @PathVariable("speciesId") Long speciesId,
            @RequestParam(required = false) String name) {
        speciesService.updateSpeciesEntity(speciesId, name);
    }
}
