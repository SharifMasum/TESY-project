package com.example.tesy.observationtype;

import com.example.tesy.speciesobsjoin.SpeciesObsJoinEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name = "ObservationType")
public class ObservationTypeEntity {
    @Id
    @SequenceGenerator(
            name= "observationtype_sequence",
            sequenceName = "observationtype_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "observationtype_sequence"
    )

    private Long type_id;

    private String obsType_name;

    @ManyToOne
    @JoinColumn(name = "speciesObsJoin_entity_id")
    private SpeciesObsJoinEntity speciesObsJoinEntity;

    public Long getId() {
        return type_id;
    }

    public String getName() {
        return obsType_name;
    }

    public void setObsType_name(String obsType_name) {
        this.obsType_name = obsType_name;
    }

    public SpeciesObsJoinEntity getSpeciesObsJoinEntity() {
        return speciesObsJoinEntity;
    }

}
