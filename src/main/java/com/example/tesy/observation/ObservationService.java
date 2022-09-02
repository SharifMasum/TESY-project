package com.example.tesy.observation;

import com.example.tesy.species.SpeciesEntity;
import com.example.tesy.status.StatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ObservationService {

    private final ObservationRepository observationRepository;


    @Autowired
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
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
    @Transactional
    public ObservationEntity updateObservation(Long observationId, ObservationEntity newObservation) {
        ObservationEntity updateObservation = observationRepository.findById(observationId).orElseThrow(()
                -> new IllegalStateException("Observation with ID " + observationId + " do not exists!"));
        if  (newObservation.getDate() !=null &&
                !Objects.equals(updateObservation.getDate(),
                        newObservation.getDate()))
            updateObservation.setDate(newObservation.getDate());

        if  (newObservation.getValue() !=null &&
                !Objects.equals(updateObservation.getValue(),
                        newObservation.getValue())) {
            updateObservation.setValue(newObservation.getValue());
        }
        return updateObservation;
    }
}
