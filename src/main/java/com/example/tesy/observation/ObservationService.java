package com.example.tesy.observation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ObservationService {

    private final ObservationRepository observationRepository;


    @Autowired
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void addNewObservation(ObservationEntity observation) {
        /*System.out.println(observation);

        Optional<ObservationEntity> observationOptional =
                observationRepository.findObservationById(observation.getObservationId());
        if (observationOptional.isPresent()) {
            throw new IllegalStateException("This observation id already exists! Try new one.");
        }
        observationRepository.save(observation);*/
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

    public void updateObservation(Long observationId, Date date, String value) {

    }
}
