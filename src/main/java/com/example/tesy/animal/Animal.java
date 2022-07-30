package com.example.tesy.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

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


}
