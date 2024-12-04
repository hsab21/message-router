package com.banque.message_router.application;

import com.banque.message_router.domain.MessageDto;
import jakarta.jms.JMSException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
@RequiredArgsConstructor
public class MessageListener implements javax.jms.MessageListener {

    private final MessageService messageService;

    @Override
    public void onMessage(javax.jms.Message jmsMessage) {
        if (jmsMessage instanceof TextMessage) {
            MessageDto content = (MessageDto) jmsMessage;
            messageService.saveMessage(content);
            System.out.println("Message received and saved: " + content);
        }
    }
}
