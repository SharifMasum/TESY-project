package com.example.tesy.people;

import javax.persistence.*;

@Table
@Entity(name = "People")
public class PeopleEntity {
    @Id
    @SequenceGenerator(
            name = "people_sequence",
            sequenceName = "people_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "people_sequence"
    )
    private Long id;
}
