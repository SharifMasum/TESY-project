package com.example.tesy.speciesobsjoin;

import javax.persistence.*;

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
    private Long id;
}
