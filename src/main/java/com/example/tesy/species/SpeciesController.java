package com.example.tesy.species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/species")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    public List<SpeciesEntity> getSpeciesEntitys() {
        return speciesService.getSpeciesEntitys();
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
