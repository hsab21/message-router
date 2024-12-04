package com.banque.message_router.infrastructure.repository;

import com.banque.message_router.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
