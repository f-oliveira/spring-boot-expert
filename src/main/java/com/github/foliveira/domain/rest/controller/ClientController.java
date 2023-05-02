package com.github.foliveira.domain.rest.controller;

import com.github.foliveira.domain.entity.Client;
import com.github.foliveira.domain.repository.ClientRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/api/clients/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Client client) {
        return clientRepository
                .findById(id)
                .map( clientExist -> {
                    client.setId(clientExist.getId());
                    clientRepository.save(client);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/clientes")
    public ResponseEntity find( Client filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        List<Client> lista = clientRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }

}
