package com.promotion.mail.controller;

import com.promotion.mail.dto.ClientDto;
import com.promotion.mail.repository.PromotionRepository;
import com.promotion.mail.service.PromotionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.mail.MessagingException;

@SpringBootTest()
public class PromotionControllerTest {
    @Autowired
    private PromotionController promotionController;

    RouterFunction<?> route= RouterFunctions.route(
            RequestPredicates.GET("/promotions/birthdate"),
            request -> ServerResponse.ok().build()
    );
    private WebTestClient webTestClient =  WebTestClient.bindToRouterFunction(route).build();

    @Test
    public void givenThePromotionWhenThereAreBirthdayClientThenSendMailWithDiscount() throws MessagingException {
        promotionController.sendPromotionMessageToBirthdayClient();
    }

    @Test
    public void givenTheWebClientWhenThereAreBirthdayClientThenSendMail(){
        webTestClient.get()
                .uri("/promotions/birthdate")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ClientDto.class);
    }


}