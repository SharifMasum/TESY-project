package com.example.tesy.animal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AnimalConfig {

    @Bean
    CommandLineRunner commandLineRunner(AnimalRepository repository){
        return args -> {
            Animal cat = new Animal(
                    "29065/22",
                    LocalDate.of(2022,06,29),
                    "Mynämäki",
                    "cat",
                    "Petra",
                    "cat",
                    "blue",
                    "male",
                    "Very bad",
                    LocalDate.of(2022,07,29),
                    "53dls",
                    "She is in very bad situation"
            );
            Animal cat2 = new Animal(
                    "29065/22",
                    LocalDate.of(2022,06,29),
                    "Mynämäki",
                    "cat",
                    "Petra",
                    "cat",
                    "blue",
                    "male",
                    "Very bad",
                    LocalDate.of(2022,07,29),
                    "53dls",
                    "She is in very bad situation"
            );
            repository.saveAll(List.of(cat2,cat));
        };
    }
}
