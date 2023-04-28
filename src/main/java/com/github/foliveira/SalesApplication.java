package com.github.foliveira;

import com.github.foliveira.domain.entity.Client;
import com.github.foliveira.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository){
        return args -> {
            System.out.println("Salvando clientes");
            clientRepository.save(new Client("Dougllas"));
            clientRepository.save(new Client("Outro Cliente"));

            List<Client> result = clientRepository.encontrarNome("Dougllas");
            result.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
