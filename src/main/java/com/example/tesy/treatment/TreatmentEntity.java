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

    public TreatmentEntity() {

    }

    public void setAnimal(AnimalEntity animalEntity) {
    }

    public TreatmentEntity(Long id, Date date, String description, Double amountOfMedication, AnimalEntity animal, PeopleEntity people) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amountOfMedication = amountOfMedication;
        this.animal = animal;
        this.people = people;
    }

    public TreatmentEntity(Date date, String description, Double amountOfMedication, AnimalEntity animal, PeopleEntity people) {
        this.date = date;
        this.description = description;
        this.amountOfMedication = amountOfMedication;
        this.animal = animal;
        this.people = people;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmountOfMedication() {
        return amountOfMedication;
    }

    public void setAmountOfMedication(Double amountOfMedication) {
        this.amountOfMedication = amountOfMedication;
    }

    public AnimalEntity getAnimal() {
        return animal;
    }

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "TreatmentEntity{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", amountOfMedication=" + amountOfMedication +
                ", animal=" + animal +
                ", people=" + people +
                '}';
    }
}
