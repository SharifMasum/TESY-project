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

    //Relation with Species
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "specisId")
    private SpeciesEntity species;

    public SpeciesEntity getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesEntity species) {
        this.species = species;
    }

    /*
    // Relation with Observation. Later, relation type changed due to failure in execution.
    An expert can still use this relation. In this case, it is suggested to remove/comment out *ManyToOne relation
         @ManyToMany
         @JoinTable(
                 name = "species_observation",
                 joinColumns = @JoinColumn(name = "speciesObsJoinId"),
                 inverseJoinColumns = @JoinColumn(name = "observationId")
         )
        private Set<ObservationEntity> addedObservation = new HashSet<ObservationEntity>();
        */

    // Relation with Observation
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "observationId")
    private ObservationEntity observation;

    public SpeciesObsJoinEntity(Long speciesObsJoinId,
                                SpeciesEntity species,
                                ObservationEntity observation) {
        this.speciesObsJoinId = speciesObsJoinId;
        this.species = species;
        this.observation = observation;
    }

    public SpeciesObsJoinEntity(SpeciesEntity species,
                                ObservationEntity observation) {
        this.species = species;
        this.observation = observation;
    }
    public SpeciesObsJoinEntity() {

    }

    public ObservationEntity getObservation() {
        return observation;
    }

    public void setObservation(ObservationEntity observation) {
        this.observation = observation;
    }
    /*
    public Long getId() {
        return speciesObsJoinId;
    }

    public void setSpeciesObsJoinId(Long speciesObsJoinId) {
        this.speciesObsJoinId = speciesObsJoinId;
    }*/

    public Long getSpeciesObsJoinId() {
        return speciesObsJoinId;
    }

    public void setSpeciesObsJoinId(Long speciesObsJoinId) {
        this.speciesObsJoinId = speciesObsJoinId;
    }

    public void assignSpecies(SpeciesEntity species) {
        this.species = species;
    }

    public void assignSpeciesObsJoin(SpeciesObsJoinEntity speciesobsjoin) {
        this.species = species;
    }

    public void AssignObservation(ObservationEntity observation) {
        this.observation = observation;
    }


    /*public void assignObservation(ObservationEntity observation) {
        addedObservation.add(observation);
    }*/

    /*public void setAssignObservation(ObservationEntity observation) { addedObservation.add(observation);
    }*/


    @Override
    public String toString() {
        return "SpeciesObsJoinEntity{" +
                "speciesObsJoinId=" + speciesObsJoinId +
                '}';
    }

}
