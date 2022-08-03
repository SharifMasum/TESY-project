package com.example.tesy.animal;

import javax.persistence.*;

@Table
@Entity(name="Animal")
public class AnimalEntity {
    @Id
    @SequenceGenerator(
          name = "animal_sequence",
          sequenceName = "animal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "animal_sequence"
    )

    private Long id;
}
