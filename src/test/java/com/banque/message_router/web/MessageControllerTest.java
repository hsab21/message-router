package com.banque.message_router.web;

import com.banque.message_router.domain.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPostMessage() throws Exception {
        // Création d'un objet JSON pour simuler la requête
        MessageDto messageDto = new MessageDto();
        messageDto.setContent("Ceci est un message de test");
        messageDto.setTimestamp("2024-12-03T10:00:00Z");

        // Conversion de l'objet en JSON
        String messagePayload = objectMapper.writeValueAsString(messageDto);

        // Simulation d'une requête POST
        mockMvc.perform(post("/api/messages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(messagePayload))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Message received")));
    }
}
