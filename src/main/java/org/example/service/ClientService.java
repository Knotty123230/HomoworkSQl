package org.example.service;

import org.example.Database;
import org.example.dto.Client;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientService {
    private PreparedStatement preparedStatement;

    public long create(String name)  {
        int id = 0;
        try {
            Connection connection = getConnection();
            String sql = "insert into client\n" +
                    "                (name) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()){
                id = generatedKeys.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;

    }

    public String getById(long id) throws SQLException {
        String name;
        preparedStatement = getConnection().prepareStatement("select name from client where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            name = resultSet.getString("name");
        } else throw new RuntimeException("Такого айді не існує");
        return name;
    }

    public void update(long id, String name) throws SQLException {
        preparedStatement = getConnection().prepareStatement("update client set name = ? where id = ?");
        preparedStatement.setLong(2, id);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }

    public void deleteById(long id) throws SQLException {
        preparedStatement = getConnection().prepareStatement("delete from client where id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<Client> listAll() throws SQLException {
        LinkedList<Client> clients = new LinkedList<>();
        preparedStatement = getConnection().prepareStatement("select * from client");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Client client = new Client();
            client.setId(id);
            client.setName(name);
            clients.add(client);
        }
        return clients;
    }

    private static Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }
}
