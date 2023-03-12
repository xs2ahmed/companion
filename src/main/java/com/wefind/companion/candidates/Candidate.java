package com.wefind.companion.candidates;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "candidates")
public class Candidate {

@Id
@SequenceGenerator(
        name = "candidate_sequence",
        sequenceName = "candidate_sequence",
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "candidate_sequence"

)
    private  Long id;
    private  String name;
    private Integer gender;
    private  String bio;
    private  String phone;
    private  String email;
    private Date dob;
    private  Integer city; // we will calculate country


    public Candidate(Long id, String name, Integer gender, String bio, String phone, String email, Date dob, Integer city) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bio = bio;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.city = city;
    }

    public Candidate() {
    }
}
