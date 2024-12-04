package com.banque.message_router.application;

import com.banque.message_router.domain.Message;
import com.banque.message_router.domain.MessageDto;
import com.banque.message_router.infrastructure.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;

    public void saveMessage(MessageDto messageDto) {
        // Convertir le DTO en entité
        Message message = new Message();
        message.setContent(messageDto.getContent());
        message.setTimestamp(messageDto.getTimestamp ());

        // Enregistrer dans la base de données
        messageRepository.save(message);
    }
}
