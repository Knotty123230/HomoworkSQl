package org.example.service;

import org.example.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public void populateClient(String name) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into client\n" +
                    "                (name) VALUES (?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateProject(Date startDate, Integer client_id,
                                Date finishDate,String projectName){
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into project\n" +
                    "( start_date, client_id, finish_date, name) VALUES (?,?,?,?)");
            preparedStatement.setDate(1, startDate);
            preparedStatement.setInt(2, client_id);
            preparedStatement.setDate(3, finishDate);
            preparedStatement.setString(4, projectName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateWorker(String name, String level, int salary, int birthday){
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into worker\n" +
                    "(name, level, salary, birthday) values(?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, level);
            preparedStatement.setInt(3, salary);
            preparedStatement.setInt(4, birthday);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateProjectWorker(int idProject, int idClient){
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into project_worker\n" +
                    "(project_id, worker_id) VALUES(?,?)");
            preparedStatement.setInt(1, idProject);
            preparedStatement.setInt(2, idClient);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection() throws SQLException {
        return Database.getInstance().getConnection();
    }
}
