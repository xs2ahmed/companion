package com.wefind.companion.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Integer> {

    //public List<Message> getMessagesBySender_idAndReceiver_idEqualsOrderByTime(Integer id);
    public List<Message> findBySenderidEqualsOrReceiveridEqualsOrderByTimeAsc(Integer senderid, Integer receiverid);
}
