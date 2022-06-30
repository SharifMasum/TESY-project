package com.example.tesy.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();

    }

    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Long animalId) {
       var doesExist = animalRepository.existsById(animalId);
       if(!doesExist){
           throw new IllegalStateException("The animal with the given ID doesn't exist");
       }else{
           animalRepository.deleteById(animalId);
       }
    }

    @Transactional
    public void updateAnimal(Long id, String tesyId, String fromWhere,
                             String animal, String name, String typeOfAnimal,
                             String color, String sex, String situation,
                             String chipNumber, String note) {
        var foundAnimal = animalRepository.findById(id).orElseThrow(()->new IllegalStateException(
                "Animal with given ID doesn't exist"
        ));
        System.out.println(foundAnimal);
        if(tesyId!=null && tesyId.length()>0 && !Objects.equals(foundAnimal.getTesyId(),tesyId)){
            foundAnimal.setTesyId(tesyId);
        }
        if(fromWhere!=null && fromWhere.length()>0 && !Objects.equals(foundAnimal.getFromWhere(),fromWhere)){
            foundAnimal.setFromWhere(fromWhere);
        }
        if(animal!=null && animal.length()>0 && !Objects.equals(foundAnimal.getAnimal(),animal)){
            foundAnimal.setAnimal(animal);
        }
        if(name!=null && name.length()>0 && !Objects.equals(foundAnimal.getName(),name)){
            foundAnimal.setName(name);
        }
        if(typeOfAnimal!=null && typeOfAnimal.length()>0 && !Objects.equals(foundAnimal.getTypeOfAnimal(),typeOfAnimal)){
            foundAnimal.setTypeOfAnimal(typeOfAnimal);
        }
        if(color!=null && color.length()>0 && !Objects.equals(foundAnimal.getColor(),color)){
            foundAnimal.setColor(color);
        }
        if(sex!=null && sex.length()>0 && !Objects.equals(foundAnimal.getSex(),sex)){
            foundAnimal.setSex(sex);
        }
        if(situation!=null && situation.length()>0 && !Objects.equals(foundAnimal.getSituation(),situation)){
            foundAnimal.setSituation(situation);
        }
        if(chipNumber!=null && chipNumber.length()>0 && !Objects.equals(foundAnimal.getChipNumber(),chipNumber)){
            foundAnimal.setChipNumber(chipNumber);
        }
        if(note!=null && note.length()>0 && !Objects.equals(foundAnimal.getNote(),note)){
            foundAnimal.setNote(note);
        }

    }
}
