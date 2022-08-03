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

    private long id;

}
