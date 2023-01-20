package com.vjezba5.demo.controllers;

import com.vjezba5.demo.entities.Client;
import com.vjezba5.demo.entities.Device;
import com.vjezba5.demo.repository.ClientRepository;
import com.vjezba5.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClientController {
    @Autowired
    public ClientService clientService;
    @Autowired
    public ClientRepository repository;

    @Valid
    @PostMapping("/clients")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(client));
    }

    @Valid
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client>  getClient(@PathVariable("id")long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.getClient(id));
    }

    @Valid
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> replaceClient(@RequestBody Client client, @PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.CREATED).body((repository.findById(id))
                .map(client1 -> {
                    client1.setName(client.getName());
                    client1.setAddress(client.getAddress());
                    return repository.save(client1);
                })
                .orElseGet(() -> {
                    client.setId(id);
                    return repository.save(client);
                }));
    }

    @DeleteMapping("/clients/{id}")
    void deleteDevice(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

