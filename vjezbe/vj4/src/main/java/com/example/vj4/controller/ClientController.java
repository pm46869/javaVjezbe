package com.example.vj4.controller;

import com.example.vj4.entity.Client;
import com.example.vj4.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to your first app!";
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.getClient(id));
    }

    @PostMapping(
            value = "/addClient", consumes = "application/json", produces = "application/json")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
}
