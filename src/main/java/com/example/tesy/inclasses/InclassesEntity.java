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

    private Long inclass_id;
    private String name;

    public InclassesEntity(Long inclass_id, String name) {
        this.inclass_id = inclass_id;
        this.name = name;
    }

    public InclassesEntity(String name) {
        this.name = name;
    }

    public Long getInclass_id() {
        return inclass_id;
    }

    public void setInclass_id(Long inclass_id) {
        this.inclass_id = inclass_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InclassesEntity{" +
                "inclass_id=" + inclass_id +
                ", name='" + name + '\'' +
                '}';
    }
}
