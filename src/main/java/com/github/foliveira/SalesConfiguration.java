package com.github.foliveira;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesConfiguration {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de Vendas";
    }
}
