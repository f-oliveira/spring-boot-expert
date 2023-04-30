package com.github.foliveira.domain.repository;

import com.github.foliveira.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "select * from client c where c.name like '%:name%' ", nativeQuery = true)
    List<Client> encontrarNome(@Param("name") String name);

    @Query(value = " delete * from Client c where c.name =:name  ", nativeQuery = true)
    @Modifying
    void deleteByNome(String name);

    boolean existsByName(String name);


}
