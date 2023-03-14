package com.wefind.companion.candidates;
// Helpful resources
// https://www.cherryservers.com/blog/how-to-install-and-setup-postgresql-server-on-ubuntu-20-04

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CandidateService {

    private  final CandidatesRepository candidatesRepository;

    @Autowired
    public CandidateService(CandidatesRepository candidatesRepository) {
        this.candidatesRepository = candidatesRepository;
    }

    public List<Candidate> getCandidates()
    {
        return candidatesRepository.findAll();
        //return List.of(new Candidate(1L, "Muhammad Ahmed", 0,"Hi This is Ahmed","+9200000000","mahmed@gmail.com", new Date(),0) );
    }

    public Candidate addCandidate(Candidate candidate)
    {
        Candidate stored = candidatesRepository.save(candidate);
        return stored;
    }

    public Candidate getUserHavingPhone(String phone) {
        Candidate candidate =  candidatesRepository.getCandidateByPhoneEquals(phone);
        return candidate;
    }
}
