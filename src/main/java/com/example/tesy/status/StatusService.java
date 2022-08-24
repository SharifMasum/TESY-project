package com.example.tesy.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<StatusEntity> getStatusEntitys() {
        return statusRepository.findAll();
    }

    public void addNewStatusEntity(StatusEntity statusEntity) {
    }

    public void deleteStatusEntity(Long statusId) {
    }

    public void updateStatusEntity(Long statusId, String name) {
    }
}
