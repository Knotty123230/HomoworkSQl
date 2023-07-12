package org.example;

import org.example.service.ClientService;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        extracted();
        System.out.println(new ClientService().create("anton"));
    }

    private static void extracted()  {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:54321/postgres",
                "myname", "mysecretpassword").load();
        flyway.migrate();

    }
}