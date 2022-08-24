package com.example.tesy.inclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/inclasses")
public class InclassesController {

    private final InclassesService inclassesService;

    @Autowired
    public InclassesController(InclassesService inclassesService) {
        this.inclassesService = inclassesService;
    }

    @GetMapping
    public List<InclassesEntity> getInClassesEntitys() {
        return inclassesService.getInClassesEntitys();
    }

    @PostMapping
    public void registerNewInClassesEntity(
            @RequestBody InclassesEntity inclassesEntity) {
        inclassesService.addNewInClassesEntity(inclassesEntity);
    }

    @DeleteMapping(path = "{inclassId}")
    public void deleteInClassesEntity(
            @PathVariable("inclassId") Long inclassId) {
        inclassesService.deleteInClassesEntity(inclassId);
    }

    @PutMapping(path = "{inclassId}")
    public void updateInclassesEntity(
            @PathVariable("inclassId") Long inclassId,
            @RequestParam(required = false) String name) {
        inclassesService.updateInClassesEntity(inclassId, name);
    }
}
