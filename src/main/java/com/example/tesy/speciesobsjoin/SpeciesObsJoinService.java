package com.example.tesy.speciesobsjoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesObsJoinService {

    private final SpeciesObsJoinRepository speciesObsJoinRepository;

    @Autowired
    public SpeciesObsJoinService(SpeciesObsJoinRepository speciesObsJoinRepository) {
        this.speciesObsJoinRepository = speciesObsJoinRepository;
    }

    public List<SpeciesObsJoinEntity> getSpeciesObsJoinEntitys() {
        return speciesObsJoinRepository.findAll();
    }

    public void addNewSpeciesObsJoinEntity(SpeciesObsJoinEntity speciesObsJoinEntity) {
    }

    public void deleteSpeciesObsJoinEntity(Long speciesObsJoinId) {
    }

    public void updateSpeciesObsJoinEntity(Long speciesObsJoinId) {
    }
}
