package com.banque.message_router.application;

import com.banque.message_router.domain.Message;
import com.banque.message_router.infrastructure.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageListenerService {
    private final MessageRepository messageRepository;

    @JmsListener(destination = "${ibm.mq.queue}")
    public void receiveMessage(String messageContent) {
        Message message = new Message();
        message.setContent(messageContent);
        message.setTimestamp(String.valueOf(LocalDateTime.now()));
        messageRepository.save(message);
    }
}
