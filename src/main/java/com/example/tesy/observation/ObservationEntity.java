package com.example.tesy.observation;

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
}
