package com.github.foliveira.domain.repository;

import com.github.foliveira.domain.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNameLike(String name);

    boolean existsByName(String name);

}
