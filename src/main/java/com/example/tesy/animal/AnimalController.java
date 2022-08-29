package com.example.tesy.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    // Create animal
    @PostMapping
    public AnimalEntity addAnimal (@RequestBody AnimalEntity animal){
        return this.animalRepository.save(animal);
    }

    //Get for all
    @GetMapping
    public List<AnimalEntity> findAnimals (){
        return animalService.getAnimalEntities();
    }

    //Get by id
    @GetMapping("/{id}")
    public AnimalEntity findAnimalById(@PathVariable (value = "id") long animalId){
        return this.animalRepository.findById(animalId).orElse(null);
    }

    @PutMapping("/{id}")
    public AnimalEntity updateAnimal (@RequestBody AnimalEntity animal, @PathVariable("id") long animalId) {
        AnimalEntity currentAnimal = this.animalRepository.findById(animalId).
                orElse(null);
        currentAnimal.setInDate(animal.getInDate());
        currentAnimal.setInTesyDate(animal.getInTesyDate());
        currentAnimal.setOutTesyDate(animal.getOutTesyDate());
        currentAnimal.setFromWhere(animal.getFromWhere());
        currentAnimal.setPopulation(animal.getPopulation());
        currentAnimal.setReason(animal.getReason());
        currentAnimal.setCallingNameOfTheAnimal(animal.getCallingNameOfTheAnimal());
        currentAnimal.setMicrochipNumber(animal.getMicrochipNumber());
        currentAnimal.setAnimalAge(animal.getAnimalAge());
        currentAnimal.setAnimalColor(animal.getAnimalColor());
        currentAnimal.setBreedAnimal(animal.getBreedAnimal());
        currentAnimal.setEuthanizedReasons(animal.getEuthanizedReasons());
        currentAnimal.setSeyStatistics(animal.getSeyStatistics());
        currentAnimal.setExtraNotes(animal.getExtraNotes());
        currentAnimal.setSpecies(animal.getSpecies());
        currentAnimal.setStatus(animal.getStatus());
        return this.animalRepository.save(currentAnimal);
    }
    // Delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<AnimalEntity> deleteAnimal(@PathVariable("id")long animalId) {
        AnimalEntity currentAnimal = this.animalRepository.findById(animalId).orElse(null);
        this.animalRepository.delete(currentAnimal);
        return ResponseEntity.ok().build();
    }
}
