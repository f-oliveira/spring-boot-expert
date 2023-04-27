package com.github.foliveira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foliveira.repository.ClientRepository;
import com.github.foliveira.model.Client;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Client client) {
        validarCliente(client);
        this.repository.persist(client);
    }

    public void validarCliente(Client client) {
        //aplica validações
    }
}
