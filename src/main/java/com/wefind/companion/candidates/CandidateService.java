package com.example.demo.candidates;
// Helpful resources
// https://www.cherryservers.com/blog/how-to-install-and-setup-postgresql-server-on-ubuntu-20-04

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CandidateService {

    public List<Candidate> getCandidates()
    {
        return List.of(new Candidate(1L, "Muhammad Ahmed", "Hi This is Ahmed", new Date()));
    }
}
