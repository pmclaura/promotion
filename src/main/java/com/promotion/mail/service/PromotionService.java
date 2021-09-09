package com.promotion.mail.service;

import com.promotion.mail.model.Client;
import com.promotion.mail.model.Promotion;
import com.promotion.mail.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    private final ClientService clientService;
    private final EmailService emailService;

    public PromotionService(PromotionRepository promotionRepository, ClientService clientService, EmailService emailService) {
        this.promotionRepository = promotionRepository;
        this.clientService = clientService;
        this.emailService = emailService;
    }

    public Promotion save(Promotion promotion){
        return promotionRepository.save(promotion);
    }

    public List<Client> sendEmailBirthdayClient() throws MessagingException {
        List<Client> clients = clientService.findBirthdayClient();
        for (Client client : clients) {
            emailService.sendMessage(client);
        }
        return clients;
    }
}
