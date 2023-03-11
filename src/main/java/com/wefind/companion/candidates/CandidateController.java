package com.example.demo.candidates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/candidates")
public class CandidateController {

    private  CandidateService service;


    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Candidate> hello()
    {
        return service.getCandidates();
    }
}
