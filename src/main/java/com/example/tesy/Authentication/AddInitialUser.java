package com.example.tesy.Authentication;


import com.example.tesy.people.PeopleEntity;
import com.example.tesy.people.PeopleRepository;
import com.example.tesy.role.RoleEntity;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.beans.JavaBean;

@Configuration
public class AddInitialUser {
//   private final PeopleEntity peopleEntity;
//   private final RoleEntity roleEntity;
   private final PeopleRepository peopleRepository;

   private final PasswordEncoder passwordEncoder;

    @Autowired
    public AddInitialUser(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
//        this.peopleEntity = peopleEntity;
//        this.roleEntity = roleEntity;
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public void adduser(){
        PeopleEntity people = new PeopleEntity(100L,

                "admin",passwordEncoder.encode("p1230"),"Tesy Admin"
        );
        if (peopleRepository.findPeopleByUsername(people.getUsername()).isPresent()){}
        else peopleRepository.save(people);
    }

}
