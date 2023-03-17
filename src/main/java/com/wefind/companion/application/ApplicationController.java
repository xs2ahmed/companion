package com.wefind.companion.application;

import com.wefind.companion.candidates.Candidate;
import com.wefind.companion.candidates.CandidateService;
import com.wefind.companion.candidates.ApiResponseEx;
import com.wefind.companion.messages.Message;
import com.wefind.companion.messages.MessageService;
import com.wefind.companion.tokens.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/candidates")
public class ApplicationController {



    private  final CandidateService candidateService;


    private  final TokenService tokenService;

    private  final MessageService messageService;


    public ApplicationController(CandidateService service,
                                 TokenService tokenService,
                                 MessageService messageService)
    {
        this.candidateService = service;
        this.tokenService = tokenService;
        this.messageService = messageService;
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
            Candidate candidate = candidateService.getUserHavingPhone(phone);
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


    @GetMapping("/matches")
    public List<Candidate> getCandidates(@RequestParam(name="max")  Integer maxRecords)
    {
        return candidateService.getCandidates();
    }

    @PostMapping ("/")
    public Candidate addCandidate(@RequestBody Candidate candidate)
    {
        return candidateService.addCandidate(candidate);
    }

    /*
    * Needed to load one candiate,
    * for example user x sends message to y, then y opens the message and has to tap
    * on x to see his/her profile. In that case only one candidate will be returned give his her id
    * */
    public Candidate getCandidate(Integer id)
    {
        return  null;

    }

    /*
     * Just posts a new message, does not just ids of sender or receiver yet.
     * */

    @PostMapping("/send-message")
    public ApiResponseEx<Message> sendMessage(@RequestBody Message message)
    {
        //set message time to be server time now.
        message.setTime(LocalDateTime.now());
        Message saved = messageService.sendMessage(message);
        ApiResponseEx resp = new ApiResponseEx<Message>("success");
        resp.addData(List.of(message));
        return resp;
    }

    /*
    * Returns all messages sent or received by candidate_id and sorted by timestamp
    * */
    @GetMapping("/get-messages")
    public ApiResponseEx<Message> getMessages(@RequestParam Integer candidate_id)
    {
        List<Message> messages= messageService.getMessages(candidate_id);
        ApiResponseEx<Message> response = new ApiResponseEx<Message>("success");
        response.addData(messages);
        return response;
    }

    /*
     * Returns all messages sicne a certain point in time
     * time in query params is read as string, so if we want to read it as object of LocalDateTime,
     * we must specify the format of string, otherwise it won't be able to to read and return as bad request.
     * read this article.
     * https://www.baeldung.com/spring-date-parameters
     *
     * http://localhost:8080/v1/candidates/get-messages-since?since=2000-10-31T01:30:00.000-05:00
     *
     * */
    @GetMapping("/get-messages-since")
    public ApiResponseEx<Message> getMessagesSince(@RequestParam("since")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                       LocalDateTime since)
    {
        List<Message> messages= messageService.getMessages(null);
        ApiResponseEx<Message> response = new ApiResponseEx<Message>("success");
        response.addData(messages);
        return response;
    }


    @GetMapping("/test")
    public ApiResponseEx<Candidate> testClass()
    {
        ApiResponseEx<Candidate> resp = new ApiResponseEx<Candidate>("success");
        resp.addMessage("name","Muhammad Ahmed");
        resp.addMessage("gender","Male");
        resp.addData(candidateService.getCandidates());
        return resp;

        //return new ApiResponse<Candidate>("success","matching candidates", service.getCandidates());
    }


}
