package com.example.tesy.status;

import com.example.tesy.animal.Animal;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name = "Status")
public class Status {
    @Id
    @SequenceGenerator(
            name = "status_sequence",
            sequenceName = "status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "status_sequence"
    )
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private Set<Animal> animals = new HashSet<>();

    public Status(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Status(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
