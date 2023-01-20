package com.vjezba5.demo.services;

import com.vjezba5.demo.entities.Client;
import com.vjezba5.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ClientServiceImpl  implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Client getClient(long id) {
        return clientRepository.findById(id).get();
    }

    /*@Override
    public Client deleteById(long id){
        return clientRepository.deleteById(id).delete();
    }*/

}
