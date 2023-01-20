package com.example.vjezba6.services;

import com.example.vjezba6.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    Client saveClient(Client client, long id);
    Client getClientById(long id);
    Page<Client> getAllClients(Pageable pageable);
    Client updateClient(Client client, Long id);
    void deleteClientById(Long id);
}
