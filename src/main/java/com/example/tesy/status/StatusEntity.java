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
    private Long id;

}
