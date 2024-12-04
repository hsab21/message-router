// PartnerController.java
package com.banque.message_router.web;

import com.banque.message_router.application.PartnerService;
import com.banque.message_router.domain.Partner;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public List<Partner> getPartners() {
        return partnerService.getAllPartners();
    }

    @GetMapping("/{id}")
    public Partner getPartner(@PathVariable Long id) {
        return partnerService.getPartner(id);
    }

    @PostMapping
    public void savePartner(@RequestBody Partner partner) {
        partnerService.savePartner(partner);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
    }
}
