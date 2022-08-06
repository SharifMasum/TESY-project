package com.example.tesy.observation;

import com.example.tesy.animal.AnimalEntity;

import javax.persistence.*;

@Table
@Entity(name = "Observation")
public class ObservationEntity {
    @Id
    @SequenceGenerator(
            name="observation_sequence",
            sequenceName = "observation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "observation_sequence"
    )

    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_entity_id")
    private AnimalEntity animalEntity;

    public AnimalEntity getAnimalEntity() {
        return animalEntity;
    }

    public void setAnimalEntity(AnimalEntity animalEntity) {
        this.animalEntity = animalEntity;
    }

    public void setAnimal(AnimalEntity animalEntity) {
    }
}
