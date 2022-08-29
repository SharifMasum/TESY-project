package com.example.tesy.observationtype;

import com.example.tesy.observation.ObservationEntity;
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

    private Long typeId;

    private String obsType_name;

    @ManyToMany
    @JoinTable(
            name = "observation_made",
            joinColumns = @JoinColumn(name = "typeId"),
            inverseJoinColumns = @JoinColumn(name = "speciesObsJoinId")
    )
    private Set<SpeciesObsJoinEntity> observationIncluded = new HashSet<>();

    public ObservationTypeEntity(Long typeId, String obsType_name) {
        this.typeId = typeId;
        this.obsType_name= obsType_name;
    }

    public ObservationTypeEntity() {

    }

    public Long getTypeId() {
        return typeId;
    }

    public String getObsType_name() {
        return obsType_name;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setObsType_name(String obsType_name) {
        this.obsType_name = obsType_name;
    }

    @Override
    public String toString() {
        return "ObservationTypeEntity{" +
                "typeId=" + typeId +
                ", obsType_name=" + obsType_name +
                '}';
    }
}
