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

    private Long inclassId;
    private String name;

    public InclassesEntity(Long inclassId, String name) {
        this.inclassId = inclassId;
        this.name = name;
    }

    public InclassesEntity(String name) {
        this.name = name;
    }

    public InclassesEntity() {

    }

    public Long getInclassId() {
        return inclassId;
    }

    public void setInclassId(Long inclassId) {
        this.inclassId = inclassId;
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
                "inclassId=" + inclassId +
                ", name='" + name + '\'' +
                '}';
    }
}
