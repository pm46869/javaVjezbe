package com.example.vj4.service;

import com.example.vj4.repository.ClientRepository;
import com.example.vj4.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {

        return clientRepository.save(client);
    }

    public Client getClient(long id) {
        return clientRepository.findById(id).get();
    }
}
