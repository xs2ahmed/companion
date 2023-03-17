package com.wefind.companion.messages;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@ToString
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer senderid;
    Integer receiverid;
    String message;
    LocalDateTime time;
}
