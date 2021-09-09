package com.promotion.mail.controller;

import com.promotion.mail.model.Client;
import com.promotion.mail.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
public class PromotionControllerTest {
    @Autowired
    private PromotionController promotionController;

    @Test
    public void givenThePromotionWhenThereAreBirthdayClientThenSendMailWithDiscount() throws MessagingException {

        promotionController.sendPromotionMessageToBirthdayClient();
    }

}