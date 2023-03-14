package com.wefind.companion.application;

import com.wefind.companion.candidates.ApiResponse;
import com.wefind.companion.candidates.Candidate;
import com.wefind.companion.candidates.CandidateService;
import com.wefind.companion.candidates.ApiResponseEx;
import com.wefind.companion.tokens.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/candidates")
public class ApplicationController {


    private  final CandidateService service;

    private  final TokenService tokenService;


    public ApplicationController(CandidateService service, TokenService tokenService) {
        this.service = service;
        this.tokenService = tokenService;
    }


    @GetMapping("/phone")
    public ApiResponseEx submitPhone(@RequestParam String phone)
    {
         tokenService.sendTokenForNumber(phone);
         ApiResponseEx resp = new ApiResponseEx<>("success");
         return resp;
         //return  new ApiResponse<String>("success",String.format("message sent to %s", phone),List.of());
    }

    @GetMapping("/verify")
    public ApiResponseEx verifyToken(@RequestParam(name="phone") String phone,@RequestParam String token)
    {
        boolean verified = tokenService.verifyToken(phone,token);
        ApiResponseEx resp;
        if(verified)
        {
            resp = new ApiResponseEx("success");
            Candidate candidate = service.getUserHavingPhone(phone);
            if(candidate!=null) {
                resp.addMessage("usertype","existing");
                resp.addData(List.of(candidate));
            }
            else
            {
                resp.addMessage("usertype","newuser");
            }

        }
        else
        {
            resp = new ApiResponseEx<>("failed");
        }
        return resp;
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




    @GetMapping("/test")
    public ApiResponseEx<Candidate> testClass()
    {
        ApiResponseEx<Candidate> resp = new ApiResponseEx<Candidate>("success");
        resp.addMessage("name","Muhammad Ahmed");
        resp.addMessage("gender","Male");
        resp.addData(service.getCandidates());
        return resp;

        //return new ApiResponse<Candidate>("success","matching candidates", service.getCandidates());
    }


}
