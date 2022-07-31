package com.example.tesy.species;

import com.example.tesy.animal.Animal;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name="Species")
public class Species {
    @Id
    @SequenceGenerator(
            name = "species_sequence",
            sequenceName = "species_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "species_sequence"
    )

    private long id;
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "species")
    private Set<Animal> animals = new HashSet<>();

    public Species(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Species(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
