package com.example.demo.candidates;

import java.util.Date;

public class Candidate {

    private  String name;
    private  String bio;
    private  Long id;
    private Date dob;

    public Candidate(Long id, String name, String bio,  Date dob) {
        this.name = name;
        this.id = id;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dob=" + dob +
                '}';
    }
}
