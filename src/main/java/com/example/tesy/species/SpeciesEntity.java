package com.example.tesy.species;

import javax.persistence.*;

@Table
@Entity(name="Species")
public class SpeciesEntity {
    @Id
    @SequenceGenerator(
            name = "species_sequence",
            sequenceName = "species_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "species_sequence"
    )

    private Long species_id;
    private String name;

    public SpeciesEntity(Long species_id, String name) {
        this.species_id = species_id;
        this.name = name;
    }

    public SpeciesEntity(String name) {
        this.name = name;
    }

    public Long getSpecies_id() {
        return species_id;
    }

    public void setSpecies_id(Long species_id) {
        this.species_id = species_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpeciesEntity{" +
                "species_id=" + species_id +
                ", name='" + name + '\'' +
                '}';
    }
}
