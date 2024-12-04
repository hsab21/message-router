package com.banque.message_router.infrastructure.repository;

import com.banque.message_router.domain.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
