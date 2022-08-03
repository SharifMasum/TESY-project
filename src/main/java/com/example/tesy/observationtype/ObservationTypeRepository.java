package com.example.tesy.observationtype;

import com.example.tesy.observation.ObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationTypeRepository extends JpaRepository<ObservationEntity,Long> {
}
