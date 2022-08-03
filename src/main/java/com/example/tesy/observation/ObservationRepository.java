package com.example.tesy.observation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<ObservationEntity,Long> {
}
