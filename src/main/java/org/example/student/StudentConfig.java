package org.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Alice = new Student(
                    "Alice",
                    "alice@gmail.com",
                    LocalDate.of(2000,1,23)
            );
            Student Bob = new Student(
                    "Bob",
                    "Bob@gmail.com",
                    LocalDate.of(2005,10,25)
            );
            repository.saveAll(List.of(Alice, Bob));
        };
    }
}
