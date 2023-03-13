package com.wefind.companion.candidates;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/candidates")
public class CandidateController {

    private  final CandidateService service;


    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Candidate> getCandidates()
    {
        return service.getCandidates();
    }

    @PostMapping ("/")
    public Candidate addCandidate(@RequestBody Candidate candidate)
    {
        return service.addCandidate(candidate);
    }

/*
    @GetMapping("/phone")
    public Req submitPhone(@RequestParam(name = "phone")  String phone)
    {

    }
*/

    @GetMapping("/test")
    public ApiResponse<Candidate> testClass()
    {
        return new ApiResponse<Candidate>("success","matching candidates", service.getCandidates());
    }


}
