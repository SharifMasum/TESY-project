package com.example.tesy.speciesobsjoin;

import com.example.tesy.observation.ObservationEntity;
import com.example.tesy.observationtype.ObservationTypeEntity;
import com.example.tesy.species.SpeciesEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name = "SpeciesObsJoin")
public class SpeciesObsJoinEntity {
    @Id
    @SequenceGenerator(
            name= "speciesobsjoin_sequence",
            sequenceName = "speciesobsjoin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "speciesobsjoin_sequence"
    )
    private Long speciesObsJoinId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "specisId")
    private SpeciesEntity species;

    public SpeciesEntity getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesEntity species) {
        this.species = species;
    }

     @ManyToMany
     @JoinTable(
             name = "species_observation",
             joinColumns = @JoinColumn(name = "speciesObsJoinId"),
             inverseJoinColumns = @JoinColumn(name = "observationId")
     )
    private Set<ObservationEntity> addedObservation = new HashSet<>();

    public SpeciesObsJoinEntity() {

    }
    public SpeciesObsJoinEntity(Long speciesObsJoinId) {
        this.speciesObsJoinId = speciesObsJoinId;
    }
    public Long getId() {
        return speciesObsJoinId;
    }

    public void setSpeciesObsJoinId(Long speciesObsJoinId) {
        this.speciesObsJoinId = speciesObsJoinId;
    }

    @Override
    public String toString() {
        return "SpeciesObsJoinEntity{" +
                "speciesObsJoinId=" + speciesObsJoinId +
                '}';
    }

    public void assignSpecies(SpeciesEntity species) {
        this.species = species;
    }

    public void assignObservation(ObservationEntity observation) {
        addedObservation.add(observation);
    }

    public void assignSpeciesObsJoin(SpeciesObsJoinEntity speciesobsjoin) {
        this.species = species;
    }
}
