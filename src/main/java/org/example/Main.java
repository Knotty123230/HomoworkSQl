package org.example;

import org.example.dto.Client;
import org.example.service.ClientService;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        extracted();
        List<Client> clients = new ClientService().listAll();
        System.out.println(clients);

    }

    private static void extracted() {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:54321/postgres",
                "myname", "mysecretpassword").load();
        flyway.migrate();
    }
}