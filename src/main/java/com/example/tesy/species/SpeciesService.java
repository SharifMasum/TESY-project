package com.example.tesy.species;

import com.example.tesy.status.StatusEntity;
import com.example.tesy.status.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    private final SpeciesRepository speciesRepository;

    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public List<SpeciesEntity> getSpeciesEntitys() {
        return speciesRepository.findAll();
    }

    public void addNewSpeciesEntity(SpeciesEntity speciesEntity) {
    }

    public void deleteSpeciesEntity(Long speciesId) {
    }

    public void updateSpeciesEntity(Long speciesId, String name) {
    }
}
