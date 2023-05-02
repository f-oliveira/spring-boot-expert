package com.github.foliveira.domain.rest.controller;

import com.github.foliveira.domain.entity.Client;
import com.github.foliveira.domain.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/api/clients/{id}")
    @ResponseBody
    public ResponseEntity getClientById(@PathVariable Integer id){
        Optional<Client> client =  clientRepository.findById(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clients")
    @ResponseBody
    public ResponseEntity save(@RequestBody Client client) {
        Client clientSaved = clientRepository.save(client);

        return ResponseEntity.ok(clientSaved);
    }

    @DeleteMapping("/api/clients/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
