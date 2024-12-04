package com.banque.message_router.web;

import com.banque.message_router.application.MessageService;
import com.banque.message_router.domain.Message;
import com.banque.message_router.domain.MessageDto;
import com.banque.message_router.infrastructure.repository.MessageRepository;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSaveMessage() {
        MessageDto dto = new MessageDto();
        dto.setContent("Test content");
        dto.setTimestamp("2024-12-03T12:00:00Z");

        messageService.saveMessage(dto);

        List<Message> messages = messageRepository.findAll();
        assertEquals(1, messages.size());
        assertEquals("Test content", messages.get(0).getContent());

        // Vérifiez que le message a bien été sauvegardé dans la base
        assertNotNull(messageRepository.findAll());
        assertEquals(1, messageRepository.count());  // Vérifier qu'il y a un message dans la base
    }
}
