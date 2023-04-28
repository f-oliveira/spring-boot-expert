package com.github.foliveira;

import com.github.foliveira.domain.entity.Client;
import com.github.foliveira.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository){
        return args -> {
            System.out.println("Salvando clientes");
            clientRepository.save(new Client("Dougllas"));
            clientRepository.save(new Client("Outro Cliente"));

            List<Client> todosClientes = clientRepository.getAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setName(c.getName() + " atualizado.");
                clientRepository.update(c);
            });

            todosClientes = clientRepository.getAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientRepository.searchByName("Cli").forEach(System.out::println);

//            System.out.println("deletando clientes");
//            clientes.obterTodos().forEach(c -> {
//                clientes.deletar(c);
//            });

            todosClientes = clientRepository.getAll();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
