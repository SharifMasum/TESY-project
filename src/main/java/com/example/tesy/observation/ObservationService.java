package com.example.tesy.observation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    private final ObservationRepository observationRepository;

    @Autowired
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void addNewObservation(ObservationEntity observation) {
    }

    public List<ObservationEntity> getObservations() {
        return observationRepository.findAll();
    }

    public void deleteObservation(Long observationId) {
        boolean exists = observationRepository.existsById(observationId);
        if (!exists) {
            throw new IllegalStateException("This observation with Id " +
                    ""+ observationId +" do not exist!");
        }
        observationRepository.deleteById(observationId);
    }
}
