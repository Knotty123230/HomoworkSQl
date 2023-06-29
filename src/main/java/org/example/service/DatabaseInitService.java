package org.example.service;

import org.example.Database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try(FileReader reader = new FileReader("/Users/mac/IdeaProjects/HomoworkSQl/src/main/resources/init_db.sql"))
        {
            int c;
            while((c=reader.read())!=-1){

               result.append((char) c);
            }
            System.out.println(result);
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(result.toString());

        }
        catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
