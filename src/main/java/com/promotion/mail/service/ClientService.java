package com.promotion.mail.service;

import com.promotion.mail.model.Client;
import com.promotion.mail.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findBirthdayClient(){
        LocalDate date = LocalDate.now();
        return clientRepository.findClientsByBirthdateEquals(date.getMonth().getValue(),date.getDayOfMonth());
    }
}
