package com.promotion.mail.repository;

import com.promotion.mail.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT client FROM Client client WHERE client.month=?1 AND client.day=?2")
    List<Client> findClientsByBirthdateEquals(int month, int day);
}
