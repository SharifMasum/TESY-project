package com.example.tesy.observation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObservationRepository extends JpaRepository<ObservationEntity,Long> {
    //Optional<ObservationEntity> findObservationById(Long observationId);
    //Optional<ObservationEntity> findObservationById(Long observationId);
}
