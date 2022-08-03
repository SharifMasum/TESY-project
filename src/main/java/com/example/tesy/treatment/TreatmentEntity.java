package com.example.tesy.treatment;

import javax.persistence.*;

@Table
@Entity(name = "Treatment")
public class TreatmentEntity {
    @Id
    @SequenceGenerator(
            name = "treatment_sequence",
            sequenceName = "treatment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "treatment_sequence"
    )

    private Long id;
}
