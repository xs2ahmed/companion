package com.wefind.companion.tokens;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "candidate_sequence"

    )
    Long id;
    private  String phone;
    private  String token;
    private LocalDate time;

    private boolean verified;

    public Token(String phone, String token, Boolean verified, LocalDate time) {
        this.phone = phone;
        this.token = token;
        this.verified = verified;
        this.time = time;
    }

    public Token() {
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
