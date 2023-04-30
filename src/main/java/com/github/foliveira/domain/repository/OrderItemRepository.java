package com.github.foliveira.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<com.github.foliveira.domain.entity.OrderItem, Integer> {
}
