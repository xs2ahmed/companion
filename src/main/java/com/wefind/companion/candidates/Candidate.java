package com.wefind.companion.candidates;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
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
    private LocalDate dob;
    private  Integer city; // we will calculate country
    // date of registration
    private LocalDate dor;
    //date of record update
    private LocalDate dou;

    @Transient
    private Integer age;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate(String name, Integer gender, String bio, String phone, String email, LocalDate dob, Integer city, LocalDate dor, LocalDate dou) {
        this.name = name;
        this.gender = gender;
        this.bio = bio;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.dor = dor;
        this.dou = dou;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getAge() {
        return Period.between(LocalDate.now(),this.dob).getYears();
    }

    public Candidate() {
    }
}
