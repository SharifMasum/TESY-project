package com.example.tesy.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimal(Long animalId) {
        var doesExist = animalRepository.existsById(animalId);
        if(!doesExist){
            throw new IllegalStateException("The animal with the given ID doesn't exist");
        }
            return animalRepository.findById(animalId);

    }
    public List<Animal> getAnimals() {
        return animalRepository.findAll();

    }


}
