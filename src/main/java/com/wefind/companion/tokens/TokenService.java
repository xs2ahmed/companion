package com.wefind.companion.tokens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class TokenService {

    private  final TokensRepository tokensRepository;
    @Autowired
    public TokenService(TokensRepository tokensRepository) {
        this.tokensRepository = tokensRepository;
    }

    public void sendTokenForNumber(String phone){
        tokensRepository.deleteByPhoneEquals(phone);
        Random random = new Random();
        //4 digit token for sending on mobile
        String token = String.format("%04d", random.nextInt(10000));
        Token newToken = new Token(phone,token, false, LocalDate.now());
        tokensRepository.save(newToken);
        //Send SMS to user mobile on phone
    }


    public boolean verifyToken(String phone, String token) {

        List<Token> tokenList = tokensRepository.findByPhoneEqualsAndTokenEquals(phone, token);
        if(tokenList!=null && !tokenList.isEmpty())
        {
            Token tokenObject = tokenList.get(0);
            tokenObject.setVerified(true);
            tokensRepository.save(tokenObject);
            return true;
        }
        else
            return false;

        //boolean exists = tokensRepository.existsByPhoneAndToken(phone,token);
        //return  exists;

    }
}
