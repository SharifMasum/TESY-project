package com.example.tesy.animal;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/animal")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(path = "{animalId}")
    public Optional<Animal> getAnimal(@PathVariable("animalId") Long animalId){
        return animalService.getAnimal(animalId);
    }
    @GetMapping
    public List<Animal> getAnimals(){
        return animalService.getAnimals();
    }


}
