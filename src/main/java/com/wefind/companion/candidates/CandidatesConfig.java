package com.wefind.companion.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Configuration
public class CandidatesConfig {

 private  final CandidatesRepository candidatesRepository;

    @Autowired
    public CandidatesConfig(CandidatesRepository candidatesRepository) {
        this.candidatesRepository = candidatesRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            Candidate one =  new Candidate("Muhammad Ahmed", 0,"Hi This is Ahmed","+9200000000","mahmed@gmail.com", LocalDate.now(),0, LocalDate.now(),LocalDate.now()) ;
            Candidate two =  new Candidate("Muhammad Ali", 0,"Hi This is Ahmed","92300","mahmed@gmail.com", LocalDate.now(),0, LocalDate.now(),LocalDate.now()) ;
            candidatesRepository.saveAll(List.of(one,two));
        };

    }
}
