package com.example.tesy.observationtype;

import javax.persistence.*;

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
    private Long id;
}
