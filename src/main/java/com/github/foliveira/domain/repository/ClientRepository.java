package com.github.foliveira.domain.repository;

import com.github.foliveira.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepository {

    private static String INSERT = "INSERT INTO client (name) VALUES (?) ";
    private static String SELECT_ALL = "SELECT * FROM client ";
    private static String UPDATE = "UPDATE CLIENT SET name = ? WHERE id = ? ";
    private static String DELETE = "DELETE FROM client WHERE id = ? ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save(Client client){
        jdbcTemplate.update( INSERT, client.getName());
        return client;
    }

    public Client update(Client client){
        jdbcTemplate.update(UPDATE, client.getName(), client.getId());
        return client;
    }

    public void delete(Client client){
        delete(client.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update(DELETE, id);
    }

    public List<Client> searchByName(String name){
        return jdbcTemplate.query(
                SELECT_ALL.concat(" where name like ? "),
                new Object[]{"%" + name + "%"},
                getClientMapper());
    }

    public List<Client> getAll(){
        return jdbcTemplate.query(SELECT_ALL, getClientMapper());
    }

    private RowMapper<Client> getClientMapper() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Client(id, name);
            }
        };
    }
}
