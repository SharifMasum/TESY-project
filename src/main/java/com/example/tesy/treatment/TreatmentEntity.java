package com.example.tesy.treatment;

import com.example.tesy.animal.AnimalEntity;
import com.example.tesy.people.PeopleEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

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

    //When performend
    private Date date;

    //What was done?
    private String description;


    //dosage String Amount of medication
    // @Wisam, I think it is better to be Double.
    private Double amountOfMedication;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER


    )
    @JoinColumn(
            name = "animal_id",
            referencedColumnName = "animalId"

    )
    private AnimalEntity animal;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "personId"

    )
    private PeopleEntity people;

    public void setAnimal(AnimalEntity animalEntity) {
    }
}
