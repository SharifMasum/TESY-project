package com.example.tesy.animal;

import com.example.tesy.observation.ObservationEntity;
import com.example.tesy.people.PeopleEntity;
import com.example.tesy.species.SpeciesEntity;
import com.example.tesy.status.StatusEntity;
import com.example.tesy.treatment.TreatmentEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity(name="Animal")
public class AnimalEntity {
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

    @SequenceGenerator(
            name = "tesyId_sequence",
            sequenceName = "tesyId_sequence",
            allocationSize = 1
    )
    private String tesyId;

    private Date inDate;

    private Date inTesyDate;

    private Date outTesyDate;

    // Origin of the animal
    private String fromWhere;

    // Name of the cat population
    private String population;

    // Why the animal was captured
    private String reason;

    //Calling name of the animal
    private String callingNameOfTheAnimal;

    // Identification microchip.
    private String microchipNumber;



    /*private String ageClass;
    public <Pregnant, Adult, Young, Dam> void ageClass
    (Pregnant pregnant, Adult adult, Young young, Dam dam)*/




    // FamilyMember fmm,FamilyMember fmf,FamilyMember fms,int mId){
    //  this.ageClass= List<pregnant, adult, young, dam>

    //            this.gender = gen;
    //            this.address = add;
    //            this.mother = fmm;
    //            this.father = fmf;
    //            this.spouse = fms;
    //            this.memberID = mId;
    //        }

    //age_class String At this point we're hardcoding this one: pregnant, adult, young, dam. In Finnish: tiine, aikuinen, pentu, emo
    // Age of the animal. Can be either number or text
    private Number animalAge;

    //sex String Well, since there are only four options it's safe to hardcode this one. (male, female, probably male, probably female)

    // Colorcodes are quite complicated issue. We can use string for this.
    private String animalColor;

    //Breed of the animal
    private String breedAnimal;

    //The reason why euthanized
    private String euthanizedReasons;

    //Information for Sey statistics. Written by the user.
    private String seyStatistics;

    // Extra notes
    private String extraNotes;

    //create_date Date When the record is created. Time from the server. Never changed.
    @CreatedDate

    private Date createDate;

    @ManyToOne(cascade = {CascadeType.ALL})

    @JoinColumn(name = "species_ID")
    private SpeciesEntity species;

    // @Embedded
    // private Species species;
/// relations
    @OneToMany(
            mappedBy = "animal",
            cascade = CascadeType.ALL
    )
    private List<TreatmentEntity> treatmentsList = new ArrayList<TreatmentEntity>();
    public void addItem(TreatmentEntity item) {

        this.treatmentsList.add(item);

        item.setAnimal(this);

    }

    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ObservationEntity> observationsList = new ArrayList<>();
    public void addItem(ObservationEntity item) {

        this.observationsList.add(item);

        item.setAnimal(this);

    }

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "personId")
    private PeopleEntity people;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name ="statusId")
    private StatusEntity status;

    public SpeciesEntity getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesEntity species) {
        this.species = species;
    }


}
