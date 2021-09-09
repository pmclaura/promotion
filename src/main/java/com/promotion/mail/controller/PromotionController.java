package com.promotion.mail.controller;

import com.promotion.mail.dto.ClientDto;
import com.promotion.mail.model.Client;
import com.promotion.mail.service.PromotionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    protected ModelMapper modelMapper;

    private PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/birthdate")
    public List<ClientDto> sendPromotionMessageToBirthdayClient() throws MessagingException {
        List<Client> clients = promotionService.sendEmailBirthdayClient();
        return clients.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ClientDto convertToDto(Client client) {
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }
}
