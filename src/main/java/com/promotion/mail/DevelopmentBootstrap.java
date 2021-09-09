package com.promotion.mail;

import com.promotion.mail.model.Client;
import com.promotion.mail.service.ClientService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ClientService clientService;

    public DevelopmentBootstrap(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Client client1 = new Client();
        client1.setName("Susana");
        client1.setLastname("Prado");
        try {
            client1.setBirthdate(sdf.parse("2000-10-02"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        client1.setYear(2000);
        client1.setMonth(10);
        client1.setDay(2);
        client1.setEmail("susana@gmail.com");
        persist(client1);


        Client client2 = new Client();
        client2.setName("Elizabeth");
        client2.setLastname("Quiroga");
        try {
            client2.setBirthdate(sdf.parse("1999-09-09"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        client2.setYear(1999);
        client2.setMonth(9);
        client2.setDay(9);
        client2.setEmail("pmclaura@gmail.com");
        persist(client2);
    }

    private void persist(Client client){
        clientService.save(client);

    }
}
