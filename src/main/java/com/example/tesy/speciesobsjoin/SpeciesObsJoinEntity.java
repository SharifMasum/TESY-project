package com.example.tesy.speciesobsjoin;

import com.example.tesy.observationtype.ObservationTypeEntity;

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


//    @OneToMany(mappedBy = "speciesObsJoinEntity")
//    @JoinColumn(name = "observationTypeId")
//    private Set<ObservationTypeEntity> observationTypeEntity;

    public Long getId() {
        return speciesObsJoinId;
    }

//    public Set<ObservationTypeEntity> getObservationTypeEntity() {
//        return observationTypeEntity;
//    }


}
