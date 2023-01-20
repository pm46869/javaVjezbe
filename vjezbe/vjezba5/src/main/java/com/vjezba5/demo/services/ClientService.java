package com.vjezba5.demo.services;

import com.vjezba5.demo.entities.Client;

public interface ClientService {
    Client saveClient(Client client);
    Client getClient(long id);
}
