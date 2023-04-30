package com.github.foliveira.domain.repository;

import com.github.foliveira.domain.entity.Client;
import com.github.foliveira.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> = findByClient(Client client);

}
