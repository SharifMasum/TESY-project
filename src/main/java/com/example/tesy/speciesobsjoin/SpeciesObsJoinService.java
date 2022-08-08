package com.example.tesy.speciesobsjoin;

import com.example.tesy.observationtype.ObservationTypeEntity;
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

    public void addNewSpeciesObsJoinEntity(ObservationTypeEntity observationTypeEntity) {
    }

    public void deleteSpeciesObsJoinEntity(Long type_id) {
    }

    public void update(Long speciesObsJoin_id) {
    }
}
