package org.example;

import org.example.service.DatabaseQueryService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("new DatabaseQueryService().findMaxProjectsClient() = "
                + new DatabaseQueryService().findMaxProjectsClient());
        System.out.println(new DatabaseQueryService().findMaxSalaryWorker());
        System.out.println(new DatabaseQueryService().findYoungestEldestWorker());
        System.out.println(new DatabaseQueryService().findLongestProject());
        System.out.println(new DatabaseQueryService().findProjectPrices());
    }
}