package com.github.foliveira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesApplication {

//    @Bean
//    public CommandLineRunner init(@Autowired ClientRepository clientRepository,
//                                  @Autowired OrderRepository orderRepository)
//    {
//        return args -> {
//            System.out.println("Salvando clientes");
//            Client client = new Client("Fulano");
//            clientRepository.save(client);
//
//            Order pedido = new Order();
//            pedido.setClient(client);
//            pedido.setOrderDate(LocalDate.now());
//            pedido.setOrderTotal(BigDecimal.valueOf(100));
//
//            orderRepository.save(pedido);
//
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
