package com.github.foliveira.domain.repository;

import com.github.foliveira.domain.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Client client){
        entityManager.persist(client);
    }

    @Transactional
    public void update(Client client){
        entityManager.merge(client);
    }

    @Transactional
    public void delete(Client client){
        if(!entityManager.contains(client)) {
            client = entityManager.merge(client);
        }
        entityManager.remove(client);
    }

    @Transactional
    public void delete(Integer id){
        Client client = entityManager.find(Client.class, id);
        delete(client);
    }

    @Transactional(readOnly = true)
    public List<Client> searchByName(String name){
        String jpql = " select c from Client c where c.nome like :nome ";
        TypedQuery<Client> query =  entityManager.createQuery(jpql, Client.class);
        query.setParameter("name", "%" + name + "%");

        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Client> getAll(){
        return entityManager
                .createQuery("from client", Client.class)
                .getResultList();
    }
}
