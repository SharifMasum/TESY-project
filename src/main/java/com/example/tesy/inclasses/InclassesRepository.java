package com.example.tesy.inclasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InclassesRepository extends JpaRepository<InclassesEntity,Long> {
}
