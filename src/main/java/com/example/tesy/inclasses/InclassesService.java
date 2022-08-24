package com.example.tesy.inclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InclassesService {

    private final InclassesRepository inclassesRepository;

    @Autowired
    public InclassesService(InclassesRepository inclassesRepository) {
        this.inclassesRepository = inclassesRepository;
    }

    public List<InclassesEntity> getInClassesEntitys() { return inclassesRepository.findAll(); }

    public void addNewInClassesEntity(InclassesEntity inclassesEntity) {
    }

    public void deleteInClassesEntity(Long typeId) {
    }

    public void updateInClassesEntity(Long inclassId, String name) {
    }
}
