package com.banque.message_router.application;

import com.banque.message_router.domain.Partner;
import com.banque.message_router.infrastructure.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    @Autowired
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public Partner getPartner(Long id) {
        return partnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found"));
    }

    public void savePartner(Partner partner) {
        partnerRepository.save(partner);
    }

    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);
    }
}
