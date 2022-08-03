package com.example.tesy.inclasses;

import javax.persistence.*;

@Table
@Entity(name="Inclasses")
public class InclassesEntity {
    @Id
    @SequenceGenerator(
            name = "inclasses_sequence",
            sequenceName = "inclasses_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inclasses_sequence"
    )

    private Long id;
}
