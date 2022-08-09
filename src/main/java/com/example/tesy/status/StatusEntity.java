package com.example.tesy.status;

import javax.persistence.*;

@Table
@Entity(name = "Status")
public class StatusEntity {
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
    private Long status_id;
    private String name;

    public StatusEntity(Long status_id, String name) {
        this.status_id = status_id;
        this.name = name;
    }

    public StatusEntity(String name) {
        this.name = name;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "status_id=" + status_id +
                ", name='" + name + '\'' +
                '}';
    }
}
