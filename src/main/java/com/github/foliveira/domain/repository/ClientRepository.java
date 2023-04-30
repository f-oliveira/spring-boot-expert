package com.github.foliveira.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<com.github.foliveira.domain.entity.Client, Integer> {

    @Query(value = "select * from client c where c.name like '%:name%' ", nativeQuery = true)
    List<com.github.foliveira.domain.entity.Client> encontrarNome(@Param("name") String name);

    @Query(value = " delete * from Client c where c.name =:name  ", nativeQuery = true)
    @Modifying
    void deleteByNome(String name);

    boolean existsByName(String name);

    @Query(value = " select c from client c left join fetch c.orders where c.id =:id ")
    com.github.foliveira.domain.entity.Client findClientFetchOrders(@Param("id") Integer id);

}
