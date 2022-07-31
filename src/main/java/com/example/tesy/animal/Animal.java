package com.example.tesy.animal;

import com.example.tesy.species.Species;
import com.example.tesy.status.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name="Animal")
public class Animal {
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
    private Date in_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    private Species species;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
}
