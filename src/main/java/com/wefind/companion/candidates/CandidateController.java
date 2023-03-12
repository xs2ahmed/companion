package com.wefind.companion.candidates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/candidates")
public class CandidateController {

    private  final CandidateService service;


    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Candidate> hello()
    {
        return service.getCandidates();
    }
}
