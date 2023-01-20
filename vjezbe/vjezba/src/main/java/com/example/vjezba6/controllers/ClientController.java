package com.example.vjezba6.controllers;

import com.example.vjezba6.entities.Client;
import com.example.vjezba6.entities.Data;
import com.example.vjezba6.exceptionHandler.*;
import com.example.vjezba6.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
   private ClientService clientService;

    @PostMapping("")
    ResponseEntity<Client> saveClient(@RequestBody Client client, @RequestParam(required = true, name= "deviceId")long id) {
        try {
            return new ResponseEntity<>(clientService.saveClient(client, id), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    }

    @GetMapping("")
    ResponseEntity<Client> getClient(@RequestParam(required = true, name = "clientId")long id) {

        try
        {

            return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Client>> getAllClients(@PageableDefault(page = 1, size = 5) Pageable pageable,
                                                      @RequestParam(required = false)String sortBy) {
        Sort sort = Sort.by(sortBy);
        Pageable sortPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Client> clients = clientService.getAllClients(sortPage);
        if(clients.isEmpty()) {
            return new ResponseEntity<>(clients, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PutMapping("")

    ResponseEntity<Client>  updateClient(@RequestBody Client client,
                               @RequestParam(required = true, name = "clientId") long id)
    {
        try {
            return new ResponseEntity<>(clientService.updateClient(client, id),HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }  catch (BadRequestException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("")

    ResponseEntity<Client>  deleteClientById(@RequestParam(required = true, name = "clientId")long id)
    {
        try {
            clientService.deleteClientById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
