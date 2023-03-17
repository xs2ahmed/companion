package com.wefind.companion.messages;

import com.wefind.companion.candidates.ApiResponseEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private  final MessagesRepository messagesRepository;

    public MessageService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public Message sendMessage(Message message)
    {
        return this.messagesRepository.save(message);
    }

    public List<Message> getMessages(Integer candidateId) {
        return messagesRepository.findBySenderidEqualsOrReceiveridEqualsOrderByTimeAsc(candidateId, candidateId);
    }
}
