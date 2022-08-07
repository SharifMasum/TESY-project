package com.example.tesy.people;

import javax.persistence.*;


@Entity(name = "People")
@Table(name ="People",
        uniqueConstraints = {
                @UniqueConstraint(name = "username_unique",
                        columnNames = "username")
        })
public class PeopleEntity {
    @Id
    @SequenceGenerator(
            name = "people_sequence",
            sequenceName = "people_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "people_sequence"
    )
    @Column (name = "id")
    private Long peopleId;

    private String username;

    private String passwd;

    private String realName;

    public PeopleEntity(Long peopleId,
                        String username,
                        String passwd,
                        String realName) {
        this.peopleId = peopleId;
        this.username = username;
        this.passwd = passwd;
        this.realName = realName;
    }

    public PeopleEntity(String username, String passwd, String realName) {
        this.username = username;
        this.passwd = passwd;
        this.realName = realName;
    }

    public PeopleEntity() {

    }

    public Long getPeopleId() {
        return peopleId;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "PeopleEntity{" +
                "peopleId=" + peopleId +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
